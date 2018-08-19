package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {
	
public static long PAGE_LOAD_TIMEOUT = 20;
public static long IMPLICIT_WAIT = 10;
public static String TestDataSheetPath="C://Users//ashish//eclipse-workspace//FreeCRMTest//src//main//java//com//crm//qa//testdata//FreeCRMTestData.xlsx";
static Workbook book;
static Sheet sheet;


public void switchToFrame()
{
	driver.switchTo().frame("mainpanel");
}
public static Object[][] getTestData(String sheetName)
{
	FileInputStream file = null;
	try {
		file = new FileInputStream(TestDataSheetPath);
	} catch (FileNotFoundException e) {
		
		e.printStackTrace();
	}
	
		try {
			book =WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	sheet = book.getSheet(sheetName);
	Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	for(int i = 0;i<sheet.getLastRowNum();i++)
	{
		for(int j = 0;j<sheet.getRow(0).getLastCellNum();j++)
		{
			data[i][j]=sheet.getRow(i+1).getCell(j).toString();
		}
	}
	return data;
}


}
