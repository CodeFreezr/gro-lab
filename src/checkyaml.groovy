@Grapes(@Grab(group='org.yaml', module='snakeyaml', version='1.19'))
import org.yaml.snakeyaml.Yaml

//initial Settings & Checks
def kmRoot = "D:\\SVN\\km\\"
def fs = File.separator
assert this.args.size() == 2
def kmType = this.args[0]
assert kmType == "Dependencies" | kmType == "ReleaseNotes" | kmType == "Configurations" 
def kmReleaseVersion = this.args[1]
def yaml = new Yaml()
def i = 1
def kmTitle = "YAML Error Report for ${kmType} in Release ${kmReleaseVersion}"
def html = """
<html>
    <head>
        <title>${kmTitle}</title>
        <link rel='stylesheet' href='styles.css'>
        <script src='sorttable.js'></script>
    </head>
    <body>
        <div class='headnavi'>
            <h2>${kmTitle}</h2>
            <a href='CheckReleaseNotes-0.6.2.html' class='Maintab'>ReleaseNotes</a> - 
            <a href='CheckDependencies-0.6.2.html' class='Maintab'>Dependencies</a> - 
            <a href='CheckConfigurations-0.6.2.html' class='Maintab'>Configurations</a>
        </div>
        <table class='sortable'><thead><tr><th>No</th><th>Status</th><th>Component</th><th>Size</th></tr></thead>

"""

def htmlClose = "</table></bod></html>"


new File(kmRoot).eachDir() { dir ->  
    def filePath = kmRoot + dir.name + fs + kmType + fs + kmType + "-" + kmReleaseVersion + ".yml"
    def file = new File(filePath)
    def chkState = "n/a"
    def chkSize = -1


    if (file.exists() & file.canRead()) {
        chkState = "ok"
        chkSize = file.length()
        try {
            def map = (Map) yaml.load(file.text) //check for correct YAML-Syntax
        } catch (all) {
            chkState = "syntax"
        }
    }
    html += "<tr><td>${i}</td><td>${chkState}</td><td>${dir.name}</td><td>${chkSize}</td></tr>"
    println i++ + "\t" + chkState + "\t" + chkSize + "\t" + dir.name 

}

//generate Report
println "______________________________________________________________________________"
def outputName = "Check${kmType}-${kmReleaseVersion}.html"
html += htmlClose
def output = new File(outputName)
output.write html
println "Report written into: " + outputName