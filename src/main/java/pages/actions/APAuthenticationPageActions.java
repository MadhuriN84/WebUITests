package pages.actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.locators.APAuthenticationPageLocators;
import utils.SeleniumDriver;

import static org.junit.Assert.assertTrue;

public class APAuthenticationPageActions {

    APAuthenticationPageLocators automationPracticeAuthenticationPageLocators = null;

    public APAuthenticationPageActions() {
        this.automationPracticeAuthenticationPageLocators = new APAuthenticationPageLocators();
        PageFactory.initElements(SeleniumDriver.getDriver(), automationPracticeAuthenticationPageLocators);
    }

    public void enterEmailAddress(String emailAddress) {

        SeleniumDriver.getWaitDriver().until(ExpectedConditions.elementToBeClickable(automationPracticeAuthenticationPageLocators.emailTextField));
        automationPracticeAuthenticationPageLocators.emailTextField.sendKeys(emailAddress);
        String enteredValue = automationPracticeAuthenticationPageLocators.emailTextField.getAttribute("value");
        assertTrue(enteredValue.contentEquals(emailAddress));
    }

    public void enterPassword(String password){
        SeleniumDriver.getWaitDriver().until(ExpectedConditions.elementToBeClickable(automationPracticeAuthenticationPageLocators.passwordTextField));
        automationPracticeAuthenticationPageLocators.passwordTextField.sendKeys(password);
        String enteredValue = automationPracticeAuthenticationPageLocators.passwordTextField.getAttribute("value");
        assertTrue(enteredValue.contentEquals(password));
    }

    public void clickOnSubmitButton(){

        automationPracticeAuthenticationPageLocators.SubmitLoginButton.click();
    }

    public void verifyTheAuthenticationFailed(){
        SeleniumDriver.getWaitDriver().until(ExpectedConditions.visibilityOf(automationPracticeAuthenticationPageLocators.errorMessage));
        String text = automationPracticeAuthenticationPageLocators.errorMessage.getText();
        assertTrue(text.contains("Authentication failed."));
    }

    public void verifyThePasswordRequired(){
        SeleniumDriver.getWaitDriver().until(ExpectedConditions.visibilityOf(automationPracticeAuthenticationPageLocators.errorMessage));
        String text = automationPracticeAuthenticationPageLocators.errorMessage.getText();
        assertTrue(text.contains("Password is required."));
    }

    public void verifyTheEmailRequired(){
        SeleniumDriver.getWaitDriver().until(ExpectedConditions.visibilityOf(automationPracticeAuthenticationPageLocators.errorMessage));
        String text = automationPracticeAuthenticationPageLocators.errorMessage.getText();
        assertTrue(text.contains("An email address required."));
    }

}
