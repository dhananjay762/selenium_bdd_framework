package com.automation.listener;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.automation.base.Utility;
import com.automation.support.ReadProperties;
import com.cucumber.listener.Reporter;
import com.google.common.io.Files;

//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//import io.cucumber.java.Scenario;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class ExtentReport implements ReportConfig{
	
	@Before
	public void before(Scenario scenario) {
		Reporter.assignAuthor(AUTHOR);
	}
	
	@After
	public void after(Scenario scenario) throws IOException {
		writeExtentReport();
	}
	
	@After
	public void afterScenario(Scenario scenario) {
//		if(scenario.isFailed()) {
//			String screenshotName = scenario.getName().replaceAll("-", "_").replaceAll(" ", "_");
//			System.out.println("screenshotName: "+screenshotName);
//			try {
//				TakesScreenshot screenshot = (TakesScreenshot)Utility.getDriver();
//				File sourcePath = screenshot.getScreenshotAs(OutputType.FILE);
//				File destinationPath = new File(System.getProperty("user.dir")+"/target/cucumber/screenshots/"+screenshotName+".png");
//				System.out.println("sourcePath: "+sourcePath);
//				System.out.println("destinationPath: "+destinationPath);
//				Files.copy(sourcePath, destinationPath);
//				Reporter.addScreenCaptureFromPath(destinationPath.toString());
//			}catch(Exception e) {
//				System.out.println("in catch block");
//				System.out.println("error: "+e.getMessage());
//				Reporter.addStepLog(e.getMessage());
//			}
//		}
	}
	
	public String getReportConfigPath() throws IOException {
		String reportConfigPath = ReadProperties.getProperties("REPORT_CONFIG_PATH");
		if(reportConfigPath!=null) {
			return reportConfigPath;
		}else {
			throw new RuntimeException("Report Config Path not specified in the config.properties file for the Key:REPORT_CONFIG_PATH");
		}
	}
	
	public void writeExtentReport() throws IOException {
		Reporter.loadXMLConfig(getReportConfigPath());
		Reporter.setSystemInfo("User Name", USER_NAME);
		Reporter.setSystemInfo("Time Zone", USER_TIMEZONE);
		Reporter.setSystemInfo("Machine", MACHINE);
		Reporter.setSystemInfo("Java Version", JAVA_VERSION);
	}

}
