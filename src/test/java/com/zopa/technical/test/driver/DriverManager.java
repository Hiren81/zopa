package com.zopa.technical.test.driver;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;


//Initiating Drivers

public class DriverManager {
    public static WebDriver driver;

    private String browser = "chrome";

    public DriverManager() {
        PageFactory.initElements(driver, this);
    }

    public DriverManager openBrowser() {
        switch (browser) {
            case "chrome":
                ChromeDriverManager.getInstance().setup();
                driver = new ChromeDriver();
                break;
            case "ie":
                InternetExplorerDriverManager.getInstance().setup();
                driver = new InternetExplorerDriver();
                break;
            default:
                FirefoxDriverManager.getInstance().setup();
                driver = new FirefoxDriver();
                break;
        }

        return this;
    }

    public DriverManager navigateToUrl() {
        driver.get("https://www.zopa.com");
        return this;

    }

    public DriverManager applyImplictWait() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return this;

    }

    public DriverManager maximizeWindow() {
        driver.manage().window().maximize();
        return this;
    }

    public void closeBrowser() {
        driver.quit();
    }
}
