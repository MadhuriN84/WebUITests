package pages.actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.locators.APOrderSummaryPageLocators;
import pages.locators.APPaymentPageLocators;
import pages.locators.APShippingPageLocators;
import utils.SeleniumDriver;

import static org.junit.Assert.assertTrue;

public class APPaymentPageActions {
    APPaymentPageLocators automationPracticePaymentPageLocators = null;
    APOrderSummaryPageLocators automationPracticeOrderSummaryPageLocators = null;

    public APPaymentPageActions() {
        this.automationPracticePaymentPageLocators = new APPaymentPageLocators();
        this.automationPracticeOrderSummaryPageLocators = new APOrderSummaryPageLocators();
        PageFactory.initElements(SeleniumDriver.getDriver(), automationPracticePaymentPageLocators);
        PageFactory.initElements(SeleniumDriver.getDriver(), automationPracticeOrderSummaryPageLocators);
    }

    public void clickOnPayByCheck() {

        SeleniumDriver.getWaitDriver().until(ExpectedConditions.elementToBeClickable(automationPracticePaymentPageLocators.payByCheckButton));
        automationPracticePaymentPageLocators.payByCheckButton.click();
        SeleniumDriver.getWaitDriver().until(ExpectedConditions.visibilityOf(automationPracticeOrderSummaryPageLocators.orderSummaryText));
        assertTrue(automationPracticeOrderSummaryPageLocators.orderSummaryText.getText().contains("SUMMARY"));
    }
}
