@cart @search
Feature: To Test the add to cart functionality

  Scenario Outline: To verify the basic functionality of add to cart for "<dress name>"
    Given the user is on the home page "http://automationpractice.com/index.php"
    When the user logs into the application successfully with "madhuri.nalamotu@gmail.com" and "test123"
    And the user clicks on the "Women" button
    And the user chooses the products with desired details "<dress name>", "<quantity>", "<size>"
    And the user clicks on the "cart" button
    Then the user should see the Shopping-Cart with selected values of "<dress name>", "<quantity>" and "<size>"
    When the user edits the Shopping-Cart with "<updated_quantity>"
    Then the user should see the Shopping-Cart with updated values "<dress name>" "<updated_quantity>"

      Examples:
      | dress name                                                      | quantity    | size       | updated_quantity |
      | Faded Short Sleeve T-shirts, Blouse                             | 1, 5        | S, L       |  4, 0            |


