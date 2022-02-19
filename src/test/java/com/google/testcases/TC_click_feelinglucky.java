package com.google.testcases;
import java.io.IOException;
import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.pageObjects.Home_Page;

public class TC_click_feelinglucky extends baseClass {
	
	
@Parameters("searchtxt")
	@Test
	public void feelinglucky(String searchtxt) throws IOException, InterruptedException {
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Home_Page hp=new Home_Page(driver);
		hp.setsearch(searchtxt);
		hp.clickfeelinglucky();
		Thread.sleep(1000);
		if(driver.getCurrentUrl().contains(searchtxt))
		{
			captureScreen(driver,"feelinglucky",searchtxt);
			Assert.assertTrue(true);
			logger.info(searchtxt+" is opened successfully");
		}
		else
		{
			captureScreen(driver,"feelinglucky",searchtxt);
			Assert.assertTrue(false);
			logger.error(searchtxt+" page not opened ");
		
	}
}
}