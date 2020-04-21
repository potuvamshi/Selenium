package com.selenium.webdriver.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DateSelection {
	
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\Selenium\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.goibibo.com/");
		
		WebElement el=driver.findElement(By.xpath("//*[@id=\"departureCalendar\"]"));
		
		String Date="Mon, 30 Mar";
		
		datePicker(driver, el, Date);
		
		/*
		 * driver.findElement(By.xpath(
		 * "//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/label")).click();
		 * driver.findElement(By.xpath(
		 * "//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[1]/span[2]"
		 * )).click(); List<WebElement> elem =driver.findElements(By.xpath(
		 * "//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div[3]"
		 * )); String day="30";
		 * 
		 * for(WebElement days:elem) { System.out.println("Days is "+days.getText());
		 * String dy=days.getText(); String Arr[]=dy.split("\n"); if(Arr[0].equals(day))
		 * {
		 * 
		 * days.click(); } }
		 */
	}		
	
	public static void datePicker(WebDriver driver, WebElement el, String Date) {
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','"+Date+"');", el);
		
		
	}
}
