package pages.login;

import java.io.IOException;
import org.openqa.selenium.By;
import com.aventstack.extentreports.Status;
import core.Driver;
import utilis.ExtentTestManager;
import utilis.Helper;
import utilis.ReadPropertisFile;


public class LoginController   {
	
	String username;
	String password;
	String submit;
	String signIn;
	String emailAddress;
	
	public LoginController()
	{
	try 
		{
		 username = Helper.load("automationpractice.login.user.id");
		 password= Helper.load("automationpractice.login.password.id");
		 submit=Helper.load("automationpractice.login.submitCreate.id");
		 signIn=Helper.load("automationpractice.login.singIn.xpath");
		 emailAddress=Helper.load("automationpractice.login.createEmail.id");
		} 
	catch (IOException e) 
		{
			ExtentTestManager.getTest().log(Status.FAIL, e.getMessage());
		}
	}
	public LoginController enterUserEmailAddress()
	{
		String email = null;
		try {
			email = ReadPropertisFile.getExistingUserEmail();
		} catch (IOException e) {

			ExtentTestManager.getTest().log(Status.FAIL,e);
		}
		Driver.findElement(By.id(username)).sendKeys(email);
		return this;
	}
	public LoginController enterPassword() throws IOException
	{
		String userPassword = null;
		userPassword = ReadPropertisFile.getExistingPassword();
		Driver.findElement(By.id(password)).sendKeys(userPassword);
		return this;
	}
	public void signIn()
	{
		Driver.findElement(By.xpath(signIn)).click();
	}
	public void enterNewAccount()
	{
		
		Driver.findElement(By.id(emailAddress)).sendKeys(Helper.getNewEmail());
		
	}
	public void clickOnCreateAccountButton() {
		
		Driver.findElement(By.id(submit)).click();

	}


}
