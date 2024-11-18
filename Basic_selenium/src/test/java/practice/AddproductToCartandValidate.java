package practice;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AddproductToCartandValidate {

	public static void main(String[] args) throws InterruptedException {
	WebDriver driver=new FirefoxDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 
	driver.get("https://www.saucedemo.com/");
	driver.findElement(By.id("user-name")).sendKeys("standard_user");
	driver.findElement(By.id("password")).sendKeys("secret_sauce");
	driver.findElement(By.id("login-button")).click();
	Thread.sleep(4000);
	
	driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).click();
	String ProductTitle = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).getText();
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
		System.out.println("Product not added to cart");
		
	}
	
	driver.findElement(By.id("react-burger-menu-btn")).click();
	driver.findElement(By.linkText("Logout")).click();
	Thread.sleep(4000);
	
	System.out.println("Logout  successful");
	driver.close();
	}
	

	}


