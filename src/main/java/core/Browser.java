package core;

import java.util.Arrays;
import java.util.function.Supplier;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.aventstack.extentreports.Status;

import utilis.ExtentTestManager;

public enum Browser {
    FIREFOX("gecko", FirefoxDriver::new),//  Creates a new FirefoxDriver instance
    CHROME("chrome", ChromeDriver::new),//   Creates a new ChromeDriver instance
    IE("ie", InternetExplorerDriver::new);// Creates a new InternetExplorerDriver instance

    private String name;
    private Supplier<WebDriver> driverSupplier;

    Browser(String name, Supplier<WebDriver> driverSupplier) {
        this.name = name;
        this.driverSupplier = driverSupplier;
    }

    public String getName() {
        return name;
    }
  //return a new driver
    public WebDriver getDriver() {
        return driverSupplier.get();
    }

    public static Browser fromString(String value) {
        for (Browser browser : values()) {
            if (value != null && value.toUpperCase().equalsIgnoreCase(browser.getName())) {
                return browser;
            }
        }
        ExtentTestManager.getTest().log(Status.FAIL,"Invalid driver name passed as 'browser' system property. "
            + "One of: " + Arrays.toString(values()) + " is expected. Defaulting to Firefox.");
        return FIREFOX;
    }
}
