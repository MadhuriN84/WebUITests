@login
Feature: Acceptance Testing to validate the user login and shopping cart functionality

  Scenario Outline: Validate the login functionality of Automation Practice
    Given the user is on the home page "http://automationpractice.com/index.php"
    When the user clicks on the "SignIn" button
    And the user enters the "emailaddress" under "<emailaddress>" field
    And the user enters the "password" under "<password>" field
    And the user clicks on the "Submit" button
    Then the user should see the corresponding "<message>"

     Examples:
      | emailaddress                | password               | message         |
      | madhuri.nalamotu@gmail.com  | Helloworld12345        | InvalidPassword |
      | madhuri.qwnalamotu@gmail.com| test123		         | InvalidEmail    |
      | madhuri.nalamotu@gmail.com  |                        | BlankPassword   |
      |                             | Helloworld12345        | BlankEmail      |
      |                             |                        | BlankDetails    |
      | madhuri.nalamotu@gmail.com  | test123	             | Successful      |