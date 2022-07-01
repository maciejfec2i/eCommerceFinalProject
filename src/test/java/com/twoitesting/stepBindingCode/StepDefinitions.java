package com.twoitesting.stepBindingCode;

import com.twoitesting.baseClasses.BaseClass;
import com.twoitesting.pomPages.*;
import com.twoitesting.utilityClasses.LoginDetailsReader;
import com.twoitesting.utilityClasses.Scroller;
import com.twoitesting.utilityClasses.Waiter;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.closeTo;

public class StepDefinitions extends BaseClass {

    private LoginPOM loginPage;
    private NavbarPOM navbar;
    private MyAccountPOM myAccountPage;
    private ShopPOM shopPage;
    private ProductPOM productPage;
    private CartPOM cartPage;
    @Before
    public void setUp() {

        super.setUp();
        super.getDriver().get(super.getBaseUrl());

        this.loginPage = new LoginPOM(super.getDriver());
        this.navbar = new NavbarPOM(super.getDriver());
        this.myAccountPage = new MyAccountPOM(super.getDriver());
        this.shopPage = new ShopPOM(super.getDriver());
        this.productPage = new ProductPOM(super.getDriver());
        this.cartPage = new CartPOM(super.getDriver());
    }

    @After
    public void tearDown() {

        // Clear cart
        this.navbar.navigateToCartPage();
        this.cartPage.emptyCart();

        // Thread sleep needed to prevent websites auto scroll down when removing items from cart.
        Waiter.threadSleep(2);

        // Logout
        Scroller.scrollToElement(super.getDriver(), this.navbar.getMyAccountTab());
        this.navbar.navigateToMyAccount();
        this.myAccountPage.clickLogoutBtn();

        super.tearDown();
    }

    @Given("I am logged in")
    public void i_am_logged_in() {

        LoginDetailsReader loginDetailsReader = new LoginDetailsReader();
        String username = loginDetailsReader.getUsername();
        String password = loginDetailsReader.getPassword();

        this.loginPage.login(username, password);

        assertThat("Login not successful", this.myAccountPage.getLogoutBtn().isDisplayed());
    }

    @Given("I am on the shop page")
    public void i_am_on_the_shop_page() {

        this.navbar.navigateToShopPage();
        assertThat("Not on the shop page", this.shopPage.getHeaderText(), is(equalTo("Shop")));
    }

    @Given("I added a {string} to the cart")
    public void i_added_a_item_to_the_cart(String item) {

        this.shopPage.searchForItem(item);
        this.productPage.addItemToCart();

        assertThat("No items in cart", this.navbar.getCartValue(), is(closeTo(0.1, this.navbar.getCartValue())));
    }
    @Given("I am on the cart page")
    public void i_am_on_the_cart_page() {

        this.navbar.navigateToCartPage();
    }
    @Given("I input discount code {string}")
    public void i_input_discount_code(String couponCode) {

        this.cartPage.inputCouponCode(couponCode);
        Waiter.threadSleep(2);
    }
    @When("I apply the discount code")
    public void i_apply_the_discount_code() {

        this.cartPage.clickApplyCouponBtn();
        Waiter.threadSleep(2);
    }
    @Then("The total is correct after discount and shipping is applied")
    public void the_total_is_correct_after_discount_and_shipping_is_applied() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
