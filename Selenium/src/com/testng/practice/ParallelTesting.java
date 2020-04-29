package com.testng.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ParallelTesting {
WebDriver driver;
	@BeforeMethod 
	public void setup() {
		System.setProperty("webdriver.chrome.driver","D:/Softwares/Selenium/chromedriver.exe");
		driver=new ChromeDriver();
	}
	@Test
	public void google() {
		driver.get("https://google.co.in"); 
	}
	@Test
	public void facebook() {
		driver.get("https://facebook.com");
	}
	
	@AfterMethod
	
	public void teardown() {
		driver.close();
	}
}
