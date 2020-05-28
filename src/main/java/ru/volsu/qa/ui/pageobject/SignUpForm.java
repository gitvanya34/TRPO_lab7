package ru.volsu.qa.ui.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpForm extends BasePage {

    private By formContainer = By.id("create-account_form");

    private By emailAddressInput = By.id("email_create");

    private By createAccountButton = By.id("SubmitCreate");

    private By errorMessage = By.id("create_account_error");

    public SignUpForm( WebDriver webDriver ) {
        super( webDriver );
    }

    public void fillForm( String email ) {
        this.waitForElementDisplayed( formContainer );
        webDriver.findElement( emailAddressInput ).sendKeys( email );
    }

    public void clickCreateAccountButton() {
        webDriver.findElement( createAccountButton ).click();
    }

    public String getErrorMessage() {
        this.waitForElementDisplayed( errorMessage );
        return webDriver.findElement( errorMessage ).getText();
    }
}
