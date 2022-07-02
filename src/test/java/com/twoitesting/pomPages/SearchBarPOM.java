package com.twoitesting.pomPages;

import com.twoitesting.utilityClasses.Waiter;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchBarPOM {

    private WebDriver driver;

    public SearchBarPOM(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(name = "s")
    private WebElement searchBar;

    public void searchForItem(String item) {

        Waiter.waitForElementToBeClickable(this.driver, 5, this.searchBar);
        this.searchBar.clear();
        this.searchBar.sendKeys(item + Keys.ENTER);
    }
}
