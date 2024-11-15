package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {//Rule 1: create separate pom class for web page
	
	//Rule 2: Identify the web elements using annotations
	@FindBy(id="user-name")
	private WebElement usernameEdt;
	
	@FindBy(id = "password")
	private WebElement passwordEdt;
	
	@FindBy(id = "login-button")
	private WebElement loginBtn;
	
	//Rule 3: Create a constructor and initialize the Web elements
	
	public LoginPage(WebDriver driver)
	
	{
		PageFactory.initElements(driver, this);
		
	}

	//Rule 4: provide getters to access the webElement
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	

	//business library-operation
	/**
	 * This method will perform login operation
	 * @param USERNAME
	 * @param PASSWORD
	 */
	public void loginToApp(String USERNAME,String PASSWORD)
	{
		usernameEdt.sendKeys(USERNAME);
		passwordEdt.sendKeys(PASSWORD);
		loginBtn.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
