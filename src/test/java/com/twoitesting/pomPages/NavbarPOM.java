package com.twoitesting.pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;

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

    @FindBy(linkText = "Cart")
    private WebElement cartTab;

    @FindBy(id = "site-header-cart")
    private WebElement shoppingCartInfo;

    public void navigateToMyAccount() {

        this.myAccountTab.click();
    }

    public void navigateToShopPage() {

        this.shopTab.click();
    }

    public void navigateToCartPage() {

        this.cartTab.click();
    }

    public double getCartValue() {

        String shoppingCartInfo = this.shoppingCartInfo.getText();
        String[] cartInfo = shoppingCartInfo.split(" ");

        return Double.parseDouble(cartInfo[0].replace("£", ""));
    }
}
