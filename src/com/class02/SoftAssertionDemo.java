package com.class02;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.utils.CommonMethods;
import com.utils.Constants;

public class SoftAssertionDemo extends CommonMethods {
	
	
	
	@BeforeMethod
	public void open() {
		setUp("chrome", Constants.HRMS_URL);
	}
	
	
	@Test
	public void logoAndLogin() {
	boolean logo=driver.findElement(By.xpath("//div[@id=]divLogo']/img")).isDisplayed();
	
	//making the logo falsed 
	logo=false;
	//Hard Assert will fail and execution will stop at that point
	//Assert.assertTrue(logo, "Logo is NOT display");
	
	SoftAssert softAssert=new SoftAssert();
	softAssert.assertTrue(logo, "Logo is NOT displa");
	
	driver.findElement(By.name("txtUsername")).sendKeys("Admin");
	driver.findElement(By.name("txtPasword")).sendKeys("Hum@nhrm123");
	driver.findElement(By.name("Submit")).click();
	boolean welcome=driver.findElement(By.id("welcome")).isDisplayed();
	//Assert.assertTrue(welcome);
	
	softAssert.assertTrue(welcome, "Welcome element is NOT displayed");
	softAssert.assertAll();
	
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
