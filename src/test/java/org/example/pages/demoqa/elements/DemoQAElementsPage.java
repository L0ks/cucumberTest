package org.example.pages.demoqa.elements;

import org.example.pages.demoqa.DemoQAAbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DemoQAElementsPage extends DemoQAAbstractPage {
    By elementsMessage = By.cssSelector("div.col-12.mt-4.col-md-6");

    public DemoQAElementsPage(WebDriver driver) {
        super(driver);
        url = url + "elements";
    }

    public void goToElementsPage(){
        driver.get(url);
    }

    public String getElementsMessageText(){
        return waitUntilVisible(elementsMessage).getText();
    }
}
