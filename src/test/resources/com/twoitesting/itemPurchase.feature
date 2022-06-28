Feature: Purchasing Items

  Background:
    Given I am logged in
    And I am on the shop page
    And I add an item to the cart

  Scenario Outline: Applying a discount code
    Given I am on the cart page
    And I input discount code "<discount code>"
    When I apply the discount code
    Then The total is correct after discount and shipping is applied

    Examples:
      | discount code |
      | edgewords     |

