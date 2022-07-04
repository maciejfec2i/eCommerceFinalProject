Feature: Purchasing Items

  Background:
    Given I am logged in
    And I am on the shop page

  @EmptyCart # Indicates cart needs to be emptied at the end
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

  @CartEmpty # Indicates cart is empty
  Scenario Outline: Viewing order details
    Given I added a "<item>" to the cart
    When I go to the checkout page
    And I purchase the item using valid details "<details>"
    Then I should see my order details
    And The order details should be in my orders

    Examples:
      | item | details                                                                         |
      | cap  | Bob,Dylan,Fake Street,Glasgow,G1 2AF,07577777777,bob.dylan@fakemail.com         |
      | polo | Jimmy,Page,Fake Street,Edinburgh,EH2 2BY,07575757575,jimmy.page@fakeemail.com   |
      | belt | Angus,Young,Fake Street,Aberdeen,AB24 3FX,07567676767,angus.young@fakeemail.com |

