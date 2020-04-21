package com.selenium.webdriver.practice;

import java.awt.Desktop.Action;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class SeleniumPractice {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver", "D:\\Softwares\\Selenium\\geckodriver.exe");
		
		FirefoxDriver driver=new FirefoxDriver(); //this is only for firefor browser
		
		//WebDriver driver1=new FirefoxDriver(); //WebDriver is interface we can use it for multiple browsers we can use this one also
        driver.manage().window().maximize();
		
		driver.get("https://www.facebook.com/");
		driver.findElement(By.name("email")).sendKeys("8142101714");
		driver.findElement(By.name("pass")).sendKeys("Vamshi@123");
		driver.findElement(By.id("u_0_b")).click();
		String ExpectedTitle="Facebook";
		String ActualTitle=driver.getTitle();
		System.out.println(ActualTitle);
 
		if(ExpectedTitle.equals(ActualTitle)) {
			
			System.out.println("Validation Pass");
			
		}
		else {
			System.out.println("Validation Fail");
		}
		
		//Actions a=new Actions(driver); 
		
		driver.findElement(By.xpath("//*[@id='userNavigationLabel']")).click();

		
        
	}

}
