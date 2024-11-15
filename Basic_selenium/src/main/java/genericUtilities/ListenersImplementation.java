package genericUtilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provides implementation to ItestListener interface of TestNG
 * @author Chetana M V
 */
public class ListenersImplementation implements ITestListener {
	//Capture the current system date and time for screenshot name and report name
	Date d= new Date();
	SimpleDateFormat f= new SimpleDateFormat("dd-mm-yyyy hh-mm-ss");
	 String date=f.format(d);
	 
	 //For Extent Reports
	 ExtentReports report;
	 ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
		//capture the method name of @Test
		String methodName = result.getMethod().getMethodName();
		/* @Test execution is started*/
		System.out.println(methodName+"Test script execution started");
		/* Intimate extent reports for @Test execution*/
		 test= report.createTest(methodName);
		 test.log(Status.INFO, methodName+"-->Tet script Execution started");
		 
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	   // capture the method name of @Test
		String methodName = result.getMethod().getMethodName();
		/*@Test execution is pass*/
		System.out.println(methodName+"Test script execution PASS");
		
		/*log the status of test as PASS in Extent Report*/
		test.log(Status.PASS, methodName+"---> Test Script is PASS");
		
		
	}
	@Override
	public void onTestFailure(ITestResult result) {
		//capture the method name of @Test
		String methodName = result.getMethod().getMethodName();
		
		/* @Test execution is Fail*/
		System.out.println(methodName+"------->Test script execution FAIL");	
		
		//Capture the Exception
		System.out.println(result.getThrowable());
		
		/*log the status of the test as FAIL in Extent Report*/
		test.log(Status.FAIL, methodName+"---->Test script is FAIL");
		
		/*log the exception in Extent Report*/
		test.log(Status.WARNING, result.getThrowable());
		
		
		//Capture the Screenshot
		SeleniumUtility s= new SeleniumUtility();
		
		//Screenshot name configuration
		 String screenshotName = methodName+date;
		try {
			String path = s.captureScreenShot(BaseClass.sDriver, screenshotName);
			/*Attach the Screenshot in extent report*/
			test.addScreenCaptureFromPath(path);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		//capture the method name of @Test
		String methodName = result.getMethod().getMethodName();
		
		/* @Test execution is SKIP*/
		System.out.println(methodName+"------->Test script execution SKIP");
		
		//Capture the Exception
				System.out.println(result.getThrowable());
		/*log the Status of test as SKIP in extent report*/
				test.log(Status.SKIP, methodName+"----->Test script is SKIP");
		/*log the exception in Extent Report*/
				test.log(Status.WARNING,result.getThrowable());
				
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		/*Suite level execution -<suite>*/
		System.out.println("Suite Execution started");
		
		/*Basic configuration of extent report*/
		ExtentSparkReporter esr = new ExtentSparkReporter(".\\ExtentReports\\Report-"+date+".html");
		esr.config().setDocumentTitle("SWAG LABS Execution Report");
		esr.config().setReportName("Execution Build version 1.12");
		esr.config().setTheme(Theme.DARK);
		
		/*feed the configuration to extent reports class*/
	    report=new ExtentReports();
		report.attachReporter(esr);
		report.setSystemInfo("Base Env","Test Env");
		report.setSystemInfo("Base Browser", "Chrome");
		report.setSystemInfo("Base Platform", "Windows Family");
		report.setSystemInfo("Base URL", "TestEnv.com");
		report.setSystemInfo("Reporter Name","Chetana");
	}

	@Override
	public void onFinish(ITestContext context) {
		/*Suite level execution*/
		System.out.println("Suite Execution Finished");
		
		/*Generate the extent report*/
		report.flush();
		
	}

}
