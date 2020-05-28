package ru.volsu.qa.ui.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopBar {

    @FindBy( css = ".login" )
    private WebElement signInButton;

    public void signIn() {
        this.signInButton.click();
    }
}
