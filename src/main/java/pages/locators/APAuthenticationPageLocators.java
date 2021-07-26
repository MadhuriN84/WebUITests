package pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class APAuthenticationPageLocators {


    @FindBy(how = How.CSS, using = "#email")
    public WebElement emailTextField;

    @FindBy(how = How.CSS, using = "#passwd")
    public WebElement passwordTextField;

    @FindBy(how = How.CSS, using = "#SubmitLogin")
    public WebElement SubmitLoginButton;

    @FindBy(how = How.XPATH, using = "//*[@id='center_column']/div[1]/ol/li")
    public WebElement errorMessage;

    @FindBy(how = How.CSS, using = "#center_column > h1")
    public WebElement myAccount;

}