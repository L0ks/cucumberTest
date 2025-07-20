package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class WikipediaMainPage extends BasePage {

    private final String url = "https://www.wikipedia.org";

    private By searchBar = By.id("searchInput");
    private By searchButton = By.cssSelector("button[type='submit']");

    public WikipediaMainPage(WebDriver driver){
        super(driver, Duration.ofSeconds(5));
    }

    public void goToMainPage(){
        driver.get(url);
    }

    public void typeIntoSearchBar(String input){
        type(searchBar, input);
    }

    public void clickSearchButton(){
        click(searchButton);
    }
}
