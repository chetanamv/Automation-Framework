package products;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
@Listeners(genericUtilities.ListenersImplementation.class)
public class RemoveProductTest extends BaseClass{
	
@Test(groups = "Smoke,Regression")
	public void sample()
	{
		
		System.out.println("Product removed successfully");

	}

}
