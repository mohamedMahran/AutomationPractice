package utilis;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import core.Driver;

public  class Helper {
	
	private Helper()
	{
		
	}
	
	public static String getNewEmail()
	{
		 String timestamp = String.valueOf(new Date().getTime());
		 //generating random values for email address
		 return  "hf_challenge_" + timestamp + "@hf" + timestamp.substring(7) + ".com";
		 
	}
	public static WebElement waitElementToBeVisible(By locator, int timeout) {

		WebDriverWait wait = new WebDriverWait( Driver.getInstance(), timeout);
		return  wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	public static WebElement waitElementListToBeVisible(List<WebElement> list, int timeout) {

		WebDriverWait wait = new WebDriverWait(Driver.getInstance(), timeout);
		return  wait.until(ExpectedConditions.visibilityOfElementLocated((By) list));
	}
	public static void   waitURLToContains(String urlValidator, int seconds) {
		WebDriverWait wait = new WebDriverWait(Driver.getInstance(),seconds );
		wait.until(ExpectedConditions.urlContains(urlValidator));
	}
	public static void   waitURLToMatches(String urlValidator, int seconds) {
		WebDriverWait wait = new WebDriverWait(Driver.getInstance(), seconds);
		wait.until(ExpectedConditions.urlMatches(urlValidator));
	}
	public static void   waitTillURLIs(String url,int timeout) {
		WebDriverWait wait = new WebDriverWait(Driver.getInstance(), timeout);
		wait.until(ExpectedConditions.urlToBe(url));
	}
	public static String splitStringByArrow(List<String> list)
    {
		StringBuilder builder = new StringBuilder();
        for (String item : list)
        {
            builder.append(item).append(">");
        }
        return builder.toString();
    }
	public static String splitStringBySlash(List<String> list)
    {
		StringBuilder builder = new StringBuilder();
        for (String item : list)
        {
            builder.append(item).append("/");
            
        }
        return builder.toString();
    }
	public static void   closeNewTabAndSwitchBackToOldOne() {
		ArrayList<String> tabs = new ArrayList<> (Driver.getInstance().getWindowHandles());
		Driver.getInstance().close();
		Driver.getInstance().switchTo().window(tabs.get(0));
	}
	public static void   switchToLastTab() {
		ArrayList<String> tabs = new ArrayList<> (Driver.getInstance().getWindowHandles());
		Driver.getInstance().switchTo().window(tabs.get(1));
	}
	public static void   acceptAlertPopup()
    {
        try
        {
        	Driver.getInstance().switchTo().alert().accept();
        }
        catch (NoAlertPresentException e){
        	ExtentTestManager.getTest().log(Status.FAIL, e);
        }
        
    }
	public static void   clickOn(List<WebElement> productList,String button)
    {
			try
			{
				
				
				List<WebElement> buttons =productList  ;

				for (WebElement btn : buttons)
				{
					
					String expectedButton= btn.getText();
					
					if (expectedButton.contains(button))
					{
						
						btn.click();
						break;
					}
				}
			}
			catch(Exception ex)
			{
				ExtentTestManager.getTest().log(Status.FAIL, ex.getMessage());
			}
		}
	public static List<String> getListOfclassNamesFromListOfElements(List<WebElement> webElements)
    {
		List<String> listOfElements = new ArrayList<>();
		for(WebElement t : webElements)
		{
			listOfElements.add(t.getAttribute("class"));
			
		}
	return listOfElements;	
    }
	public static List<String> getListOfonmousemoveattributeFromListOfElements(List<WebElement> webElements)
    {
		List<String> listOfOnMousemOveAttribute = new ArrayList<>();
		for(WebElement t : webElements)
		{
			listOfOnMousemOveAttribute.add(t.getAttribute("onmousemove"));
			
		}
        return listOfOnMousemOveAttribute;
    }
	public static List<String> getListOfStyleAttributeFromListOfElements(List<WebElement> webElements)
    {
		List<String> listOfStyleAttributes = new ArrayList<>();
		for(WebElement t : webElements)
		{
			listOfStyleAttributes.add(t.getAttribute("style"));
			
		}
        return listOfStyleAttributes;
       
    }
	public static List<String> getListOfStringsFromListOfElements(List<WebElement> ilist)
    {
		List<String> listOfStringsFromListOfElements = new ArrayList<>();
		for(WebElement t : ilist)
		{
			listOfStringsFromListOfElements.add(t.getText());
			
		}
        return listOfStringsFromListOfElements;
    }
	public static List<String> getListOfStringsFromElementListByAttribute(List<WebElement> ilist,String attribute)
    {
		List<String> listOfStringsFromListOfElements = new ArrayList<>();
		for(WebElement t : ilist)
		{
			listOfStringsFromListOfElements.add(t.getAttribute(attribute));
			
		}
        return listOfStringsFromListOfElements;
    }
	public static void hoverOn(WebElement element) throws InterruptedException {
		Actions builder = new Actions(Driver.getInstance());
		builder.moveToElement(element).perform();
		Thread.sleep(500);
		
	}
	public static String load(String property) throws IOException {
	    Properties prop;
		prop = new Properties();
		FileInputStream fis = new FileInputStream("../Task1/data.properties");
		prop.load(fis);
		return prop.getProperty(property);
		
	}
}
