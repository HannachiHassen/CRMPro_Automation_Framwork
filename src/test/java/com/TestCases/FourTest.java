package com.TestCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Base.BaseClass;

public class FourTest extends BaseClass{
public WebDriver driver;
Logger log;
	
	@BeforeMethod
	public void setUP() {
		log = LogManager.getLogger(FourTest.class.getName());
		
		driver = initializeBrowser();
		log.debug("Browser got launched");
		driver.get(prop.getProperty("url"));
		log.debug("Navigated to application URL");
	}
	
	@Test
	public void testFour() throws InterruptedException {
		System.out.println("TestFour");
		log.info("testFour Method is started");
	
		driver.get("https://classic.crmpro.com/index.html");
		log.debug("Browser got launched");
		
		Thread.sleep(2000);
		Assert.assertTrue(false);
		log.error("Login Test got failed");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		if (driver != null) {
			driver.quit();
		}		
	} 
}
