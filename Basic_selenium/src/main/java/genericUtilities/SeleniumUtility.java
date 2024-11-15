package genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;
/**
 * This class consists of generic methods related to selenium
 * @author Chetana M V
 */
public class SeleniumUtility {
/**
 * This method will maximize the window
 * @param driver
 */
	public void maximizeWindow(WebDriver driver)
	
	{
	  driver.manage().window().maximize();	
	}
	
	/**
	 * This method will minimize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	/**
	 * This method will add implicitly wait for 10 seconds
	 * @param driver
	 */
	public void addImplicitlyWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	/**
	 * This method will wait for particular element to be visible
	 * @param driver
	 * @param element
	 */
	public void WaitForElementToBeVisible(WebDriver driver,WebElement element)
	{
	 WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
	 wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * 
	 * @param index
	 * @param element
	 */
	public void handledropdown(int index,WebElement element)
	{
		Select s= new Select( element);
	    s.selectByIndex(index);	
	
	}
	/**
	 * 
	 * @param element
	 * @param value
	 */
	public void handledropdown(WebElement element,String value)
	{
		Select s= new Select( element);
	    s.selectByValue(value);	
	
	}
	/**
	 * 
	 * @param visibleText
	 * @param element
	 */
	public void handledropdown(String visibleText,WebElement element)
	{
		Select s= new Select( element);
	    s.selectByVisibleText(visibleText);	
}
/**
 * This method will perform mouse over action
 * @param driver
 * @param element
 */
public void mouseOverAction(WebDriver driver,WebElement element) 
{
	Actions act= new Actions(driver);
	
	act.moveToElement(element).perform();
	
}
/**
 * This method will perform double click action
 * @param driver
 * @param element
 */
public void doubleClickAction(WebDriver driver,WebElement element)
{
	Actions act=new Actions(driver);
	act.doubleClick(element).perform();
	
}
/**
 * This method will perform right click action
 * @param driver
 * @param element
 */
public void rightClickAction(WebDriver driver,WebElement element)
{
	Actions act=new Actions(driver);
	act.contextClick(element).perform();
	
}
/**
 * 
 * @param driver
 * @param src
 * @param target
 */
public void dragAndDropAction(WebDriver driver,WebElement src,WebElement target)
{
	Actions act=new Actions(driver);
	act.dragAndDrop(src, target).perform();
}
/**
 * This method will handle frame by index
 * @param driver
 * @param index
 */
public void handleFrame(WebDriver driver,int index)
{
driver.switchTo().frame(index);

}
/**
 * This method will handle frame by nameOrId
 * @param driver
 * @param nameOrid
 */
public void handleFrame(WebDriver driver,String nameOrid)
{
driver.switchTo().frame(nameOrid);
}
/**
 * This method will handle frame by element
 * @param driver
 * @param element
 */
public void handleFrame(WebDriver driver, WebElement element)
{
driver.switchTo().frame(element);
}
/**
 * This method will navigate to immediate parent
 * @param driver
 */
public void switchToParent(WebDriver driver)
{
	driver.switchTo().parentFrame();
	
	
}
/**
 * This
 * @param driver
 */
public void switchToMainPage(WebDriver driver)
{
	driver.switchTo().parentFrame();
}

public void scrollTOElement(WebDriver driver,WebElement element)
{
	Actions act=new Actions(driver);
	act.scrollToElement(element);
}
/**
 * This method will randomly scroll the page up by 500 units
 * @param driver
 */
public void scrollUpAction(WebDriver driver)
{
	JavascriptExecutor js=(JavascriptExecutor) driver;
	js.executeScript("Window.scrollBy(0,-500);", "");
}
/**
 * THis method will randomly scroll the page down by 500 units
 * @param driver
 */
public void scrollDownAction(WebDriver driver)
{
	JavascriptExecutor js= (JavascriptExecutor) driver;
	js.executeScript("Window.scrollBy(0,500);", "");
	
			
}
/**
 * This method will scroll to element using java script executor
 * @param driver
 * @param element
 */
public void scrollToElementJavascript(WebDriver driver,WebElement element) {
	JavascriptExecutor js=(JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView();", element);
	
	
}
/**
 * THis method will take screen shot and return the path
 * @param driver
 * @param screenShotName
 * @return
 * @throws IOException
 */
public String captureScreenShot(WebDriver driver,String screenShotName) throws IOException
{
	TakesScreenshot ts=(TakesScreenshot) driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	File dst= new File(".\\Screenshots\\"+screenShotName+".png");
	Files.copy(src, dst);
	
	return dst.getAbsolutePath(); //Extent reports
	
}

}
 

























