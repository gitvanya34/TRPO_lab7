package ru.volsu.qa.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected FirefoxDriver webdriver;

    @BeforeMethod
    public void initBrowser() {
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.gecko.driver", path + "/geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--start-maximized");
         webdriver = new FirefoxDriver(options);

        webdriver.get("http://automationpractice.com/");
    }

    @AfterMethod
    public void closeBrowser(){
        webdriver.quit();
    }
}
