package pages.actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.locators.APLandingPageLocators;
import utils.SeleniumDriver;

import static org.junit.Assert.assertTrue;


public class APLandingPageActions {

    APLandingPageLocators automationPracticeLandingPageLocators = null;


    public APLandingPageActions() {
        this.automationPracticeLandingPageLocators = new APLandingPageLocators();
        PageFactory.initElements(SeleniumDriver.getDriver(), automationPracticeLandingPageLocators);
    }

    public void verifyTheLandingPage(){
        String actualTitle = SeleniumDriver.getDriver().getTitle();
        assertTrue(actualTitle.contains("Store"));
    }

    public void clickOnSignInButton() {
        SeleniumDriver.getWaitDriver().until(ExpectedConditions.elementToBeClickable(automationPracticeLandingPageLocators.signInButton));
        automationPracticeLandingPageLocators.signInButton.click();
        assertTrue(SeleniumDriver.getDriver().getCurrentUrl().contains("authentication"));
    }

}
