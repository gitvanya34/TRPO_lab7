package ru.volsu.qa.ui.pageobject;

import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import ru.volsu.qa.ui.config.Config;
import ru.volsu.qa.ui.expectedconditions.PageLoaded;

import java.io.ByteArrayInputStream;
@Component
@ContextConfiguration( classes = Config.class )
public class BasePage  extends AbstractTestNGSpringContextTests {

    private static final int BASE_TIMEOUT = 60;

    @Autowired
    protected WebDriver webdriver;

    @Autowired
    protected Config config;

    public void waitForPageLoaded() {
        WebDriverWait wait = new WebDriverWait( webdriver, config.getBaseTimeout() );
        wait.until( new PageLoaded() );
    }

    public void waitForElementDisplayed( By by ) {
        WebDriverWait wait = new WebDriverWait( webdriver, BASE_TIMEOUT );
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
     public void openBrowser()
     {
         webdriver.get(config.getBaseUrl());
     }
    public void closeBrowser()
    {
        screenshot();
        webdriver.quit();
    }
    // @Attachment
    public void screenshot() {
        Allure.addAttachment("JXRj.png", new ByteArrayInputStream(((TakesScreenshot) webdriver).getScreenshotAs(OutputType.BYTES)));
    }
}
