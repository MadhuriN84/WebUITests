package pages.actions;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import pages.locators.APContactusPageLocators;

import utils.SeleniumDriver;

public class APContactusPageActions {
	APContactusPageLocators automationPracticeContactusPageLocators = null;

    public APContactusPageActions() {
        this.automationPracticeContactusPageLocators = new APContactusPageLocators();
        PageFactory.initElements(SeleniumDriver.getDriver(), automationPracticeContactusPageLocators);
    }

/*    public void verifyTheOrderConfirmation() {
        SeleniumDriver.getWaitDriver().until(ExpectedConditions.visibilityOf(automationPracticeContactusPageLocators.orderSuccessText));
        assertTrue(automationPracticeContactusPageLocators.orderSuccessText.getText().contains("My Store is complete"));
    }*/
    
    public void clickOnContactusButton() { 
        SeleniumDriver.getWaitDriver().until(ExpectedConditions.elementToBeClickable(automationPracticeContactusPageLocators.ContactusButton));
        automationPracticeContactusPageLocators.ContactusButton.click();
        assertTrue(SeleniumDriver.getDriver().getCurrentUrl().contains("contact"));
    }
    public void enterEmailAddress(String emailid) {

        SeleniumDriver.getWaitDriver().until(ExpectedConditions.elementToBeClickable(automationPracticeContactusPageLocators.emailTextbox));
        automationPracticeContactusPageLocators.emailTextbox.sendKeys(emailid);
        String enteredValue = automationPracticeContactusPageLocators.emailTextbox.getAttribute("value");
        assertTrue(enteredValue.contentEquals(emailid));
    }
    
	public void enterfilelocation(String filelocation) {

		File classpathRoot = new File(System.getProperty("user.dir"));
		File picture = new File(classpathRoot, filelocation);
		String picturePath = picture.getAbsolutePath();
		automationPracticeContactusPageLocators.FileUploadTextArea.sendKeys(picturePath);

	}
    
	public void selectValueFromDown() { 
		Select dropdown = new Select(automationPracticeContactusPageLocators.SubjectHeading);
		dropdown.selectByIndex(2);

	}
	
	public void clickOnSendButton() { 
		SeleniumDriver.getWaitDriver().until(ExpectedConditions.elementToBeClickable(automationPracticeContactusPageLocators.sendButton));
		automationPracticeContactusPageLocators.sendButton.click();
	
	}
    
    public void messageTextArea(String message) {

        SeleniumDriver.getWaitDriver().until(ExpectedConditions.elementToBeClickable(automationPracticeContactusPageLocators.MessageTextArea));
        automationPracticeContactusPageLocators.MessageTextArea.sendKeys(message);
       
        
    }
    
    public void confirmationMessage(String Message) { 

        SeleniumDriver.getWaitDriver().until(ExpectedConditions.visibilityOf(automationPracticeContactusPageLocators.ConfirmationMessage));
       
        String text = automationPracticeContactusPageLocators.ConfirmationMessage.getText();
        assertTrue(text.contains("successful"));
        
        
    }

}
