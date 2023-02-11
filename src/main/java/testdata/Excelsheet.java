package testdata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excelsheet {
	public static Workbook book; //globally declaring workbook to access in other classes
	public static Sheet sheet;//globally declaring sheet to access in other classes
	public static Object[][] readdata(String Sheetname){
		FileInputStream file=null;		
		try {
			file=new FileInputStream("C:\\Users\\deepu\\Rocians QA software classes\\eclipse\\HRmanagement\\src\\main\\java\\details.xlsx");
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
	 book=WorkbookFactory.create(file);//book has to be declared globally so we can access
	
	/*Workbook is the Interface and WorkbookFactory is the class which has the properties of auto detecting the type of file and
	 refer all the methods from Interface and create workbook*/
	}
		catch(IOException a) { 
			a.printStackTrace();
		}
		 sheet=book.getSheet(Sheetname);//globally declaring sheet to access in other classes
		 
//Create object array with rows and columns
		 Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		 //Hence we created 2D Object array with no. of columns & Rows
		 
		 for(int i=0;i<sheet.getLastRowNum();i++) {
			 for(int k=0;k<sheet.getRow(0).getLastCellNum();k++) {
				 data[i][k]=sheet.getRow(i+1).getCell(k).toString();
			 }
			 
		 }
		 
		return data;
		

}}
