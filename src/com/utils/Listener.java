package com.utils;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener extends CommonMethods implements ITestListener {
	
	
	public void onTestStart(ITestResult result) {
		System.out.println("Test started"+result.getName());
	}
	
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test passed"+result.getName());
		CommonMethods.takescreenshot("passed/"+result.getName());
	}
	
	
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed"+result.getName());
		CommonMethods.takescreenshot("failed/"+result.getName());
	}
	

}
