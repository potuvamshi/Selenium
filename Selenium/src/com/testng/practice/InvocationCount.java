package com.testng.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InvocationCount {
	WebDriver driver;
	@BeforeMethod
	public void setProperty() {
		System.setProperty("webdriver.chrome.driver","D:/Softwares/Selenium/chromedriver.exe");
		driver=new ChromeDriver();
		
	}
	//invocationCount is for running the method for multiple times
	//invocationTimeOut is the total time for all the invocationCount(2sec's time for 2testcases)
	//threadPoolSize is used to decrease invocationCountTime.
	@Test(invocationCount = 2,threadPoolSize = 2,invocationTimeOut =20000 )
	public void ndTv() {
		driver.get("https://www.ndtv.com/");
	}
	
	@Test(invocationCount = 2)
	public void timesOfIndia() {
		driver.get("https://timesofindia.indiatimes.com/");
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.close();
	}
	

}
