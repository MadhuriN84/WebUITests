package pages.locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class APGlobalSearchPageLocators {

	 @FindBy(how = How.ID, using = "search_query_top")
	    public WebElement SearchTextArea;
	    
	    @FindBy(how = How.XPATH, using = "//button[@name='submit_search']")
	    public WebElement SearchButton;
	    

	    @FindBy(how = How.CSS, using = ".heading-counter")
	    public WebElement ResultsMessage;
	    
	    @FindBy(how = How.XPATH, using = "//h5[@itemprop='name']/a[@class='product-name']")
	    public List<WebElement> Resultnames;
	    
	    


	    
}
