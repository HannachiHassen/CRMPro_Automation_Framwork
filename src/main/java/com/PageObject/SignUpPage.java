package com.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Base.BasePage;

public class SignUpPage extends BasePage{
	
	@FindBy(xpath="//a[@class='navbar-brand']")
	WebElement SignUpLogo ;
	
	//select[@id='payment_plan_id']
	
	//input[@placeholder='First Name']
	
	//input[@placeholder='Last Name']
	
	//input[@placeholder='Email']
	
	//input[@placeholder='Confirm Email']
	
	//input[@placeholder='Username']
	
	//input[@placeholder='Password']
	
	//input[@placeholder='Confirm Password']
	
	//input[@name='agreeTerms']
	
	//div[@class='myButton']
	
	//a[normalize-space()='Forgot Password?']
	
		
	public String validateLoginPageTitle() {
		return getDriver().getTitle();
	}
	
	public Boolean validateCRMImage() {
		return SignUpLogo.isDisplayed();
	}
}
