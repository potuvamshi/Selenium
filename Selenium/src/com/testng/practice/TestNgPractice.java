package com.testng.practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgPractice {
	@BeforeSuite
	public void setSystemProperty(){
		System.out.println("@BeforeSuite browser property's were set");
	}
	
	@BeforeTest
	public void launchBrowser() {
		System.out.println("@BeforeTest browser is launched");
	}
	
	@BeforeClass
	public void login(){ 
		System.out.println("@BeforeClass login is done");
	}
	
	@BeforeMethod
	public void enterUrl(){ 
		System.out.println("@BeforeMethod url is entered");
	}
	
	@Test
	public void verifyTitle(){ 
		System.out.println("@Test Title is verified");
	}
	@AfterMethod
	public void logout(){ 
		System.out.println("@AfterMethod logout successfully");
	}
	@AfterClass
	public void closeBrowser(){ 
		System.out.println("@AfterClass Browser is closed");
	}
	@AfterTest
	public void deleteAllCookies(){ 
		System.out.println("@AfterTest Deleted all cookies");
	}

	}
