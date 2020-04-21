package com.selenium.webdriver.practice;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class FileUploadDownloadAutoITAndSikuli {

	public static void main(String[] args) throws IOException, InterruptedException, FindFailed {
		
		FirefoxProfile profile=new FirefoxProfile();
		
		//What type  of file you are downloading("Set MIME Type(pdf,text,image..etc..)")
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/plain,application/pdf");
		
		//while downloading the file save window will come it will be disabled with below line
		profile.setPreference("browser.download.manager.showWhenStarting", false);
		
		//*****for specifying the Download Location******optional as per requirement use it
		
		//download location
		profile.setPreference("browser.download.dir", "D:\\New folder\\Downloads");
		profile.setPreference("browser.download.folderList", 2);
		
		//while downloading pdf file internally java script will exicute we have to disable it 
		//other wiser pdf will not be donloaded
		profile.setPreference("pdfjs.disabled", true);
		
		FirefoxOptions options=new FirefoxOptions();
		options.setProfile(profile);
		
		
		System.setProperty("webdriver.gecko.driver", "D:\\Softwares\\Selenium\\geckodriver.exe");
		FirefoxDriver driver=new FirefoxDriver(options);
		
		driver.get("https://www.ilovepdf.com/excel_to_pdf");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"pickfiles\"]")).click();
		
		//*******AutoIT file Upload***********
		
		//Runtime.getRuntime().exec("D:/Java programming Eclips/AutoIT/Fileupload.exe");
		
		
		//*******Sikuli file upload***********************
		
		
		
		Screen sc=new Screen();
		String imagesfilePath="D:\\Java programming Eclips\\Sikuli\\Images\\";
		String FilepathUpload="D:\\Java programming Eclips\\Sikuli\\";
		
		//identifying the images for Text Box and Open Button
		Pattern FileiInputTextBox=new Pattern(imagesfilePath+ "Filename.png");
		Pattern OpenButton=new Pattern(imagesfilePath+ "Open.png");
		
		Thread.sleep(2000);
		//witing time for identifying the text box
		sc.wait(FileiInputTextBox,20);
		//Giving file path
		sc.type(FileiInputTextBox,FilepathUpload+"TestScenario Template");
		sc.click(OpenButton);
		//Converting the file(excell to pdf)
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='processTask']")).click();
		// downloading
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"pickfiles\"]")).click();

	}

}
