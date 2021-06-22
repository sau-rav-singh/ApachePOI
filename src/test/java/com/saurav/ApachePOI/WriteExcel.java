package com.saurav.ApachePOI;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//import utilities.TestLogs;

public class WriteExcel {
	public static Logger log = Logger.getLogger(WriteExcel.class.getName());

	public static void main(String[] args) throws IOException {
		//Date d = new Date();
		//System.setProperty("current.date", d.toString().replace(":", "_").replace(" ", "_"));
		PropertyConfigurator.configure(".\\properties\\log4j.properties");
		String filePath = ".\\datafiles\\employee.xlsx";
		FileInputStream instream = new FileInputStream(filePath);
		XSSFWorkbook workbook = new XSSFWorkbook(instream);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		Object empdata[][] = { { "EmpID", "Name", "Job" }, { 101, "David", "Engineer" }, { 102, "Smith", "Manager" },
				{ 103, "Scott", "Analyst" } };
		int rowCount = sheet.getLastRowNum();
		for (Object emp[] : empdata) {
			XSSFRow row = sheet.createRow(rowCount++);
			int columnCount = 0;
			for (Object value : emp) {
				XSSFCell cell = row.createCell(columnCount++);
				if (value instanceof String)
					cell.setCellValue((String) value);
				if (value instanceof Integer)
					cell.setCellValue((Integer) value);
				if (value instanceof Boolean)
					cell.setCellValue((Boolean) value);
			}
		}
		FileOutputStream outstream = new FileOutputStream(filePath);
		workbook.write(outstream);
		outstream.close();
		workbook.close();
		System.out.println("Employee.xls file written successfully...");
		log.info("This is the information log");
	}

}
