package ru.volsu.qa.ui;


import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.volsu.qa.ui.pageobject.AccountCreationForm;
import ru.volsu.qa.ui.utils.EmailGenerator;
import ru.volsu.qa.ui.pageobject.models.Account;

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
        topBar.signIn();
        signUpForm.fillForm( account.getEmail() );
        signUpForm.clickCreateAccountButton();
        accountCreationForm.fillForm(account);

       Assert.assertTrue(accountCreationForm.Title().equals("My account - My Store"));

    }

}
