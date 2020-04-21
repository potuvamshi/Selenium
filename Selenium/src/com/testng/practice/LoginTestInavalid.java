package com.testng.practice;

import java.util.concurrent.TimeUnit;

import org.junit.runners.Suite.SuiteClasses;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class LoginTestInavalid {
	WebDriver driver;
	WebElement Username;
	WebElement Password;
	WebElement Login;
	String expected;
	String actual="Invalid credentials";
	
	@BeforeSuite
	public void setProperty(){
	System.setProperty("webdriver.chrome.driver","D:/Softwares/Selenium/chromedriver.exe");
	
	
	}
	@BeforeMethod
	public void elimentsData() {
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		Username=driver.findElement(By.xpath("//*[@id=\"txtUsername\"]"));
		Password=driver.findElement(By.xpath("//*[@id=\"txtPassword\"]"));
		Login=driver.findElement(By.xpath("//*[@id=\"btnLogin\"]"));
	}
	@Test(priority = 1)
	public void invalidData1() {
		Username.sendKeys("admin@3453");
		Password.sendKeys("admin123");
		Login.click();
		
		  expected=driver.findElement(By.xpath("//*[@id=\"spanMessage\"]")).getText();
		  Assert.assertEquals(expected, actual);
		  System.out.println("validation successfull with invalidData1");
	}
	@Test(priority = 2)
	public void invalidData2() throws InterruptedException {
		Username.sendKeys("Admin");
		Password.sendKeys("Vamshi@2424");
		Login.click();
		
		  expected=driver.findElement(By.xpath("//*[@id=\"spanMessage\"]")).getText();
		  Assert.assertEquals(expected, actual);
		  System.out.println("validation successfull with invalidData2");
	}
	@Test(priority = 3)
	public void invalidData3() throws InterruptedException {
		Username.sendKeys("Vamshi");
		Password.sendKeys("Krishna");
		Login.click();
		
		  expected=driver.findElement(By.xpath("//*[@id=\"spanMessage\"]")).getText();
		  Assert.assertEquals(expected, actual);
		  System.out.println("validation successfull with invalidData3");
	}
	@Test(priority = 4)
	public void invalidData4() throws InterruptedException {
		Username.sendKeys("13231@vamshi");
		Password.sendKeys("Ram@123");
		Login.click();
		
		  expected=driver.findElement(By.xpath("//*[@id=\"spanMessage\"]")).getText();
		  Assert.assertEquals(expected, actual);
		  System.out.println("validation successfull with invalidData4");
	}
	@Test(priority = 5)
	public void invalidData5() throws InterruptedException {
		Username.sendKeys("admin");
		Password.sendKeys("admin123");
		Login.click();
		
		  expected=driver.findElement(By.xpath("//*[@id=\"spanMessage\"]")).getText();
		  Assert.assertEquals(expected, actual);
		  System.out.println("validation successfull with invalidData5");
	}
	
	  @AfterMethod
	  public void closeBrowser() { 
		  driver.close(); 
		  }
	 

}
