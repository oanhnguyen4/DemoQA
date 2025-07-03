package common;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;

public class Utils {
	public String[][] getTableObject(String fileName, String sheetName){
		String[][] dataTable = null;
		String excelFile = System.getProperty("user.dir") + "\\testcase\\testdata" + fileName ;
		try {
			FileInputStream file = new FileInputStream(new File(excelFile));
			Workbook workbook = WorkbookFactory.create(file);
//			Sheet sheet = workbook.getSheet(sheetName);
//			int maxRow = sheet.getLastRowNum();
//			int maxColumn = sheet.get;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dataTable;
	}
}
