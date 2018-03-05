@Grab(group='org.yaml', module='snakeyaml', version='1.18')
import org.yaml.snakeyaml.Yaml

def myName = this.args[0] + "!!!.yaml"

println "${myName}: test start" 
def yaml = new Yaml()
def doc = new File(myName).text
def map = (Map) yaml.load(doc)

def result = ""
map.eachWithIndex { myItem , i ->
    result += "${myItem.key}|"
};

assert result == "message_type|monitoring_point|attributes|"
println "${myName}: test done"