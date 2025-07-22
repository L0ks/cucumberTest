package org.example.steps.wikipedia;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.core.WebDriverFactory;
import org.example.pages.wikipedia.WikipediaArticlePage;
import org.example.pages.wikipedia.WikipediaHomePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class WikipediaSearchSteps {
    WebDriver driver = WebDriverFactory.getDriver();
    WikipediaHomePage wikiHomePage = new WikipediaHomePage(driver);

    @Given("I open the Wikipedia home page")
    public void openWikipediaHomePage() {
        wikiHomePage.goToHomePage();
    }

    @When("I search for {string}")
    public void searchFor(String query) {
        wikiHomePage.typeIntoSearchBar(query);
        wikiHomePage.clickSearchButton();
    }

    @Then("the first heading should be {string}")
    public void verifyHeading(String expectedHeading) {
        WikipediaArticlePage resultPage = new WikipediaArticlePage(driver);
        Assertions.assertEquals(expectedHeading, resultPage.getArticleHeading());
    }
}
