package com.selenium.webdriver.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ObjectRepositry {

	private static WebDriver driver;

	public static void main(String[] args) throws IOException {

		Properties prop=new Properties();
		FileInputStream fi=new FileInputStream("D:\\Java programming Eclips\\Selenium\\src\\com\\selenium\\webdriver\\practice\\data.properties");
		prop.load(fi);
		
		String Browser=prop.getProperty("Browser");
		
		if(Browser.equals("Chrome")){
		System.setProperty(prop.getProperty("Driver1"),prop.getProperty("Path1"));
		driver=new ChromeDriver();
		}
		else if(Browser.equals("Firefox")){
		System.setProperty(prop.getProperty("Driver2"),prop.getProperty("Path2"));
		driver=new FirefoxDriver();
		}
		
		driver.get(prop.getProperty("url"));
		driver.findElement(By.xpath(prop.getProperty("UserName"))).sendKeys(prop.getProperty("Id"));
		driver.findElement(By.xpath(prop.getProperty("Password"))).sendKeys(prop.getProperty("Pass"));
		driver.findElement(By.xpath(prop.getProperty("Login"))).click();


	}

}
