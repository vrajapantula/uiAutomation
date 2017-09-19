package com.automation.uiAutomation.excelReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;




public class Excel_Reader {
	
	public FileInputStream fis = null;
	public String path;
	public XSSFWorkbook workbook = null;
	public XSSFSheet sheet = null;
	public XSSFRow row = null;
	public XSSFCell cell = null;
	
	public Excel_Reader(String path){
		this.path = path;
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);	
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public String[][] getDataFromSheet(String sheetName) {
		
		try {
			int rowCount,colCount;
			String dataSets[][] = null;
					
			sheet = workbook.getSheet(sheetName);			
			rowCount = sheet.getLastRowNum();
			colCount = sheet.getRow(0).getLastCellNum();
			dataSets = new String[rowCount-1][colCount];
			for (int i = 1; i<rowCount; i++){
				XSSFRow currentRow = sheet.getRow(i); 
				for (int j=0;j<colCount; j++){				
					dataSets[i-1][j]=  currentRow.getCell(j).getStringCellValue();				
				}			
			}			
			return dataSets;
		} catch (Exception e) {			
			e.printStackTrace();
		}
		return null;
		
	}
	
	public String getCellData(String sheetName, String colName, int rowNum) {
		try {
			int colCount,regCol=0;
			sheet = workbook.getSheet(sheetName);
			row = sheet.getRow(0);
			colCount = row.getLastCellNum();
			
			for (int i=0; i<colCount; i++){
				if (row.getCell(i).getStringCellValue().equals(colName)){
					regCol = i;
					break;
				}		
			}
			return sheet.getRow(rowNum).getCell(regCol).getStringCellValue();
		} catch (Exception e) {			
			e.printStackTrace();
		}	
		return null;
	}
	
	
	
	
	
}
