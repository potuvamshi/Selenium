package com.selenium.webdriver.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DateSelection2 {

	private static boolean flag=false;

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		driver.get("https://www.cleartrip.com/");
		driver.findElement(By.id("FromTag")).sendKeys("Hyderabad");
		driver.findElement(By.id("ToTag")).sendKeys("Chennai");
		driver.findElement(By.xpath("//*[@id=\"DepartDate\"]")).click();
		
		String date="30-March-2020";
		String DateArray[]=date.split("-");
		
		while(true) {
			String year=driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/div/div/span[2]")).getText();
			if(year.equals(DateArray[2])) {
				break;
			}
			driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[2]/div/a")).click();
		}
		
		while(true) {
			String month=driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/div/div/span[1]")).getText();
			if(month.equals(DateArray[1])) {
				break;
			}
			driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[2]/div/a")).click();
		}
		
			  for(int i=1; i<=7;i++) {
			  
			  for(int j=1; j<=7; j++) {			  
			  String day=driver.findElement(By.xpath("/html/body/div[2]/div[1]/table/tbody/tr["+i+"]/td["+j+"]")).getText();
			  System.out.println("day is "+day);
			  
			  if (day.equals(DateArray[0])) {
			  driver.findElement(By.xpath("/html/body/div[2]/div[1]/table/tbody/tr["+i+"]/td["+j+"]")).click(); 
			  
			  flag=true;
			  break; 
			  }
			  }
			  if (flag) {
				  break;
			  }
			  }
			  driver.findElement(By.id("SearchBtn")).click();
		 
	}
	}
