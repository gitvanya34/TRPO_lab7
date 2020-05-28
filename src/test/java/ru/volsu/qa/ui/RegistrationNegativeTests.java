package ru.volsu.qa.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.volsu.qa.models.Account;
import ru.volsu.qa.ui.expectedconditions.PageLoaded;
import ru.volsu.qa.ui.pagefactory.TopBar;
import ru.volsu.qa.ui.pageobject.SignUpForm;
import ru.volsu.qa.ui.utils.EmailGenerator;

public class RegistrationNegativeTests extends BaseTest {

    @DataProvider(name = "accountNegativeDataProvider")
    public Object[][] accountNegativeDataProvider() {
        Account accountWithAlreadyUsedEmail = new Account();
        accountWithAlreadyUsedEmail.setEmail("john.doe@yahoo.com");

        Account accountWithInvalidEmail = new Account();
        accountWithInvalidEmail.setEmail("john.doeyahoo.com");

        return new Object[][] {
                {accountWithAlreadyUsedEmail, "An account using this email address has already been registered. Please enter a valid password or request a new one."},
                {accountWithInvalidEmail, "Invalid email address."}
        };
    }

    @Test(dataProvider = "accountNegativeDataProvider")
    public void registerAccountNegativeTest(Account account, String errorMessage ) {
        TopBar topBar = PageFactory.initElements(webdriver, TopBar.class);
        topBar.signIn();

        SignUpForm signUpForm = new SignUpForm(webdriver);
        signUpForm.fillForm( account.getEmail() );
        signUpForm.clickCreateAccountButton();

        String errorOnPage = signUpForm.getErrorMessage();

        Assert.assertEquals(errorOnPage, errorMessage);
    }


}
