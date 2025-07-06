package common;

import java.io.FileInputStream;

import jxl.Sheet;
import jxl.Workbook;

import java.io.File;

public class Utils {
	public String[][] getTableObject(String fileName, String sheetName){
		String[][] dataTable = null;
		String xlFilePath = System.getProperty("user.dir") + "\\testcase\\testdata\\" + fileName ;
		int ci, cj;
		try {
			Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));
			Sheet sheet = workbook.getSheet(sheetName);
			int maxOfColumn = sheet.getColumns();
			dataTable = new String[sheet.getRows() - 1][maxOfColumn];
			ci = 0;

			for (int i = 1; i < sheet.getRows(); i++, ci++) {
				cj = 0;
				for (int j = 0; j < maxOfColumn; j++, cj++) {
					dataTable[ci][cj] = sheet.getCell(j, i).getContents();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return (dataTable);

		
	}
}
