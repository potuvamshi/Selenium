package com.selenium.webdriver.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyPressEvents {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver","D:/Softwares/Selenium/chromedriver.exe");
		
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("http://demo.automationtesting.in/Register.html");
		
		Thread.sleep(2000);
		
		//Form Filling
		
		  driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[1]/input")).sendKeys("Vamshi"+
		  Keys.TAB +"krishna"+Keys.TAB+"Kokkireni Munagala(m), Suryapet(dt)"
		  +Keys.TAB+"krishna@gmail.com"+Keys.TAB +"8142101714"+Keys.SPACE+Keys.TAB
		  +Keys.SPACE+Keys.SPACE+Keys.SPACE);
		 
	
		
		
		
	}

}
