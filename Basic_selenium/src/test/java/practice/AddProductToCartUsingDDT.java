package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AddProductToCartUsingDDT {

		public static void main(String[] args) throws InterruptedException, IOException {
			
			//Read the common data from property file
		FileInputStream fisp=new FileInputStream(".\\src\\test\\resources\\CommonDataProperties");
		Properties p=new Properties();
		p.load(fisp);
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		
		//Read the test data from excel file
		FileInputStream file =new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb= WorkbookFactory.create(file);
		Sheet sh = wb.getSheet("Products");
		Row rw = sh.getRow(1);
		Cell c1 = rw.getCell(2);
		String PRODUCTNAME = c1.getStringCellValue();
		
		
		//Step 1: Launch the browser
			WebDriver driver=new FirefoxDriver();
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Step 2: Load the URL	 
			driver.get(URL);
		//Step 3: Login to application	
			driver.findElement(By.id("user-name")).sendKeys(USERNAME);
			driver.findElement(By.id("password")).sendKeys(PASSWORD);
			driver.findElement(By.id("login-button")).click();
			
		//Step 4: Click on a Product
			Thread.sleep(4000);
			System.out.println(PRODUCTNAME);
			
			driver.findElement(By.xpath("//div[text()='"+PRODUCTNAME+"']")).click();
			String ProductTitle = driver.findElement(By.xpath("//div[text()='"+PRODUCTNAME+"]")).getText();
			Thread.sleep(4000);
			
			driver.findElement(By.id("add-to-cart")).click();
			
			driver.findElement(By.className("shopping_cart_link")).click();
			String ProducttitleInCart = driver.findElement(By.className("inventory_item_name")).getText();
			Thread.sleep(4000);
			if(ProducttitleInCart.equalsIgnoreCase(ProductTitle))
			{
				System.out.println("Product successfully added to cart");
				System.out.println("Pass");
				System.out.println(ProducttitleInCart);
			}
			else
			{
				System.out.println("Product not added to cart-> Fail");
				
			}
			
			driver.findElement(By.id("react-burger-menu-btn")).click();
			driver.findElement(By.linkText("Logout")).click();
			Thread.sleep(4000);
			
			System.out.println("Logout successful");
			
			}
			

			
	}


