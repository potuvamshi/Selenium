package com.selenium.webdriver.practice;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.xmlgraphics.image.writer.imageio.ImageIOImageWriter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class ImageCompare {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		

		System.setProperty("webdriver.chrome.driver","D:/Softwares/Selenium/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("https://jntuh.ac.in/");
		Thread.sleep(5000);
		WebElement logo=driver.findElement(By.xpath("/html/body/header/div[3]/div/div[1]/a/img"));
		Screenshot logoScreenshot=new AShot().takeScreenshot(driver,logo);
		//below comand is used to save the captured image
		ImageIO.write(logoScreenshot.getImage(), "png", new File("D:\\New folder\\screenshot1.png"));
		
		//it is used for comparing the image
		BufferedImage ActualImage=logoScreenshot.getImage();
		
		File f=new File("D:\\New folder\\screenshot.png");
		if(f.exists()) {
			System.out.println("screenshot captured");
		}
		else {
			System.out.println("screenshot not captured");			
		}
		//below camand is used to take expected image from our system
		BufferedImage ExpectedImage=ImageIO.read(new File("D:\\New folder\\screenshot.png"));
		
		ImageDiffer imgdiff=new ImageDiffer();
		//image comparision
		ImageDiff diff=imgdiff.makeDiff(ExpectedImage, ActualImage);
		
		if(diff.hasDiff()==true) {
			System.out.println("images are not same");
		}
		else {
			System.out.println("images are same");
		}
	}

}
