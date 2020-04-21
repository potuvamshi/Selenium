package com.selenium.webdriver.practice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AlertPopUp {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.gecko.driver", "D:\\Softwares\\Selenium\\geckodriver.exe");
		FirefoxDriver driver=new FirefoxDriver();
		driver.get("https://www.irctc.co.in/nget/train-search");
		//driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div[2]/form/div[1]/div[2]/div[2]/div[2]/input[2]")).click();
		Thread.sleep(8000);
		Alert al=driver.switchTo().alert();
		System.out.println(al.getText());
		al.accept();
		al.dismiss();
	}

}
