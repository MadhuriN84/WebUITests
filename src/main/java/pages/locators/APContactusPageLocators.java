package pages.locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class APContactusPageLocators {
	
    @FindBy(how = How.XPATH, using = "//div[@id='contact-link']")
    public WebElement ContactusButton;
    
    @FindBy(how = How.XPATH, using = "//select[@id='id_contact']")
    public WebElement SubjectHeading;
    

    @FindBy(how = How.XPATH, using = "//input[@id='email']")
    public WebElement emailTextbox;

    @FindBy(how = How.ID, using = "fileUpload")
    public WebElement FileUploadTextArea;
    
    @FindBy(how = How.XPATH, using = "//textarea[@id='message']")
    public WebElement MessageTextArea;
    
    @FindBy(how = How.XPATH, using = "//button[@id='submitMessage']")
    public WebElement sendButton;
    
    @FindBy(how = How.XPATH, using = "(//p)[3]")
    public WebElement ConfirmationMessage;
    

	
    
    





}
