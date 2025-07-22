package org.example.pages.demoqa;

import org.example.pages.BasePage;
import org.openqa.selenium.WebDriver;

public class DemoQABasePage extends BasePage {
    protected String url = "https://demoqa.com/";

    public DemoQABasePage(WebDriver driver) {
        super(driver);
    }
}
