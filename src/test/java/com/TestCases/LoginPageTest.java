package com.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Base.BaseClass;
import com.PageObject.HomePage;
import com.PageObject.LoginPage;

public class LoginPageTest extends BaseClass{		
		LoginPage loginPage;
		HomePage homePage;
		
		//Initializing PageFactory
		public LoginPageTest() {
			super();   //Call the Constructor of the Super class - TestBase
		}
		
		@BeforeMethod
		public void setUp() {
			initializeBrowser();
			loginPage = new LoginPage();
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
			homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		}
		
		@AfterMethod
		public void tearDown() {
			driver.close();
			if (driver != null) {
				driver.quit();
			}		
		}   

}
