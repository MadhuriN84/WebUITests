@SearchProduct
Feature: To validate the search product functionality

  Scenario Outline: Validate the search product functionality.
   Given the user is on the home page "http://automationpractice.com/index.php"
    When the search bar is visible and enabled
    And the user enters the "productname" under "<productname>" field
    And the users click on the "Search" button
   Then the user should see the corresponding "<ResultsMessage>"
   And the results should contain the "<productname>"
   

     Examples:
      | productname				   |ResultsMessage		|
      | shirts					   |1			|
      | Dress					   |7			|
      | Tops  					   |0			|
      