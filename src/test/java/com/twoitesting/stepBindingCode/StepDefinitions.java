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

    private NavbarPOM navbar;
    private SearchBarPOM searchBar;
    private LoginPOM loginPage;
    private MyAccountPOM myAccountPage;
    private ShopPOM shopPage;
    private ProductPOM productPage;
    private CartPOM cartPage;
    private CheckoutPOM checkoutPage;
    private OrderReceivedPOM orderReceivedPage;
    private OrdersPOM ordersPage;

    @Before
    public void setUp() {

        super.setUp();
        super.getDriver().get(super.getBaseUrl());

        // POM setup
        this.navbar = new NavbarPOM(super.getDriver());
        this.searchBar = new SearchBarPOM(super.getDriver());
        this.loginPage = new LoginPOM(super.getDriver());
        this.myAccountPage = new MyAccountPOM(super.getDriver());
        this.shopPage = new ShopPOM(super.getDriver());
        this.productPage = new ProductPOM(super.getDriver());
        this.cartPage = new CartPOM(super.getDriver());
        this.checkoutPage = new CheckoutPOM(super.getDriver());
        this.orderReceivedPage = new OrderReceivedPOM(super.getDriver());
        this.ordersPage = new OrdersPOM(super.getDriver());

        this.loginPage.clickCookieDismissBtn();
    }

    @After(value = "@EmptyCart")
    public void tearDown() {

        // Clear cart
        Waiter.threadSleep(1); // Thread sleep needed to wait out the websites autoscroll
        Scroller.scrollToElement(super.getDriver(), this.navbar.getMyAccountTab());
        this.navbar.navigateToCartPage();
        this.cartPage.emptyCart();

        // Thread sleep needed to wait out the website's auto scroll down after removing items from cart.
        Waiter.threadSleep(2);

        // Logout
        Scroller.scrollToElement(super.getDriver(), this.navbar.getMyAccountTab());
        this.navbar.navigateToMyAccount();
        this.myAccountPage.clickLogoutBtn();

        super.tearDown();
    }

    @After(value = "@CartEmpty")
    public void tearDown2() {

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
        assertThat("Login not successful", this.myAccountPage.getLogoutBtn().isDisplayed(), is(true));
    }

    @Given("I am on the shop page")
    public void i_am_on_the_shop_page() {

        this.navbar.navigateToShopPage();
        assertThat("Not on the shop page", this.shopPage.getHeaderText(), is(equalTo("Shop")));
    }

    @Given("I added a {string} to the cart")
    public void i_added_a_item_to_the_cart(String item) {

        this.searchBar.searchForItem(item);
        this.productPage.addItemToCart();

        assertThat("No items in cart", this.navbar.getCartValue(), is(closeTo(0.1, this.navbar.getCartValue())));
    }
    @Given("I am on the cart page")
    public void i_am_on_the_cart_page() {

        this.navbar.navigateToCartPage();
        assertThat("Not on the cart page", this.cartPage.getHeaderText(), is(equalTo("Cart")));
    }
    @Given("I input discount code {string}")
    public void i_input_discount_code(String couponCode) {

        this.cartPage.inputCouponCode(couponCode);
    }
    @When("I apply the discount code")
    public void i_apply_the_discount_code() {

        this.cartPage.clickApplyCouponBtn();

        // Wait for discount table data to appear
        Waiter.waitForElementToBeVisible(super.getDriver(), 5, this.cartPage.getCouponTableData());
        assertThat("Coupon not applied", this.cartPage.getCouponTableData().isDisplayed(), is(true));
    }
    @Then("The total is correct after discount and shipping is applied")
    public void the_total_is_correct_after_discount_and_shipping_is_applied() {

        double subtotal = this.cartPage.getSubtotal();
        double discountAmount = this.cartPage.getDiscountAmount();
        double shippingCost = this.cartPage.getShippingCost();
        double expectedTotal = this.cartPage.getTotal();
        double actualTotal = subtotal - discountAmount + shippingCost;

        assertThat("Expected total is not equal actual total", actualTotal, is(equalTo(expectedTotal)));
    }

    @When("I go to the checkout page")
    public void i_go_to_the_checkout_page() {

        this.navbar.navigateToCheckoutPage();
        assertThat("Not on the checkout page", this.checkoutPage.getHeaderText(), is(equalTo("Checkout")));
    }
    @When("I purchase the item using valid details {string}")
    public void i_purchase_the_item_using_valid_details(String details) {

        // The details are passed in as a string separated by commas, hence the split method.
        String[] requiredBillingDetails = details.split(",");
        this.checkoutPage.inputRequiredBillingDetails(
                requiredBillingDetails[0],
                requiredBillingDetails[1],
                requiredBillingDetails[2],
                requiredBillingDetails[3],
                requiredBillingDetails[4],
                requiredBillingDetails[5],
                requiredBillingDetails[6]
        );

        Waiter.threadSleep(1); // one second wait for button to update after inserting postcode
        this.checkoutPage.clickPlaceOrderBtn();
    }
    @Then("I should see my order details")
    public void i_should_see_my_order_details() {

        assertThat("Order details are not displayed", this.orderReceivedPage.getOrderNumTableData().isDisplayed(), is(true));
    }
    @Then("The order details should be in my orders")
    public void the_order_details_should_be_in_my_orders() {

        // Captures the order number from the Order Received page
        String expectedOrderNum = this.orderReceivedPage.getOrderNumber();

        this.navbar.navigateToMyAccount();
        this.myAccountPage.clickOrdersBtn();

        // Captures the latest order number from the Orders page
        String latestOrderNum = this.ordersPage.getLatestOrderNumber();

        assertThat("Order numbers do not match", expectedOrderNum, is(equalTo(latestOrderNum)));
    }
}
