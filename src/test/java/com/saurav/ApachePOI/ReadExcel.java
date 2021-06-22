package com.saurav.ApachePOI;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;

public class ReadExcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String excelFilePath = System.getProperty("user.dir") + "\\datafiles\\saurav.xlsx";
		FileInputStream fis = new FileInputStream(excelFilePath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);// workbook.getSheet("Sheet 1");
		int rows = sheet.getLastRowNum();
		for (int i = 0; i < rows; i++) {
			int col = sheet.getRow(i).getLastCellNum();
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < col; j++) {
				XSSFCell cell = row.getCell(j);
				switch (cell.getCellType()) {
				case STRING:
					System.out.println(cell.getStringCellValue());
					break;
				case NUMERIC:
					System.out.println(cell.getNumericCellValue());
					break;
				default:
					System.out.println("Please check cell data");
				}
			}
			System.out.println(" ");
		}
		workbook.close();
	}

}
