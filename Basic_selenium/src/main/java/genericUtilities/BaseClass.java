package genericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import objectRepository.AllProductsPage;
import objectRepository.LoginPage;

/**
 * @author Chetana M V
 * This class consists of basic configuration annotations of TestNG
 */
public class BaseClass {
	 public ExcelFileUtility eUtil= new ExcelFileUtility();
	public PropertyFileUtility pUtil= new PropertyFileUtility();
	public SeleniumUtility sUtil= new SeleniumUtility();
	
	public WebDriver driver;
	// used for listeners
	public static WebDriver sDriver;
	
	@BeforeSuite(groups = {"Smoke","Regression"})
	
		public void bsConfig()
		{
			System.out.println(" -------------Database Connection successful----------------------");
		}
	//@Parameters("browser")
	//@BeforeTest
	@BeforeClass(alwaysRun = true)
	public void bcConfig(/*String BROWSER*/) throws IOException
	{
		/*for cross browser Execution*/
	/*	if(BROWSER.equalsIgnoreCase("Chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("Firefox"))
		{
			driver=new FirefoxDriver();
			
		}
		else
		{
			driver=new ChromeDriver();
		}  */
		
		String URL = pUtil.readDataFromPropertyFile("url");
	driver=new ChromeDriver();
	sUtil.maximizeWindow(driver);
	sUtil.addImplicitlyWait(driver);
	
	driver.get(URL);
	System.out.println("-----------Browser launch successful----------------");
	//used for listeners
	sDriver=driver;
	}
	
	@BeforeMethod(alwaysRun = true)
	public void bmConfig() throws IOException
	{
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		LoginPage lp= new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		System.out.println("------------Login to application successful------------------");
		
	}
	@AfterMethod(alwaysRun = true)
	public void amConfig()
	{   AllProductsPage app=new AllProductsPage(driver);
	    app.logoutOfApp();
		System.out.println("------------Logout of application successful------------------");	
	}
	@AfterClass(alwaysRun = true)
	//@AfterTest
	public void acConfig()
	{
	driver.quit();
	System.out.println("-----------Browser Closure successful----------------");
	}
	@AfterSuite(alwaysRun = true)
	public void asConfig()
	{
		System.out.println(" -------------Database Closure successful----------------------");
	}
	
	

}
