package com.selenium.webdriver.practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.chrome.ChromeDriver;

public class WindowPopUps {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\Selenium\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.popuptest.com/popuptest2.html");
		Thread.sleep(5000);
		
		Set<String> windows =driver.getWindowHandles();
		
		  Iterator<String> it =windows.iterator(); 
		  Thread.sleep(5000);
		  
		  String Parentwindow= it.next();
		  System.out.println(Parentwindow);
		  String ChildWindow= it.next();
		  System.out.println(ChildWindow);
		  
		  driver.switchTo().window(ChildWindow); 
		  driver.close(); 
		  System.out.println("ChildWindow is Closed");
		  Thread.sleep(2000); 
		  
		  driver.switchTo().window(Parentwindow); 
		  driver.close(); 
		  System.out.println("ParentWindow is Closed");
		  
		/*
		 * Thread.sleep(5000); for(String win:windows) { System.out.println(win);
		 * driver.switchTo().window(win); driver.close(); Thread.sleep(2000); }
		 */
		 

	}

}
