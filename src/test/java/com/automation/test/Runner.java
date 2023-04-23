package com.automation.test;

import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.testng.TestNGCucumberRunner;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {
				"src/test/resources/com/automation/features/Test_OrderMensJacket.feature",
//				"src/test/resources/com/automation/features/New_Test.feature"
				},
		glue= {"com/automation/stepdefs", "com/automation/support", "com/automation/listener", "com/automation/base"},
		plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/test-report/TestReport.html"},
	//	plugin = {"pretty", "json:target/json/report.json", "html:target/cucumber"},
		monochrome = true,
		snippets = SnippetType.UNDERSCORE,
		strict = true,
		dryRun = false
	)


public class Runner extends AbstractTestNGCucumberTests{
	
//	TestNGCucumberRunner testNGCucumberRunner;
//	
//	@DataProvider(name="myFeatures")
//	public Object[][] getFeatures()
//	{
//	    if(testNGCucumberRunner == null){
//	        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
//	    }
//	    return testNGCucumberRunner.provideFeatures();
//	}
		
}
