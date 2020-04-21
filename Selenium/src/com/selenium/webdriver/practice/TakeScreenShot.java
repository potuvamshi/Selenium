package com.selenium.webdriver.practice;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class TakeScreenShot {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\Selenium\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		
		Thread.sleep(3000);
		
		WebElement ele=driver.findElement(By.className("large_form"));
		
		// whole page screen shot
		File src=driver.getScreenshotAs(OutputType.FILE); 
		FileHandler.copy(src, new File("D:/Java programming Eclips/Selenium/src/Screenshots/Page.png"));
		 
		// single element screenshot
		File src1=ele.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src1, new File("D:/Java programming Eclips/Selenium/src/Screenshots/Elem.png"));
		
	}

}
