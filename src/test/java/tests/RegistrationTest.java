package tests;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.header.HeaderPage;
import pages.landing.LandingPage;
import pages.login.LoginPage;
import pages.registration.Register;

public class RegistrationTest extends BaseTest{
	
	@Test(dataProvider="accountInformation")
	public void validateNewAccount(String firstName,String surName,String passwod,String company,String days,String month,String year,
								  String address1,String address2,String city,String state,String postcode,String other,
								  String phone,String mobilePhone,String alias) throws IOException 
	{
		HeaderPage header = HeaderPage.getHeaderPage();
		Register  registerPage =Register.getRegisterPage();
		LandingPage landing = LandingPage.getLandingPage();
		LoginPage loginPage = LoginPage.getLoginPage();
		header.step().signIn();
		loginPage.step().enterNewAccount();
		loginPage.step().clickOnCreateAccountButton();
		registerPage.step().enterPersonalData(firstName, surName, passwod, company)
						   .selectDates(days, month, year)
						   .selectState(state)
						   .enterAddress(address1, address2, city)
						   .enterContacts(postcode, other, phone, mobilePhone, alias)
						   .submit();
						  
		landing.check().accountInfo("Welcome to your account.")
					  .fullName(firstName + " " + surName)
					  .logOutAvailable();
		header.step().signOut();
	}
	@DataProvider(name="accountInformation")
	public Object[][] accountInformation()
	{
		return new Object[][] {{"Firstname","Lastname","Qwerty","Company",
								"1","10","2000",
								"Qwerty, 123","zxcvb","Qwerty",
								"2",
								"12345","Qwerty","12345123123","12345123123","hf"
								}};
	}
}
