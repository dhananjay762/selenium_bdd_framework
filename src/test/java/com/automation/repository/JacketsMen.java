package com.automation.repository;

import org.testng.Assert;

import com.automation.base.Utility;

public class JacketsMen extends Utility{
	
	public static String sideHeader = "//main//h1";
	public static String sizeFilterDiv = "//div[contains(@class, 'filter')][normalize-space()='Size']";
	public static String sizeFilterXL = "//div[contains(@class, 'filter')][normalize-space()='Size']/..//*[@option-label='XL']";
	public static String productItemsGrid = "//div[contains(@class, 'products-grid')]";
	public static String selectJacketType = "//div[contains(@class, 'products-grid')]//a[normalize-space()='placeholder']";
	public static String selectSize = "//div[contains(@class, 'swatch-attribute')]//div[normalize-space()='placeholder']";
	public static String selectColor = "//div[contains(@class, 'swatch-attribute')]//div[@option-label='placeholder']";
	public static String selectQuantity = "//input[@id='qty']";
	public static String addToCartBtn = "//button[normalize-space()='Add to Cart']";
	public static String addedToCartMsg = "//div[@class='messages'][@role='alert']";
	
	public void verifySideHeader() {
		Assert.assertEquals(getTextXpath(sideHeader), "Jackets");
	}
	
	public void filterWithSizeXL() {
		clickElementXpath(sizeFilterDiv);
		clickElementXpath(sizeFilterXL);
		waitUntilPageIsReady();
	}
	
	public void chooseJacketType(String type) {
		clickElementXpath(selectJacketType.replace("placeholder", type));
		waitUntilPageIsReady();
	}
	
	public void chooseJacketAttributes(String size, String color, int quantity) {
		clickElementXpath(selectSize.replace("placeholder", size));
		clickElementXpath(selectColor.replace("placeholder", color));
		enterTextXpath(selectQuantity, String.valueOf(quantity));
	}
	
	public void clickOnAddToCart() {
		clickElementXpath(addToCartBtn);
		waitUntilPageIsReady();
	}
	
	

}
