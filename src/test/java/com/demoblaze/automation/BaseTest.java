package com.demoblaze.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;

    // Reusable base URL
    protected static final String BASE_URL = "https://www.demoblaze.com/";

    @BeforeMethod
    public void setUp() {

        // Open Chrome browser
        driver = new ChromeDriver();

        // Maximize browser
        driver.manage().window().maximize();

        // Create explicit wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Navigate to DemoBlaze
        driver.get(BASE_URL);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {

        // Safely close browser session
        if (driver != null) {
            driver.quit();
        }
    }
}