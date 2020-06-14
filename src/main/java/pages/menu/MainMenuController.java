package pages.menu;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.Status;
import core.Driver;
import utilis.ExtentTestManager;
import utilis.Helper;

public class MainMenuController {

	String menuList;

	public MainMenuController()
	{
	try 
		{
		menuList = Helper.load("automationpractice.menu.menuItems.css");		 
		} 
	catch (IOException e) 
		{
			ExtentTestManager.getTest().log(Status.FAIL, e.getMessage());
		}
	}
	private List<WebElement> getMenuItems()
	{
		return Driver.findElements(By.cssSelector(menuList));
	}
	public  void selectCategoryFromMenu(String category) 
	{
	
	List<WebElement> menuItems =  getMenuItems();

	for (WebElement menu : menuItems) {

		if (category.equalsIgnoreCase(menu.getText()))
		{
			menu.click();
			break;
		}
	}

}
	public void hoverOnTheMainMenu(String product) 
	{
		int count = 0;
		for (WebElement Element : getMenuItems()) {
			count = count + 1;
			String link = Element.getAttribute("title");
			if(link.equalsIgnoreCase(product))
				try {
					Helper.hoverOn(Element);
				} catch (Exception e) {

					ExtentTestManager.getTest().log(Status.FAIL, e.getMessage());
				}
			
		}
	}
	
}
