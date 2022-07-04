package com.twoitesting.pomPages;

import com.twoitesting.utilityClasses.Waiter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrdersPOM {

    private WebDriver driver;

    public OrdersPOM(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(css = "tr > td")
    private WebElement latestOrderNumTableData;

    public String getLatestOrderNumber() {

        Waiter.waitForElementToBeVisible(this.driver, 5, this.latestOrderNumTableData);
        return this.latestOrderNumTableData.getText().replace("#", "");
    }
}
