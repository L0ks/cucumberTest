package org.example.pages.demoqa;

import org.example.common.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DemoQAHomePage extends AbstractPage {

    private By categoryCards = By.cssSelector(".category-cards > .card.mt-4.top-card");
    private By categoryCardName = By.cssSelector(".card-body > h5");

    public DemoQAHomePage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getCategoryCards() {
        return waitUntilAllClickable(categoryCards);
    }

    public String getCategoryCardText(WebElement card) {
        return card.findElement(categoryCardName).getText();
    }

    public void clickCategoryCardByName(String name) {
        for (WebElement card : getCategoryCards()) {
            if (getCategoryCardText(card).contains(name)) card.click();
            return;
        }
        throw new NoSuchElementException("No category card with text: " + name);
    }

}
