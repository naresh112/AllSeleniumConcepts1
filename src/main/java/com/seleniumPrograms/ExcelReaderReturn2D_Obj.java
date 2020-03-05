package com.seleniumPrograms;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReaderReturn2D_Obj {

	public static String Excel_TestData_File_path = "C:\\Users\\madhu\\Desktop\\i temp\\test data.xlsx";
	public static Workbook workbook;
	public static Sheet sheet;
	public static int totalRows;
	public static int totalColumn;

	public Object[][] getTestData(int sheetNamePosition) throws IOException {
		FileInputStream fis;
		File file;
		try {
			file = new File(Excel_TestData_File_path);
			fis = new FileInputStream(file);
			workbook = WorkbookFactory.create(fis);

		} catch (Exception e) {
			e.printStackTrace();
		}

		sheet = workbook.getSheetAt(sheetNamePosition);
		System.out.println(sheet.getLastRowNum());
		System.out.println(sheet.getRow(0).getLastCellNum());

		// be carefull using below methods
		totalRows = sheet.getLastRowNum();// here getLastRowNum() methods gives one row less count
		// that means if in your excel file 10 rows but this method gives count=9
		// thats why we use sheet.getLastRowNum()+1 depends on situation ad depends on
		// logic
		totalColumn = sheet.getRow(0).getLastCellNum();// here it gives exact columns nums
		// if u have 10 columns it gives total coumns=10
		Object[][] data = new Object[sheet.getLastRowNum() + 1][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i <= sheet.getLastRowNum(); i++) {
			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
				data[i][j] = sheet.getRow(i).getCell(j).toString();
			}
		}
		workbook.close();
		return data;

	}

	public static void main(String[] args) throws IOException {
		Object data[][] = new ExcelReaderReturn2D_Obj().getTestData(0);
		System.out.println("length means number of rows in excel file or rows in data array :" + data.length);
		System.out.println(
				"number of columns in that particular row here i given 0 excel file 1st row " + data[0].length);
		System.out.println("total rows " + totalRows);
		System.out.println("total number of columns is " + totalColumn);
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				System.out.print(data[i][j] + "            ");

			}
			System.out.println();

		}
		
		//***************************************excel writting*********
		
		new ExcelReaderReturn2D_Obj().set_Data();

	}

	public void set_Data() throws IOException {
		File file = new File("C:\\Users\\madhu\\Desktop\\i temp\\demoExcelFile.xlsx");

		try {
			FileInputStream fis = new FileInputStream(file);
			//workbook = WorkbookFactory.create(fis);
			workbook=new XSSFWorkbook(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//workbook.getNumberOfSheets() >> it gives total sheet count from given excel file
		System.out.println(workbook);
		sheet=workbook.createSheet();
		sheet.createRow(0).createCell(0).setCellValue("name");
		FileOutputStream fos=new FileOutputStream(file);
		workbook.write(fos);
		workbook.close();
//		sheet=workbook.getSheetAt(0);
//		int lastRow=sheet.getLastRowNum();
//		int lastColumn=sheet.getRow(0).getLastCellNum();
//		sheet.getRow(0)

	}

}
