package com.google.pageObjects;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {
	
	WebDriver driver;
	
	public Home_Page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="q")
	@CacheLookup
	WebElement searchbox;
	
	@FindBy(xpath="//a[text()='About']")
	@CacheLookup
	WebElement aboutLink;
	
	@FindBy(xpath="//a[text()='Store']")
	@CacheLookup
	WebElement storeLink;
	
	@FindBy(xpath="//a[text()='Gmail']")
	@CacheLookup
	WebElement gmailLink;
	
	@FindBy(xpath="//a[text()='Images']")
	@CacheLookup
	WebElement imagesLink;
	
	@FindBy(xpath="//*[name()='svg' and @class='gb_Se']")
	@CacheLookup
	WebElement googleApps;
	
	@FindBy(xpath="//a[text()='Sign in']")
	@CacheLookup
	WebElement signInButton;
	
	@FindBy(xpath="//img[@alt='Google']")
	@CacheLookup
	WebElement googleLogo;
	
	@FindBy(xpath="//div[@aria-label='Search by voice']")
	@CacheLookup
	WebElement ByvoiceButton;
	
	@FindBy(xpath="(//input[@name='btnK'])[2]")
	@CacheLookup
	WebElement searchButton;
	
	@FindBy(xpath="(//input[@name='btnI'])[1]")
	@CacheLookup
	WebElement FeelingLuckyButton;
	
	@FindBy(xpath="//a[text()='Advertising']")
	@CacheLookup
	WebElement advertisingLink;
	
	@FindBy(xpath="//a[text()='Business']")
	@CacheLookup
	WebElement businessLink;
	
	@FindBy(xpath="//a[text()=' How Search works ']")
	@CacheLookup
	WebElement howsearchworksLink;
	
	@FindBy(xpath="//a[text()='Privacy']")
	@CacheLookup
	WebElement privacyLink;
	
	@FindBy(xpath="//a[text()='Terms']")
	@CacheLookup
	WebElement termsLink;
	
	@FindBy(xpath="//button[text()='Settings']")
	@CacheLookup
	WebElement settingsButton;
	
	
	@FindBy(xpath="//img[@alt='Google Images']")
	@CacheLookup
	WebElement GoogleImageLogo;
	
	@FindBy(xpath="//div[@jsname and @jsaction]//li/a")
	@CacheLookup
	List<WebElement> allItems;
	
	
	public void setsearch(String searchtxt)
	{
		searchbox.sendKeys(searchtxt);
	}
	public void clickfeelinglucky()
	{
		FeelingLuckyButton.click();
	}
	public void clicksearchbtn()
	{
		searchButton.click();
	}
	
	public void clickImage() {
		imagesLink.click();
	}
	public Boolean isGoogleImageLogo_changed()
	{
		Boolean bool=GoogleImageLogo.isDisplayed();
		return bool;
	}
	public void clickGoogleApps()
	{
		googleApps.click();
	}
	public List<WebElement> listOfApps()
	{
		return allItems;
	}
}
