package com.google.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.pageObjects.Home_Page;

public class TC_Images_link_test extends baseClass {
	@Test
	public void ImageLink_Test() throws IOException, InterruptedException
	{
		
	Home_Page hp=new Home_Page(driver);
	hp.clickImage();
	captureScreen(driver,"TC_Images_link_test","GoogleImages");
	Thread.sleep(1000);
	if(hp.isGoogleImageLogo_changed())
	{
		logger.info("Google search by Image page loaded successfully");
		Assert.assertTrue(true);
	}
	else
	{
		logger.error("Google search by Image not opened successfully");
		Assert.assertTrue(false);
	}
}
}