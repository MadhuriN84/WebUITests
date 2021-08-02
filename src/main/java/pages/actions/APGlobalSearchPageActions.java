package pages.actions;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import pages.locators.*;

import utils.SeleniumDriver;

public class APGlobalSearchPageActions {
	APGlobalSearchPageLocators automationPracticeGlobalSearchPageLocators = null;

	public APGlobalSearchPageActions() {
		this.automationPracticeGlobalSearchPageLocators = new APGlobalSearchPageLocators();
		PageFactory.initElements(SeleniumDriver.getDriver(), automationPracticeGlobalSearchPageLocators);
	}

	public void clickOnSearchButton() {
		SeleniumDriver.getWaitDriver().until(
				ExpectedConditions.elementToBeClickable(automationPracticeGlobalSearchPageLocators.SearchButton));
		automationPracticeGlobalSearchPageLocators.SearchButton.click();
		assertTrue(SeleniumDriver.getDriver().getCurrentUrl().contains("submit_search"));
	}

	public void enterTheProductInfo(String Product) { 

		SeleniumDriver.getWaitDriver().until(
				ExpectedConditions.elementToBeClickable(automationPracticeGlobalSearchPageLocators.SearchTextArea));
		automationPracticeGlobalSearchPageLocators.SearchTextArea.sendKeys(Product);

	}
	
	public void searchEnabled() { 

		SeleniumDriver.getWaitDriver().until(
				ExpectedConditions.elementToBeClickable(automationPracticeGlobalSearchPageLocators.SearchTextArea));
		Boolean searchenabled = automationPracticeGlobalSearchPageLocators.SearchTextArea.isDisplayed();
		assertTrue(searchenabled.TRUE);
		
	}
	
    public void verifyNoResultsFound(){ 
        SeleniumDriver.getWaitDriver().until(ExpectedConditions.visibilityOf(automationPracticeGlobalSearchPageLocators.ResultsMessage));
        String text = automationPracticeGlobalSearchPageLocators.ResultsMessage.getText();
        assertTrue(text.contains("No results"));
    }
    
	public void verifyTheResultNames(String productname) { 

		if (productname.equals("Tops")) {
			String resultMessage = automationPracticeGlobalSearchPageLocators.ResultsMessage.getText();
			assertTrue("There are results shown", resultMessage.contains("0 results"));
		} else {
			List<WebElement> results = automationPracticeGlobalSearchPageLocators.Resultnames;
			for (int i = 0; i < results.size(); i++) {
				String pname = results.get(i).getText();
				assertTrue("The results are missing the search product name", pname.contains(productname));
			}
		}
	}

}
	

