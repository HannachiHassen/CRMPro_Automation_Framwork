package com.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Base.BaseClass;
import com.Utils.TestUtils;

public class LandingPage extends BaseClass {
	
	By CRMLog =By.xpath("//img[@src='https://classic.freecrm.com/img/logo.png']");
	
	@FindBy(xpath = "//img[@src='https://classic.freecrm.com/img/logo.png']")
	WebElement freeCRMLogo;

	@FindBy(xpath = "//input[@name='username']")
	WebElement userNameLabel;

	@FindBy(xpath = "//input[@name='password']")
	WebElement userPasswordLabel;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginBtn;

	@FindBy(xpath = "//a[contains(text(),'Sign Up')]")
	WebElement singUpLink;

	@FindBy(xpath = "//a[contains(text(),'Pricing')]")
	WebElement pricingLink;

	@FindBy(xpath = "//a[contains(text(),'Features')]")
	WebElement featuresLink;

	@FindBy(xpath = "//a[contains(text(),'Customers')]")
	WebElement customersLink;

	@FindBy(xpath = "//a[contains(text(),'Contact')]")
	WebElement contactLink;

	@FindBy(xpath = "//a[contains(@href,'#services')]")
	WebElement servicesImageLink;

	@FindBy(xpath = "//div[contains(@class,'intercom-1326a87 e4nbtsn3')]")
	WebElement interactionChat;

	
	public LandingPage() {
		PageFactory.initElements(driver, this);		
	}
	
	public String validateHomePageTitle() {
		return driver.getTitle();
	}

	public Boolean validateCRMImage() {
		TestUtils.waitForElementPresence(driver, CRMLog, 5);
		return driver.findElement(CRMLog).isDisplayed();
	}

	public Boolean verifyUserName() {
		return userNameLabel.isDisplayed();
	}

	public Boolean verifyUserPassword() {
		return userPasswordLabel.isDisplayed();
	}
	
	public void clickLogInbtn() {
		loginBtn.click();
	}
	
	public void clickSigninLink() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(singUpLink));
		singUpLink.click();
	}	
}
