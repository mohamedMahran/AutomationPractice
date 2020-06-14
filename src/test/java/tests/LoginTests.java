package tests;
	
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import pages.header.HeaderPage;
import pages.landing.LandingPage;
import pages.login.LoginPage;
import utilis.ExtentTestManager;

	public class LoginTests extends BaseTest {
		

		@Test
		public void validateValidLogin()  {
			try
			{
				Logger log = Logger.getLogger(LoginTests.class);
				LoginPage loginPage = LoginPage.getLoginPage();
				HeaderPage header = HeaderPage.getHeaderPage();
				LandingPage landing = LandingPage.getLandingPage();
				
				log.info(
					"****************************** Starting test cases execution  *****************************************");
				// one is inheritance
				// creating object to that class and invoke methods of it
			
				
		
			
				// 2. Click *Sign in* button (in the header)
				header.step().signIn();
	
				/*
				 * 3. Fill *Email address* in _Already registered_ block Fill *Password*
				 * in _Already registered_ block Then Click Sign in
				 */
				loginPage.step().enterUserEmailAddress()
								.enterPassword()
								.signIn();
				//Assertions
			
				landing.check().fullName("Joe Black")
				   .headerText("MY ACCOUNT")
				   .logOutAvailable();
				header.step().signOut();

			log.info("Navigation Bar is displayed");
			log.info("Test completed");
			}
			catch(Exception e)
			{
				ExtentTestManager.getTest().log(Status.INFO, ExceptionUtils.getStackTrace(e));
			}
	
		}
	}
