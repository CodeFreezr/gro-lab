def emojiCounter = 0
def bigCounter = 0
def mediumCounter = 0
def bigStr = ""
def mediumStr = ""
def emojiStr = ""

def output = ""
def start = System.currentTimeMillis()
def dotFile = new File("emojiv11.dot")
dotFile << "digraph g{\n"

def text = new URL('https://unicode.org/emoji/charts/emoji-list.html').eachLine { line ->
    
    def big = (line =~ "bighead") //imga
    def medium = (line =~ "mediumhead") //imga
    def emoji = (line =~ "imga") //imga


    if (big.find()) {
        bigCounter++
        def tr = new XmlSlurper().parseText(line)
        
        def s = tr.th.a
        bigStr = "big-" + "$bigCounter".padLeft(2,'0')
        println bigStr // + " [ label = \"$s\" ];"
        dotFile << bigStr + " [ label = \"$s\" ];\n"


    }

    if (medium.find()) {
        mediumCounter++
        def tr = new XmlSlurper().parseText(line)

        def s = tr.th.a
        mediumStr = "med-" + "$mediumCounter".padLeft(3,'0')
        //println mediumStr + " [ label = \"$s\" ];"
        dotFile << mediumStr + " [ label = \"$s\" ];\n"
        //println mediumStr + " -> " + bigStr + ";"
        dotFile << mediumStr + " -> " + bigStr + ";\n"
        println mediumStr
    }



    if (emoji.find()) {
        emojiCounter++ 
        //def td = new XmlSlurper().parseText(line)

        emojiStr = "emoji-" + "$emojiCounter".padLeft(4,'0')
        //println emojiStr + " [image=\"emojis\\" + emojiStr + ".png\" label=\"\"];"
        dotFile << emojiStr + " [image=\"emojis\\" + emojiStr + ".png\" label=\"\"];\n"
        // println emojiStr + " -> " + mediumStr + ";"
        dotFile << emojiStr + " -> " + mediumStr + ";\n"
        println emojiStr
    } 

}

/*
def text = new File('emojiv5.html').eachLine { line ->
    def matcher = (line =~ "imga")
    if (matcher.find()) {
        def td = new XmlSlurper().parseText(line)
        println td.a'@href'
        //output += line
        println counter++
    }
}
*/


//https://unicode.org/emoji/charts/emoji-list.html
//emojiv5.html
dotFile << "}\n"
def now = System.currentTimeMillis()
def differ = (now - start) / 1000
//println counter + " found in " + differ + "s"

//new File("emojiv05.html") << output