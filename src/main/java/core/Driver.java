package core;

import java.io.File;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Driver {
	/*When we develop a class in such a way that it can have only instance at any time, is called Singleton design pattern. It is very useful when you need to use same object of a class across all classes or framework. Singleton class must return the same instance again, if it is instantiated again.
To create a singleton class, we need to do following steps:
1.	Declare constructor of class as private so that no one instantiate class outside of it.
2.	Declare a static reference variable of class. Static is needed to make it available globally.
3.	Declare a static method with return type as object of class which should check if class is already instantiated once.
How does Singleton pattern help in Selenium Web driver?
1.	Keep track of same driver instance throughout execution.
2.	Loading external files like properties, excel etc. once rather than loading again and again.
3.	Logger.
So, wherever you feel, you should have single instance of any class, you should use singleton design pattern.  For example: If database connection is already established, you should not create new connection.
*/
	private static WebDriverWait wait;
	private static WebDriver instance = null;
	private static final String WEB_DRIVER_FOLDER = "webdrivers";

	private Driver() {

	}

	public static WebDriver getDriver(String desiredBrowser) {
		if (getInstance() == null) 
		{
			Browser browser = Browser.fromString(desiredBrowser);// fromString
																	// function
																	// to return
																	// the type
																	// of the
																	// browser
			String driverFileName = browser.getName() + "driver.exe";// get the
																		// browser
																		// name
			String driverFilePath = driversFolder(new File("").getAbsolutePath());
			System.setProperty("webdriver." + browser.getName() + ".driver", driverFilePath + driverFileName);

			setInstance(browser.getDriver());
			return getInstance();
		}

		return getInstance();
	}

	public static WebDriver getInstance() {
		return instance;
	}

	public static void setInstance(WebDriver instance) {
		Driver.instance = instance;
	}

	private static String driversFolder(String path) {
		File file = new File(path);
		for (String item : file.list()) {
			if (WEB_DRIVER_FOLDER.equals(item)) {
				return file.getAbsolutePath() + "/" + WEB_DRIVER_FOLDER + "/";
			}
		}
		return driversFolder(file.getParent());
	}

	public static WebElement findElement(By by) {
		try {
			WebDriverWait wait1 = new WebDriverWait(getInstance(), 5);
			return wait1.until(ExpectedConditions.visibilityOfElementLocated(by));
		} catch (Exception ex) {
			return NullWebElement.getNull(by);
		}
	}

	public static List<WebElement> findElements(By by) {
		WebDriverWait wait = new WebDriverWait(getInstance(), 10);
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
	}

	public static String getCurrentUrl() {
		return getInstance().getCurrentUrl();
	}

	public static WebDriverWait getWebDriverWait() {
		if (wait == null) {

			wait = new WebDriverWait(getInstance(), 5);
		}
		return new WebDriverWait(getInstance(), 5);
	}

	public static void destoryDriver() {
		if (getInstance() != null) {
			getInstance().quit();
			setInstance(null);
		}
	}

	
}
