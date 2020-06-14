package tests;

import java.io.IOException;
import org.apache.log4j.Logger;
import pages.login.LoginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import pages.header.HeaderPage;
import pages.landing.LandingPage;
import pages.menu.MainMenu;
import pages.product.Product;
import pages.order.OrderPage;
import pages.summary.Summary;
import utilis.ExcelLib;
import utilis.ExtentTestManager;


public class CheckOutTests extends BaseTest {

	@Test(dataProvider = "checkOut")
	public void validateCheckoutProcess(String productName, String size)   {
		try {

			Logger log = Logger.getLogger(CheckOutTests.class);
			LoginPage loginPage = LoginPage.getLoginPage();
			HeaderPage header = HeaderPage.getHeaderPage();
			LandingPage landing = LandingPage.getLandingPage();
			MainMenu menu = MainMenu.getMainMenuPage();
			OrderPage order = OrderPage.getOrderPage();
			Product product = Product.getProductPage();
			Summary summary = new Summary();
			
			
			log.info("1. Log in as existing customer");
			header.step().
						  signIn();
			ExtentTestManager.getTest().log(Status.INFO, " 1. Log in as existing customer");
			log.info("2. Click *Women* button in the header");
			loginPage.step().enterUserEmailAddress()
					 		.enterPassword()
					 		.signIn();
			
			ExtentTestManager.getTest().log(Status.INFO, " 2. Click *Women* button in the header");		
			menu.step().selectCategoryFromMenu("WOMEN");
			menu.check().productListDisplayedCorrectly();
			
			log.info("3. Click the product with name Faded Short Sleeve T-shirts");
			landing.check().fullName("Joe Black")
			   			   .headerText("WOMEN")
			   			   .logOutAvailable();
			landing.step().clickOnProduct(productName);
			ExtentTestManager.getTest().log(Status.INFO, " 3. Click the product with name Faded Short Sleeve T-shirts");
			
 			log.info("4.Verify then Select Size,Enter Quantity then click add to cart");
 			
 			
 			String[] expectedDisplayedColors = {"Orange","Blue"};
 			product.check().colorsOfTheProduct(expectedDisplayedColors)
						   .countOfSocialSharingProduct();
			
			product.step().enterQuantity("5")
				   		  .selectSize(size)
				   		  .addToCart();
			log.info("5. Click *Proceed to checkout*");
			product.step()
						.click("Proceed to checkout");
			ExtentTestManager.getTest().log(Status.INFO, " 6. Click *Proceed to checkout*");
			
			log.info("7. Click *Proceed to checkout*");
			summary.proceedToCheckOut();
			ExtentTestManager.getTest().log(Status.INFO, " 7. Click *Proceed to checkout*");
			
		
			log.info("8. Process Address,Click By term Of Service,Proceed to checkout then confirm the order*");
			order.step()
					.processAddress()
					.clickByTermOfService()
					.proceedToTheCheckOut()
					.payByBankWire()
					.confirmMyOrder();
			ExtentTestManager.getTest().log(Status.INFO, " 8. Process Address,Click By term Of Service,Proceed to checkout then confirm the order*");

			order.check()
				 	.orderConfirmationPageIsDisplayedSuccessfully()
				 	.orderIsComplete()
				 	.currentPageIsLastStepOfOrdering();
			
			log.info("9. Sign out ");
			header.step().signOut();

		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL,e);
		}
	}

	@DataProvider(name = "checkOut")
	public Object[][] checkOut() throws  IOException {
		return ExcelLib.getExcelData("../Task1/Data.xlsx", "checkout");

	}
}
