package com.twoitesting.pomPages;

import com.twoitesting.utilityClasses.Waiter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPOM {

    private WebDriver driver;

    public CheckoutPOM(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(css = "#post-6 > header")
    private WebElement header;

    @FindBy(id = "billing_first_name")
    private WebElement firstNameField;

    @FindBy(id = "billing_last_name")
    private WebElement lastNameField;

    @FindBy(id = "billing_address_1")
    private WebElement streetAddressField;

    @FindBy(id = "billing_city")
    private WebElement cityField;

    @FindBy(id = "billing_postcode")
    private WebElement postcodeField;

    @FindBy(id = "billing_phone")
    private WebElement phoneNumField;

    @FindBy(id = "billing_email")
    private WebElement emailAddressField;

    @FindBy(id = "place_order")
    private WebElement placeOrderBtn;

    public String getHeaderText() {

        Waiter.waitForElementToBeVisible(this.driver, 5, this.header);
        return this.header.getText();
    }

    public void inputFirstName(String firstName) {

        Waiter.waitForElementToBeClickable(this.driver, 5, this.placeOrderBtn);
        this.firstNameField.clear();
        this.firstNameField.sendKeys(firstName);
    }

    public void inputLastName(String lastName) {

        Waiter.waitForElementToBeClickable(this.driver, 5, this.placeOrderBtn);
        this.lastNameField.clear();
        this.lastNameField.sendKeys(lastName);
    }

    public void inputStreetAddress(String streetAddress) {

        Waiter.waitForElementToBeClickable(this.driver, 5, this.placeOrderBtn);
        this.streetAddressField.clear();
        this.streetAddressField.sendKeys(streetAddress);
    }

    public void inputCityName(String cityName) {

        Waiter.waitForElementToBeClickable(this.driver, 5, this.placeOrderBtn);
        this.cityField.clear();
        this.cityField.sendKeys(cityName);
    }

    public void inputPostcode(String postcode) {

        Waiter.waitForElementToBeClickable(this.driver, 5, this.placeOrderBtn);
        this.postcodeField.clear();
        this.postcodeField.sendKeys(postcode);
    }

    public void inputPhoneNumber(String phoneNumber) {

        Waiter.waitForElementToBeClickable(this.driver, 5, this.placeOrderBtn);
        this.phoneNumField.clear();
        this.phoneNumField.sendKeys(phoneNumber);
    }

    public void inputEmail(String email) {

        Waiter.waitForElementToBeClickable(this.driver, 5, this.placeOrderBtn);
        this.emailAddressField.clear();
        this.emailAddressField.sendKeys(email);
    }

    public void inputRequiredBillingDetails(String firstName, String lastName, String streetAddress, String cityName, String postcode, String phoneNumber, String email) {

        this.inputFirstName(firstName);
        this.inputLastName(lastName);
        this.inputStreetAddress(streetAddress);
        this.inputCityName(cityName);
        this.inputPostcode(postcode);
        this.inputPhoneNumber(phoneNumber);
        this.inputEmail(email);
    }

    public void clickPlaceOrderBtn() {

        Waiter.waitForElementToBeClickable(this.driver, 5, this.placeOrderBtn);
        this.placeOrderBtn.click();
    }
}
