package com.twoitesting.pomPages;

import com.twoitesting.utilityClasses.Waiter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderReceivedPOM {

    private WebDriver driver;

    public OrderReceivedPOM(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(css = "ul > li.woocommerce-order-overview__order.order")
    private WebElement orderNumTableData;

    public WebElement getOrderNumTableData() {

        Waiter.waitForElementToBeVisible(this.driver, 5, this.orderNumTableData);
        return this.orderNumTableData;
    }

    public String getOrderNumber() {
        /*
        Captures the order number to be compared with the order number in order history
         */

        Waiter.waitForElementToBeVisible(this.driver, 5, this.orderNumTableData);
        String orderNumTableData = this.orderNumTableData.getText();

        String orderNum = orderNumTableData.substring(orderNumTableData.indexOf(":") + 1);

        if(orderNum.contains("\n")) {
            orderNum = orderNum.replace("\n", "");
        }

        return orderNum;
    }
}
