package com.automation.repository;

import org.testng.Assert;

import com.automation.base.Utility;

public class MenPage extends Utility{
	
	public static String sideHeader = "//main//h1";
	public static String categoryTops = "//dt[normalize-space()='Category']/..//a[normalize-space()='Tops']";
	public static String categoryBotton = "//dt[normalize-space()='Category']/..//a[normalize-space()='Bottoms']";
	public static String categoryJackets = "//div[@class='categories-menu']//a[normalize-space()='Jackets']";


	public void verifySideHeader() {
		Assert.assertEquals(getTextXpath(sideHeader), "Men");
	}
	
	public void clickOnCategoryTops() {
		clickElementXpath(categoryTops);
		waitUntilPageIsReady();
	}
	
	public void clickOnCategoryJackets() {
		clickElementXpath(categoryJackets);
		waitUntilPageIsReady();
	}

}
