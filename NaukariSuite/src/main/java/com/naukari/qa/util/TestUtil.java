package com.naukari.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class TestUtil {
	
	public static long PAGE_LOAD_TIMEOUT = 40;
	public static long IMPLICT_WAIT = 40;

	public static String TESTDATA_SHEET_PATH = System.getProperty("user.dir") + "/src/main/java/com/naukari/qa/testdata/NaukariTestData.xlsx"; 
	
	static Workbook book;
	static Sheet sheet;
	
	

	public static Object[][] readTestData(String sheetName) {
		FileInputStream file = null;
		 try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		 
		 try {
			book= WorkbookFactory.create(file);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 sheet = book.getSheet(sheetName);
		 Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		 for(int i =0; i<sheet.getLastRowNum(); i++) {
			 for(int j= 0; j<sheet.getRow(0).getLastCellNum();j++) {
				 data[i][j] = sheet.getRow(i+1).getCell(j).toString();
				 //System.out.println(data[i][j] );
			 }
		 }
		 return data;
	}
	
/*	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}*/

}
