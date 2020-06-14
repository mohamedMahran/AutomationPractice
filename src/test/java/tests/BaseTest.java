package tests;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import core.Driver;
import utilis.ReadPropertisFile;

public class BaseTest {

	WebDriver driver;
	WebDriverWait wait;
	String url ;
	static Logger log = Logger.getLogger(BaseTest.class);
	
	@Parameters("browser")
	@BeforeTest
	public  void setUp(String browser) 
	{

		driver = Driver.getDriver(browser);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		wait=Driver.getWebDriverWait();

	}

	@BeforeMethod()
	public  void goToHome() {
		try
		{
		url = ReadPropertisFile.getURL();
		driver.get(url);

		}
		catch(Exception ex)
		{
			log.info("Error in url",ex);
		}
	}

	@AfterTest
	public void tearDown() {
		Driver.destoryDriver();
	}

}
