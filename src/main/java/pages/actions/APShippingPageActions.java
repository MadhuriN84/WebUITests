package pages.actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.locators.APAddressPageLocators;
import pages.locators.APPaymentPageLocators;
import pages.locators.APShippingPageLocators;
import utils.SeleniumDriver;

import static org.junit.Assert.assertTrue;

public class APShippingPageActions {
    APShippingPageLocators automationPracticeShippingPageLocators = null;
    APPaymentPageLocators automationPracticePaymentPageLocators = null;

    public APShippingPageActions() {
        this.automationPracticeShippingPageLocators = new APShippingPageLocators();
        this.automationPracticePaymentPageLocators = new APPaymentPageLocators();
        PageFactory.initElements(SeleniumDriver.getDriver(), automationPracticeShippingPageLocators);
        PageFactory.initElements(SeleniumDriver.getDriver(), automationPracticePaymentPageLocators);
    }

    public void acceptTermsAndClickOnProceedToCheckout() {

        SeleniumDriver.getWaitDriver().until(ExpectedConditions.elementToBeClickable(automationPracticeShippingPageLocators.proceedToCheckout));
        automationPracticeShippingPageLocators.acceptTerms.click();
        automationPracticeShippingPageLocators.proceedToCheckout.click();
        assertTrue(automationPracticePaymentPageLocators.paymentMethodText.getText().contains("PAYMENT"));

    }
}
