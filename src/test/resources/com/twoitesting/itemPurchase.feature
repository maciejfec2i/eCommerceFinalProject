Feature: Purchasing Items

  Background:
    Given I am logged in
    And I add an item to the cart

  Scenario: Applying a discount code
    Given I am on the cart page
    And I input discount code "<discount code>"
      | discount code |
      | edgewords     |
    When I apply the discount code
    Then The total is correct after discount and shipping is applied

