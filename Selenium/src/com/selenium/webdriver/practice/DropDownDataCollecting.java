package com.selenium.webdriver.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownDataCollecting {

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
		
		String DOB="2-Jul-1992";
		String ArrayMemo[]=DOB.split("-"); //Splitting String By "-"
	
			 dataCollecting(day, ArrayMemo[0]);
			 dataCollecting(month, ArrayMemo[1]);
			 dataCollecting(year, ArrayMemo[2]);
		}
		
		public static void dataCollecting(WebElement elem, String value) {
			
			Select selc=new Select(elem);
			
			List<WebElement> data=selc.getOptions(); //Getting data from dropdown data and storing in list
			
			for(WebElement a:data) {
				
				System.out.println(a.getText());
			
				if(a.getText().equals(value)) {
					  
				selc.selectByVisibleText(a.getText()); 		  
	  }
	}
  }
}
