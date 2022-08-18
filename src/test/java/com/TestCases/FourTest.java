package com.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Base.BaseClass;

public class FourTest extends BaseClass{
	public WebDriver driver;
	
	@BeforeMethod
	public void setUP() {
		driver = initializeBrowser();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void testFour() throws InterruptedException {
		System.out.println("TestFour");
		Thread.sleep(3000);
		Assert.assertTrue(false);
	}
	
	@AfterMethod
	public void closebrowser() {
		driver.close();
	}
}
