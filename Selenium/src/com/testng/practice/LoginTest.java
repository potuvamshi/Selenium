package com.testng.practice;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.sikuli.hotkey.Keys;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.gargoylesoftware.htmlunit.javascript.host.Iterator;
import com.thoughtworks.selenium.webdriven.commands.FindSelectedOptionProperties;

import junit.framework.Assert;
import net.sourceforge.htmlunit.corejs.javascript.ast.SwitchCase;

public class LoginTest {
	WebDriver driver;
	WebElement Username;
	WebElement Password;
	WebElement Login;
	String expected;
	String actual="OrangeHRM";
	@BeforeSuite
	public void setProperty() {
		System.setProperty("webdriver.chrome.driver","D:/Softwares/Selenium/chromedriver.exe");
	}
	
	@BeforeTest 
	public void launchBrowser() {
		driver=new ChromeDriver();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@BeforeClass
	public void enterUrl() {
		driver.manage().window().maximize();
		
		
	}
	
	@BeforeMethod
	public void login() {
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		Username=driver.findElement(By.xpath("//*[@id=\"txtUsername\"]"));
		Password=driver.findElement(By.xpath("//*[@id=\"txtPassword\"]"));
		Login=driver.findElement(By.xpath("//*[@id=\"btnLogin\"]"));
		
	}
	@Test(description = "login")
	public void enterValidUserNamePassword1() throws InterruptedException {
		String title=driver.getTitle();
		
		Username.sendKeys("Admin");
		Password.sendKeys("admin123");
		Login.click();
		
		  expected=driver.getTitle(); 
		  Assert.assertEquals(expected, actual);
		  System.out.println("validation successfull");
	}

	  @AfterMethod
	  public void logOut() { 
		driver.findElement(By.xpath("//*[@id=\"welcome\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"welcome-menu\"]/ul/li[2]/a")).click(); }
	  
	  @AfterClass public void closeBrowser() { 
		  driver.close(); 
		  }
	 
}
