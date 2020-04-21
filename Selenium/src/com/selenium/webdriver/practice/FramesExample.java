package com.selenium.webdriver.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FramesExample {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.gecko.driver","D:\\Softwares\\Selenium\\geckodriver.exe");
		
		FirefoxDriver driver=new FirefoxDriver();
		driver.get("https://easyhtmlcode.com/frames.html");
		driver.switchTo().frame("main");
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div/div[2]/ul/li[3]/a")).click();
		
	}

}
