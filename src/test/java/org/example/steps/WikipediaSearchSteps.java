package org.example.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.pages.WikipediaArticlePage;
import org.example.pages.WikipediaMainPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WikipediaSearchSteps {
    WebDriver driver;
    WikipediaMainPage wikiMainPage;

    @Before
    public void setupFireFoxBrowser() {
        WebDriverManager.firefoxdriver().setup();

        FirefoxOptions options = new FirefoxOptions();
//        options.addArguments("-headless");

        driver = new FirefoxDriver(options);
        wikiMainPage = new WikipediaMainPage(driver);
    }

    @Given("I open the Wikipedia home page")
    public void openWikipediaHomePage() {
        wikiMainPage.goToMainPage();
    }

    @When("I search for {string}")
    public void searchFor(String query) {
        wikiMainPage.typeIntoSearchBar(query);
        wikiMainPage.clickSearchButton();
    }

    @Then("the first heading should be {string}")
    public void verifyHeading(String expectedHeading) {
        WikipediaArticlePage resultPage = new WikipediaArticlePage(driver);
        Assertions.assertEquals(expectedHeading, resultPage.getArticleHeading());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
