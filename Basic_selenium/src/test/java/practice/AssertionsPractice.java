package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsPractice {
@Test

	public void Sample() {
		System.out.println("Step 1"); 
		System.out.println("Step 2");
		System.out.println("Step 3");
		
		Assert.assertEquals(false, false);

		System.out.println("Step 4");
		System.out.println("Step 5");
	}
@Test
public void  sample1()
{
	SoftAssert sa= new SoftAssert();
	
	System.out.println("Step 1");
	System.out.println("Step 2");
	System.out.println("Step 3");
	
	sa.assertEquals(false, false);
	
	System.out.println("Step 4");
	System.out.println("Step 5");
	
	sa.assertAll(); //log the assertion fails
}
}
