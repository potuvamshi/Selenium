package com.selenium.webdriver.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigatingWebsiteAndFrwBcwReloButtons {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver","D:\\Softwares\\Selenium\\geckodriver.exe");
		
		FirefoxDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ndtv.com/");
		  Thread.sleep(2000); 
		  driver.navigate().to("https://timesofindia.indiatimes.com/");
		  Thread.sleep(2000); 
		  driver.navigate().back(); 
		  Thread.sleep(2000);
		  driver.navigate().forward(); 
		  Thread.sleep(2000); 
		  driver.navigate().back();
		  Thread.sleep(2000); 
		  driver.navigate().refresh();
		  
		 
	}

}
