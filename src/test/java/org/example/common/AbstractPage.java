package org.example.common;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class AbstractPage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(10);


    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, DEFAULT_TIMEOUT);
    }

    public AbstractPage(WebDriver driver, Duration timeout) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, timeout);
    }

    // Common Waits
    protected WebElement waitUntilVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected List<WebElement> waitUntilAllVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    protected WebElement waitUntilClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected List<WebElement> waitUntilAllClickable(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator))
                .stream()
                .filter(WebElement::isEnabled)
                .toList(); // Requires Java 17+, or use collect(Collectors.toList()) in older Java versions
    }

    protected void waitForUrlToContain(String partialUrl) {
        wait.until(ExpectedConditions.urlContains(partialUrl));
    }

    protected boolean isElementPresent(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            return false;
        }
    }

    // Common Actions
    protected void type(By locator, String text) {
        WebElement element = waitUntilVisible(locator);
        element.clear();
        element.sendKeys(text);
    }

    protected void click(By locator) {
        waitUntilClickable(locator).click();
    }

    protected String getText(By locator) {
        return waitUntilVisible(locator).getText();
    }
}
