package com.selenium.webdriver.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\Selenium\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
		
		driver.findElement(By.name("firstname")).sendKeys("VamshiKrishna");
		driver.findElement(By.name("lastname")).sendKeys("Potu");
		driver.findElement(By.name("reg_email__")).sendKeys("vamshikrishna453@gmail.com");
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys("vamshikrishna453@gmail.com");
		driver.findElement(By.name("reg_passwd__")).sendKeys("Vamshi@1234");
		
		
		WebElement day=driver.findElement(By.xpath("//*[@id=\"day\"]"));
		WebElement month=driver.findElement(By.xpath("//*[@id=\"month\"]"));
		WebElement year=driver.findElement(By.xpath("//*[@id=\"year\"]"));
		
		Select sel=new Select(day);
		Select sel1=new Select(month);
		Select sel2=new Select(year);
		
		sel.selectByVisibleText("2");
		sel1.selectByIndex(7);
		sel2.selectByValue("1992");
		
		driver.findElement(By.xpath("//*[@id=\"u_0_7\"]")).click();
		
		driver.findElement(By.name("websubmit")).click();
		
		driver.close();
		
		
	}

}
