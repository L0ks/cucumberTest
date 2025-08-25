package org.example.pages.wikipedia;

import org.example.common.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class WikipediaHomePage extends AbstractPage {
    private By searchBar = By.id("searchInput");
    private By searchButton = By.cssSelector("button[type='submit']");

    public WikipediaHomePage(WebDriver driver){
        super(driver, Duration.ofSeconds(5));
    }

    public void typeIntoSearchBar(String input){
        type(searchBar, input);
    }
    public void clickSearchButton(){
        click(searchButton);
    }
}
