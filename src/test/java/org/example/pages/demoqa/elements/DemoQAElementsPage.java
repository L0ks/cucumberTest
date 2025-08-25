package org.example.pages.demoqa.elements;

import org.example.common.AbstractPage;
import org.openqa.selenium.WebDriver;

public class DemoQAElementsPage extends AbstractPage {
    private final String PAGE_PATH = "/elements";

    public DemoQAElementsPage(WebDriver driver) {
        super(driver);
    }

    public String getPath() {
        return PAGE_PATH;
    }
}
