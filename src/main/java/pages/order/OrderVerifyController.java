package pages.order;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;

import core.Driver;


public class OrderVerifyController {
	
	public OrderVerifyController orderConfirmationPageIsDisplayedSuccessfully()
	{
		// Order confirmation page(?controller=order-confirmation) is opened
			assertTrue(Driver.getCurrentUrl().contains("controller=order-confirmation"));
			return this;
								
	}

	public OrderVerifyController orderIsComplete()
	{
		// The order is complete.
		assertTrue(Driver.findElement(By.xpath("//*[@class='cheque-indent']/strong")).getText().contains("Your order on My Store is complete."));
		return this;

		
	}
	
	public OrderVerifyController currentPageIsLastStepOfOrdering()
	{
		// Current page is the last step of ordering
		assertTrue(Driver.findElement(By.xpath("//li[@id='step_end' and @class='step_current last']")).isDisplayed());
		return this;
	}

}
