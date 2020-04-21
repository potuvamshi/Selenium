package com.selenium.webdriver.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver","D:/Softwares/Selenium/chromedriver.exe");
		
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("http://demo.automationtesting.in/WebTable.html");
		
		Thread.sleep(2000);

		
		for(int i=1; i<=10; i++) {
			
			Thread.sleep(1000);

			String el=driver.findElement(By.xpath("/html/body/section/div[1]/div/div[3]/div[1]/div[1]/div[2]/div/div["+i+"]/div/div[2]/div")).getText();
			
			System.out.println(el);
			
			if (el.equals("Mudassir")) {
				
			driver.findElement(By.xpath("/html/body/section/div[1]/div/div[3]/div[1]/div[1]/div[2]/div/div["+i+"]/div/div[6]/user-click-select/div[1]/del-click/button")).click();
			break;
			}
			}
		Thread.sleep(5000);
		driver.quit();
	}
	}


