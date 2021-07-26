package pages.actions;

import org.apache.commons.lang3.ArrayUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.locators.APAddressPageLocators;
import pages.locators.APShoppingCartPageLocators;
import utils.SeleniumDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class APShoppingCartPageActions {
    APShoppingCartPageLocators automationPracticeShoppingCartPageLocators = null;
    APAddressPageLocators automationPracticeAddressPageLocators = null;

    public APShoppingCartPageActions() {
        this.automationPracticeShoppingCartPageLocators = new APShoppingCartPageLocators();
        this.automationPracticeAddressPageLocators = new APAddressPageLocators();
        PageFactory.initElements(SeleniumDriver.getDriver(), automationPracticeShoppingCartPageLocators);
        PageFactory.initElements(SeleniumDriver.getDriver(), automationPracticeAddressPageLocators);
    }

    public void verifyTheUpdatedProductDetails(String[] dressnames, String[] quantities){
        List<String> quantityList = new ArrayList(Arrays.asList(quantities));
        List<String> dressList = new ArrayList(Arrays.asList(dressnames));
        String [] updatedDressnames;
        if(quantityList.contains("0")){
            if(quantityList.size() == 1 && dressList.size()==1){
                String cartEmptyText = automationPracticeShoppingCartPageLocators.cartEmpty.getText();
                assertTrue(cartEmptyText.contentEquals("Your shopping cart is empty."));
            }else if (dressList.size()>1){
                int positionOfZero = quantityList.indexOf("0");
                dressList.remove(positionOfZero);
                updatedDressnames = dressList.stream().toArray(String[]::new);
                verifyTheProductNamesInShoppingCart(updatedDressnames);
            }
        }else {
            verifyTheProductNamesInShoppingCart(dressnames);
        }
    }


    public void verifyTheProductNamesInShoppingCart(String [] dressNameArray){
        List<WebElement> productSet = automationPracticeShoppingCartPageLocators.productsSummaryTable;
        int numberofProducts = dressNameArray.length;
        assertEquals(productSet.size(), numberofProducts);
        for(int index = 0; index<dressNameArray.length; index++ ) {
            String fullProductText = productSet.get(index).getText();
            String nameSubstringFromfullProductText = fullProductText.substring(0,fullProductText.indexOf("SKU")-1);
            assertTrue(dressNameArray[index].contains(nameSubstringFromfullProductText));
        }
    }

    public void verifyTheProductsSizeInShoppingCart(String [] sizeArray){
        List<WebElement> productSet = automationPracticeShoppingCartPageLocators.productsSummaryTable;
        for(int i = 0; i<sizeArray.length; i++ ) {
            String fullProductText = productSet.get(i).getText();
            String sizeSubstringFromFullProductText = fullProductText.substring(fullProductText.indexOf("Size"),fullProductText.indexOf("Size")+9);
            assertTrue(sizeSubstringFromFullProductText.contains(sizeArray[i]));
        }
    }

    public void verifyTheProductQuantities(String [] quantityArray){
        for(int i = 1; i <= quantityArray.length; i++){

            WebElement tempElement = SeleniumDriver.getDriver().findElement(By.xpath("//table/tbody/tr["+i+"]/td[5]/input[2]"));
            assertTrue(tempElement.getAttribute("value").contentEquals(quantityArray[i-1]));
        }
    }

    public void updateTheProductQuantities(String [] quantityArray) throws InterruptedException {
        for(int i = 1; i <= quantityArray.length; i++) {
            WebElement tempElement = SeleniumDriver.getDriver().findElement(By.xpath("//table/tbody/tr[" + i + "]/td[5]/input[2]"));
            tempElement.clear();
            if(quantityArray[i - 1].equalsIgnoreCase("0") ){
                WebElement tempDeleteButton = SeleniumDriver.getDriver().findElement(By.xpath("//table/tbody/tr["+i+"]/td[7]/div/a"));
                tempDeleteButton.click();
                Thread.sleep(3000);
                quantityArray = ArrayUtils.remove(quantityArray, Integer.parseInt(quantityArray[i - 1]));

            }
            else {
                tempElement.sendKeys(quantityArray[i - 1]);
            }
        }
    }

    public void clickOnProceedToCheckout(){
        SeleniumDriver.getWaitDriver().until(ExpectedConditions.elementToBeClickable(automationPracticeShoppingCartPageLocators.proceedToCheckOutButton));
        automationPracticeShoppingCartPageLocators.proceedToCheckOutButton.click();
        assertTrue(automationPracticeAddressPageLocators.addressText.getText().equalsIgnoreCase("ADDRESSES"));
    }
}
