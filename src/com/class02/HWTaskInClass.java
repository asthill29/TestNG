package com.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utils.CommonMethods;
import com.utils.Constants;

public class HWTaskInClass extends CommonMethods{

	
	@BeforeMethod
	public void open() {
		setUp("chrome", Constants.HRMS_URL);
	}

	@AfterMethod
	public void close() {
		driver.close();
	}
	
		@Test(priority=1)
		public void validationOfMessage() {
			driver.findElement(By.id("txtUsername")).sendKeys("Admin");
			driver.findElement(By.id("btnLogin")).click();
			boolean error = driver.findElement(By.id("spanMessage")).isDisplayed();
			String expectedError="Password cannot be empty";
			String actualError=driver.findElement(By.id("spanMessage")).getText();
			Assert.assertTrue(error, "Error is display");
			Assert.assertEquals(actualError, expectedError, "Messages match");
			
		}

	

}
