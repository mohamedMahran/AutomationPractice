package tests;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import pages.header.HeaderPage;
import pages.landing.LandingPage;
import pages.login.LoginPage;
import pages.menu.MainMenu;
import pages.product.Product;
import utilis.ExtentTestManager;

public class ProductTests extends BaseTest {

	@Test
	public void validateProductDetails() {

		Logger log = Logger.getLogger(ProductTests.class);
		LoginPage loginPage = LoginPage.getLoginPage();
		HeaderPage header = HeaderPage.getHeaderPage();
		LandingPage landing = LandingPage.getLandingPage();
		MainMenu menu = MainMenu.getMainMenuPage();
		Product product = Product.getProductPage();
		String[] expectedDisplayedColors = { "Orange", "Blue" };
		String[] expectedColumns = { "Compositions", "Styles", "Properties" };
		String[] expectedProduct = { "Styles", "Casual" };
		String data = "Compositions";
		String productItem = "Short Sleeve";

		ExtentTestManager.getTest().log(Status.INFO, " Log in as existing customer");
		log.info("1. Log in as existing customer");
		header.step().signIn();

		ExtentTestManager.getTest().log(Status.INFO, " 2. Click *Women* button in the header");
		log.info("2. Click *Women* button in the header");
		try {
			loginPage.step().enterUserEmailAddress().enterPassword().signIn();
		} catch (IOException e) {

			e.printStackTrace();
		}

		ExtentTestManager.getTest().log(Status.INFO, " 3. Select Category from Menu");
		menu.step().selectCategoryFromMenu("WOMEN");

		ExtentTestManager.getTest().log(Status.INFO, " 4. Click the product with name Faded Short Sleeve T-shirts");
		log.info("4. Click the product with name Faded Short Sleeve T-shirts");
		landing.step().clickOnProduct("Faded Short Sleeve T-shirts");

		try {
			product.check().colorsOfTheProduct(expectedDisplayedColors).countOfSocialSharingProduct().columnCounts()
					.rowCount().columnNames(expectedColumns).rowDetails(expectedProduct).presenceOfData(data)
					.productIsExist(productItem).productDetails(productItem).allData();
		} catch (Exception e) {

			e.printStackTrace();
		}

		header.step().signOut();

	}
}
