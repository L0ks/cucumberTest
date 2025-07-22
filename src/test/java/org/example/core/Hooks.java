package org.example.core;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import static org.example.helpers.SystemPropertyHelper.getBooleanProperty;

public class Hooks {
    @Before(order = 0)
    public void startDriver(Scenario scenario) {
        String browser = System.getProperty("browser", "firefox");
        boolean headless = getBooleanProperty("headless");
        WebDriverFactory.createInstance(browser, headless);
    }

    @After(order = 0)
    public void stopDriver(Scenario scenario) {
        WebDriverFactory.quitDriver();
    }
}
