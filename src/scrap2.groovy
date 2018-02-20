//@Grab(group='org.ccil.cowan.tagsoup',module='tagsoup', version='1.2' )
//def parser = new XmlSlurper(new org.ccil.cowan.tagsoup.Parser())

def counter = 0
def output = ""
def start = System.currentTimeMillis()


def text = new URL('https://unicode.org/emoji/charts/emoji-list.html').eachLine { line ->
    def emoji = (line =~ "imga") //imga
    if (emoji.find()) {


        counter++ 
        //println td.a.img.@src

        if (counter > 2775) {

        xString = line.replaceAll('></a></td>','/></a></td>')
        xString = xString.replaceAll('data:image/png;base64,','')
        def td = new XmlSlurper().parseText(xString)

            def s = td.a.img.@src.text()

            byte[] decoded = s.decodeBase64()

            def fName = "emojis\\emoji-" + "$counter".padLeft(4,'0') + ".png"
            println fName 
            def f = new File(fName) 
            f << decoded


        } else {
            println counter
        }




        
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

def now = System.currentTimeMillis()
def differ = (now - start) / 1000
println counter + " found in " + differ + "s"

//new File("emojiv05.html") << output