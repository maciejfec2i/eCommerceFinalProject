package com.twoitesting.pomPages;

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

    @FindBy(name = "s")
    private WebElement searchBar;

    @FindBy(css = "#main > header")
    private WebElement header;

    public void searchForItem(String item) {

        this.searchBar.clear();
        this.searchBar.sendKeys(item + Keys.ENTER);
    }

    public String getHeaderText() {

        return this.header.getText();
    }
}
