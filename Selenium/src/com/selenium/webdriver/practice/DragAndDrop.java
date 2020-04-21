package com.selenium.webdriver.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","D:\\Softwares\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get("https://jqueryui.com/droppable/");
		Thread.sleep(7000);
		
		driver.switchTo().frame(0);
		Actions ac=new Actions(driver);             
		
		
		WebElement source=driver.findElement(By.xpath("//*[@id=\"draggable\"]/p"));
		WebElement target=driver.findElement(By.id("droppable"));
		ac.dragAndDrop(source, target).build().perform();
		
		ac.clickAndHold(source).moveToElement(target).release().build().perform();
	}

}
