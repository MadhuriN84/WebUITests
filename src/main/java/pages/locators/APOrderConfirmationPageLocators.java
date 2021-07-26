package pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class APOrderConfirmationPageLocators {
    @FindBy(how = How.XPATH, using = "//*[@id='center_column']/p[1]")
    public WebElement orderSuccessText;

}
