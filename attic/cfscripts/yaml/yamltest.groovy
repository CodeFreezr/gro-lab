@Grab(group='org.yaml', module='snakeyaml', version='1.18')
import org.yaml.snakeyaml.Yaml

println this.args[0] + " :start"
def yaml = new Yaml()
def doc = new File(this.args[0]).text
def map = (Map) yaml.load(doc)

def result = ""
map.eachWithIndex { myItem , i ->
    result += "${myItem.key}|"
};

assert result == "message_type|monitoring_point|attributes|"
println this.args[0] + " :done"
