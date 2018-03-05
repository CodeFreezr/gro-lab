//** If access to internet is available the @Grab-Line can be uncommented
//** If not, download snakeyaml[latest].jar for e.g. from maven-central 
//** and copy it into [groovy-home]/lib

@Grab(group='org.yaml', module='snakeyaml', version='1.18')

import org.yaml.snakeyaml.Yaml
import javax.xml.xpath.*

if ( this.args.size() < 1 || this.args[0] == "-help") {
def usage = '''

Purpose: This utility test a YAML File with the help of snakeyaml and javax
         +> if a File is Yaml 1.2 compliant (no options)
         +> if a File has valid XPATH for MMP (with -mmp option)

Usage:   groovy yamltester [singlefilename] [options]

Options:
-mmp     = MMP Specific xpath compliant check
-x       = Check !!! marked YAMLs; very MMP Specific w/o .yaml extension
-help    = Print this screen

Examples:
groovy yamltest
groovy yamltest myfile.yaml -mmp
groovy yamltest anotherfile -x

'''
 
println usage
System.exit(0)
}


def yamlfile = this.args.contains("-x") ? this.args[0] + "!!!.yaml" : this.args[0]

println yamlfile + " (start)"

def xpath = (XPath) XPathFactory.newInstance().newXPath()
def yaml = new Yaml()
def doc = new File(yamlfile).text

//** Check if File is YAML 1.2 Compliant 
def map = (Map) yaml.load(doc)


//** Check if YAML has the default keys
def result = ""
map.eachWithIndex { myItem , i ->
    result += "${myItem.key}|"
}
assert result == "message_type|monitoring_point|attributes|"

//** Check if XPath is able to compile (MMP Specific):
if (this.args.contains("-mmp")) {
	def mapAtts = map.get('attributes')
	mapAtts.each {it -> 
		def ListOfXPath = (List) it.value	
		def testok = "ok"
		ListOfXPath.eachWithIndex {xp, i -> 	
			XPathExpression expr = xpath.compile(xp);
		}
		println "${ListOfXPath.size()} * ${it.key} = ${testok}"
	}
}

println yamlfile + " (done)"
println "" 