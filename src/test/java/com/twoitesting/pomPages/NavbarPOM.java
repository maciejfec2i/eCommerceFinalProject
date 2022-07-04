package com.twoitesting.pomPages;

import com.twoitesting.utilityClasses.Scroller;
import com.twoitesting.utilityClasses.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
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

    @FindBy(linkText = "Checkout")
    private WebElement checkoutTab;

    @FindBy(id = "site-header-cart")
    private WebElement shoppingCartInfo;

    public void navigateToMyAccount() {

        Waiter.waitForElementToBeClickable(this.driver, 5, this.myAccountTab);
        this.myAccountTab.click();
    }

    public void navigateToShopPage() {

        Waiter.waitForElementToBeClickable(this.driver, 5, this.shopTab);
        this.shopTab.click();
    }

    public void navigateToCartPage() {

        Waiter.waitForElementToBeClickable(this.driver, 5, this.cartTab);
        this.cartTab.click();
    }

    public void navigateToCheckoutPage() {

        Waiter.waitForElementToBeClickable(this.driver, 5, this.checkoutTab);
        this.checkoutTab.click();
    }

    public double getCartValue() {

        String shoppingCartInfo = this.shoppingCartInfo.getText();
        String[] cartInfo = shoppingCartInfo.split(" ");

        return Double.parseDouble(cartInfo[0].replace("£", ""));
    }

    public WebElement getMyAccountTab() {

        return this.myAccountTab;
    }
}
