package com.testng.practice;

import static org.testng.Assert.assertEquals;
import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class TimeoutAndRetryAnalyzer implements IRetryAnalyzer {
	int retryLimit =4;
	int count=0;
	//below method will be failed if exceed the timeout 3000msc
	@Test(timeOut = 3000)
	public void pageLoading() throws InterruptedException {
		Thread.sleep(5000);
	}
	@Override
	public boolean retry(ITestResult result) {
		
		if (count<retryLimit) {
			count++;
			return true;
		}
		return false;
	}
	//if below test is filed it will be tried for four times 
	//see above method it will retry bellow method for four times
	@Test(retryAnalyzer = TimeoutAndRetryAnalyzer.class)
	public void loading() {
		Assert.assertEquals(true, false);
	}
	
}
