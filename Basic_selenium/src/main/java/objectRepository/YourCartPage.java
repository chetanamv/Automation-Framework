package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourCartPage {
	//Declaration
	
	@FindBy(className = "inventory_item_name")
	 private WebElement ProductNameLnk;
	
	//initialization
	
	public YourCartPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getProductNameLnk()
	{
		return ProductNameLnk;
	}

	//Business library
	/**
	 * this method will capture the product title in cart and return to caller
	 * @return
	 */
	public String getProducttitle()
	{
		return ProductNameLnk.getText();
	}

}
