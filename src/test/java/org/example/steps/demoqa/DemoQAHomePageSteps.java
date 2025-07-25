package org.example.steps.demoqa;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.core.WebDriverFactory;
import org.example.pages.demoqa.DemoQAHomePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DemoQAHomePageSteps {
    WebDriver driver = WebDriverFactory.getDriver();
    DemoQAHomePage homePage = new DemoQAHomePage(driver);
    private List<WebElement> categoryList;

    @Given("I open the Demo QA home page")
    public void openDemoQAHomePage() {
        homePage.goToHomePage();
    }

    @When("I see a list of category cards")
    public void getCategoryCardList() {
        categoryList = homePage.getCategoryCards();
    }

    @Then("the list contains the following options options:")
    public void checkCategories(List<String> expectedCategories) {
        for (WebElement category : categoryList) {
            String categoryText = homePage.getCategoryCardText(category);
            Assertions.assertTrue(expectedCategories.contains(categoryText), "Expected " + categoryText + " to be in " + expectedCategories);
        }
    }
}
