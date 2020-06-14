package pages.landing;

import java.io.IOException;

import org.openqa.selenium.By;

import com.aventstack.extentreports.Status;

import core.Driver;
import utilis.ExtentTestManager;
import utilis.Helper;

public class LandingController {
	
	String account;
	String header;
	String accountInfo;
	String logout;
	String productList;
	
	public LandingController()
	{
	try 
		{
		account = Helper.load("automationpractice.landing.account.className");
		header= Helper.load("automationpractice.landing.header.classname");
		accountInfo=Helper.load("automationpractice.landing.accountInfor.css");
		logout=Helper.load("automationpractice.landing.logout.className");
		productList=Helper.load("automationpractice.landing.productList.css");
		} 
	catch (IOException ex) 
		{
			ExtentTestManager.getTest().log(Status.FAIL, ex.getMessage());
		}
	}


	public void clickOnProduct(String item) {

		try
		{
		Helper.clickOn(Driver.findElements(By.cssSelector(productList)), item);
		}

		catch(Exception ex)
		{
			ExtentTestManager.getTest().log(Status.FAIL, ex.getMessage());
		}
	}
	
}
