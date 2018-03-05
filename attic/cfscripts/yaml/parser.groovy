def yamls = new XmlParser().parse("allyaml.xml")

yamls.yamlFile.each{
  File file = new File(it.attribute("fname") + ".yaml")
  file.write it.text()
  println it.attribute("fname") + "done"
}