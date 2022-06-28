package com.twoitesting.pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavbarPOM {

    private WebDriver driver;

    public NavbarPOM(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(linkText = "My account")
    private WebElement myAccountTab;

    @FindBy(linkText = "Shop")
    private WebElement shopTab;

    public void navigateToMyAccount() {

        this.myAccountTab.click();
    }

    public void navigateToShopPage() {

        this.shopTab.click();
    }
}
