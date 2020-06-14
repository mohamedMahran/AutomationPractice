package core;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import utilis.ExtentTestManager;
public class NullWebElement implements WebElement {
	
/*  Null object implements given interface and its methods are doing nothing.This makes the null object more predictable. 
    You can safely invoke methods on the null object without the threat of a NullRefferenceException to break your application.
    This pattern is very well combined with singleton pattern where a null object is actually a singleton. 
    In this case, you can check for reference or equality.
    
    I’m going to give example where Singleton is used along with Null object pattern. 
    NullWebElement implements IWebElement interface. 
    So it must implement all methods and properties defined by the interface. 
    This is done on lines 50 to 129.
    
    Properties are returning some values, but not null! Methods are doing nothing. 
    
    From line 35 to 38 is the Singleton definition. 
    If Singleton is an object you have defined then it should have a private constructor so no one is able to instantiate it. 
    
    There is a private field which actually holds the reference to the singleton. 
    NULL is a property which instantiates the singleton 
    if not already instantiated and returns it.
  */
		
	
	    private NullWebElement() {
	    }
	 

	    private static NullWebElement instance;
	   
	    public static NullWebElement getNull(By element) {
	        if (instance == null) {
	            instance = new NullWebElement();
	        }
	        else 
	        {
	        	
	    		ExtentTestManager.getTest().log(Status.FAIL,"Please Note " + "Error in the Element "+ element.toString());
	    		
	        }
	        return instance;
	    }
	    public static NullWebElement getNull() {
	        if (instance == null) {
	            instance = new NullWebElement();
	        }
	        else 
	        {
	        	
	    		ExtentTestManager.getTest().log(Status.FAIL,"Element is null ");
	    		
	        }
	        return instance;
	    }
	    
	    

	    public static boolean isNull(WebElement element) {
	        return getNull().equals(element);
	    }

	    @Override
	    public void click() {
	    	
	    }

	    @Override
	    public void submit() {
	    }

	    @Override
	    public void sendKeys(CharSequence... charSequences) {
	    	
	    }

	    @Override
	    public void clear() {
	    	
	    }

	    @Override
	    public String getTagName() {
	        return "";
	    }

	    @Override
	    public String getAttribute(String s) {
	        return "";
	    }

	    @Override
	    public boolean isSelected() {
	        return false;
	    }

	    @Override
	    public boolean isEnabled() {
	        return false;
	    }

	    @Override
	    public String getText() {
	        return "";
	    }

	    @Override
	    public List<WebElement> findElements(By by) {
	        return new ArrayList<>();
	    }

	    @Override
	    public WebElement findElement(By by) {
	        return NullWebElement.getNull(by);
	    }

	    @Override
	    public boolean isDisplayed() {
	        return false;
	    }

	    @Override
	    public Point getLocation() {
	        return new Point(0, 0);
	    }

	    @Override
	    public Dimension getSize() {
	        return new Dimension(0, 0);
	    }

	    @Override
	    public Rectangle getRect() {
	        return new Rectangle(0, 0, 0, 0);
	    }

	    @Override
	    public String getCssValue(String s) {
	        return "";
	    }

	    @Override
	    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
	        return null;
	    }
}
