package pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class APShippingPageLocators {
    @FindBy(how = How.XPATH, using = "//*[@id='carrier_area']/h1")
    public WebElement shippingText;

    @FindBy(how = How.XPATH, using = "//*[@id='form']/p/button")
    public WebElement proceedToCheckout;

    @FindBy(how = How.XPATH, using = "//*[@id='cgv']")
    public WebElement acceptTerms;

}
