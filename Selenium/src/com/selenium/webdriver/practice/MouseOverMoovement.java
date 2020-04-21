package com.selenium.webdriver.practice;

import java.awt.event.ActionEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.beust.jcommander.JCommander.Builder;

public class MouseOverMoovement {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver","D:\\Softwares\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get("https://jntuh.ac.in/");
		Thread.sleep(10000);
		Actions ac=new Actions(driver);
		ac.moveToElement(driver.findElement(By.id("menu-item-9"))).build().perform();
		Thread.sleep(10000);
		driver.findElement(By.linkText("Courses Offered")).click();
		/*
		 * Alert al=driver.switchTo().alert(); System.out.println(al.getText());
		 * al.accept();
		 */
		
	}

}
