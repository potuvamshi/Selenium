package com.selenium.webdriver.practice;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWaitExample {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver","D:\\Softwares\\Selenium\\chromedriver.exe");
		
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.ndtv.com/");
		
		/*
		 * driver.findElement(By.xpath(
		 * "//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input")).sendKeys("stocks")
		 * ; driver.findElement(By.name("btnK")).click();
		 */
		
		WebElement element1=driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/section/article[3]/ul/li[13]/figure/div/a/picture/img"));
				
		
		
		
		
		  Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		  .withTimeout(Duration.ofSeconds(30)) .pollingEvery(Duration.ofSeconds(30))
		  .ignoring(NoSuchElementException.class);
		  
		  WebElement elem =wait.until(ExpectedConditions.visibilityOf(element1));
		  elem.click();
		 
		 

		
		
	}

}
