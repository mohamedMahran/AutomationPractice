package pages.order;

import java.io.IOException;

import org.openqa.selenium.By;

import com.aventstack.extentreports.Status;
import core.Driver;
import utilis.ExtentTestManager;
import utilis.Helper;

public class OrderController {
	
	private String confirmMyOrder;
	private String proceedToTheCheckOut;
	private String clickByTermOfService;
	private String payByBankWire;
	private String processAddress;
	
	public OrderController()
	{
	try 
		{
		confirmMyOrder = Helper.load("automationpractice.order.confirmMyOrder.css");
		proceedToTheCheckOut= Helper.load("automationpractice.order.proceedToTheCheckOut.xpath");
		clickByTermOfService=Helper.load("automationpractice.order.clickByTermOfService.xpath");
		payByBankWire=Helper.load("automationpractice.order.payByBankWire.xpath");
		processAddress=Helper.load("automationpractice.order.processAddress.xpath");
		} 
	catch (IOException e) 
		{
			ExtentTestManager.getTest().log(Status.FAIL, e.getMessage());
		}
	}
	public OrderController confirmMyOrder()
	{
		Driver.findElement(By.cssSelector(confirmMyOrder)).click();
		return this;
	}

	public OrderController proceedToTheCheckOut()
	{		
		Driver.findElement(By.xpath(proceedToTheCheckOut)).click();
		return this;
	}

	public OrderController clickByTermOfService() {

		Driver.findElement(By.xpath(clickByTermOfService)).click();
		return this;
	}
	
	public OrderController payByBankWire()
	{
		Driver.findElement(By.xpath(payByBankWire)).click();
		return this;
	}
	
	public OrderController processAddress() {
		Driver.findElement(By.xpath(processAddress)).click();
		return this;
	}
}
