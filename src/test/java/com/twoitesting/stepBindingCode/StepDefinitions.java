package com.twoitesting.stepBindingCode;

import com.twoitesting.baseClasses.BaseClass;
import com.twoitesting.pomPages.LoginPOM;
import com.twoitesting.pomPages.MyAccountPOM;
import com.twoitesting.pomPages.NavbarPOM;
import com.twoitesting.utilityClasses.LoginDetailsReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.FileNotFoundException;

public class StepDefinitions extends BaseClass {

    private LoginPOM loginPage;
    private NavbarPOM navbar;
    private MyAccountPOM myAccountPage;
    @Before
    public void setUp() {

        super.setUp();
        super.getDriver().get(super.getBaseUrl());

        this.loginPage = new LoginPOM(super.getDriver());
        this.navbar = new NavbarPOM(super.getDriver());
        this.myAccountPage = new MyAccountPOM(super.getDriver());
    }

    @After
    public void tearDown() {

        // If not on my account page, navigate to my account page.
        String currentUrl = super.getDriver().getCurrentUrl();

        if(!currentUrl.contains("my-account")) {
            this.navbar.navigateToMyAccount();
        }

        this.myAccountPage.clickLogoutBtn();
        super.tearDown();
    }

    @Given("I am logged in")
    public void i_am_logged_in() {

        LoginDetailsReader loginDetailsReader = new LoginDetailsReader();
        String username = loginDetailsReader.getUsername();
        String password = loginDetailsReader.getPassword();

        this.loginPage.login(username, password);
    }

    @Given("I am on the shop page")
    public void i_am_on_the_shop_page() {

        this.navbar.navigateToShopPage();
    }

    @Given("I added an {string} to the cart")
    public void i_added_an_item_to_the_cart(String item) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Given("I am on the cart page")
    public void i_am_on_the_cart_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Given("I input discount code {string}")
    public void i_input_discount_code(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("I apply the discount code")
    public void i_apply_the_discount_code() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("The total is correct after discount and shipping is applied")
    public void the_total_is_correct_after_discount_and_shipping_is_applied() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
