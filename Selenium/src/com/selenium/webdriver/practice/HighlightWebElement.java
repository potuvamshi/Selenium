package com.selenium.webdriver.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HighlightWebElement {
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver","D:/Softwares/Selenium/chromedriver.exe");
		
		driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		WebElement ele1=driver.findElement(By.xpath("//*[@id=\"email\"]"));
		eleHighlight(ele1);
		WebElement ele2=driver.findElement(By.xpath("//*[@id=\"pass\"]"));
		eleHighlight(ele2);
		WebElement ele3=driver.findElement(By.xpath("//*[@id=\"u_0_b\"]"));
		ele3.click();
		eleHighlight(ele3);
	}
	
	public static void eleHighlight(WebElement ele) throws InterruptedException {
	
		JavascriptExecutor js= ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.border='2px solid red'", ele);
		Thread.sleep(1000);
		js.executeScript("arguments[0].style.border='2px'", ele);
	}

}
