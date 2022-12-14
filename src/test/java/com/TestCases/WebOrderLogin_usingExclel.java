package com.TestCases;


import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

//import java.util.Properties;

//import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.excelExport.ReadExcelFile;
import com.operations.ReadObject;
import com.operations.UIOperation;

public class WebOrderLogin_usingExclel {
	 @Test
		public void testLogin() throws Exception {
			// TODO Auto-generated method stub
	    	WebDriver dr;
	       ReadExcelFile file = new ReadExcelFile();
	        ReadObject object = new ReadObject();
	        Properties allObjects =  object.getObjectRepository();
	        UIOperation operation = new UIOperation();
	        //Read keyword sheet
	        Sheet KDSheet = file.readExcel(System.getProperty("user.dir")+"\\","TestCase.xls" , "TC_002");
	      //Find number of rows in excel file
	    	int rowCount = KDSheet.getLastRowNum()-KDSheet.getFirstRowNum();
	    	//Create a loop over all the rows of excel file to read it
	    	for (int i = 1; i < rowCount+1; i++) {
	    		//Loop over all the rows
	    		Row row = KDSheet.getRow(i);
	    		//Check if the first cell contain a value, if yes, That means it is the new testcase name
	    		if(row.getCell(0).toString().length()==0){
	    		//Print testcase detail on console
	    			System.out.println(row.getCell(1).toString()+"----"+ row.getCell(2).toString()+"----"+
	    			row.getCell(3).toString()+"----"+ row.getCell(4).toString());
	    		//Call perform function to perform operation on UI
	    			operation.perform(allObjects, row.getCell(1).toString(), row.getCell(2).toString(),
	    				row.getCell(3).toString(), row.getCell(4).toString(),row.getCell(5).toString());
	    	    }
	    		else{
	    			//Print the new  testcase name when it started
	    				System.out.println("New Testcase->"+row.getCell(0).toString() +" Started");
	    			}
	    		}
		}





}
