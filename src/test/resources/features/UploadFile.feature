@UploadFile
Feature: To test the upload file functionality, Raise a ticket by uploading a file

  Scenario Outline: Validate the upload file functionality by raising a ticket.
   Given the user is on the home page "http://automationpractice.com/index.php"
    When the user clicks on the "Contactus" button
    And the user sets the subject heading
    And the user enters the "emailid" under "<emailid>" field
   And the user enters the "FileLocation" under "<FileLocation>" field
   And the user enters the "message" under "<message>" field
   And the users click on the "Send" button
   Then the user should see the corresponding "<Message>"
    

     Examples:
      | emailid				   		| FileLocation      | message          |Message						|
      | madhuri.nalamotu@gmail.com  | dress.png         | hi      		   |Successfullysent			|
      