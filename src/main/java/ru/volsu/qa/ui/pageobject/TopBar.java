package ru.volsu.qa.ui.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;

@Component
public class TopBar extends BasePage{

    @FindBy( css = ".login" )
    private WebElement signInButton;

    private By formContainer = By.cssSelector(".header-container");

    public void signIn() {
        this.waitForElementDisplayed( formContainer );
        PageFactory.initElements(webdriver, this);
       signInButton.click();
    }
}
