package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllProductsPage {
	
	@FindBy(id = "react-burger-menu-btn")
	private WebElement menubtn;
	
	@FindBy(id = "logout_sidebar_link")
   private WebElement logoutlnk;
	
public AllProductsPage(WebDriver driver)
	
	{
		PageFactory.initElements(driver, this);
		
	}


public WebElement getMenubtn() {
	return menubtn;
}

public WebElement getLogoutlnk() {
	return logoutlnk;
}

//Business library operation
/**
 * this method will click on menu button
 */
public void clickOnMenuButton()
{
	menubtn.click();
}
/**
 * this method will perform logout operation 
 */
public void logoutOfApp()
{
	menubtn.click();
	logoutlnk.click();
	
}
/**
 * This method will click on particular  product and return the title to caller
 * @param driver
 * @param PRODUCTNAME
 * @return
 */
public String clickOnProductName(WebDriver driver,String PRODUCTNAME)
{
	String productTitle = driver.findElement(By.xpath("//div[text()='"+PRODUCTNAME+"']")).getText();
	driver.findElement(By.xpath("//div[text()='"+PRODUCTNAME+"']")).click();
	 return productTitle;          // for validation
	 
}
}
