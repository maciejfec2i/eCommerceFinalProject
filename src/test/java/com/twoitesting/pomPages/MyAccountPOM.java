package com.twoitesting.pomPages;

import com.twoitesting.utilityClasses.Waiter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPOM {

    private WebDriver driver;

    public MyAccountPOM(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(linkText = "Logout")
    private WebElement logoutBtn;

    @FindBy(linkText = "Orders")
    private WebElement ordersBtn;

    public void clickLogoutBtn() {

        Waiter.waitForElementToBeClickable(this.driver, 5, this.logoutBtn);
        this.logoutBtn.click();
    }

    public void clickOrdersBtn() {

        Waiter.waitForElementToBeClickable(this.driver, 5, this.ordersBtn);
        this.ordersBtn.click();
    }

    public WebElement getLogoutBtn() {

        Waiter.waitForElementToBeClickable(this.driver, 5, this.logoutBtn);
        return this.logoutBtn;
    }
}
