package com.twoitesting.baseClasses;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BaseClass {

    private WebDriver driver;
    private String baseUrl = "https://www.edgewordstraining.co.uk/demo-site/my-account/";

    public void setUp() {
        /*
        Sets up the browser to be used to run the test.
        If tests are run from the command line, a browser can be specified.
        Valid browsers: chrome, firefox and edge
         */

        String browser = System.getProperty("browser");

        if(browser == null) {

            browser = "";
        }

        switch(browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                this.driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                this.driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                this.driver = new EdgeDriver();
            default:
                WebDriverManager.chromedriver().setup();
                this.driver = new ChromeDriver();
                break;
        }

        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        this.driver.manage().window().maximize();
    }

    public void tearDown() {

        this.driver.quit();
    }

    public WebDriver getDriver() {

        return this.driver;
    }

    public String getBaseUrl() {

        return this.baseUrl;
    }
}
