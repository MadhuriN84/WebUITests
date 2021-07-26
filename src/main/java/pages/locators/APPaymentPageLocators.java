package pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class APPaymentPageLocators {
    @FindBy(how = How.XPATH, using = "//*[@id='center_column']/h1")
    public WebElement paymentMethodText;

    @FindBy(how = How.XPATH, using = "//*[@id='HOOK_PAYMENT']/div[2]/div/p/a")
    public WebElement payByCheckButton;

}
