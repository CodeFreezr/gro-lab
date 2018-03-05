@Grapes([
    @Grab("org.gebish:geb-core:1.1.1"),
//    @Grab("org.codehaus.geb:geb-core:1.1.1"),//always use latest version of geb and selenium drivers
    @Grab("org.seleniumhq.selenium:selenium-firefox-driver:3.3.1"),
    @Grab("org.seleniumhq.selenium:selenium-support:3.3.1")
])

import geb.Browser


Browser.drive {
    go "http://gebish.org"
}

/*
    println title
  
    assert title == "Geb - Very Groovy Browser Automation" 

    $("#sidebar .sidemenu a", text: "jQuery-like API").click()

    assert $("#main h1")*.text() == ["Navigating Content", "Form Control Shortcuts"] 
    assert $("#sidebar .sidemenu a", text: "jQuery-like API").parent().hasClass("selected")
    
}
*/

