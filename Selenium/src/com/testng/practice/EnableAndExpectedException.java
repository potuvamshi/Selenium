package com.testng.practice;

import org.testng.annotations.Test;

public class EnableAndExpectedException {
	
	// the below method will not execute bcz enabled = false
	@Test(enabled = false)
	public void loginGmail() {
		System.out.println("Gmail login Is Enabled");
		
	}
	
	//The below method will be passed even if there is exception
	@Test(expectedExceptions = ArithmeticException.class)
	public void division() {
		int a=5/0;
	}
}
