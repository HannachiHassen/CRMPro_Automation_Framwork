package com.TestCases;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Base.BaseClass;
import com.Listeners.Listener;
import com.Utils.BrokenImages;
import com.Utils.BrokenLinks;
import com.aventstack.extentreports.Status;

public class FourTest{

	public WebDriver driver;
	public BaseClass baseClass;
	public Properties prop;
	Logger log;

	
	@BeforeMethod
	public void setUP() {
		log = LogManager.getLogger(FourTest.class.getName());
		
		baseClass=new BaseClass();		
		prop = baseClass.initializeProperties();
		driver = baseClass.initializeBrowser();
		
		log.debug("Browser got launched");
		driver.get(prop.getProperty("url"));
		log.debug("Navigated to application URL");
	}
	
	@Test(priority=0, description = "This is a description for testFour")
	public void testFour() throws InterruptedException {
		System.out.println("TestFour");
		log.info("testFour Method is started");
		
		Listener.extentTestThread.get().log(Status.INFO, " Hey I'm in FourTest");
		Listener.extentTestThread.get().log(Status.INFO, "Hellooo started testFour method ");
		Listener.extentTestThread.get().assignAuthor("QA Tester 1").assignCategory("Dummy Test");
		
		driver.get("https://classic.crmpro.com/index.html");
		log.debug("Browser got launched");
		
		Thread.sleep(2000);
		Assert.assertTrue(false);
		log.error("Login Test got failed");
	}
	
	/*@Test(priority=1, description = "Find broken images on a web page")
   	public void verifyBrokenImages(){
    	log.info("verifyBrokenlinks Method is started");
    	
    	BrokenImages.validateInvalidImages();
    	
   		Listener.extentTestThread.get().log(Status.INFO, " Hey I'm in FourTest");
   		Listener.extentTestThread.get().log(Status.INFO, "Hellooo started verifyBrokenImages method ");
   		Listener.extentTestThread.get().assignAuthor("QA Tester 1").assignCategory("Dummy Test");
   	}
	
	@Test(priority=2, description = "Find broken Links on a web page")
   	public void verifyBrokenlinks(){
    	log.info("verifyBrokenlinks Method is started");
    	
    	BrokenLinks.myBrokenLinks();
    	
   		Listener.extentTestThread.get().log(Status.INFO, " Hey I'm in FourTest");
   		Listener.extentTestThread.get().log(Status.INFO, "Hellooo started verifyBrokenlinks method ");
   		Listener.extentTestThread.get().assignAuthor("QA Tester 1").assignCategory("Dummy Test");
   	}*/
	
	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.close();
		}		
	} 
}
