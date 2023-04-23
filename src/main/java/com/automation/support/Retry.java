package com.automation.support;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{
	
	private int retryCount=0;
	public static int max_retry_count = 0;

	@Override
	public boolean retry(ITestResult itestresult) {
		try {
			max_retry_count = Integer.parseInt(ReadProperties.getProperties("MAX_RETRY_COUNT"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(!itestresult.isSuccess()) {
			if(retryCount<max_retry_count) {
				retryCount++;
				itestresult.setStatus(ITestResult.FAILURE);
				return true;
			}else {
				itestresult.setStatus(ITestResult.FAILURE);
			}
		}else {
			itestresult.setStatus(ITestResult.SUCCESS);
		}
		return false;
	}

}
