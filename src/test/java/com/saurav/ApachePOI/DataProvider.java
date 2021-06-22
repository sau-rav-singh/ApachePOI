package com.saurav.ApachePOI;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataProvider {

	public static void main(String[] args) throws IOException {
		String excelFilePath = System.getProperty("user.dir") + "\\datafiles\\saurav.xlsx";
		//HashMap<Integer,String> table=new HashMap<Integer,String>();
		
		FileInputStream fis = new FileInputStream(excelFilePath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);// workbook.getSheet("Sheet 1");
		int rows = sheet.getLastRowNum();
		int col = sheet.getRow(1).getLastCellNum();
		Object[][] data = new Object[rows][col];
		for (int i = 0; i < rows; i++) {
			col = sheet.getRow(i).getLastCellNum();
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < col; j++) {
				XSSFCell cell = row.getCell(j);
				switch (cell.getCellType()) {
				case STRING:
					//System.out.print(cell.getStringCellValue()+" ");
					//table.put(, cell.getStringCellValue());
					data[i][j]=cell.getStringCellValue();
					break;
				case NUMERIC:
					//System.out.print(cell.getNumericCellValue());
					data[i][j]=cell.getNumericCellValue();
					break;
				default:
					//System.out.print("Please check cell data");
				}
			}
			//System.out.println(" ");
		}
		workbook.close();
		for(int i=0;i<rows;i++) {
			for(int j=0;j<col;j++) {
				System.out.print(data[i][j]+" ");
			}
			System.out.println(" ");
		}
		
	}
}
