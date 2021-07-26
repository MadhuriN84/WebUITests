package pages.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import pages.locators.APProductDetailsPageLocators;

import utils.SeleniumDriver;

import static org.junit.Assert.*;

public class APProductDetailsPageActions {
    APProductDetailsPageLocators automationPracticeProductDetailsPageLocators = null;

    public APProductDetailsPageActions() {
        this.automationPracticeProductDetailsPageLocators = new APProductDetailsPageLocators();
        PageFactory.initElements(SeleniumDriver.getDriver(), automationPracticeProductDetailsPageLocators);
    }

    public void clickOnWomenButton(){
        automationPracticeProductDetailsPageLocators.subMenuWomen.click();
        SeleniumDriver.getWaitDriver().until(ExpectedConditions.visibilityOf(automationPracticeProductDetailsPageLocators.womenLogo));
        assertTrue(automationPracticeProductDetailsPageLocators.womenLogo.isDisplayed());

    }

    public void chooseTheDesiredProduct(String[] productName, String [] quantityArray, String [] sizeArray) {
        int index = 0;
        WebElement ProductToSelect;
        for (String dressName: productName) {
            switch (dressName) {
                case "Printed Dress1":
                    ProductToSelect = automationPracticeProductDetailsPageLocators.printedDress1;
                    break;
                case "Printed Summer Dress1":
                    ProductToSelect = automationPracticeProductDetailsPageLocators.printedSummerDress1;
                    break;
                default:
                    ProductToSelect = SeleniumDriver.getDriver().findElement(new By.ByXPath
                            ("//div[@id='center_column']//a[@class='product-name' and contains(text(),'" + dressName + "')]"));

            }
            SeleniumDriver.getWaitDriver().until(ExpectedConditions.elementToBeClickable(ProductToSelect));
            ProductToSelect.click();
            assertTrue(dressName.toLowerCase().contains(automationPracticeProductDetailsPageLocators.productName.getText().toLowerCase()));
            setQuantity(index, quantityArray);
            setSize(index, sizeArray);
            clickOnAddToCart();
            clickOnContinueShopping();
            index++;
            returnToProductDetails();
        }

    }

    public void setQuantity(int index, String [] quantityArray){
        String quantity = quantityArray[index];
        automationPracticeProductDetailsPageLocators.quantity.clear();
        automationPracticeProductDetailsPageLocators.quantity.sendKeys(quantity);
        assertTrue(automationPracticeProductDetailsPageLocators.quantity.getAttribute("value").contentEquals(quantity));
    }

    public void setSize(int index, String[] sizeArray){
        String textValue = sizeArray[index];
        Select dropdown = new Select(automationPracticeProductDetailsPageLocators.sizeDropdown);
        dropdown.selectByVisibleText(textValue);
        System.out.println(dropdown.getFirstSelectedOption());
    }

    public void clickOnAddToCart(){
        SeleniumDriver.getWaitDriver().until(ExpectedConditions.elementToBeClickable(automationPracticeProductDetailsPageLocators.addToCart));
        automationPracticeProductDetailsPageLocators.addToCart.click();
        SeleniumDriver.getWaitDriver().until(ExpectedConditions.visibilityOf(automationPracticeProductDetailsPageLocators.productAddedSucccessfulText));
        assertTrue(automationPracticeProductDetailsPageLocators.productAddedSucccessfulText.getText().contains("successfully"));
    }

    public void clickOnContinueShopping() {
        SeleniumDriver.getWaitDriver().until(ExpectedConditions.elementToBeClickable(automationPracticeProductDetailsPageLocators.continueShoppingButton));
        automationPracticeProductDetailsPageLocators.continueShoppingButton.click();
        assertTrue(automationPracticeProductDetailsPageLocators.addToCart.isDisplayed());

    }

    public void clickOnCart() {
        SeleniumDriver.getWaitDriver().until(ExpectedConditions.elementToBeClickable(automationPracticeProductDetailsPageLocators.shoppingCartButton));
        automationPracticeProductDetailsPageLocators.shoppingCartButton.click();
        assertTrue(SeleniumDriver.getDriver().findElement(By.xpath("//*[@id='center_column']/p[2]/a[1]")).isDisplayed());

    }

    public void returnToProductDetails()  {
        String currentUrl = SeleniumDriver.getDriver().getCurrentUrl();
        if(currentUrl.contains("id_product")){
            SeleniumDriver.getDriver().navigate().to("http://automationpractice.com/index.php?id_category=3&controller=category");
        }
        SeleniumDriver.getWaitDriver().until(ExpectedConditions.visibilityOf(automationPracticeProductDetailsPageLocators.womenLogo));
        assertTrue(automationPracticeProductDetailsPageLocators.womenLogo.isDisplayed());
    }



}

