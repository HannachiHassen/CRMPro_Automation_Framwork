package com.TestCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Base.BaseClass;
import com.Listeners.Listener;
import com.PageObject.LandingPage;
import com.PageObject.LoginPage;
import com.Utils.TestUtils;
import com.aventstack.extentreports.Status;

public class LandingPageTest extends BaseClass {
	public WebDriver driver;
	Logger log;
	
    public LandingPage landingPage;
    public LoginPage loginPage;
    public TestUtils testUtils;
    
  //Initializing PageFactory
  	public LandingPageTest() {
  		super();   //Call the Constructor of the Super class - BaseClass
  	}
    
    @BeforeMethod	
    public void setUp(){
    	log = LogManager.getLogger(LandingPageTest.class.getName());
    	
        driver=initializeBrowser();
        log.debug("Browser got launched");
    	driver.get(prop.getProperty("url"));
    	log.debug("Navigated to application URL");
    	
    	landingPage=new LandingPage();
        //testUtils=new TestUtils();
        //loginPage = new LoginPage();
        //landingPage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }

    @Test(priority=0, description = "Verify Home Page Title")
	public void verifyTitle() {
    	String title=landingPage.validateHomePageTitle();
    	Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.", "Home Page Title does not Matche");
    	
    	log.info("verifyTitle Method is started");
		
		Listener.extentTestThread.get().log(Status.INFO, " Hey I'm in LandingPageTest");
		Listener.extentTestThread.get().log(Status.INFO, "Hellooo started verifyTitle method ");
		Listener.extentTestThread.get().assignAuthor("QA Tester 1").assignCategory("LandingPage Test").assignDevice("Windows HP");
    
    	System.out.println("Landing Page Title :"+ title);	
	}
	
    @Test(priority=1, description = "Verify CRM Logo Image is Present in Home Page")
	public void verifyCRMLogo() {
		Boolean b = landingPage.validateCRMImage();
		Assert.assertTrue(b);
		
		Listener.extentTestThread.get().log(Status.INFO, " Hey I'm in LandingPageTest");
		Listener.extentTestThread.get().log(Status.INFO, "Hellooo started verifyCRMLogo method ");
		Listener.extentTestThread.get().assignAuthor("QA Tester 1").assignCategory("LandingPage Test");
	}
    
    @Test(priority=2, description = "Verify User name box is displayed")
	public void verifyUserName(){
		//testUtil.switchToFrame();
		Assert.assertTrue(landingPage.verifyUserName().);
		
		Listener.extentTestThread.get().log(Status.INFO, " Hey I'm in LandingPageTest");
		Listener.extentTestThread.get().log(Status.INFO, "Hellooo started verifyUserName method ");
		Listener.extentTestThread.get().assignAuthor("QA Tester 1").assignCategory("LandingPage Test");
	}
    
    @Test(priority=3, description = "Verify User password box is displayed")
   	public void verifyUserPassword(){
   		//testUtil.switchToFrame();
   		Assert.assertTrue(landingPage.verifyUserPassword());
   		
   		Listener.extentTestThread.get().log(Status.INFO, " Hey I'm in LandingPageTest");
   		Listener.extentTestThread.get().log(Status.INFO, "Hellooo started verifyUserPassword method ");
   		Listener.extentTestThread.get().assignAuthor("QA Tester 1").assignCategory("LandingPage Test");
   	}
    
    @Test(priority=4, description = "Verify Login Button is displayed")
   	public void verifyLoginBtn(){
   		//testUtil.switchToFrame();
   		loginPage=landingPage.verifyLoginBtn();
   		
   		Listener.extentTestThread.get().log(Status.INFO, " Hey I'm in LandingPageTest");
   		Listener.extentTestThread.get().log(Status.INFO, "Hellooo started verifyLoginBtn method ");
   		Listener.extentTestThread.get().assignAuthor("QA Tester 1").assignCategory("LandingPage Test");
   	}
    
    @Test(priority=4, description = "Verify Login Button is displayed")
   	public void verifyMouseLink(){
   		//testUtil.switchToFrame();
   		Assert.assertTrue(landingPage.clickMouseLink());   		
   		
   		Listener.extentTestThread.get().log(Status.INFO, " Hey I'm in LandingPageTest");
   		Listener.extentTestThread.get().log(Status.INFO, "Hellooo started verifyLoginBtn method ");
   		Listener.extentTestThread.get().assignAuthor("QA Tester 1").assignCategory("LandingPage Test");
   	}
        
    @AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.close();;
		}		
	}
}
