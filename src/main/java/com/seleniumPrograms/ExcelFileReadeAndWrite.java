package com.seleniumPrograms;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelFileReadeAndWrite {
	//me
	@Test
	public void excelReader() throws IOException {
		File fil = new File("C:\\Users\\madhu\\Desktop\\i temp\\demoExcelFile.xlsx");
		FileInputStream fis = new FileInputStream(fil);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sht = wb.getSheetAt(0);
		Row row = sht.getRow(0);
		System.out.println(sht.getLastRowNum() + 1);
	}
	
	//@Test
	public void ExcelWrite() throws IOException {
		FileInputStream fis=new FileInputStream("C:\\Users\\madhu\\Desktop\\i temp\\demoExcelFile.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		Sheet sh=wb.getSheetAt(0);
		Row row=sh.getRow(1);
		FileOutputStream wedata=new FileOutputStream("C:\\Users\\madhu\\Desktop\\i temp\\demoExcelFile.xlsx");
			row.createCell(10).setCellValue("fail");
			wb.write(wedata);
			wb.close();
	}
	
	//@Test--me
	
	
	
	//@Test
		public void writeDataFromExcel(int rowcount, int columncount, String filepath, String Sheetname, String value) {
			try {
				FileInputStream input = new FileInputStream(filepath);
				XSSFWorkbook wb = new XSSFWorkbook(input);
				XSSFSheet sh = wb.getSheet(Sheetname);
				XSSFRow row = sh.getRow(rowcount);
				FileOutputStream webdata = new FileOutputStream(filepath);
				row.createCell(columncount).setCellValue(value);
				wb.write(webdata);
				wb.close();

			} catch (Exception e) {

			}
		}
	
	
	// @Test
	public String readDataFromExcel(int rowcount, int columncount, String filepath, String Sheetname) {
		String data = null;
		try {
			FileInputStream input = new FileInputStream(filepath);
			XSSFWorkbook wb = new XSSFWorkbook(input);
			XSSFSheet sh = wb.getSheet(Sheetname);
			XSSFRow row = sh.getRow(rowcount);
			data=row.getCell(columncount).toString();
			wb.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return data;
	}

	
	public static void main(String[] args) throws IOException {
		String data1=new ExcelFileReadeAndWrite().readDataFromExcel(0, 0, "C:\\\\Users\\\\madhu\\\\Desktop\\\\i temp\\\\demoExcelFile.xlsx", "Sheet1");
		System.out.println("data1 :"+data1);
		new ExcelFileReadeAndWrite().writeDataFromExcel(1, 9, "C:\\\\\\\\Users\\\\\\\\madhu\\\\\\\\Desktop\\\\\\\\i temp\\\\\\\\demoExcelFile.xlsx", "Sheet1", "pass");
		String data2=new ExcelFileReadeAndWrite().readDataFromExcel(1, 9, "C:\\\\Users\\\\madhu\\\\Desktop\\\\i temp\\\\demoExcelFile.xlsx", "Sheet1");
		System.out.println("data2 :"+data2);
		System.out.println(System.getProperty("user.dir")+"//src/main/java");
	}
	

}
