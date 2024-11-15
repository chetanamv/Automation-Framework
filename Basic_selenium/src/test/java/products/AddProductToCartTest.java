package products;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.AllProductsPage;
import objectRepository.LoginPage;
import objectRepository.ProductPage;
import objectRepository.YourCartPage;
@Listeners(genericUtilities.ListenersImplementation.class)
public class AddProductToCartTest extends BaseClass {
@Test(groups = "Smoke") /* Test method or test script*/
		public void tc_001_AddSingleProductToCartTest() throws InterruptedException, IOException {
		
			//Create object of utility classes
	ExcelFileUtility eutil=new ExcelFileUtility();
	PropertyFileUtility putil=new PropertyFileUtility();
	SeleniumUtility sutil=new SeleniumUtility(); 
	
	
			//Read the common data from property file
		/*String URL = putil.readDataFromPropertyFile("url");
		String USERNAME = putil.readDataFromPropertyFile("username");
		String PASSWORD = putil.readDataFromPropertyFile("password");*/
		//Read the test data from excel file
	
		String PRODUCTNAME = eutil.readDataFromExcel("products", 1, 2);
		System.out.println(PRODUCTNAME);
		
		
		//Step 1: Launch the browser
			//WebDriver driver=new FirefoxDriver();
			
			sutil.maximizeWindow(driver);
			sutil.addImplicitlyWait(driver);
		//Step 2: Load the URL	 
			//driver.get(URL);
		//Step 3: Login to application	
	//		driver.findElement(By.id("user-name")).sendKeys(USERNAME);
	//		driver.findElement(By.id("password")).sendKeys(PASSWORD);
	//		driver.findElement(By.id("login-button")).click();
			
			//LoginPage lp= new LoginPage(driver);
	//		lp.getUsernameEdt().sendKeys(USERNAME);
	//		lp.getPasswordEdt().sendKeys(PASSWORD);
	//		lp.getLoginBtn().click();
	//		lp.loginToApp(USERNAME, PASSWORD);
			
		//Step 4: Click on a Product
			Thread.sleep(4000);
			
			/*The below line is an example for dynamic xpath*/
		
	//		driver.findElement(By.xpath("//div[text()='"+PRODUCTNAME+"']")).click();
	//		String ProductTitle = driver.findElement(By.xpath("//div[text()='"+PRODUCTNAME+"']")).getText();
			
			AllProductsPage ap=new AllProductsPage(driver);
			String ProductTitle = ap.clickOnProductName(driver, PRODUCTNAME);
			
			
			
			//step 5: Add product to cart
	//		driver.findElement(By.id("add-to-cart")).click();
	//	Thread.sleep(4000);
			ProductPage pp=new ProductPage(driver);
			pp.clickOnAddToCartButton();
			
		
			//step6: Navigate to cart and validate the product
	//		driver.findElement(By.className("shopping_cart_link")).click();
	//		String ProducttitleInCart = driver.findElement(By.className("inventory_item_name")).getText();
	//		Thread.sleep(4000);
			pp.clickOnCartContainer();
			
			Assert.fail();
			
			//step 7: capture the product details in cart
			
			YourCartPage ucp=new YourCartPage(driver);
					String ProductTitleInCart = ucp.getProducttitle();
			//Step 8: VAlidate for product name
			
	/*		if(ProductTitleInCart.equalsIgnoreCase(ProductTitle))
			{
				System.out.println("Product successfully added to cart");
				System.out.println("Pass");
				//System.out.println(ProducttitleInCart);
			}
			else
			{
				System.out.println("Product not added to cart-> Fail");
				
			}
			
			driver.findElement(By.id("react-burger-menu-btn")).click();
			driver.findElement(By.linkText("Logout")).click();
			Thread.sleep(4000);
			
			System.out.println("Logout successful");  */
					
					Assert.assertEquals(ProductTitleInCart, ProductTitle);
					Assert.assertTrue(ProductTitleInCart.contains(ProductTitle));
			
			}

	}


