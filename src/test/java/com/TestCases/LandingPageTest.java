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
import com.PageObject.LandingPage;
import com.PageObject.LoginPage;
import com.Utils.BrokenImages;
import com.Utils.BrokenLinks;
import com.Utils.ElementUtils;
import com.aventstack.extentreports.Status;

public class LandingPageTest extends BaseClass {
	public WebDriver driver;
	Logger log;
	public Properties prop;
	public BaseClass baseClass;
	
    public LandingPage landingPage;
    public LoginPage loginPage;
    public ElementUtils elementUtils;
    
  //Initializing PageFactory
  	public LandingPageTest() {
  		super();   //Call the Constructor of the Super class - BaseClass
  	}
    
    @BeforeMethod	//this method will be executed before every @test method
    public void setUp(){
    	log = LogManager.getLogger(LandingPageTest.class.getName());
    	
    	baseClass=new BaseClass();	
    	prop = baseClass.initializeProperties();
		driver = baseClass.initializeBrowser();
		
        log.debug("Browser got launched");
    	driver.get(prop.getProperty("url"));
    	log.debug("Navigated to application URL");
    	
    	landingPage=new LandingPage();        
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
    	
    	log.info("verifyCRMLogo Method is started");
    	
		Boolean b = landingPage.validateCRMImage();
		Assert.assertTrue(b);
		
		Listener.extentTestThread.get().log(Status.INFO, " Hey I'm in LandingPageTest");
		Listener.extentTestThread.get().log(Status.INFO, "Hellooo started verifyCRMLogo method ");
		Listener.extentTestThread.get().assignAuthor("QA Tester 1").assignCategory("LandingPage Test");
	}
    
    @Test(priority=2, description = "Verify User name box is displayed")
	public void verifyUserName(){
    	log.info("verifyUserName Method is started");
    	
		//testUtil.switchToFrame();
		Assert.assertTrue(landingPage.verifyUserName().isDisplayed());
		Assert.assertTrue(landingPage.verifyUserName().isEnabled());
				
		Listener.extentTestThread.get().log(Status.INFO, " Hey I'm in LandingPageTest");
		Listener.extentTestThread.get().log(Status.INFO, "Hellooo started verifyUserName method ");
		Listener.extentTestThread.get().assignAuthor("QA Tester 1").assignCategory("LandingPage Test");
	}
    
    @Test(priority=3, description = "Verify User password box is displayed")
   	public void verifyUserPassword(){
    	log.info("verifyUserPassword Method is started");
    	
   		//testUtil.switchToFrame();
   		Assert.assertTrue(landingPage.verifyUserPassword().isDisplayed());
   		Assert.assertTrue(landingPage.verifyUserPassword().isEnabled());
   		
   		Listener.extentTestThread.get().log(Status.INFO, " Hey I'm in LandingPageTest");
   		Listener.extentTestThread.get().log(Status.INFO, "Hellooo started verifyUserPassword method ");
   		Listener.extentTestThread.get().assignAuthor("QA Tester 1").assignCategory("LandingPage Test");
   	}
    
    @Test(priority=4, description = "Verify Login Button is displayed")
   	public void verifyLoginBtn(){
    	log.info("verifyLoginBtn Method is started");
    	
   		//testUtil.switchToFrame();
    	Assert.assertTrue(landingPage.verifyLoginBtn().isDisplayed());   		
    	Assert.assertTrue(landingPage.verifyLoginBtn().isEnabled());
    	
   		Listener.extentTestThread.get().log(Status.INFO, " Hey I'm in LandingPageTest");
   		Listener.extentTestThread.get().log(Status.INFO, "Hellooo started verifyLoginBtn method ");
   		Listener.extentTestThread.get().assignAuthor("QA Tester 1").assignCategory("LandingPage Test");
   	}
    
    @Test(priority=5, description = "Verify Mouse Link is displayed")
   	public void verifyMouseLink(){
    	log.info("verifyMouseLink Method is started");
    	
   		Assert.assertTrue(landingPage.verifyclickMouseLink().isDisplayed());
   		Assert.assertTrue(landingPage.verifyclickMouseLink().isEnabled());   		
   		
   		Listener.extentTestThread.get().log(Status.INFO, " Hey I'm in LandingPageTest");
   		Listener.extentTestThread.get().log(Status.INFO, "Hellooo started verifyMouseLink method ");
   		Listener.extentTestThread.get().assignAuthor("QA Tester 1").assignCategory("LandingPage Test");
   	}
    
    @Test(priority=6, description = "Verify interaction Chat Icon is displayed")
   	public void verifyinteractionChatIcon(){
    	log.info("verifyinteractionChatIcon Method is started");
    	
   		Assert.assertTrue(landingPage.verifyChatIcon().isDisplayed());
   		Assert.assertTrue(landingPage.verifyChatIcon().isEnabled());    		
   		
   		Listener.extentTestThread.get().log(Status.INFO, " Hey I'm in LandingPageTest");
   		Listener.extentTestThread.get().log(Status.INFO, "Hellooo started verifyinteractionChatIcon method ");
   		Listener.extentTestThread.get().assignAuthor("QA Tester 1").assignCategory("LandingPage Test");
   	}
    
    @Test(priority=7, description = "Verify Broken links")
   	public void verifyBrokenlinks(){
    	log.info("verifyBrokenlinks Method is started");
    	
    	BrokenLinks.myBrokenLinks();
    	
   		Listener.extentTestThread.get().log(Status.INFO, " Hey I'm in LandingPageTest");
   		Listener.extentTestThread.get().log(Status.INFO, "Hellooo started verifyBrokenlinks method ");
   		Listener.extentTestThread.get().assignAuthor("QA Tester 1").assignCategory("LandingPage Test");
   	}
    
    @Test(priority=8, description = "Find broken images on a web page")
   	public void verifyBrokenImages(){
    	log.info("verifyBrokenlinks Method is started");
    	
    	BrokenImages.validateInvalidImages();
    	
   		Listener.extentTestThread.get().log(Status.INFO, " Hey I'm in LandingPageTest");
   		Listener.extentTestThread.get().log(Status.INFO, "Hellooo started verifyBrokenImages method ");
   		Listener.extentTestThread.get().assignAuthor("QA Tester 1").assignCategory("LandingPage Test");
   	}
	
        
    @AfterMethod //--this method will be executed after every test method
	public void tearDown() {
		if (driver != null) {
			driver.close();;
		}		
	}
}
