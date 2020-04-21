package com.selenium.webdriver.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HeadlessBrowser {

	public static void main(String[] args) {
		
		//System.setProperty("webdriver.chrome.driver", "D:/Softwares/Selenium/chromedriver.exe");
	
		//ChromeDriver driver=new ChromeDriver();
		WebDriver driver=new HtmlUnitDriver();
		
		driver.get("https://www.google.co.in/");
		
		String BeforeSearch=driver.getTitle();
		
		System.out.println("Before search Title:"+BeforeSearch);
		
		driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input")).sendKeys("stock"+Keys.ENTER);
		
		String AfterSearch=driver.getTitle();
		System.out.println("After search Title:"+AfterSearch);
		
		
		driver.close();

	}

}
