package com.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Base.BaseClass;
import com.PageObject.HomePage;
import com.PageObject.LoginPage;
import com.Utils.TestUtils;

public class HomePageTest extends BaseClass {
	public WebDriver driver;
    public HomePage homePage;
    public LoginPage loginPage;
    public TestUtils testUtils;
    
  //Initializing PageFactory
  	public HomePageTest() {
  		super();   //Call the Constructor of the Super class - BaseClass
  	}
    
    @BeforeMethod	
    public void setUp(){
        driver=initializeBrowser();
    	driver.get(prop.getProperty("url"));
        //testUtils=new TestUtils();
        //loginPage = new LoginPage();
        homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }

    @Test(priority=1, description = "Verify Home Page Title")
	public void HomePageTitleTest() {
    	String title=homePage.validateHomePageTitle();
    	Assert.assertEquals(title, "CRMPRO  - CRM software for customer relationship management, sales, and support.", "Home Page Title does not Matche");
    	//Assert.assertEquals(homePage.getPageTitle(), homePage.verifyBasePageTitle());
    	//Assert.assertTrue(homePage.verifyBasePageTitle(),"Home Page Title does not Matche"); 
    	System.out.println(homePage.validateHomePageTitle());	
	}
    
    /*@Test(priority=4, description = "Verify Home Page Title Test")
	public void verifyHomePageTitleTest(){
		String title = homePage.getPageTitle();
		System.out.println("the home page title is: "+ title);
		Assert.assertEquals(title, "CRMPRO  - CRM software for customer relationship management, sales, and support.");
	}
	
    @Test(priority=2, description = "Verify CRM Logo Image is Present in Home Page")
	public void CRMLogoImageTest() {
		Boolean b = homePage.validateCRMImage();
		Assert.assertTrue(b);
	}
    
    @Test(priority=3, description = "Verify User name")
	public void verifyUserNameTest(){
		//testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyUserName());
	}*/
    
    @AfterMethod
	public void tearDown() {
		driver.close();
		if (driver != null) {
			driver.quit();
		}		
	}   

}
