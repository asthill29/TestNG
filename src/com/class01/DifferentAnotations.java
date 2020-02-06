package com.class01;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DifferentAnotations {
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("After Suite");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Suite");
	}	
	
	@AfterTest
	public void afterTest() {
		System.out.println("After Test");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class");
	}
	
	@AfterClass
	public void AfterClass() {
		System.out.println("After Class");
	}	
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
	}
	
	@Test
	public void test() {
		System.out.println("I am actual test");
	}
	
	
	
}
