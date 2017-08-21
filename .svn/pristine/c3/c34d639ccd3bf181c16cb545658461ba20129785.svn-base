package com.tr.genericlib;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * WebDriver Excel Libraries.
 * class provide Excel  libraries , which can be used to fetch the data from the excel sheet, to get the row count from the excel sheet .etc
 *
 * @author Deepak HR
 *
 */

public class ExcelLIb {
	
	 public static String filePath;
	
	
	public String getExcelData(String sheetName , String testID , String columnHeader) throws InvalidFormatException, IOException{
			
		String userDir = System.getProperty("user.dir");
		filePath = userDir+"\\testdata\\Test_Data.xlsx";
		String data = null;
		  FileInputStream fis = new FileInputStream(filePath);
		  Workbook wb = WorkbookFactory.create(fis);
		  Sheet sh = wb.getSheet(sheetName);
		  int rowcount =getRowCount(sheetName);
		  
		  for(int r=0 ; r<rowcount; r++){
			  Row row = sh.getRow(r);
			  if(row.getCell(0).getStringCellValue().toLowerCase().equals(testID.toLowerCase())){
				 int col =  row.getLastCellNum();
				 	for(int c=0; c<col ; c++){
				 		if(row.getCell(c).getStringCellValue().toLowerCase().equals(columnHeader.toLowerCase())){
				 		    row = sh.getRow(r+1);
				 		   data = row.getCell(c).getStringCellValue();
				 		   break;
				 		}
				 		
				 	}
				 	
				  
			  }
			  
			  
		  }
		  
		 
		  return data;
	}
	
	
	public String getExcelData(String sheetName , int rowNum , int colNum) throws InvalidFormatException, IOException{
		  FileInputStream fis = new FileInputStream(filePath);
		  Workbook wb = WorkbookFactory.create(fis);
		  Sheet sh = wb.getSheet(sheetName);	
		  Row row = sh.getRow(rowNum);
		  String data = row.getCell(colNum).getStringCellValue();
		  return data;
	}
	
	public int getRowCount(String sheetName) throws InvalidFormatException, IOException{
		
		  FileInputStream fis = new FileInputStream(filePath);
		  Workbook wb = WorkbookFactory.create(fis);
		  Sheet sh = wb.getSheet(sheetName);
		  int rowCount = sh.getLastRowNum()+1;
		return rowCount;
	}
	
	public void setExcelData(String sheetName,int rowNum,int colNum,String data) throws InvalidFormatException, IOException{
		  FileInputStream fis = new FileInputStream(filePath);
		  Workbook wb = WorkbookFactory.create(fis);
		  Sheet sh = wb.getSheet(sheetName);
		  Row row = sh.getRow(rowNum);
		  Cell cel = row.createCell(colNum);
		  cel.setCellType(cel.CELL_TYPE_STRING);
		  cel.setCellValue(data);
		  
		  FileOutputStream fos = new FileOutputStream(filePath);
		  wb.write(fos);
		  
	}
	
	public int getcellCount(String sheetName,int rowNum) throws InvalidFormatException, IOException{
		  FileInputStream fis = new FileInputStream(filePath);
		  Workbook wb = WorkbookFactory.create(fis);
		  Sheet sh = wb.getSheet(sheetName);	
		  Row row = sh.getRow(rowNum);
		 return row.getLastCellNum();
		  
	}
	
	
	
	
	

}
