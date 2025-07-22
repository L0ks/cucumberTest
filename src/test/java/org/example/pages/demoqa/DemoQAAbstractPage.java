package org.example.pages.demoqa;

import org.example.common.AbstractPage;
import org.openqa.selenium.WebDriver;

public class DemoQAAbstractPage extends AbstractPage {
    protected String url = "https://demoqa.com/";

    public DemoQAAbstractPage(WebDriver driver) {
        super(driver);
    }
}
