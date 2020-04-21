package com.selenium.webdriver.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {
	
	static WebElement el;
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","D:\\Softwares\\Selenium\\chromedriver.exe");
		
		ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/flights/");
		
		//driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input")).sendKeys("Stocks");
		Thread.sleep(7000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/p/a")).click();
		
		
		// el=driver.findElement(By.className("error-subtitle"));
		
		explicitSendkey(driver);
		
	}
	
	  @SuppressWarnings("deprecation") 
	  public static void explicitSendkey(WebDriver driver) {
	  
	  new WebDriverWait(driver,100).until(ExpectedConditions.visibilityOf(el=driver.
			  findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/div/div/a"))));
	  
	  
	  if(el.isEnabled()) { System.out.println("found: "+el.getText()); } else {
	  System.out.println("not found"); } }
	 
}
