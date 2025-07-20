package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WikipediaMainPage {
    private WebDriverWait wait;
    private WebDriver driver;

    Duration waitTime = Duration.ofSeconds(5);
    private final String url = "https://www.wikipedia.org";
    private By searchBar = By.id("searchInput");
    private By searchButton = By.cssSelector("button[type='submit']");

    public WikipediaMainPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(this.driver, waitTime);
    }

    public void goToMainPage(){
        driver.get(url);
    }

    private WebElement getSearchBar(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(searchBar));
    }

    private WebElement getSearchButton(){
        return wait.until(ExpectedConditions.elementToBeClickable(searchButton));
    }

    public void typeIntoSearchBar(String input){
        getSearchBar().sendKeys(input);
    }

    public void clickSearchButton(){
        getSearchButton().click();
    }
}
