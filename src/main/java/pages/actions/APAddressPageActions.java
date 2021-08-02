package pages.actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.locators.APAddressPageLocators;
import pages.locators.APAuthenticationPageLocators;
import pages.locators.APShippingPageLocators;
import utils.SeleniumDriver;

import static org.junit.Assert.assertTrue;

public class APAddressPageActions {

	APAddressPageLocators automationPracticeAddressPageLocators = null;
	APShippingPageLocators automationPracticeShippingPageLocators = null;

	public APAddressPageActions() {
		this.automationPracticeAddressPageLocators = new APAddressPageLocators();
		this.automationPracticeShippingPageLocators = new APShippingPageLocators();
		PageFactory.initElements(SeleniumDriver.getDriver(), automationPracticeAddressPageLocators);
		PageFactory.initElements(SeleniumDriver.getDriver(), automationPracticeShippingPageLocators);
	}

	public void clickOnProceedToCheckout() {
		SeleniumDriver.getWaitDriver().until(
				ExpectedConditions.elementToBeClickable(automationPracticeAddressPageLocators.proceedToCheckout));
		automationPracticeAddressPageLocators.proceedToCheckout.click();
		assertTrue(automationPracticeShippingPageLocators.shippingText.getText().equalsIgnoreCase("shipping"));
	}
}
