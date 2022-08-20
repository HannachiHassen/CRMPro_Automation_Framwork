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

	By userNameLabel=By.xpath ("//input[@name='username']");
	
	By userPasswordLabel= By.xpath ("//input[@name='password']");
	

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

	//@FindBy(xpath = "//a[contains(@href,'#services')]")
	@FindBy(css = "mouse")
	WebElement mouseLink;

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

	public WebElement verifyUserName() {
		return TestUtils.waitForElementPresence(driver, userNameLabel, 30);
	}	

	public Boolean verifyUserPassword() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(userPasswordLabel));
		if (userPasswordLabel.isEnabled()){
			
		}
		return userPasswordLabel.isDisplayed();		
	}
	
	public Boolean interactionChat() {
		return interactionChat.isDisplayed();
	}
	
	public void verifyclickMouseLink() {
		mouseLink.click();
	}
	
	public void verifyLoginBtn() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(loginBtn));
		loginBtn.isDisplayed();
	}
	
	public void clickSigninLink() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(singUpLink));
	}	
	
	public void clickOnPricingLink() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
		loginBtn.click();
	}
	
	public void clickOnFeaturesLink() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
		loginBtn.click();
	}
	
	public void clickOnCustomersLink() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
		loginBtn.click();
	}
	
	public void clickOnContactsLink() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
		loginBtn.click();
	}	
}
