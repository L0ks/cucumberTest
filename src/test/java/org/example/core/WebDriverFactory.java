package org.example.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Optional;

public class WebDriverFactory {
    private static final ThreadLocal<WebDriver> TL_DRIVER = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return TL_DRIVER.get();
    }

    public static void createInstance(String browser, boolean headless) {
        if (TL_DRIVER.get() == null) {
            TL_DRIVER.set(initDriver(browser, headless));
        }
    }

    public static void quitDriver() {
        Optional.ofNullable(TL_DRIVER.get()).ifPresent(d -> {
            d.quit();
            TL_DRIVER.remove();
        });
    }

    // -- helpers ----------------------------------------------------------

    private static WebDriver initDriver(String browser, boolean headless) {
        return switch (browser.toLowerCase()) {
            case "edge" -> {
                WebDriverManager.edgedriver().setup();
                EdgeOptions options = new EdgeOptions();
                if (headless) {
                    options.addArguments("--headless");
                }
                yield new EdgeDriver(options);
            }

            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                if (headless) {
                    options.addArguments("--headless=new");
                }
                yield new ChromeDriver(options);
            }

            default -> {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions options = new FirefoxOptions();
                if (headless) {
                    options.addArguments("--headless");
                }
                yield new FirefoxDriver(options);
            }
        };
    }
}
