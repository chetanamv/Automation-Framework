package genericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
/**
 * This class provides implementation to IRetryAnalyser interface of TestNG
 * @author Chetana M V
 */
public class RetryAnalyserImplementation implements IRetryAnalyzer{

	int count=0;
	int retrycount=3;
	@Override
	public boolean retry(ITestResult result) {
		if(count<=retrycount)
		{
			count++;
			return true; //retry
		}
		
		return false; //not retry
	}
	

}
