package ru.volsu.qa.ui;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;


import java.io.ByteArrayInputStream;
import java.io.IOException;

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


    // @Attachment
    public void screenshot() {
        Allure.addAttachment("JXRj.png", new ByteArrayInputStream(((TakesScreenshot) webdriver).getScreenshotAs(OutputType.BYTES)));
    }
    @AfterMethod
    public void closeBrowser(){
       screenshot();
        webdriver.quit();
    }

}
