package ru.volsu.qa.ui;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;

import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.volsu.qa.ui.pageobject.models.Account;
import ru.volsu.qa.ui.utils.EmailGenerator;

import java.io.IOException;
public class RegistrationNegativeTests extends BaseTest {

    @DataProvider(name = "testSingUpFormNegative_Data")
    public Object[][] testSingUpFormNegative_Data() {
        Account accountWithAlreadyUsedEmail = new Account();
        accountWithAlreadyUsedEmail.setEmail("john.doe@yahoo.com");

        Account accountWithInvalidEmail = new Account();
        accountWithInvalidEmail.setEmail("john.doeyahoo.com");

        Account accountValidEmail= new Account("Иван" ,
                                                "Иванов",
                                                EmailGenerator.generateEmail(),
                                                "QWERTY!@#$",
                                                "1",
                                                "1",
                                                "1999",
                                                "",
                                                "Albuquerque",
                                                "New Mexico",
                                                "87001",
                                                "United States",
                                                "12345678910");

        return new Object[][] {
                {accountWithAlreadyUsedEmail, "An account using this email address has already been registered. Please enter a valid password or request a new one."},
               {accountWithInvalidEmail, "Invalid email address."},
        };
    }

    @Test(dataProvider = "testSingUpFormNegative_Data")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify user registration with incorrect email value.")
    public void registerAccountNegativeTest(Account account, String errorMessage ) {
        topBar.signIn();
        signUpForm.fillForm( account.getEmail() );
        signUpForm.clickCreateAccountButton();
        String errorOnPage = signUpForm.getErrorMessage();
        System.out.println("Ожидаемая ошибка:"+errorMessage);
        System.out.println("Текущая ошибка:"+errorOnPage);

        Assert.assertEquals(errorOnPage, errorMessage);
    }

    @DataProvider(name = "testAccountCreationFormNegative_Data")
    public Object[][] testAccountCreationFormNegative_Data() {
        Account accountNullAddress= new Account(
                "Иван" ,
                "Иванов",
                EmailGenerator.generateEmail(),
                "QWERTY!@#$",
                "1",
                "1",
                "1999",
                "",
                "Albuquerque",
                "New Mexico",
                "87001",
                "United States",
                "12345678910");

        return new Object[][] {
                {accountNullAddress, "There is 1 error\naddress1 is required."},
        };
    }

    @Test(dataProvider = "testAccountCreationFormNegative_Data")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify user registration with incorrect address value.")
    public void testAccountCreationFormNegative(Account account, String errorMessage ) throws IOException {
        topBar.signIn();
        signUpForm.fillForm( account.getEmail() );
        signUpForm.clickCreateAccountButton();
        accountCreationForm.fillForm(account);
        String errorOnPage = accountCreationForm.getErrorMessage();
        System.out.println("Ожидаемая ошибка:"+errorMessage);
        System.out.println("Текущая ошибка:"+errorOnPage);

        Assert.assertEquals(errorOnPage, errorMessage);

    }

}
