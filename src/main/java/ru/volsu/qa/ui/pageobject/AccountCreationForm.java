package ru.volsu.qa.ui.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import ru.volsu.qa.models.Account;

public class AccountCreationForm extends BasePage {

    private By formContainer = By.id("account-creation_form");

    private By genderManInput = By.id("id_gender1");

    private By genderWomenInput = By.id("id_gender2");

    private By customfirstNameInput = By.id("customer_firstname");

    private By customlastNameInput = By.id("customer_lastname");

    //private By emailAddressInput = By.id("email_create");

    private By passwordInput = By.id("passwd");

    private By daysSelect = (By.id("days"));

    private By monthsSelect = By.id("months");

    private By yearsSelect = By.id("years");

    private By firstNameInput = By.id("firstname");

    private By lastNameInput = By.id("lastname");

   // private By companyInput = By.id("company");
   // private By address2Input = By.id("address2");

    private By address1Input = By.id("address1");

    private By cityInput = By.id("city");

    private By stateSelect = By.id("id_state");

    private By postCodeInput = By.id("postcode");

    private By countrySelect = By.id("id_country");

    private By phoneMobileInput = By.id("phone_mobile");

    private By registerButton = By.id("submitAccount");






    public AccountCreationForm(WebDriver webDriver) {
        super( webDriver );
    }

    public boolean isFormDisplayed() {
        this.waitForElementDisplayed(formContainer);
        return true;
    }

    public void fillForm(Account account) {
       this.waitForElementDisplayed( formContainer );
       webDriver.findElement( genderManInput ).click();
       webDriver.findElement( customfirstNameInput ).sendKeys( account.getFirstName() );
       webDriver.findElement( customlastNameInput ).sendKeys( account.getLastName() );
       webDriver.findElement( passwordInput ).sendKeys( account.getPassword() );

        Select select = new Select(webDriver.findElement(daysSelect));
        select.selectByValue(account.getDayBirth());

        select = new Select(webDriver.findElement(monthsSelect));
        select.selectByValue(account.getMonthBirth());

        select = new Select(webDriver.findElement(yearsSelect));
        select.selectByValue(account.getYearBirth());

      //  webDriver.findElement( firstNameInput ).sendKeys( account.getFirstName() );
      //  webDriver.findElement( lastNameInput ).sendKeys( account.getLastName() );
        webDriver.findElement( address1Input ).sendKeys( account.getAddress() );
        webDriver.findElement( cityInput ).sendKeys( account.getCity() );

        select = new Select(webDriver.findElement(stateSelect));
        select.selectByVisibleText(account.getState());

        webDriver.findElement( postCodeInput ).sendKeys( account.getPostalCode() );
        webDriver.findElement( phoneMobileInput ).sendKeys( account.getPhone() );

       webDriver.findElement( registerButton ).click();

    }
}
