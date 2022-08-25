package com.TestCases;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Base.BasePage;
import com.Listeners.Listener;
import com.PageObject.LandingPage;
import com.PageObject.LoginPage;
import com.Utils.BrokenImages;
import com.Utils.BrokenLinks;
import com.Utils.ElementUtils;
import com.aventstack.extentreports.Status;

public class LandingPageTest {
	public WebDriver driver;
	public BasePage basePage;
	public Properties prop;
    Logger log;
	
    public LandingPage landingPage;
    public LoginPage loginPage;
    public ElementUtils elementUtils;
    
  //Initializing PageFactory
  	public LandingPageTest() {
  		super();   //Call the Constructor of the Super class - BaseClass
  	}
    
    @BeforeMethod(alwaysRun = true)	//this method will be executed before every @test method
    @Parameters(value={"browser"})
	public void setUP(String browser) {
    	log = LogManager.getLogger(LandingPageTest.class.getName());
    	
    	String browserName = null;
    	basePage=new BasePage();	
        prop = basePage.initializeProperties();
		
		if (browser == null) {
			prop.setProperty("browser", browser);
		}else {
			browserName = browser;		
		}
		driver = basePage.initializeBrowser(browserName);
		log.info("****************************** Browser is launched *****************************************");
		
        log.debug("Browser got launched");
    	driver.get(prop.getProperty("url"));
    	log.debug("Navigated to application URL");
    	
    	landingPage=new LandingPage();        
    }

    @Test(priority=0, description = "Verify Home Page Title")
	public void verifyTitle() {
    	log.info("****************************** Starting Test Case verifyTitle *****************************************");
		
    	String title=landingPage.validateHomePageTitle();
    	Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.", "Home Page Title does not Matche");
    	   
		Listener.extentTestThread.get().log(Status.INFO, " Hey I'm in LandingPageTest");
		Listener.extentTestThread.get().log(Status.INFO, "Hellooo started verifyTitle method ");
		Listener.extentTestThread.get().assignAuthor("QA Tester 1").assignCategory("LandingPage Test").assignDevice("Windows HP");
		
		log.info("****************************** Ending Test Case verifyTitle *****************************************");
		System.out.println("Landing Page Title : " + title );	
	}
	
    @Test(priority=1, description = "Verify CRM Logo Image is Present in Home Page")
	public void verifyCRMLogo() {
    	log.info("****************************** Starting Test Case verifyCRMLogo *****************************************");
    	    	
		Boolean b = landingPage.validateCRMImage();
		Assert.assertTrue(b);
		
		Listener.extentTestThread.get().log(Status.INFO, " Hey I'm in LandingPageTest");
		Listener.extentTestThread.get().log(Status.INFO, "Hellooo started verifyCRMLogo method ");
		Listener.extentTestThread.get().assignAuthor("QA Tester 1").assignCategory("LandingPage Test");
		
		log.info("****************************** Ending Test Case verifyCRMLogo *****************************************");
	}
    
    @Test(priority=2, description = "Verify User name box is displayed")
	public void verifyUserName(){
    	log.info("****************************** Starting Test Case verifyUserName *****************************************");
    	
		//testUtil.switchToFrame();
		Assert.assertTrue(landingPage.verifyUserName().isDisplayed());
		Assert.assertTrue(landingPage.verifyUserName().isEnabled());
				
		Listener.extentTestThread.get().log(Status.INFO, " Hey I'm in LandingPageTest");
		Listener.extentTestThread.get().log(Status.INFO, "Hellooo started verifyUserName method ");
		Listener.extentTestThread.get().assignAuthor("QA Tester 1").assignCategory("LandingPage Test");
		
		log.info("****************************** Ending Test Case verifyUserName *****************************************");
	}
    
    @Test(priority=3, description = "Verify User password box is displayed")
   	public void verifyUserPassword(){
    	log.info("****************************** Starting Test Case verifyUserPassword *****************************************");
    	
   		//testUtil.switchToFrame();
   		Assert.assertTrue(landingPage.verifyUserPassword().isDisplayed());
   		Assert.assertTrue(landingPage.verifyUserPassword().isEnabled());
   		
   		Listener.extentTestThread.get().log(Status.INFO, " Hey I'm in LandingPageTest");
   		Listener.extentTestThread.get().log(Status.INFO, "Hellooo started verifyUserPassword method ");
   		Listener.extentTestThread.get().assignAuthor("QA Tester 1").assignCategory("LandingPage Test");
   		
   		log.info("****************************** Ending Test Case verifyUserPassword *****************************************");
   	}
    
    @Test(priority=4, description = "Verify Login Button is displayed")
   	public void verifyLoginBtn(){
    	log.info("****************************** Starting Test Case verifyLoginBtn *****************************************");
    	
   		//testUtil.switchToFrame();
    	Assert.assertTrue(landingPage.verifyLoginBtn().isDisplayed());   		
    	Assert.assertTrue(landingPage.verifyLoginBtn().isEnabled());
    	
   		Listener.extentTestThread.get().log(Status.INFO, " Hey I'm in LandingPageTest");
   		Listener.extentTestThread.get().log(Status.INFO, "Hellooo started verifyLoginBtn method ");
   		Listener.extentTestThread.get().assignAuthor("QA Tester 1").assignCategory("LandingPage Test");
   		
   		log.info("****************************** Ending Test Case verifyLoginBtn *****************************************");
   	}
    
    @Test(priority=5, description = "Verify Mouse Link is displayed")
   	public void verifyMouseLink(){
    	log.info("****************************** Starting Test Case verifyMouseLink *****************************************");
    	
   		Assert.assertTrue(landingPage.verifyclickMouseLink().isDisplayed());
   		Assert.assertTrue(landingPage.verifyclickMouseLink().isEnabled());   		
   		
   		Listener.extentTestThread.get().log(Status.INFO, " Hey I'm in LandingPageTest");
   		Listener.extentTestThread.get().log(Status.INFO, "Hellooo started verifyMouseLink method ");
   		Listener.extentTestThread.get().assignAuthor("QA Tester 1").assignCategory("LandingPage Test");
   		
   		log.info("****************************** Ending Test Case verifyMouseLink *****************************************");
   	}
    
    @Test(priority=6, description = "Verify interaction Chat Icon is displayed")
   	public void verifyinteractionChatIcon(){
    	log.info("****************************** Starting Test Case verifyinteractionChatIcon *****************************************");
    	
    	Listener.extentTestThread.get().log(Status.INFO, " Hey I'm in LandingPageTest");
   		Listener.extentTestThread.get().log(Status.INFO, "Hellooo started verifyinteractionChatIcon method ");
   		Listener.extentTestThread.get().assignAuthor("QA Tester 1").assignCategory("LandingPage Test");
   		
    	Assert.assertTrue(landingPage.verifyChatIcon().isDisplayed());
   		Assert.assertTrue(landingPage.verifyChatIcon().isEnabled()); 
   		
   		log.info("****************************** Ending Test Case verifyinteractionChatIcon *****************************************");
   	}
    
    @Test(priority=7, description = "Verify Carsoul Right Button is displayed")
   	public void verifyCarouslRightBtn(){
    	log.info("****************************** Starting Test Case verifyCarouslRightBtn *****************************************");
    	
   		Assert.assertTrue(landingPage.verifyclickCarouselRightBtn().isDisplayed());   		
   		
   		Listener.extentTestThread.get().log(Status.INFO, " Hey I'm in LandingPageTest");
   		Listener.extentTestThread.get().log(Status.INFO, "Hellooo started verifyCarouslRightBtn method ");
   		Listener.extentTestThread.get().assignAuthor("QA Tester 1").assignCategory("LandingPage Test");
   		
   		log.info("****************************** Ending Test Case verifyCarouslRightBtn *****************************************");
   	}
    
    @Test(priority=8, description = "Verify Carsoul Left Button is displayed")
   	public void verifyCarouslLeftBtn(){
    	log.info("****************************** Starting Test Case verifyclickCarouselLeftBtn *****************************************");
    	
   		Assert.assertTrue(landingPage.verifyclickCarouselLeftBtn().isDisplayed());   		
   		
   		Listener.extentTestThread.get().log(Status.INFO, " Hey I'm in LandingPageTest");
   		Listener.extentTestThread.get().log(Status.INFO, "Hellooo started verifyclickCarouselLeftBtn method ");
   		Listener.extentTestThread.get().assignAuthor("QA Tester 1").assignCategory("LandingPage Test");
   		
   		log.info("****************************** Ending Test Case verifyclickCarouselLeftBtn *****************************************");
   	}
    
    
    @Test(priority=9, description = "Verify Forget Password Link is displayed")
   	public void verifyForgetPasswordLink(){
    	log.info("****************************** Starting Test Case verifyForgetPasswordLink *****************************************");
    	
   		Assert.assertTrue(landingPage.clickforgetPasswordLink().isDisplayed());   		
   		
   		Listener.extentTestThread.get().log(Status.INFO, " Hey I'm in LandingPageTest");
   		Listener.extentTestThread.get().log(Status.INFO, "Hellooo Started verifyForgetPasswordLink Method ");
   		Listener.extentTestThread.get().assignAuthor("QA Tester 1").assignCategory("LandingPage Test");
   		
   		log.info("****************************** Ending Test Case verifyForgetPasswordLink *****************************************");
   	}
    
    @Test(priority=10, description = "Verify Go To Top Button is displayed")
   	public void verifyGoToTopBtn(){
    	log.info("****************************** Starting Test Case verifyGoToTopBtn *****************************************");
    	
   		Assert.assertTrue(landingPage.clickGoTopBtn().isDisplayed());   		
   		
   		Listener.extentTestThread.get().log(Status.INFO, " Hey I'm in LandingPageTest");
   		Listener.extentTestThread.get().log(Status.INFO, "Hellooo Started verifyGoToTopBtn Method ");
   		Listener.extentTestThread.get().assignAuthor("QA Tester 1").assignCategory("LandingPage Test");
   		
   		log.info("****************************** Ending Test Case verifyGoToTopBtn *****************************************");
   	}
    
    @Test(priority=11, description = "Verify Footer is displayed")
   	public void verifyFooterText(){
    	log.info("****************************** Starting Test Case verifyFooterText *****************************************");
    	
    	Listener.extentTestThread.get().log(Status.INFO, " Hey I'm in LandingPageTest");
   		Listener.extentTestThread.get().log(Status.INFO, "Hellooo Started verifyGoToTopBtn Method ");
   		Listener.extentTestThread.get().assignAuthor("QA Tester 1").assignCategory("LandingPage Test");
   		
   		Assert.assertTrue(landingPage.verifyFoorter().isDisplayed());
   		Assert.assertTrue(false, landingPage.verifyFoorter().getText());
   		
   		String footertext= landingPage.verifyFoorter().getText();
   		System.out.println(footertext);   		
   		
   		log.info("****************************** Ending Test Case verifyFooterText *****************************************");
   	}
    
    @Test(priority=12, description = "Verify Broken links")
   	public void verifyBrokenlinks(){
    	log.info("****************************** Starting Test Case verifyBrokenlinks *****************************************");
    	
    	BrokenLinks.myBrokenLinks();
    	
   		Listener.extentTestThread.get().log(Status.INFO, " Hey I'm in LandingPageTest");
   		Listener.extentTestThread.get().log(Status.INFO, "Hellooo started verifyBrokenlinks method ");
   		Listener.extentTestThread.get().assignAuthor("QA Tester 1").assignCategory("LandingPage Test");
   		
   		log.info("****************************** Ending Test Case verifyBrokenlinks *****************************************");
   	}
    
    @Test(priority=13, description = "Find broken images on a web page")
   	public void verifyBrokenImages(){
    	log.info("****************************** Starting Test Case verifyBrokenImages *****************************************");
    	
    	BrokenImages.validateInvalidImages();
    	
   		Listener.extentTestThread.get().log(Status.INFO, " Hey I'm in LandingPageTest");
   		Listener.extentTestThread.get().log(Status.INFO, "Hellooo started verifyBrokenImages method ");
   		Listener.extentTestThread.get().assignAuthor("QA Tester 1").assignCategory("LandingPage Test");
   		
   		log.info("****************************** Ending Test Case verifyBrokenImages *****************************************");
   	}	
        
    @AfterMethod(alwaysRun = true) //--this method will be executed after every test method
	public void tearDown() {
    	driver.close();
		if (driver != null) {
			driver.quit();
		}
	log.info("****************************** Browser is Closed *****************************************");
		
	}
}
