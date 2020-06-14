package pages.product;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;

import core.Driver;
import utilis.ExtentTestManager;
import utilis.Helper;

public class ProductController {
	
	public ProductController enterQuantity(String quantity) {
		Driver.findElement(By.cssSelector("#quantity_wanted")).clear();
		Driver.findElement(By.cssSelector("#quantity_wanted")).sendKeys(quantity);
		return this;
	}
	

	public ProductController selectSize(String requiredSize) {
		if (!Driver.findElements(By.xpath("//fieldset[1]/div/div/select")).isEmpty()) {
			List<WebElement> dropdownlist = Driver.findElements(By.xpath("//fieldset[1]/div/div/select"));
			for (WebElement e : dropdownlist) {
				if (e.getText().contains(requiredSize)) {
					Select size = new Select(e);
					size.selectByVisibleText(requiredSize);
				}
			}

		}
		return this;
	}
	
	public void click(String button) {

		try {

			Helper.clickOn(Driver.findElements(By.xpath("//div[@class='button-container']")), button);
		} catch (Exception ex) {
			ExtentTestManager.getTest().log(Status.FAIL,ex);
		}

	}

	public void addToCart() {
		Driver.findElement(By.id("add_to_cart")).click();
		Helper.waitElementToBeVisible(By.xpath("//div[@class='button-container']"), 10);
		
	}

}
