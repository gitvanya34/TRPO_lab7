package ru.volsu.qa.ui.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.volsu.qa.ui.expectedconditions.PageLoaded;

public class BasePage {

    private static final int BASE_TIMEOUT = 60;

    protected WebDriver webDriver;

    protected BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void waitForPageLoaded() {
        WebDriverWait wait = new WebDriverWait( webDriver, BASE_TIMEOUT );
        wait.until( new PageLoaded() );
    }

    public void waitForElementDisplayed( By by ) {
        WebDriverWait wait = new WebDriverWait( webDriver, BASE_TIMEOUT );
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}
