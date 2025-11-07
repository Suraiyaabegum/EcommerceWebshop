package com.qa.reusableComponent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import com.qa.base.BaseClass;

public class ReadyDataFromExcel extends BaseClass {

	@DataProvider(name="testdataexcel")
	public String[][] getData(Method m) throws EncryptedDocumentException, IOException

	{
		String excelSheetName = m.getName();
		File file=new File(System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\testdata.xlsx");
		FileInputStream fis=new FileInputStream(file);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sheetName=wb.getSheet(excelSheetName);

		int totalRows=sheetName.getLastRowNum();  
		System.out.println(totalRows);

		Row rowCells=sheetName.getRow(0); // Row 0 = Excel row 1 //Refers to Excel’s Row 1.
		int totalCols=rowCells.getLastCellNum();
		System.out.println(totalCols);

		DataFormatter format=new DataFormatter();   

		String testdata[][]=new String[totalRows][totalCols];  //memory allocation as per the need. 2-D Array
		for(int i=1; i<=totalRows; i++) {
			for(int j=0; j<totalCols; j++) {
				testdata[i-1][j]=format.formatCellValue(sheetName.getRow(i).getCell(j));
				System.out.println(testdata[i-1][j]);            
			}
		}
		return testdata;
	}
}