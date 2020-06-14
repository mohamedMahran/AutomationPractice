package tests;

import java.io.IOException;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import pages.menu.MainMenu;
import utilis.ExcelLib;
import utilis.ExtentTestManager;


public class MenuTests extends BaseTest {
	Logger log = Logger.getLogger(MenuTests.class);
	@Test(dataProvider = "menuItems")
	public void testCountsOfProductListForEachMainProduct(String mainProduct, String actualCount) {
		try {
			MainMenu menu = MainMenu.getMainMenuPage();
			menu.step().hoverOnTheMainMenu(mainProduct);
			int expectedCountOfMainProduct = menu.check().countOfProductItemsOf(mainProduct);
			int actualCountOfMainProduct = Integer.parseInt(actualCount);
			Assert.assertEquals(expectedCountOfMainProduct, actualCountOfMainProduct);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.INFO, ExceptionUtils.getStackTrace(e));
		}

	}

	@DataProvider(name = "menuItems")
	public Object[][] checkOut() throws  IOException {
		return ExcelLib.getExcelData("../Task1/Data.xlsx", "menuItems");
		
	}

}
