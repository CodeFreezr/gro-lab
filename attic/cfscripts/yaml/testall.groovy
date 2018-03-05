def p =  ~/.*.(?i)yaml/
   
new File(".").eachFileMatch(p) { file ->
	def myYamlBody = file.getName().split("\\.")[0]
    def myYamlExt = file.getName().split("\\.")[1]
	
	//"cmd /c groovy yamltest.groovy ${myYamlBody}.${myYamlExt} -mmp".execute()
	
	
	
	print "cmd /c groovy yamltest.groovy ${myYamlBody}.${myYamlExt} -mmp".execute().text
}
