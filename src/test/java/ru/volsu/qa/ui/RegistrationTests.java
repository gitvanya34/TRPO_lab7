package ru.volsu.qa.ui;


import io.qameta.allure.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.volsu.qa.ui.utils.EmailGenerator;
import ru.volsu.qa.ui.pageobject.models.Account;
import ru.volsu.qa.ui.pagefactory.TopBar;
import ru.volsu.qa.ui.pageobject.AccountCreationForm;
import ru.volsu.qa.ui.pageobject.SignUpForm;

import org.apache.commons.io.FileUtils;
import java.io.File;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class RegistrationTests extends BaseTest {

    @DataProvider(name = "accountDataProvider")
    public Object[][] accountDataProvider() {
        Account account = new Account();
        account.setEmail(EmailGenerator.generateEmail());

        return new Object[][] {
                {account}
        };
    }




    @Test(dataProvider = "accountDataProvider")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify user registration correct value.")
    public void registerAccount(Account account){

        TopBar topBar = PageFactory.initElements(webdriver, TopBar.class);
        topBar.signIn();

        SignUpForm signUpForm = new SignUpForm(webdriver);
        signUpForm.fillForm( account.getEmail() );
        signUpForm.clickCreateAccountButton();

        AccountCreationForm accountCreationForm = new AccountCreationForm(webdriver);
        accountCreationForm.fillForm(account);

       Assert.assertTrue(webdriver.getTitle().equals("My account - My Store"));

    }






}
