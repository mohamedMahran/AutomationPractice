package utilis;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.Status;

import core.Driver;



public class TestListener implements ITestListener {
	
		
	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		
		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();
	}

	public void onTestStart(ITestResult result) {
		
		ExtentTestManager.startTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		ExtentTestManager.getTest().log(Status.PASS, result.getName()+ " " + "Test passed"  );
	}

	public void onTestFailure(ITestResult result) 
	{
	   	String methodName=result.getName();
	   	String screenshotPath = takeScreenShot(methodName, Driver.getInstance());
	   	
	   	try {
	   		ExtentTestManager.getTest().log(Status.FAIL, "Test Failed" + " " + result.getThrowable() + " " + 
	   		ExtentTestManager.getTest().addScreenCaptureFromPath(screenshotPath));
			
		} catch (IOException e) {

			ExtentTestManager.getTest().log(Status.FAIL,e);
		}
	   
	}
	

	public void onTestSkipped(ITestResult result) {
		
		ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
	}

		
	public  static String takeScreenShot(String methodName, WebDriver driver) {
		   	 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		   	 String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		     String destinationPath = System.getProperty("user.dir")+methodName+timeStamp + ".png";
	    	 
		     
	         //The below method will save the screen shot in d drive with test method name 
	            try {

					FileUtils.copyFile(scrFile, new File(destinationPath));
					
				} catch (IOException e) {
					ExtentTestManager.getTest().log(Status.FAIL,e);
				}
				return destinationPath;
	    }

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	
}
