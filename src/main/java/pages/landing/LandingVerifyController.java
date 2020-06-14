package pages.landing;

import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import core.Driver;
import utilis.ExtentTestManager;
import utilis.Helper;

public class LandingVerifyController {
	String account;
	String header;
	String accountInfo;
	String logout;
	String productList;
	
	public LandingVerifyController()
	{
	try 
		{
		account = Helper.load("automationpractice.landing.account.className");
		header= Helper.load("automationpractice.landing.header.css");
		accountInfo=Helper.load("automationpractice.landing.accountInfor.className");
		logout=Helper.load("automationpractice.landing.logout.className");
		productList=Helper.load("automationpractice.landing.productList.css");
		} 
	catch (IOException e) 
		{
			ExtentTestManager.getTest().log(Status.FAIL, e.getMessage());
		}
	}
	public LandingVerifyController fullName(String expectedName)
	{
		 Assert.assertEquals(expectedName, Driver.findElement(By.className(account)).getText());
		 return this;
	}
	public LandingVerifyController headerText(String expectedHeader)
	{
		String actualHeader=Driver.findElement(By.cssSelector(header)).getText();
		Assert.assertTrue(actualHeader.contains(expectedHeader));
		return this;
	}
	public LandingVerifyController logOutAvailable()
	{
		
			 Driver.findElement(By.className(logout)).isDisplayed();
			 return this;
		
	}
	public LandingVerifyController accountInfo(String actual)
	{
		String expected=Driver.findElement(By.xpath("//p[@class='info-account']")).getText();
		Assert.assertTrue(expected.contains(actual));
		return this;
	}
	public void clickOnProduct(String item) {

		try
		{
		Helper.clickOn(Driver.findElements(By.cssSelector(productList)), item);
		}

		catch(Exception ex)
		{
			ExtentTestManager.getTest().log(Status.FAIL, ex);
		}
	}

}
