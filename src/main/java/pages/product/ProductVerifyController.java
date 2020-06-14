package pages.product;

import java.util.List;
import org.openqa.selenium.By;
import org.testng.Assert;

import core.Driver;
import core.WebTable;
import utilis.Helper;

public class ProductVerifyController {
	
	private String table="//table";

	public ProductVerifyController colorsOfTheProduct(String[] expectedColors) {

		List<String> actualDisplayedColors = Helper.getListOfStringsFromElementListByAttribute(
				Driver.findElements(By.xpath("//ul[@id='color_to_pick_list']/li//a")), "title");
		for (int i = 0; i < expectedColors.length; i++) {
			Assert.assertEquals(expectedColors[i], actualDisplayedColors.get(i));

		}
		return this;
	}

	public ProductVerifyController countOfSocialSharingProduct() {
		Helper.getListOfStringsFromListOfElements(
				Driver.findElements(By.xpath("//p[@class='socialsharing_product list-inline no-print']")));
		return this;
	}

	public ProductVerifyController rowCount() {
		WebTable w = new WebTable(Driver.findElement(By.xpath(table)));
		Assert.assertEquals(2, w.getRowCount());
		return this;
	}

	public ProductVerifyController columnCounts() {
		WebTable w = new WebTable(Driver.findElement(By.xpath(table)));
		Assert.assertEquals(2, w.getColumnCount());
		return this;
	}

	public ProductVerifyController columnNames(String[] expectedColumnNames) {
		WebTable w = new WebTable(Driver.findElement(By.xpath(table)));
		List<String> actualColumns = w.columnData(1);
		for (int i = 0; i < expectedColumnNames.length; i++) {
			Assert.assertEquals(expectedColumnNames[i], actualColumns.get(i));

		}

		return this;
	}

	public ProductVerifyController rowDetails(String[] productList) throws Exception {
		WebTable w = new WebTable(Driver.findElement(By.xpath(table)));
		List<String> actualRows = w.rowData(1);
		for (int i = 0; i < productList.length; i++) 
		{
			Assert.assertEquals(productList[i], actualRows.get(i));
		}		
		return this;
	}

	public ProductVerifyController productDetails(String product)
	{
		WebTable w = new WebTable(Driver.findElement(By.xpath(table)));
		Assert.assertTrue(w.getCellData(2, 2).contains(product));
		return this;
	}

	public ProductVerifyController presenceOfData(String data) {
		WebTable w = new WebTable(Driver.findElement(By.xpath(table)));
		Assert.assertTrue(w.presenceOfData(data));
		return this;
	}

	public ProductVerifyController productIsExist(String data) {
		WebTable w = new WebTable(Driver.findElement(By.xpath(table)));
		Assert.assertTrue(w.getCellData(2, 2).contains(data));
		return this;
	}

	public ProductVerifyController allData() {
		WebTable w = new WebTable(Driver.findElement(By.xpath(table)));
		List<String> actualData = w.getAllData();
		Assert.assertTrue(actualData.contains("Properties"));
		return this;
	}

}
