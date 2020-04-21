package com.selenium.webdriver.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ReadAndWriteDataToExcel {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\Selenium\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india/fixed-deposit-calculator-SBI-BSB001.html?classic=true");
		Thread.sleep(5000);
		
		FileInputStream fi=new FileInputStream("D:\\Java programming Eclips\\Interest caliculator1.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fi);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		int row = sheet.getLastRowNum();
		System.out.println("Number of ROWS="+row);
		int cell=sheet.getRow(1).getLastCellNum();
		System.out.println("Number of CELLS="+cell);
		
		for(int i=1; i<=row;i++) {
			
			XSSFRow CurentRow=sheet.getRow(i);
			int Principal=(int)CurentRow.getCell(0).getNumericCellValue();
			System.out.print(Principal+"  ");
			int RateOfInterest =(int)CurentRow.getCell(1).getNumericCellValue();
			System.out.print(RateOfInterest+"  ");
			int Period=(int)CurentRow.getCell(2).getNumericCellValue();
			System.out.print(Period+"  ");
			String Frequency=CurentRow.getCell(3).getStringCellValue();
			System.out.print(Frequency+"  ");
			System.out.println();
			
			Thread.sleep(5000);
			
			driver.findElement(By.xpath("//*[@id=\"principal\"]")).sendKeys(String.valueOf(Principal));
			driver.findElement(By.xpath("//*[@id=\"interest\"]")).sendKeys(String.valueOf(RateOfInterest));
			driver.findElement(By.xpath("//*[@id=\"tenure\"]")).sendKeys(String.valueOf(Period));
			
			Select se=new Select(driver.findElement(By.id("tenurePeriod")));
			se.selectByIndex(2);
			Select se1=new Select(driver.findElement(By.id("frequency")));
			se1.selectByIndex(0);
			
			driver.findElement(By.xpath("//*[@id=\"fdMatVal\"]/div[2]/a[1]")).click();
			Thread.sleep(2000);
			
			String Maturity=driver.findElement(By.xpath("//*[@id=\"resp_matval\"]")).getText();
			
			XSSFCell MaturityValue =CurentRow.getCell(4);
			MaturityValue.setCellValue(Maturity);
			
			FileOutputStream fo=new FileOutputStream("D:\\Java programming Eclips\\Interest caliculator.xlsx");
			
			workbook.write(fo);
			fo.close();
			
			driver.findElement(By.xpath("//*[@id=\"fdMatVal\"]/div[2]/a[2]")).click();
			
			driver.close();
		}
		
	}
			
}
	


