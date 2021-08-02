
@Orderplacement
Feature: OrderPlacement Process

  Scenario Outline: To verify the basic functionality of Checkout for "<dress name>"
    Given the user is on the home page "http://automationpractice.com/index.php"
    When the user logs into the application successfully with "madhuri.nalamotu@gmail.com" and "test123"
    And the user clicks on the "Women" button
    And the user chooses the products with desired details "<dress name>", "<quantity>", "<size>"
    And the user clicks on the "cart" button
    And the user clicks on the "proceed to checkout" button
    And the user clicks on the "pay by check" button
    And the user clicks on the "confirm order" button
    Then the user should see the order confirmation

      Examples:
        | dress name                                                      | quantity    | size       |
        | Printed Summer Dress                                            | 1           |  L         |

