package org.example.pages.wikipedia;

import org.example.common.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WikipediaArticlePage extends AbstractPage {
    private By articleHeading = By.className("mw-page-title-main");

    public WikipediaArticlePage(WebDriver driver) {
        super(driver);
    }

    private WebElement getArticleHeadingElement() {
        return waitUntilVisible(articleHeading);
    }

    public String getArticleHeading() {
        return getText(articleHeading);
    }
}
