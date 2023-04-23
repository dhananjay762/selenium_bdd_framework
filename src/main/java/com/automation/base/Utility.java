package com.automation.base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {
	
	private static WebDriver driver;
	private static RemoteWebDriver r_driver;
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	public static void setDriver(WebDriver wDriver) {
		driver = wDriver;
	}
	
	public String getPageTitle() {
		return getDriver().getTitle();
	}
	
	public WebElement findElementXpath(String xpath) {
		return getDriver().findElement(By.xpath(xpath));		
	}
	
	public WebElement findElement(String css) {
		return getDriver().findElement(By.cssSelector(css));		
	}
	
	public List<WebElement> findElements(String css){
		return getDriver().findElements(By.cssSelector(css));
	}
	
	public List<WebElement> findElementsXpath(String xpath){
		return getDriver().findElements(By.xpath(xpath));
	}
	
	public void wait(int timeInSeconds) throws InterruptedException {
		Thread.sleep(timeInSeconds*1000);
	}
	
	public WebElement waitForElementVisible(WebElement element, int timeout) {
		WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
		wait.until(ExpectedConditions.visibilityOf(element));
		return element;
	}
	
	public WebElement waitForElementInvisibility(WebElement element, int timeout) {
		WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
		wait.until(ExpectedConditions.invisibilityOf(element));
		return element;
	}
	
	public WebElement waitForElementClickable(WebElement element, int timeout) {
		WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		return element;
	}
	
	public WebElement waitForElementToBeSelected(WebElement element, int timeout) {
		WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
		wait.until(ExpectedConditions.elementToBeSelected(element));
		return element;
	}
	
	public void waitForTitleContains(String title, int timeout) {
		WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
		wait.until(ExpectedConditions.titleContains(title));
	}
	
	public WebElement waitForElementSelectionState(WebElement element, boolean selectionState, int timeout) {
		WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
		wait.until(ExpectedConditions.elementSelectionStateToBe(element, selectionState));
		return element;
	}
	
	public void waitUntilPageIsReady() {
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		if(js.executeScript("return document.readyState").toString().equals("complete")) {
			return;
		}
	}
	
	public void clickElement(String css) {
		waitForElementClickable(
				waitForElementVisible(findElement(css), 30), 30).click();
	}
	
	public void clickElementXpath(String xpath) {
		waitForElementClickable(
				waitForElementVisible(findElementXpath(xpath), 30), 30).click();
	}
	
	public void enterText(String css, String textToEnter) {
		WebElement element = findElement(css);
		waitForElementVisible(element, 60).clear();
		element.sendKeys(textToEnter);
	}
	
	public void enterTextXpath(String xpath, String textToEnter) {
		WebElement element = findElementXpath(xpath);
		waitForElementVisible(element, 60).clear();
		element.sendKeys(textToEnter);
	}
	
	public void selectByVisibleText(String css, String textToSelect) {
		Select sel = new Select(waitForElementClickable(findElement(css), 60));
		sel.selectByVisibleText(textToSelect);
	}
	
	public void selectByVisibleTextXpath(String xpath, String textToSelect) {
		Select sel = new Select(waitForElementClickable(findElementXpath(xpath), 60));
		sel.selectByVisibleText(textToSelect);
	}
	
	public void selectByIndex(String css, int indexToSelect) {
		Select sel = new Select(waitForElementClickable(findElement(css), 60));
		sel.selectByIndex(indexToSelect);
	}
	
	public void selectByIndexXpath(String xpath, int indexToSelect) {
		Select sel = new Select(waitForElementClickable(findElementXpath(xpath), 60));
		sel.selectByIndex(indexToSelect);
	}
	
	public String getText(String css) {
		return waitForElementVisible(findElement(css), 30).getText();
	}
	
	public String getTextXpath(String xpath) {
		return waitForElementVisible(findElementXpath(xpath), 30).getText();
	}
	
	public boolean isElementPresent(String css) {
		return findElements(css).size()!=0;
	}
	
	public boolean isElementPresentXpath(String xpath) {
		return findElementsXpath(xpath).size()!=0;
	}
	
	public boolean isElementDisplayed(String css) {
		return findElement(css).isDisplayed();
	}
	
	public boolean isElementDisplayedXpath(String xpath) {
		return findElementXpath(xpath).isDisplayed();
	}

}
