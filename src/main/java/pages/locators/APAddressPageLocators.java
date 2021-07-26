package pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class APAddressPageLocators {
    @FindBy(how = How.XPATH, using = "//*[@id='center_column']/h1")
    public WebElement addressText;

    @FindBy(how = How.XPATH, using = "//*[@id='center_column']/form/p/button")
    public WebElement proceedToCheckout;


}
