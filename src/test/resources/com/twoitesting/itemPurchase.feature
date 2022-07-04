Feature: Purchasing Items

  Background:
    Given I am logged in
    And I am on the shop page

    """
  Scenario Outline: Applying a discount code
    Given I added a "<item>" to the cart
    And I am on the cart page
    And I input discount code "<discount code>"
    When I apply the discount code
    Then The total is correct after discount and shipping is applied

    Examples:
      | item | discount code |
      | cap  | edgewords     |
      | polo | edgewords     |
      | belt | edgewords     |
      """

  Scenario Outline:
    Given I added a "<item>" to the cart
    When I go to the checkout page
    And I purchase the item
    Then I should see my order details
    And The order details should be in my orders

    Examples:
      | item |
      | cap  |
      #| polo |
      #| belt |

