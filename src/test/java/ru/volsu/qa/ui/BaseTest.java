package ru.volsu.qa.ui;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.*;
import ru.volsu.qa.ui.config.Config;
import ru.volsu.qa.ui.pageobject.BasePage;
import ru.volsu.qa.ui.pageobject.TopBar;
import ru.volsu.qa.ui.pageobject.AccountCreationForm;
import ru.volsu.qa.ui.pageobject.SignUpForm;

import java.io.ByteArrayInputStream;

@Component
public class BaseTest extends BasePage{

    @Autowired
    protected TopBar topBar;
    @Autowired
    protected SignUpForm signUpForm;
    @Autowired
    protected BasePage basePage;
    @Autowired
    protected AccountCreationForm accountCreationForm;

    @BeforeMethod
    public void initBrowser()
        {
            basePage.openBrowser();
        }


    @AfterSuite
    public void closeBrowser(){
          basePage.closeBrowser();
    }

}
