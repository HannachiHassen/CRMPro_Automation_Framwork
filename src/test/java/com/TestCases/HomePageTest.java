package com.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Base.BaseClass;
import com.PageObject.HomePage;
import com.PageObject.LoginPage;
import com.Utilites.TestUtils;

public class HomePageTest extends BaseClass {
    HomePage homePage;
    LoginPage loginPage;
    TestUtils testUtils;

    //Initializing PageFactory
    public HomePageTest() {
        super();    //Call the Constructor of the Super class - BaseClass
    }

    public void setUp(){
        initialization();
        testUtils=new TestUtils();
        loginPage = new LoginPage();
        homePage=loginPage.login(props.getProperty("username"), props.getProperty("password"));
    }

    @Test(priority=1)
	public void loginPageTitleTest() {
    	String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Free CRM - CRM software for customer relationship management, sales, and support.", "Home Page Title is not Matched");
		System.out.println(homePageTitle); 
	}
	
    @Test(priority=2)
	public void CRMLogoImageTest() {
		Boolean b = homePage.validateCRMImage();
		Assert.assertTrue(b);
	}
    
    @Test(priority=3)
	public void verifyUserNameTest(){
		//testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyUserName());
	}

}
