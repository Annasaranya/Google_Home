package com.google.testcases;

import java.io.IOException;
import java.util.List;


import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.pageObjects.Home_Page;

public class TC_openGoogleApps extends baseClass  {
	@Parameters("app")
	@Test
	public void clickGoogleApps(String app) throws InterruptedException, IOException
	{
	// Google Apps is a SVG element. There are multiple svg element so I used multiple attributes.
		Home_Page hp=new Home_Page(driver);
		hp.clickGoogleApps();
			Thread.sleep(1000);
			
			driver.switchTo().frame(1);
			// Locating all app names. XPath is tricky as we can not use their values as they are dynamic
			List<WebElement> allMenus = hp.listOfApps();
			
			// Printing all app names Without stream
			for(WebElement menu : allMenus)
			{
				 String link=menu.getAttribute("href");
				//System.out.println(link);
				if(link.contains(app))
				{
				driver.get(link);	
				break;
				}
				
			}
			Thread.sleep(1000);
			if(driver.getCurrentUrl().contains("youtube"))
			{
				captureScreen(driver,"clickGoogleApps",app);
			logger.info(app+ "opened successfully");
			Assert.assertTrue(true);
			}
			else
			{
				captureScreen(driver,"clickGoogleApps",app);
				logger.error(app+"not opened");
				Assert.assertTrue(false);
			}
			
			
			
		}

}
