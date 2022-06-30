package com.twoitesting.pomPages;

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

    @FindBy(id = "site-header-cart")
    private WebElement shoppingCartInfo;

    public void navigateToMyAccount() {

        Actions action = new Actions(this.driver);
        int yOffset;

        /*try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/

        action.scrollToElement(this.myAccountTab).build().perform();

        yOffset = -100;

        for(int i = yOffset; i >= -300; i+=yOffset) {
            action.scrollByAmount(0, i).build().perform();
        }

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
