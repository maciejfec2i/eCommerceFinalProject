package com.twoitesting.pomPages;

import com.twoitesting.utilityClasses.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartPOM {

    private WebDriver driver;

    public CartPOM(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(css = "a[aria-label='Remove this item']")
    private List<WebElement> itemsToBeRemoved;

    @FindBy(id = "coupon_code")
    private WebElement couponCodeField;

    @FindBy(name = "apply_coupon")
    private WebElement applyCouponBtn;

    @FindBy(css = "#post-5 > header")
    private WebElement header;

    public void emptyCart() {

        while(this.itemsToBeRemoved.size() > 0) {


            this.itemsToBeRemoved.get(0).click();
            // Wait for clicked element to be gone from the page
            Waiter.waitForElementToBeStale(this.driver, 5, this.itemsToBeRemoved.get(0));
        }
    }

    public void inputCouponCode(String couponCode) {

        Waiter.waitForElementToBeClickable(this.driver, 5, this.applyCouponBtn);
        this.couponCodeField.sendKeys(couponCode);
    }

    public void clickApplyCouponBtn() {

        this.applyCouponBtn.click();
    }

    public String getHeaderText() {

        return this.header.getText();
    }
}
