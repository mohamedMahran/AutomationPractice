package core;

import java.io.File;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Driver {

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
		WebDriverWait wait = new WebDriverWait(getInstance(), 5);
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
