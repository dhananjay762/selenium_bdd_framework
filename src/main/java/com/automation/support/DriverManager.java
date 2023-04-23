package com.automation.support;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import com.automation.base.Utility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	
	public void launchChrome() throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(false);
		Utility.setDriver(new ChromeDriver());
		Utility.getDriver().manage().window().maximize();
	}
	
	public void launchEdge() throws IOException {
		//WebDriverManager.edgedriver().driverVersion("79.0.284.0").setup();
		WebDriverManager.edgedriver().setup();
		EdgeOptions options = new EdgeOptions();
		Utility.setDriver(new EdgeDriver());
		Utility.getDriver().manage().window().maximize();
	}
	
	public void launchFirefox() throws IOException {
		WebDriverManager.firefoxdriver().setup();
		FirefoxOptions options = new FirefoxOptions();
		options.setLegacy(true);
		Utility.setDriver(new FirefoxDriver());
		Utility.getDriver().manage().window().maximize();
	}
	
	public void launchIE() throws IOException {
		WebDriverManager.iedriver().setup();
		InternetExplorerOptions options = new InternetExplorerOptions();
		Utility.setDriver(new InternetExplorerDriver());
		Utility.getDriver().manage().window().maximize();
	}
	
	public void launchOpera() {
		WebDriverManager.operadriver().setup();
		OperaOptions options = new OperaOptions();
		Utility.setDriver(new OperaDriver());
		Utility.getDriver().manage().window().maximize();
	}
	
	public void launchSafari() {
		WebDriverManager.safaridriver().setup();
		SafariOptions options = new SafariOptions();
		Utility.setDriver(new SafariDriver());
		Utility.getDriver().manage().window().maximize();
	}
	
//	CHROME{
//		public void launch() throws IOException {
//			String driverPath = ReadProperties.getProperties("CHROME_DRIVER_PATH");
//			System.setProperty("webdriver.chrome.driver", driverPath);
//			Utility.driver = new ChromeDriver();
//			Utility.driver.manage().window().maximize();
//		}
//	},
//	EDGE{
//		public void launch() throws IOException {
//			String driverPath = ReadProperties.getProperties("EDGE_DRIVER_PATH");
//			System.setProperty("webdriver.edge.driver", driverPath);
//			Utility.driver = new EdgeDriver();
//			Utility.driver.manage().window().maximize();
//		}
//	},
//	FIREFOX{
//		public void launch() throws IOException {
//			String driverPath = ReadProperties.getProperties("GECKO_DRIVER_PATH");
//			System.setProperty("webdriver.gecko.driver", driverPath);
//			DesiredCapabilities cap = DesiredCapabilities.firefox();
//			cap.setCapability("marionette", true);
//			Utility.driver = new FirefoxDriver(cap);
//			Utility.driver.manage().window().maximize();
//		}
//	},
//	IE{
//		public void launch() throws IOException {
//			String driverPath = ReadProperties.getProperties("IE_DRIVER_PATH");
//			System.setProperty("webdriver.ie.driver", driverPath);
//			Utility.driver = new InternetExplorerDriver();
//			Utility.driver.manage().window().maximize();
//		}
//	};
	
//	public enum driverType{
//		
//	}
//	
	

}
