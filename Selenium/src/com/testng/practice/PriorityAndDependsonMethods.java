package com.testng.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class PriorityAndDependsonMethods {
	WebDriver driver;
	WebElement Username;
	WebElement Password;
	WebElement Login;
	String expected;
	String actual="OrangeHRM";
	
	@BeforeSuite
	public void setProperty(){
	System.setProperty("webdriver.chrome.driver","D:/Softwares/Selenium/chromedriver.exe");
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
	public void login() {
		Username.sendKeys("Admin");
		Password.sendKeys("admin123/-");
		Login.click();
		
		 expected=driver.getTitle(); 
		  Assert.assertEquals(expected, actual);
		  System.out.println("Login validation successfull");

	}
	@Test(priority =2, dependsOnMethods ="login")
	public void addingEmployee() {
		Actions ac=new Actions(driver);
		ac.moveToElement(driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[2]/a/b")));
		driver.findElement(By.xpath("//*[@id=\"menu_pim_addEmployee\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"firstName\"]")).sendKeys("vamshi");
		driver.findElement(By.xpath("//*[@id=\"middleName\"]")).sendKeys("krishna");
		driver.findElement(By.xpath("//*[@id=\"lastName\"]")).sendKeys("potu");
		driver.findElement(By.xpath("//*[@id=\"photofile\"]")).sendKeys("D:\\download.jpg");
		driver.findElement(By.xpath("//*[@id=\"btnSave\"]")).click();

	}
	
	@AfterSuite
	 public void closeBrowser() { 
		  driver.close(); 
		  }
}
