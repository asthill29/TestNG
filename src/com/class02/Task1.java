package com.class02;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.utils.CommonMethods;
import com.utils.Constants;

public class Task1 extends CommonMethods{
	

	@BeforeMethod
	public void open() {
		setUp("chrome", Constants.HRMS_URL);
	}
	
	
	@Test
	public void login() throws InterruptedException {
		
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.name("Submit")).click();
		driver.findElement(By.linkText("PIM")).click();
		driver.findElement(By.linkText("Add Employee")).click();
		String expectedName="Full Name";
		String expEmp="Emploee Id";
		String expPhoto="Photograph";
		boolean actualName=driver.findElement(By.xpath("//label[@class='hasTopFieldHelp']")).isDisplayed();
		boolean actualEmp=driver.findElement(By.xpath("//label[@for='employeeId']")).isDisplayed();
		boolean actualPhoto=driver.findElement(By.xpath("//label[@for='photofile']")).isDisplayed();
		SoftAssert st=new SoftAssert();
		st.assertEquals(actualName, expectedName, "Name is not displayed");
		st.assertEquals(actualEmp, expEmp, "Employee id is not displaye");
		st.assertEquals(actualPhoto, expPhoto, "Photo is not displaye");
		
		//addind employee
		driver.findElement(By.xpath("//*[@id=\"firstName\"]")).sendKeys("John");
        driver.findElement(By.xpath("//*[@id=\"lastName\"]")).sendKeys("David");
        
        
        //adding foto
        driver.findElement(By.id("photofile")).sendKeys("/Users/sthilldelaespada/Downloads/perro.jpg");  
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"btnSave\"]")).click();
        
        //verifying added employee
        boolean empAdded=driver.findElement(By.xpath("//div[@id='profile-pic']/h1")).isDisplayed();
        if (empAdded) {
        	System.out.println("Employee was added");
        }else {
        	System.out.println("Employee was NOT added");
        }    
	
	}
	
	@AfterMethod
	public void closed() {
		driver.quit();
	}

	
	
}
