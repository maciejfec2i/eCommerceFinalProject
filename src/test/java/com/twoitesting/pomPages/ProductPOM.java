package com.twoitesting.pomPages;

import com.twoitesting.utilityClasses.Waiter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPOM {

    private WebDriver driver;

    public ProductPOM(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(name = "add-to-cart")
    private WebElement addToCartBtn;

    public void addItemToCart() {

        Waiter.waitForElementToBeClickable(this.driver, 5, this.addToCartBtn);
        this.addToCartBtn.click();
    }
}
