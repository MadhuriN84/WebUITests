package pages.actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.locators.APOrderConfirmationPageLocators;
import pages.locators.APOrderSummaryPageLocators;
import utils.SeleniumDriver;

import static org.junit.Assert.assertTrue;

public class APOrderConfirmationPageActions {
        APOrderConfirmationPageLocators automationPracticeOrderConfirmationPageLocators = null;

        public APOrderConfirmationPageActions() {
            this.automationPracticeOrderConfirmationPageLocators = new APOrderConfirmationPageLocators();
            PageFactory.initElements(SeleniumDriver.getDriver(), automationPracticeOrderConfirmationPageLocators);
        }

        public void verifyTheOrderConfirmation() {
            SeleniumDriver.getWaitDriver().until(ExpectedConditions.visibilityOf(automationPracticeOrderConfirmationPageLocators.orderSuccessText));
            assertTrue(automationPracticeOrderConfirmationPageLocators.orderSuccessText.getText().contains("My Store is complete"));
        }
}
