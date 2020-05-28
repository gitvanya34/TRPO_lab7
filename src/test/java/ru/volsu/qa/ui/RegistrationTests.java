package ru.volsu.qa.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.volsu.qa.ui.utils.EmailGenerator;
import ru.volsu.qa.models.Account;
import ru.volsu.qa.ui.pagefactory.TopBar;
import ru.volsu.qa.ui.pageobject.AccountCreationForm;
import ru.volsu.qa.ui.pageobject.SignUpForm;

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
    public void registerAccount(Account account) {

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
