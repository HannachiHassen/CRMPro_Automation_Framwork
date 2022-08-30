package com.testCases;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.model.Media;
import com.base.BasePage;
import com.listeners.Listener;
import com.utils.BrokenImages;
import com.utils.BrokenLinks;

public class FourTest{
	
	public WebDriver driver;
	public BasePage baseClass;
	public Properties prop;
    Logger log;
	
	@BeforeMethod(alwaysRun = true)
	@Parameters(value={"browser"})
	public void setUP(String browser) {
		log = LogManager.getLogger(FourTest.class.getName());
		log.info("****************************** Starting test cases execution *****************************************");
		
		String browserName = null;
		
		baseClass=new BasePage();		
		prop = baseClass.initializeProperties();
		
		if (browser == null) {
			prop.setProperty("browser", browser);
		}else {
			browserName = browser;		
		}
		driver = baseClass.initializeBrowser(browserName);
		
		log.info("****************************** Browser is launched *****************************************");
		log.debug("Browser got launched");
		driver.get(prop.getProperty("url"));
		log.debug("Navigated to application URL");
	}
	
	@Test(priority=0, description = "This is a description for testFour")
	public void testFourTest() throws InterruptedException {
		
		log.info("****************************** starting test case testFourTest *****************************************");
		System.out.println("TestFour");		
		
		Listener.extentTestThread.get().log(Status.INFO, " Hey I'm in FourTest");
   		Listener.extentTestThread.get().log(Status.INFO, "Hellooo testFourTest Method Started ");		
		Listener.extentTestThread.get().assignAuthor("QA Tester 1").assignCategory("Dummy Test");		
		
		log.debug("Browser got launched");
		//driver.get("https://classic.crmpro.com/index.html");
		log.debug("Navigated to application URL");
		
		Thread.sleep(2000);
		Assert.assertTrue(false);
		log.warn("Test Failed");
		
		log.info("****************************** ending test case testFourTest *****************************************");
	}
	
	@Test(priority=1, description = "Find broken images on a web page")
   	public void verifyBrokenImages(){
		log.info("****************************** starting test case verifyBrokenlinks *****************************************");
    	    	
    	BrokenImages.validateInvalidImages();
	    	
   		Listener.extentTestThread.get()
   		 .log(Status.INFO, " Hey I'm in FourTest")
   		 .log(Status.INFO, "Hellooo validateInvalidImages Method Started ")
    	 .assignAuthor("QA Tester 1").assignCategory("Dummy Test");
   		
   		log.info("****************************** ending test case verifyBrokenImages *****************************************");
   	}
	
	@Test(priority=2, description = "Find broken Links on a web page")
   	public void verifyBrokenlinks(){
		log.info("****************************** starting test case verifyBrokenlinks *****************************************");
		
    	BrokenLinks.myBrokenLinks();
    	
    	Listener.extentTestThread.get().createNode("INFO")
		 .log(Status.INFO, " Hey I'm in FourTest")
		 .log(Status.INFO, "Hellooo verifyBrokenImages Method Started ");    	
  	
   		Listener.extentTestThread.get().assignAuthor("QA Tester 1").assignCategory("Dummy Test");
   		
   		List<Object> items = Arrays.asList(new Object[] {"Hey I'm in FourTest", "Hellooo started verifyBrokenlinks method"});
		Listener.extentTestThread.get().createNode("INFO").info(MarkupHelper.createOrderedList(items));
   		
   		log.info("****************************** ending test case verifyBrokenlinks *****************************************");
   	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.close();
		if (driver != null) {
			driver.quit();
		}		
	log.info("****************************** Browser is closed *****************************************");
	} 
}
