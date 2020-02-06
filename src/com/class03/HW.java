package com.class03;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utils.CommonMethods;
import com.utils.Constants;

public class HW extends CommonMethods{
	
	
	
	
	@BeforeMethod(alwaysRun=true)
	public void openAndNavigate() {
		setUp("chrome", "http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.linkText("PIM")).click();
		driver.findElement(By.linkText("Add Employee")).click();
	}

	@Test(dataProvider="loginInfo", groups="regression")
	public void addingEmp(String name, String last, String username, String password) {
		driver.findElement(By.xpath("//*[@id=\"firstName\"]")).sendKeys(name);
        driver.findElement(By.xpath("//*[@id=\"lastName\"]")).sendKeys(last);
        driver.findElement(By.xpath("//input[@name='chkLogin']")).click();
        driver.findElement(By.id("user_name")).sendKeys(username);
        driver.findElement(By.id("user_password")).sendKeys(password);
        driver.findElement(By.id("re_password")).sendKeys(password);
        driver.findElement(By.id("btnSave")).click();
        WebDriverWait wait=new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='profile-pic']/h1")));
        
        //verifying added employee
        boolean empAdded=driver.findElement(By.xpath("//div[@id='profile-pic']/h1")).isDisplayed();
        if (empAdded) {
        	System.out.println("Employee was added");
        }else {
        	System.out.println("Employee was NOT added");
        }
        
        TakesScreenshot ts=(TakesScreenshot)driver;
         File screen=ts.getScreenshotAs(OutputType.FILE);
 		try {
 			FileUtils.copyFile(screen, new File("screenshots/HRMS/AddingEmp.jpg"));
 		} catch (IOException e) {
 			e.printStackTrace();
 		}
        
	}
	
	@DataProvider
	public Object[][] loginInfo() {
		
		Object[][] data= {
				{"Juan","Pablo", "usuario0", "Syntax12@"},
				{"David","Herrera","usuario2", "Syntax12@"},
				{"Peter","James","usuario3", "Syntax12@"},
				{"Isaac","Smith","usuario4", "Syntax12@"},
				{"Ann","Marie","usuario5", "Syntax12@"}
		};
		return data;
	}

	@AfterMethod(alwaysRun=true)
	public void closeBrowser() {
		driver.quit();
	}

}
