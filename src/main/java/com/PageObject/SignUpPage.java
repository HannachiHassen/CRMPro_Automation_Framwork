package com.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.Base.BasePage;

public class SignUpPage extends BasePage {

	@FindBy(xpath="//img[@src='https://classic.crmpro.com/img/logo.png']")
	@CacheLookup 
	private WebElement SignUpLogo;
	
	@FindBy(xpath="//select[@id='payment_plan_id']") 
	@CacheLookup 
	private WebElement edition;
	
	@FindBy(xpath="//div[@id='editionText']") 
	@CacheLookup 
	private WebElement selectEditionAbove;

	@FindBy(xpath = "//input[@placeholder='First Name']")
	WebElement FirstName;

	@FindBy(xpath="//input[@placeholder='Last Name']")
	WebElement LastName;

	@FindBy(xpath="//input[@placeholder='Email']")
	WebElement Email;

	@FindBy(xpath="//input[@placeholder='Confirm Email']")
	WebElement ConfirmEmail;

	@FindBy(xpath="//input[@placeholder='Username']") 
	WebElement Username;

	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement Password;
	
	@FindBy(xpath="//input[@placeholder='Confirm Password']")
	WebElement ConfirmPassword;
	
	@FindBy(xpath="//form[@id='multipleForm']//div//span") 
	@CacheLookup 
	private WebElement allFieldsAreRequired;
	
	@FindBy(xpath="//input[@name='agreeTerms']")
	WebElement agreeTerms;
	
	@FindBy(xpath="//div[@class='myButton']")
	WebElement myButton;
	
	@FindBy(xpath="//a[normalize-space()='Forgot Password?']")
	WebElement ForgotPassword;
	
	public String validateLoginPageTitle() {
		return getDriver().getTitle();
	}

	public Boolean validateCRMImage() {
		return SignUpLogo.isDisplayed();
	}	
}
