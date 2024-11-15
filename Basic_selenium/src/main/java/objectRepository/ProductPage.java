package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
//declaration
	
	@FindBy(id = "add-to-cart")
	private WebElement addtocartBtn;
	
	@FindBy(id = "shopping_cart_container")
	private WebElement cartContainerbtn;
	
	//initialization
	
	public ProductPage(WebDriver driver)
	
	{
	 PageFactory.initElements(driver, this);	
	}
	
	//utilization
	

	public WebElement getAddtocartBtn() {
		return addtocartBtn;
	}

	public WebElement getCartContainerbtn() {
		return cartContainerbtn;
	}
	 //business library
	/**
	 * This method will click on add to cart button
	 */
	public void clickOnAddToCartButton()
	{
		addtocartBtn.click();
	}
	/**
	 * This method will click on cart container
	 */
	public void clickOnCartContainer()
	{
		cartContainerbtn.click();
		
	}
}



