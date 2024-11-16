package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
@Test
public class Test1 {

	public static void Test() {
		// TODO Auto-generated method stub

		WebDriver driver= new FirefoxDriver();
		driver.get("https://www.facebook.com/");
		 System.out.println("hi");
		 System.out.println("hi");
	}

}
