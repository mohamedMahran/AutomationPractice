package pages.summary;

import org.openqa.selenium.By;

import core.Driver;


public class Summary {
	
	public void proceedToCheckOut()
	{
		Driver.findElement(By.xpath("//p[@class='cart_navigation clearfix'] //a[@title='Proceed to checkout'] ")).click();
	}

}
