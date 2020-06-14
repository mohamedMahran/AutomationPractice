package core;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
/*WebDriver facade main responsibility is to define custom behavior on elements location. 
 This gives you centralized control over elements location.
 The constructor takes browser type and uses the factory to create WebDriver instance which is used internally in the facade. 
 FindElement method defines explicit wait. If the element is not found then NullWebElement 
 which is actual implementation of Null object pattern.
 The idea is to safely locate elements with try/catch and then just use them skipping checks for null.*/

public class WebDriverFacade    {
    
	private static final long WAIT_SECONDS = 10;
	public static WebDriver instance=null;
	
	public WebDriverFacade(String browser) 
	{
			instance = DriverFactory.createWebDriver(browser);
    }
   
	public  void start(String url) {
		instance.get(url); 
		instance.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    
    public  void maximize()
    {
    	instance.manage().window().maximize();
    }

    public  void destoryDriver() 
    {
    	if(instance!=null)
    	{
    		instance.quit();
    		instance=null;
    	}
    }
    
    public  WebElement findElement(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(instance, WAIT_SECONDS);
            return  wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Exception ex) {
            return NullWebElement.getNull(by);
        }
    }

    public  List<WebElement> findElements(By by) {
        WebDriverWait wait = new WebDriverWait(instance, WAIT_SECONDS);
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }
	
    public  String getCurrentUrl() {

		return instance.getCurrentUrl();
		
	
    }
    
    public  Object executeJavaScript(String script) {
        return ((JavascriptExecutor) instance).executeScript(script);
    }




}