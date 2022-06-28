package com.twoitesting.pomPages;

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

    public void clickLogoutBtn() {

        this.logoutBtn.click();
    }
}
