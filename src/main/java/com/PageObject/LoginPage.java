package com.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Base.BasePage;

public class LoginPage extends BasePage{
	
	private WebDriver driver;

	//Load PageFactory(OR - Object Repository)
	@FindBy(name="username")
	WebElement username;

	@FindBy(name="password")
	WebElement password;

	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;

	@FindBy(xpath="//button[contains(text(),'Sign Up']")
	WebElement signUpBtn;

	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement freeCRMLogo;

	//Initializing PageFactory
	public LoginPage() {
		PageFactory.initElements(driver, this); //this --> points to current class object.
	}

	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public Boolean validateCRMImage() {
		return freeCRMLogo.isEnabled();
	}

	public LandingPage login(String uname , String pwd) {
		username.sendKeys(uname);
		password.sendKeys(pwd);
		loginBtn.click();

		return new LandingPage(); //LandingPage is the landing page for LoginPage
	}
}

