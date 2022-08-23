package com.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Base.BasePage;
import com.Utils.ElementUtils;

public class LandingPage extends BasePage {

	By CRMLog = By.xpath("//img[@src='https://classic.freecrm.com/img/logo.png']");

	By userNameLabel = By.xpath("//input[@name='username']");

	By userPasswordLabel = By.xpath("//input[@name='password']");

	By loginBtn = By.xpath("//input[@type='submit']");

	By singUpLink = By.xpath("//a[contains(text(),'Sign Up')]");

	By pricingLink = By.xpath("//a[contains(text(),'Pricing')]");

	By featuresLink = By.xpath("//a[contains(text(),'Features')]");

	By customersLink = By.xpath("//a[contains(text(),'Customers')]");

	By contactLink = By.xpath("//a[contains(text(),'Contact')]");
	
	By goTopArrow = By.xpath("//button[@class='right carousel-control skrollable skrollable-between']");

    By mouseLink = By.xpath ("//span[@class='mouse']");

	By interactionChat = By.xpath("//div[@class='intercom-lightweight-app-launcher-icon intercom-lightweight-app-launcher-icon-open']");
	
	By carouselImageBtn = By.xpath("//button[@class='right carousel-control skrollable skrollable-between']");
	
	By forgetPassword = By.xpath("//a[contains(text(),'Forgot Password?')]");
	
	

	public LandingPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public String validateHomePageTitle() {
		return getDriver().getTitle();
	}

	public Boolean validateCRMImage() {
		ElementUtils.waitForElementPresence(getDriver(), CRMLog, 5);
		return getDriver().findElement(CRMLog).isDisplayed();
	}

	public WebElement verifyUserName() {
		return ElementUtils.waitForElementPresence(getDriver(), userNameLabel, 30);
	}
	
	public WebElement verifyLoginBtn() {
		return ElementUtils.waitToBeClickable(getDriver(), loginBtn, 30);
	}

	public WebElement verifyUserPassword() {
		return ElementUtils.waitForElementPresence(getDriver(), userPasswordLabel, 30);
	}

	public WebElement verifyclickMouseLink() {
		return ElementUtils.waitForElementPresence(getDriver(), mouseLink, 30);
	}
	
	public WebElement verifyclickCarouselBtn() {
		return ElementUtils.waitForElementPresence(getDriver(), carouselImageBtn, 30);
	}
	
	public WebElement verifyChatIcon() {
		return ElementUtils.waitForElementPresence(getDriver(), interactionChat, 30);
	}	

	public void clickSigninLink() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		wait.until(ExpectedConditions.elementToBeClickable(singUpLink));
	}

	public void clickOnPricingLink() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
		
	}

	public void clickOnFeaturesLink() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
		
	}

	public void clickOnCustomersLink() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
		
	}

	public void clickOnContactsLink() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		wait.until(ExpectedConditions.elementToBeClickable(loginBtn));		
	}
	
	public WebElement clickforgetPasswordLink() {
		return ElementUtils.waitForElementPresence(getDriver(), forgetPassword, 30);		
	}	
	
	public WebElement clickGoTopButton() {
	   return ElementUtils.waitForElementPresence(getDriver(), goTopArrow, 30);	
	}	
}
