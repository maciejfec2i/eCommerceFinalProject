package com.twoitesting.stepBindingCode;

import com.twoitesting.baseClasses.BaseClass;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.jupiter.api.Assertions.*;

public class StepDefinitions extends BaseClass {

    @Before
    public void setUp() {

        super.setUp();
        super.getDriver().get(super.getBaseUrl());
    }

    public void tearDown() {

        super.tearDown();
    }

    @Given("I am logged in")
    public void i_am_logged_in() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Given("I add an item to the cart")
    public void i_add_an_item_to_the_cart() {
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
