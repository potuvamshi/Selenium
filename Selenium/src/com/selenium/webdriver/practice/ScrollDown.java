package com.selenium.webdriver.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollDown {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","D:/Softwares/Selenium/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("https://jntuh.ac.in/");
		Thread.sleep(5000);
		
		JavascriptExecutor js=((JavascriptExecutor)driver);
		//scroldown using pixel
		//js.executeScript("window.scrollBy(0,1000)", "");
		
		//scroldown using element
		WebElement el=driver.findElement(By.xpath("//*[@id=\"home\"]/section[2]/div/div/div[1]/div/div[1]/div"));
		
		//js.executeScript("arguments[0].scrollIntoView();", el);
		
		//scroldown to bottom
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

	}

}
