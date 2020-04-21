package com.selenium.webdriver.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindingElements {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","D:\\Softwares\\Selenium\\chromedriver.exe");
		
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.amazon.in/");
		
		List<WebElement> data=driver.findElementsByTagName("a"); //Finding the Links in page
		
		System.out.println(data.size());
		
		for(WebElement a:data) {
			System.out.println(a.getText());
		}
		

	}

}
