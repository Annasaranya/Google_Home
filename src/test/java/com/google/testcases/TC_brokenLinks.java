package com.google.testcases;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Iterator;
import java.util.List;
import java.net.URL;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;



public class TC_brokenLinks extends baseClass{
	
	@Test
	public void broken_links() throws IOException
	{

		
		List<WebElement> linklist=driver.findElements(By.tagName("a"));
		System.out.println("Number of links"+linklist.size());
		Iterator<WebElement> it = linklist.iterator();
		
		while(it.hasNext())
		{
			
			String url = it.next().getAttribute("href");
			URL link=new URL(url);
			HttpURLConnection connection=(HttpURLConnection)link.openConnection();
			connection.connect();
			int responsecode=connection.getResponseCode();
			if(responsecode>=400)
			{
				logger.error(url + "-"+"is broken link");
			
			}
			else
			{
				logger.info(url +"-" +"is valid link");
				
		}
			
				}
		
		
	}
}


	
