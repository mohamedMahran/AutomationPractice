package core;

import java.io.File;
import org.openqa.selenium.WebDriver;

class DriverFactory {

    private static final String WEB_DRIVER_FOLDER = "webdrivers";

    public static WebDriver createWebDriver(String desiredBrowser) {
    	
        Browser browser = Browser.fromString(desiredBrowser);// fromString function to return the type of the browser
        String driverFileName = browser.getName() + "driver.exe" ;// get the browser name
        String driverFilePath = driversFolder(new File("").getAbsolutePath());
        System.setProperty("webdriver." + browser.getName() + ".driver", driverFilePath + driverFileName);
        
       return browser.getDriver();
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
}
