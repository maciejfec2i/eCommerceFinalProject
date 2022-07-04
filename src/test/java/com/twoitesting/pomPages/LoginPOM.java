package com.twoitesting.pomPages;

import com.twoitesting.utilityClasses.Waiter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM {

    private WebDriver driver;

    public LoginPOM(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(name = "login")
    private WebElement loginBtn;

    @FindBy(linkText = "Dismiss")
    WebElement cookieDismissBtn;

    public void inputUsername(String username) {
        /*
        Inputs username into username field.
        Username field is always cleared first in case 'Remember me' checkbox is checked.
         */

        Waiter.waitForElementToBeClickable(this.driver, 5, this.loginBtn);
        this.usernameField.clear();
        this.usernameField.sendKeys(username);
    }

    public void inputPassword(String password) {
        /*
        Inputs password into password field.
        Password field is always cleared first in case 'Remember me' checkbox is checked.
         */

        Waiter.waitForElementToBeClickable(this.driver, 5, this.loginBtn);
        this.passwordField.clear();
        this.passwordField.sendKeys(password);
    }

    public void clickLoginBtn() {

        Waiter.waitForElementToBeClickable(this.driver, 5, this.loginBtn);
        this.loginBtn.click();
    }

    public void login(String username, String password) {

        this.inputUsername(username);
        this.inputPassword(password);
        this.clickLoginBtn();
    }

    public void clickCookieDismissBtn() {

        Waiter.waitForElementToBeClickable(this.driver, 5, this.loginBtn);
        this.cookieDismissBtn.click();
    }
}
