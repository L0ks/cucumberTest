package org.example.pages.demoqa.fragments;

import org.example.common.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LeftPanel extends AbstractPage {
    private By elementGroup = By.cssSelector(".element-group");
    private By elementGroupHeader = By.cssSelector(".header-text");
    private By menuList = By.cssSelector(".menu-list");

//    private By leftPanel = By.cssSelector(".left-pannel");
//    .left-pannel

    public LeftPanel(WebDriver driver) {
        super(driver);
    }

    private WebElement getElementGroupByHeaderName(String headerName){
        for (WebElement e : waitUntilAllVisible(elementGroup)) {
            String header = waitUntilVisible(e, elementGroupHeader).getText();
            if(header.equals(headerName)) return e;
        }
        throw new NoSuchElementException("No left panel button with text: " + headerName);
    }

    private WebElement getMenuList(WebElement elementsGroup){
        return waitUntilVisible(elementsGroup, menuList);
    }


    public void clickHeaderGroupByName(String headerName){
        getElementGroupByHeaderName(headerName).click();
    }



}
