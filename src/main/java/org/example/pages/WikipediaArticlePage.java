package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WikipediaArticlePage {
    private WebDriverWait wait;
    private WebDriver driver;

    Duration waitTime = Duration.ofSeconds(10);
    private By articleHeading = By.className("mw-page-title-main");

    public WikipediaArticlePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, waitTime);
    }

    private WebElement getArticleHeadingElement() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(articleHeading));
    }

    public String getArticleHeading() {
        return getArticleHeadingElement().getText();
    }
}
