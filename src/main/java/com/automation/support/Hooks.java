package com.automation.support;

import java.io.IOException;
import cucumber.api.java.Before;
import cucumber.api.java.After;
import com.automation.base.Utility;


public class Hooks {
		
	@Before
	public void setUp() throws IOException, NoSuchMethodException, SecurityException {
		boolean remote = Boolean.parseBoolean(ReadProperties.getProperties("REMOTE"));
		String browserType = ReadProperties.getProperties("BROWSER");
		String applicationURL = ReadProperties.getProperties("APPLICATION_URL");
		setupDriver(browserType, remote);
		launchURL(applicationURL);
	}
	
	@After
	public void closeBrowser() {
		Utility.getDriver().quit();
	}
	
	public static void setupDriver(String browserType, boolean remote) throws IOException {
		DriverManager driverManager = new DriverManager();
		switch(browserType.toUpperCase()) {
		case "CHROME":
			driverManager.launchChrome();
			break;
		case "FIREFOX":
			driverManager.launchFirefox();
			break;
		case "EDGE":
			driverManager.launchEdge();
			break;
		case "IE":
			driverManager.launchIE();
			break;
		case "OPERA":
			driverManager.launchOpera();
			break;
		case "SAFARI":
			driverManager.launchSafari();
			break;
		default:
			driverManager.launchChrome();
			break;
		}
	}
	
	public static void launchURL(String url) {
		Utility.getDriver().navigate().to(url);
	}

}
