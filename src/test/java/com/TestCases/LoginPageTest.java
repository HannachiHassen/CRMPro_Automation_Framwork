package com.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Base.BasePage;
import com.Base.BaseTest;
import com.PageObject.LandingPage;
import com.PageObject.LoginPage;

public class LoginPageTest extends BaseTest{		
		LoginPage loginPage;
		LandingPage landingPage;
		
		//Initializing PageFactory
		public LoginPageTest() {
			super();   //Call the Constructor of the Super class - TestBase
		}
				
		@Test(priority=1)
		public void loginPageTitleTest() {
			String title = loginPage.validateLoginPageTitle();
			Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
		    System.out.println(title); 
		}
		
		@Test(priority=2)
		public void CRMLogoImageTest() {
			Boolean b = loginPage.validateCRMImage();
			Assert.assertTrue(b);
		}
		
		@Test(priority=3)
		public void loginTest() {
			landingPage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		}	

}
