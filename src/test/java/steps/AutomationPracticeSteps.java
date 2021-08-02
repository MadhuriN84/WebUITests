package steps;

import pages.actions.*;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;

import java.io.File;

import org.openqa.selenium.By;

import io.cucumber.java.en.And;
import utils.SeleniumDriver;

public class AutomationPracticeSteps {

	APLandingPageActions automationPracticeLandingPageActions = new APLandingPageActions();
	APAuthenticationPageActions automationPracticeAuthenticationPageActions = new APAuthenticationPageActions();
	APProductDetailsPageActions automationPracticeProductDetailsPageActions = new APProductDetailsPageActions();
	APShoppingCartPageActions automationPracticeShoppingCartPageActions = new APShoppingCartPageActions();
	APAddressPageActions automationPracticeAddressPageActions = new APAddressPageActions();
	APShippingPageActions automationPracticeShippingPageActions = new APShippingPageActions();
	APPaymentPageActions automationPracticePaymentPageActions = new APPaymentPageActions();
	APOrderSummaryPageActions automationPracticeOrderSummaryPageActions = new APOrderSummaryPageActions();
	APOrderConfirmationPageActions automationPracticeOrderConfirmationPageActions = new APOrderConfirmationPageActions();
	APContactusPageActions automationPracticeContactusPageActions = new APContactusPageActions();
	APGlobalSearchPageActions automationPracticeGlobalSearchPageActions = new APGlobalSearchPageActions();

	@Given("^the user is on the home page \"([^\"]*)\"$")
	public void theUserIsOnTheHomePage(String BaseURL) {
		SeleniumDriver.openPage(BaseURL);
		automationPracticeLandingPageActions.verifyTheLandingPage();
	}

	/*
	 * @Given("^the user is on the Signin page \"([^\"]*)\"$") public void
	 * theUserIsOnTheSigninPage(String SigninURL) {
	 * 
	 * SeleniumDriver.openPage(SigninURL); }
	 */

	@And("^the user enters the \"([^\"]*)\" under \"([^\"]*)\" field$")

	public void theUserEntersTheValues(String fieldName, String userInput) {
		switch (fieldName) {
		case "emailaddress": 
			automationPracticeAuthenticationPageActions.enterEmailAddress(userInput);
			break;
		case "password": 
			automationPracticeAuthenticationPageActions.enterPassword(userInput);
			break;
		case "emailid": 
			automationPracticeContactusPageActions.enterEmailAddress(userInput);
			break;
		case "message": 
			automationPracticeContactusPageActions.messageTextArea(userInput);
			break;
		case "FileLocation": 
			automationPracticeContactusPageActions.enterfilelocation(userInput);
			break;
		case "productname": 
			automationPracticeGlobalSearchPageActions.enterTheProductInfo(userInput);
			break;

		}
	}

	@And("^the results should contain the \"([^\"]*)\"$")

	public void verifyTheResultPnames(String productname) 
	{
		automationPracticeGlobalSearchPageActions.verifyTheResultNames(productname);
	}

	@When("^the search bar is visible and enabled$") 

	public void visiblecheck() {

		automationPracticeGlobalSearchPageActions.searchEnabled();

	}

	@And("^the user sets the subject heading$") 

	public void selectValuefromDropdown() {

		automationPracticeContactusPageActions.selectValueFromDown();

	}

	@And("^the users click on the \"([^\"]*)\" button$")

	public void theUserClicksOnTheButtonWithAnd(String buttonName) {
		switch (buttonName) {
		case "Send": 
			automationPracticeContactusPageActions.clickOnSendButton();
			break;

		case "Search": 
			automationPracticeGlobalSearchPageActions.clickOnSearchButton();
			break;

		}
	}

	@When("^the user clicks on the \"([^\"]*)\" button$")

	public void theUserClicksOnTheButton(String buttonName) {
		switch (buttonName) {
		case "SignIn": 
			automationPracticeLandingPageActions.clickOnSignInButton();
			break;
		case "Submit": 
			automationPracticeAuthenticationPageActions.clickOnSubmitButton();
			break;
		case "Women": 
			automationPracticeProductDetailsPageActions.clickOnWomenButton();
			break;
		case "cart": 
			automationPracticeProductDetailsPageActions.clickOnCart();
			break;
		case "proceed to checkout": 
			automationPracticeShoppingCartPageActions.clickOnProceedToCheckout();
			automationPracticeAddressPageActions.clickOnProceedToCheckout();
			automationPracticeShippingPageActions.acceptTermsAndClickOnProceedToCheckout();
			break;
		case "pay by check": 
			automationPracticePaymentPageActions.clickOnPayByCheck();
			break;
		case "confirm order": 
			automationPracticeOrderSummaryPageActions.clickOnConfirmOrderButton();
			break;
		case "Contactus": 
			automationPracticeContactusPageActions.clickOnContactusButton();
			break;

		}
	}

	@Then("^the user should see the corresponding \"([^\"]*)\"$")

	public void theUserShouldSeeTheCorresponding(String expected) {
		switch (expected) {
		case "InvalidPassword":
		case "InvalidEmail": 
		case "InvalidDetails":
			automationPracticeAuthenticationPageActions.verifyTheAuthenticationFailed();
			break;
		case "BlankPassword":
			automationPracticeAuthenticationPageActions.verifyThePasswordRequired();
			break;
		case "BlankEmail": 
		case "BlankDetails": 
			automationPracticeAuthenticationPageActions.verifyTheEmailRequired();
			break;
		case "Successfullysent":
			automationPracticeContactusPageActions.confirmationMessage(expected);
			;
		case "Successful": 
			break;
		case "No Results": 
			automationPracticeGlobalSearchPageActions.verifyNoResultsFound();
			break;

		}
	}

	@When("^the user logs into the application successfully with \"([^\"]*)\" and \"([^\"]*)\"$") 
	public void theUserLogsIntoTheApplicationWithValidCredentials(String emailAddress, String password) {
		automationPracticeLandingPageActions.clickOnSignInButton();
		automationPracticeAuthenticationPageActions.enterEmailAddress(emailAddress);
		automationPracticeAuthenticationPageActions.enterPassword(password);
		automationPracticeAuthenticationPageActions.clickOnSubmitButton();

	}

	@And("^the user chooses the products with desired details \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$") 
	public void theUserChoosesTheProductsWithDesiredDetails(String dressNames, String quantities, String size) {
		String[] sizeArray = size.split(", ");
		String[] dressNameArray = dressNames.split(", ");
		String[] quantityArray = quantities.split(", ");
		automationPracticeProductDetailsPageActions.chooseTheDesiredProduct(dressNameArray, quantityArray, sizeArray);

	}

	@Then("^the user should see the Shopping-Cart with selected values of \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\"$") 
	public void theUserConfirmsSelectedShoppingCart(String dressNames, String quantities, String size) {
		String[] sizeArray = size.split(", ");
		String[] dressNameArray = dressNames.split(", ");
		String[] quantityArray = quantities.split(", ");
		automationPracticeShoppingCartPageActions.verifyTheProductNamesInShoppingCart(dressNameArray);
		automationPracticeShoppingCartPageActions.verifyTheProductsSizeInShoppingCart(sizeArray);
		automationPracticeShoppingCartPageActions.verifyTheProductQuantities(quantityArray);
	}

	@When("^the user edits the Shopping-Cart with \"([^\"]*)\"$") 
	public void theUserEditsTheShoppingCartWith(String updatedQuantities) throws InterruptedException {
		String[] quantityArray = updatedQuantities.split(", ");
		automationPracticeShoppingCartPageActions.updateTheProductQuantities(quantityArray);
	}

	@Then("^the user should see the Shopping-Cart with updated values \"([^\"]*)\" \"([^\"]*)\"$") 
	public void theUserShouldSeeTheShoppingCartWithUpdatedValues(String dressNames, String quantities) {
		String[] dressNameArray = dressNames.split(", ");
		String[] quantityArray = quantities.split(", ");
		automationPracticeShoppingCartPageActions.verifyTheUpdatedProductDetails(dressNameArray, quantityArray);
	}

	@Then("^the user should see the order confirmation$") 
	public void theUserShouldSeeTheOrderConfirmation() {
		automationPracticeOrderConfirmationPageActions.verifyTheOrderConfirmation();
	}

}
