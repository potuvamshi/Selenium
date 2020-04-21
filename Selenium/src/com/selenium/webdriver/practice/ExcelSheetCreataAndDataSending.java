package com.selenium.webdriver.practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFTableStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExcelSheetCreataAndDataSending {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		System.setProperty("webdriver.chrome.driver","D:/Softwares/Selenium/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("http://demo.automationtesting.in/WebTable.html");
		
		Thread.sleep(2000);
		FileOutputStream fo=new FileOutputStream("D:\\Create1.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet Sheet=workbook.createSheet("Vamshi");
		
		for(int i=1; i<=10; i++) {
			XSSFRow row=Sheet.createRow(i);
			for(int j=1; j<=5;j++){
			XSSFCell cell=row.createCell(j);
			String el=driver.findElement(By.xpath("/html/body/section/div[1]/div/div[3]/div[1]/div[1]/div[2]/div/div["+i+"]/div/div["+j+"]/div")).getText();
			System.out.print(el+"    ");
			
			cell.setCellValue(el);
			
			}
			System.out.println();
	}
		workbook.write(fo);
		fo.close();
		driver.close();
	}
}
