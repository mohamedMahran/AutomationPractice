package pages.header;

import java.io.IOException;

import org.openqa.selenium.By;
import core.Driver;
import utilis.Helper;


public class HeaderController {
	String logout;
	
	public HeaderController()
	{
		try {
			logout =Helper.load("automationpractice.header.logout.xpath");
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	public void signOut()
	{
		Driver.findElement(By.xpath(logout)).click();
	}

	public void signIn()
	{
		Driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).click();
	}
	
}
