package com.testng.practice;

import org.testng.annotations.Test;

public class GoupsInTestNG {
	
	@Test(groups = {"login and Logout"})
	public void login() {
		System.out.println("Logged in");
	}
	
	@Test(groups = {"Verify and Adding"})
	public void verifyHomePage() {
		System.out.println("HomePage Title");
	}
	
	@Test(groups = {"Verify and Adding"})
	public void goTOContacts() {
		System.out.println("Go TO Contacts");
	}
	@Test(groups = {"Verify and Adding"})
	public void addContact() {
		System.out.println("Adding Contact");
	}
	@Test(groups = {"login and Logout"})
	public void logOut() {
		System.out.println("Logged Out");
	}
	
	

}
