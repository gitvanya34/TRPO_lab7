package ru.volsu.qa.ui.pageobject;

import io.qameta.allure.*;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.springframework.stereotype.Component;
import org.testng.Assert;
import ru.volsu.qa.ui.pageobject.models.Account;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
@Component
public class AccountCreationForm extends BasePage {


    private By formContainer = By.id("account-creation_form");

    @FindBy( id = "id_gender1" )
    private WebElement genderManInput;

    @FindBy( id = "id_gender2" )
    private WebElement genderWomanInput;

    @FindBy( id = "customer_firstname" )
    private WebElement customfirstNameInput;

    @FindBy( id = "customer_lastname" )
    private WebElement customlastNameInput;

    @FindBy( id = "passwd" )
    private WebElement passwordInput;

    @FindBy( id = "days" )
    private WebElement daysSelect;

    @FindBy( id = "months" )
    private WebElement monthsSelect ;

    @FindBy( id = "years" )
    private WebElement yearsSelect;


   // private By companyInput = By.id("company");
   // private By address2Input = By.id("address2");

    @FindBy( id = "address1" )
    private WebElement address1Input ;

    @FindBy( id = "city" )
    private WebElement cityInput;

    @FindBy( id = "id_state" )
    private WebElement stateSelect;

    @FindBy( id = "postcode" )
    private WebElement postCodeInput ;

    @FindBy( id = "id_country" )
    private WebElement countrySelect ;

    @FindBy( id = "phone_mobile" )
    private WebElement phoneMobileInput;

    @FindBy( id = "submitAccount" )
    private WebElement registerButton;


    private By errorMessage = By.cssSelector(".alert.alert-danger");


    public String getErrorMessage() {
        this.waitForElementDisplayed( errorMessage );
        return webdriver.findElement( errorMessage ).getText();
    }



    public boolean isFormDisplayed() {
        this.waitForElementDisplayed(formContainer);
        return true;
    }

    public void fillForm(Account account)  {
       this.waitForElementDisplayed( formContainer );

        PageFactory.initElements(webdriver, this);

        genderManInput.click();

        customfirstNameInput.sendKeys( account.getFirstName());

        // webDriver.findElement( customfirstNameInput ).sendKeys( account.getFirstName() );

       customlastNameInput.sendKeys( account.getLastName() );
       passwordInput.sendKeys( account.getPassword() );

        Select select = new Select(daysSelect);
        select.selectByValue(account.getDayBirth());

        select = new Select(monthsSelect);
        select.selectByValue(account.getMonthBirth());

        select = new Select(yearsSelect);
        select.selectByValue(account.getYearBirth());

        address1Input.sendKeys( account.getAddress() );
        cityInput.sendKeys( account.getCity() );

        select = new Select(stateSelect);
        select.selectByVisibleText(account.getState());

        postCodeInput.sendKeys( account.getPostCode() );
        phoneMobileInput.sendKeys( account.getPhone() );
        registerButton.click();



    }
    public String Title()
    {
        return webdriver.getTitle();
    }


}
