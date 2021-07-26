package pages.actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.locators.APOrderConfirmationPageLocators;
import pages.locators.APOrderSummaryPageLocators;
import utils.SeleniumDriver;

import static org.junit.Assert.assertTrue;

public class APOrderSummaryPageActions {
    APOrderSummaryPageLocators automationPracticeOrderSummaryPageLocators = null;
    APOrderConfirmationPageLocators automationPracticeOrderConfirmationPageLocators = null;

    public APOrderSummaryPageActions() {
        this.automationPracticeOrderSummaryPageLocators = new APOrderSummaryPageLocators();
        this.automationPracticeOrderConfirmationPageLocators = new APOrderConfirmationPageLocators();
        PageFactory.initElements(SeleniumDriver.getDriver(), automationPracticeOrderSummaryPageLocators);
        PageFactory.initElements(SeleniumDriver.getDriver(), automationPracticeOrderConfirmationPageLocators);
    }

    public void clickOnConfirmOrderButton() {

        SeleniumDriver.getWaitDriver().until(ExpectedConditions.elementToBeClickable(automationPracticeOrderSummaryPageLocators.confirmOrderButton));
        automationPracticeOrderSummaryPageLocators.confirmOrderButton.click();
        SeleniumDriver.getWaitDriver().until(ExpectedConditions.visibilityOf(automationPracticeOrderConfirmationPageLocators.orderSuccessText));
        assertTrue(automationPracticeOrderConfirmationPageLocators.orderSuccessText.getText().contains("My Store is complete"));
    }
}
