package pages.registration;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import core.Driver;
import utilis.Helper;

public class RegsitrationController {

	String firstName;
	String surName;
	String password;
	String day;
	String month;
	String year;
	String company;
	String address1;
	String address2;
	String city;
	String state;
	String postcode;
	String other;
	String phone;
	String phoneMobile;
	String submitAccount;
	String hf;
	Select stateList;

	public void select(String value, String dropDownList) {
		Select calendar = null;
		List<WebElement> dropdownlist = Driver.findElements(By.xpath(dropDownList));
		for (WebElement e : dropdownlist) {
			if (e.getText().contains(value)) {
				calendar = new Select(e);
				calendar.selectByValue(value);
			} 
			if (!e.getText().contains(value)) 
			{
				calendar = new Select(e);
				calendar.selectByValue(value);
			}

		}

	}

	public RegsitrationController() throws IOException {

		firstName = Helper.load("automationpractice.Register.firstName.id");

		surName = Helper.load("automationpractice.Register.surName.id");

		password = Helper.load("automationpractice.Register.password.id");

		company = Helper.load("automationpractice.Register.company.id");

		address1 = Helper.load("automationpractice.Register.address1.id");

		address2 = Helper.load("automationpractice.Register.address2.id");

		city = Helper.load("automationpractice.Register.city.id");

		other = Helper.load("automationpractice.Register.other.id");

		phone = Helper.load("automationpractice.Register.phone.id");

		phoneMobile = Helper.load("automationpractice.Register.phoneMobile.id");

		submitAccount = Helper.load("automationpractice.Register.submitAccount.id");

		postcode = Helper.load("automationpractice.Register.postcode.id");

		hf = Helper.load("automationpractice.Register.hf.id");

	}

	public RegsitrationController enterAddress(String address1, String address2, String city) {
		Driver.findElement(By.id(this.address1)).sendKeys(address1);
		Driver.findElement(By.id(this.address2)).sendKeys(address2);
		Driver.findElement(By.id(this.city)).sendKeys(city);
		return this;
	}

	public RegsitrationController selectState(String state) {
		select(state, "//select[@id='id_state']");
		return this;
	}

	public void submit() {
		Driver.findElement(By.id(this.submitAccount)).click();
	}

	public RegsitrationController enterContacts(String postcode, String other, String phone, String mobilePhone,
			String alias) {
		Driver.findElement(By.id(this.postcode)).sendKeys(postcode);
		Driver.findElement(By.id(this.other)).sendKeys(other);
		Driver.findElement(By.id(this.phone)).sendKeys(phone);
		Driver.findElement(By.id(this.phoneMobile)).sendKeys(mobilePhone);
		Driver.findElement(By.id(this.hf)).sendKeys(alias);
		return this;
	}

	public RegsitrationController selectDates(String days, String month, String year) {
		select(days, "//select[@id='days']");
		select(month, "//select[@id='months']");
		select(year, "//select[@id='years']");
		return this;
	}

	public RegsitrationController enterPersonalData(String firstName, String surName, String passwod, String company) {
		Driver.findElement(By.id(this.firstName)).sendKeys(firstName);
		Driver.findElement(By.id(this.surName)).sendKeys(surName);
		Driver.findElement(By.id(this.password)).sendKeys(passwod);
		Driver.findElement(By.id(this.company)).sendKeys(company);
		return this;
	}
}
