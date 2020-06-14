package pages.menu;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import core.Driver;
import utilis.ExtentTestManager;
import utilis.Helper;

public class MainMenuVerifyController {
	String menuList;
	String womenProducts;
	String dressProducts;
	String tshirtProducts;
	
	
	public MainMenuVerifyController()
	{
	try 
		{
		menuList = Helper.load("automationpractice.menu.menuItems.css");
		womenProducts= Helper.load("automationpractice.menu.womenProducts.xpath");
		dressProducts=Helper.load("automationpractice.menu.dressProducts.xpath");
		tshirtProducts=Helper.load("automationpractice.menu.TshirtProducts.xpath");
		 
		} 
	catch (IOException e) 
		{
			ExtentTestManager.getTest().log(Status.FAIL, e.getMessage());
		}
	}
	public int countOfProductItemsOf(String product) {

		switch(product)
		{
		case "WOMEN":
			return Driver.findElements(By.xpath(womenProducts)).size();
			
		case "DRESSES":
			return Driver.findElements(By.xpath(dressProducts)).size();
		case "T-shirts":
			return Driver.findElements(By.xpath(tshirtProducts)).size();
		default:
			break;
		}
		return 0;
		
	}
	public List<String> getMainMenuItems()
	{
		return Helper.getListOfStringsFromListOfElements(Driver.findElements(By.cssSelector(menuList)));
	}

	public void productListDisplayedCorrectly()
	{
		List<String> actualProductList = getMainMenuItems();
		Assert.assertTrue(actualProductList.contains("WOMEN"));
		Assert.assertTrue(actualProductList.contains("DRESSES"));
		Assert.assertTrue(actualProductList.contains("T-SHIRTS"));
		
	}
}
