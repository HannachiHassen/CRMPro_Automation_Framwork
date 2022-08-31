package com.testCases;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.driver.Driver;

public class BaseTest {

	protected BaseTest() {
	
	}
	
	@BeforeMethod
	protected void setUp() throws Exception {		
		Driver.initDriver();
	}
	
	@AfterMethod
	protected void tearDown(ITestResult result) {		
		Driver.quitDriver();
	}
}
