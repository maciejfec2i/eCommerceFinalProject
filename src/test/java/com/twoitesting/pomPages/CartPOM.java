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

    @FindBy(css = "td[data-title*='Coupon:']")
    private WebElement couponTableData;

    @FindBy(css = "td[data-title='Subtotal']")
    private WebElement subtotalTableData;

    @FindBy(css = "td[data-title='Shipping']")
    private WebElement shippingTableData;

    @FindBy(css = ".order-total > td[data-title='Total']")
    private WebElement totalTableData;

    @FindBy(linkText = "Proceed to checkout")
    private WebElement proceedToCheckoutBtn;

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

        Waiter.waitForElementToBeVisible(this.driver, 5, this.header);
        return this.header.getText();
    }

    public WebElement getCouponTableData() {

        return this.couponTableData;
    }

    public double getSubtotal() {

        String subtotal = this.subtotalTableData.getText().replace("£", "");

        return Double.parseDouble(subtotal);
    }

    public double getDiscountAmount() {

        String discountData = this.couponTableData.getText();
        String discountAmount = discountData.substring(0, discountData.indexOf(" ")).replace("-£", "");

        return Double.parseDouble(discountAmount);
    }

    public double getShippingCost() {

        String shippingData = this.shippingTableData.getText();
        String shippingCost = shippingData.substring(shippingData.indexOf("£"), shippingData.indexOf("\n")).replace("£", "");

        return Double.parseDouble(shippingCost);
    }

    public double getTotal() {

        String total = this.totalTableData.getText().replace("£", "");

        return Double.parseDouble(total);
    }
}
