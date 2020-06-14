package core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WebTable {
	WebElement table;
	
	// accept the web element (table) as parameter to then constructor
	public WebTable(WebElement wtable) {
		this.table= wtable;
	}
	// get the number of rows present
	public int getRowCount(){
		return table.findElements(By.tagName("tr")).size() - 1;
		
	}
	// get the number of columns present
	public int getColumnCount(){
		return table.findElements(By.xpath("//tr[2]/td")).size();
		
	}
	// get the nuber of rows and columns and return it as Map
	public Map<String, Integer> getTableSize(){
		Map<String, Integer> tableSize = new HashMap<>();
		tableSize.put("rows", getRowCount());
		tableSize.put("columns", getColumnCount());
		return tableSize;
	}

		// get row data and return it as list
		public List<String> rowData(int rowNumber) throws Exception{
			if(rowNumber == 0){
				throw new Exception("Row number starts from 1");
			}
			rowNumber = rowNumber + 1;
			List<WebElement> row = table.findElements(By.xpath("//tr["+rowNumber+"]/td"));
			List<String> rData = new ArrayList<>();
			for (WebElement webElement : row) {
				rData.add(webElement.getText());
			}
			return rData;
		}
		// get the column data and return as list
		public List<String> columnData(int columnNumber) {
			if(columnNumber == 0){
				try {
					throw new Exception("Column number starts from 1");
				} catch (Exception e) {

					e.printStackTrace();
				}
			}
			List<WebElement> column = table.findElements(By.xpath("//tr/td["+columnNumber+"]"));
			List<String> cData = new ArrayList<>();
			for (WebElement webElement : column) {
				cData.add(webElement.getText());
			}
			return cData;
		}

	// get all the data from the table
	public List<String> getAllData(){
		// get number of rows
		int noOfRows = table.findElements(By.xpath("//tr")).size();
		// get number of columns
		int noOfColumns = table.findElements(By.xpath("//tr[2]/td")).size();
		List<String> allData = new ArrayList<>();
		// iterate over the rows, to ignore the headers we have started the i with '1'
		for (int i = 1; i <= noOfRows; i++) {
			// reset the row data every time
			List<String> ro = new ArrayList<>();
			// iterate over columns
			for (int j = 1; j <= noOfColumns; j++) {
				// get text from the i th row and j th column
				ro.add(table.findElement(By.xpath("//tr["+i+"]/td["+j+"]")).getText());
			}
			// add the row data to allData of the table
			allData.addAll(ro);
		}
		return allData;
	}

	// verify presence of the text/data
	public boolean presenceOfData(String data){
		// verify the data by getting the size of the element matches based on the text/data passed
		int dataSize = table.findElements(By.xpath("//td[normalize-space(text())='"+data+"']")).size();
		boolean presence = false;
		if(dataSize > 0){
			presence = true;
		}
		return presence;
	}

	// get the data from a specific cell
	public String getCellData(int rowNumber, int columnNumber){
		if(rowNumber == 0){
			try {
				throw new Exception("Row number starts from 1");
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		rowNumber = rowNumber+1;
		return table.findElement(By.xpath("//tr["+rowNumber+"]/td["+columnNumber+"]")).getText();
		
	}
}

