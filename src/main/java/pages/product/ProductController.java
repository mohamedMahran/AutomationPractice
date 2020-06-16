package pages.product;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.aventstack.extentreports.Status;
import core.Driver;
import utilis.ExtentTestManager;
import utilis.Helper;

public class ProductController {
	String drpSize;
	String qty;
	String addToCart;
	String container;
	public ProductController() throws IOException
	{
		drpSize = Helper.load("automationpractice.Product.Size.xpath");
		qty= Helper.load("automationpractice.Product.Qty.css");
		addToCart=Helper.load("automationpractice.Product.addToCart.id");
		container=Helper.load("automationpractice.Product.container.xpath");
	}
	
	public ProductController enterQuantity(String quantity) {
		Driver.findElement(By.cssSelector(qty)).clear();
		Driver.findElement(By.cssSelector(qty)).sendKeys(quantity);
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

			Helper.clickOn(Driver.findElements(By.xpath(container)), button);
		} catch (Exception ex) {
			ExtentTestManager.getTest().log(Status.FAIL,ex);
		}

	}

	public void addToCart() {
		Driver.findElement(By.id(addToCart)).click();
		Helper.waitElementToBeVisible(By.xpath(container), 10);
		
	}

}
