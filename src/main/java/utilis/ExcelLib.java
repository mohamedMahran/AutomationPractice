package utilis;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelLib {
	
	private ExcelLib()
	{
		
	}
	public static String[][] getExcelData(String fileName, String sheetName)
			throws IOException  {
		
		FileInputStream fs = new FileInputStream(fileName);
		XSSFWorkbook wb = new XSSFWorkbook(fs);
		XSSFSheet sh = wb.getSheet(sheetName);

		// Loop through all rows in the sheet
		// Start at row 1 as row 0 is our header row
		int totalNoOfCols = sh.getRow(0).getLastCellNum();
		int totalNoOfRows = sh.getLastRowNum();
		String[][] data = new String[(totalNoOfRows - 1)][totalNoOfCols];
		// Loop through all rows in the sheet
		// Start at row 1 as row 0 is our header row
		int k = 0;
		for (int i = 1; i <= totalNoOfRows - 1; i++) {
			XSSFRow row = sh.getRow(i);
			for (int j = 0; j < totalNoOfCols; j++) {
				XSSFCell cell = row.getCell(j);
				String value = cellToString(cell);
				data[k][j] = value;
			}
			k++;
		}
		return data;
				
			}
	public static String cellToString(XSSFCell cell) {

		Object result;
		switch (cell.getCellType()) {

		case Cell.CELL_TYPE_NUMERIC:
			result = cell.getNumericCellValue();
			break;

		case Cell.CELL_TYPE_STRING:
			result = cell.getStringCellValue();
			break;

		case Cell.CELL_TYPE_BOOLEAN:
			result = cell.getBooleanCellValue();
			break;

		case Cell.CELL_TYPE_FORMULA:
			result = cell.getCellFormula();
			break;

		default:
			throw new IllegalArgumentException ("Unknown Cell Type");
		}

		return result.toString();
	}
			
}
