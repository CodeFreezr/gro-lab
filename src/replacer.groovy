

if (args.length < 1)
{
   println "Enter a target-file, search-string and replace-string as arguments."
   System.exit(-1)
}

sFile = new File(args[0])
def searchMe = args[1]
def replaceMe = args[2]


def txt = sFile.text
txt = txt.replaceAll(searchMe, replaceMe)

sFile.write(txt)

println searchMe + " replaced."
