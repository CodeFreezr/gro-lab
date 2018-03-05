@Grapes([
    @Grab("org.codehaus.geb:geb-core:0.7.2"),//always use latest version of geb and selenium drivers
    @Grab("org.seleniumhq.selenium:selenium-firefox-driver:2.46.0"),
    @Grab("org.seleniumhq.selenium:selenium-support:2.46.0")
])

import geb.Browser

Browser.drive {
    go "http://gebish.org"

    assert title == "Geb - Very Groovy Browser Automation" 

    $("#sidebar .sidemenu a", text: "jQuery-like API").click()

    assert $("#main h1")*.text() == ["Navigating Content", "Form Control Shortcuts"] 
    assert $("#sidebar .sidemenu a", text: "jQuery-like API").parent().hasClass("selected")
}

