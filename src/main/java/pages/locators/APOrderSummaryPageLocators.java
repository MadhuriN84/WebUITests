package pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class APOrderSummaryPageLocators {
    @FindBy(how = How.XPATH, using = "//*[@id='center_column']/h1")
    public WebElement orderSummaryText;

    @FindBy(how = How.XPATH, using = "//*[@id='cart_navigation']/button")
    public WebElement confirmOrderButton;
}
