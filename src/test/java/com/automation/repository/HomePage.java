package com.automation.repository;

import com.automation.base.Utility;
import org.testng.Assert;

public class HomePage extends Utility{
	
	public static String pageHeader = "//header//a[@class='logo']";
	public static String whatsNewLink = "//a[normalize-space()=\"What's New\"]";
	public static String womenLink = "//a[normalize-space()='Women']";
	public static String menLink = "//a[normalize-space()='Men']";
	public static String gearLink = "//a[normalize-space()='Gear']";
	public static String trainingLink = "//a[normalize-space()='Training']";
	public static String saleLink = "//a[normalize-space()='Sale']";
	
	public void verifyHome() {
		Assert.assertTrue(isElementDisplayedXpath(pageHeader));
	}
	
	public void clickOnMenLink() {
		clickElementXpath(menLink);
		waitUntilPageIsReady();
	}

}
