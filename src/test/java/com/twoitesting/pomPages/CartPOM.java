package com.twoitesting.pomPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPOM {

    private WebDriver driver;

    public CartPOM(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(css = "a[aria-label='Remove this item']")
    private List<WebElement> itemsToBeRemoved;

    public void emptyCart() {

        for(int i = this.itemsToBeRemoved.size() - 1; i >= 0; i--) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            this.itemsToBeRemoved.get(i).click();
        }
    }
}
