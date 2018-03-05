String phantomJSVersion = '1.9.2'

String platform
String archiveExtension
String execFilePath

if (Platform.current.is(Platform.WINDOWS)) {
    execFilePath = 'phantomjs.exe'
    platform = 'windows'
    archiveExtension = 'zip'
}
else if (Platform.current.is(Platform.MAC)) {
    execFilePath = '/bin/phantomjs'
    platform = 'macosx'
    archiveExtension = 'zip'
} else if (Platform.current.is(Platform.LINUX)) {
    execFilePath = '/bin/phantomjs'
    platform = 'linux-i686'
    archiveExtension = 'tar.bz2'
} else {
    throw new RuntimeException("Unsupported operating system [${Platform.current}]")
}

String phantomjsExecPath = "phantomjs-${phantomJSVersion}-${platform}/${execFilePath}"

String phantomJsFullDownloadPath = "https://phantomjs.googlecode.com/files/phantomjs-${phantomJSVersion}-${platform}.${archiveExtension}"

File phantomJSDriverLocalFile = downloadDriver(phantomJsFullDownloadPath, phantomjsExecPath, archiveExtension)

System.setProperty('phantomjs.binary.path', phantomJSDriverLocalFile.absolutePath)

driver = {
    Capabilities caps = DesiredCapabilities.phantomjs()
    def phantomJsDriver = new PhantomJSDriver(PhantomJSDriverService.createDefaultService(caps), caps)
    phantomJsDriver.manage().window().setSize(new Dimension(1028, 768))

    return phantomJsDriver
}

private File downloadDriver(String driverDownloadFullPath, String driverFilePath, String archiveFileExtension) {
    File destinationDirectory = new File("target/drivers")
    if (!destinationDirectory.exists()) {
        destinationDirectory.mkdirs()
    }

    File driverFile = new File("${destinationDirectory.absolutePath}/${driverFilePath}")

    String localArchivePath = "target/driver.${archiveFileExtension}"

    if (!driverFile.exists()) {
        def ant = new AntBuilder()
        ant.get(src: driverDownloadFullPath, dest: localArchivePath)

        if (archiveFileExtension == "zip") {
            ant.unzip(src: localArchivePath, dest: destinationDirectory)
        } else {
            ant.untar(src: localArchivePath, dest: destinationDirectory, compression: 'bzip2')
        }

        ant.delete(file: localArchivePath)
        ant.chmod(file: driverFile, perm: '700')
    }

    return driverFile
}