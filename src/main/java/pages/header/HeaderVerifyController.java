package pages.header;

import java.io.IOException;

import org.openqa.selenium.By;
import core.Driver;
import utilis.Helper;


public class HeaderVerifyController {
	String logout;
	String login;
	
	public HeaderVerifyController()
	{
		try {
			logout =Helper.load("automationpractice.header.logout.xpath");
			login = Helper.load("automationpractice.header.login.xpath");
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
		Driver.findElement(By.xpath(login)).click();
	}
	
}
