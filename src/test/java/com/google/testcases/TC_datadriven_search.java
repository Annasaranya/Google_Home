package com.google.testcases;

import java.io.IOException;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.pageObjects.Home_Page;
import com.google.utilities.XLUtils;

public class TC_datadriven_search extends baseClass{
	
	@Test(dataProvider="searchdata")
	public void datadriven_search(String searchtxt) throws IOException, InterruptedException
	{
		Home_Page hp=new Home_Page(driver);
		hp.setsearch(searchtxt);
		hp.clicksearchbtn();
		Thread.sleep(1000);
		captureScreen(driver,"datadriven_search",searchtxt);
		
		//Thread.sleep(1000);
		
	if(driver.getPageSource().contains("did not match any documents"))
		{
		
			logger.error("Invalid search text" +searchtxt);		
		}
	else
	{
	
		logger.info("valid search"+searchtxt);
		Thread.sleep(1000);	
		
	}
	
		//logger.info("check the screen shot for search data"+searchtxt);
	driver.navigate().back();
	Thread.sleep(1000);
	
	}
	
	@DataProvider(name="searchdata")
	String[][] getdata() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/google/testdata/searchdata.xlsx";
		int rownum=XLUtils.getRowCount(path,"Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String searchdata[][]=new String[rownum][colcount];
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				searchdata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return searchdata;
	}

}
