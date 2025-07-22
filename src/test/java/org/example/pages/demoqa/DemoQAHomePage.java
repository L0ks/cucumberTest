package org.example.pages.demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DemoQAHomePage extends DemoQABasePage {
    private By categoryCards = By.cssSelector(".category-cards > .card.mt-4.top-card");
    private By categoryCardName = By.cssSelector(".card-body > h5");

    public DemoQAHomePage(WebDriver driver) {
        super(driver);
    }

    public void goToHomePage(){
        driver.get(url);
    }

    public List<WebElement> getCategoryCards(){
        return waitUntilAllClickable(categoryCards);
    }
    public String getCategoryCardText(WebElement card){
        return card.findElement(categoryCardName).getText();
    }
}
