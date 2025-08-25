package org.example.steps.demoqa;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.example.core.WebDriverFactory;
import org.example.pages.demoqa.elements.DemoQAElementsPage;
import org.example.pages.demoqa.fragments.LeftPanel;
import org.example.utils.WebsiteDataManager;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static org.example.utils.SystemPropertyHelper.getEnvironment;

public class DemoQAElementsPageSteps {
    WebDriver driver = WebDriverFactory.getDriver();
    DemoQAElementsPage elementsPage = new DemoQAElementsPage(driver);
    LeftPanel leftPanel = new LeftPanel(driver);
    WebsiteDataManager demoQAData = new WebsiteDataManager("demoqa", getEnvironment());

    @Given("I open the Demo QA elements page")
    public void openDemoQAElementsPage() {
        elementsPage.goToPage(demoQAData.getBaseUrl() + elementsPage.getPath());
    }

    @When("I click {string} in the left panel")
    public void clickOptionInLeftPanel(String elementName){
        leftPanel.clickHeaderGroupByName(elementName);
    }

}
