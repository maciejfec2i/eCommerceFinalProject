package com.twoitesting.pomPages;

import com.twoitesting.utilityClasses.Waiter;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopPOM {

    private WebDriver driver;

    public ShopPOM(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(css = "#main > header")
    private WebElement header;

    public String getHeaderText() {

        Waiter.waitForElementToBeVisible(this.driver, 5, this.header);
        return this.header.getText();
    }
}
