package com.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Base.BasePage;
import com.Utils.ElementUtils;

public class LandingPage extends BasePage {
	private WebDriver driver;

	By CRMLog = By.xpath("//img[@src='https://classic.freecrm.com/img/logo.png']");

	@FindBy(xpath = "//img[@src='https://classic.freecrm.com/img/logo.png']")
	WebElement freeCRMLogo;

	By userNameLabel = By.xpath("//input[@name='username']");

	By userPasswordLabel = By.xpath("//input[@name='password']");

	By loginBtn = By.xpath("//input[@type='submit']");

	By singUpLink = By.xpath("//a[contains(text(),'Sign Up')]");

	By pricingLink = By.xpath("//a[contains(text(),'Pricing')]");

	By featuresLink = By.xpath("//a[contains(text(),'Features')]");

	By customersLink = By.xpath("//a[contains(text(),'Customers')]");

	By contactLink = By.xpath("//a[contains(text(),'Contact')]");

    By mouseLink = By.xpath ("//span[@class='mouse']");

	By interactionChat = By.xpath("//div[@class='intercom-lightweight-app-launcher-icon intercom-lightweight-app-launcher-icon-open']");

	public LandingPage() {
		PageFactory.initElements(driver, this);
	}

	public String validateHomePageTitle() {
		return driver.getTitle();
	}

	public Boolean validateCRMImage() {
		ElementUtils.waitForElementPresence(driver, CRMLog, 5);
		return driver.findElement(CRMLog).isDisplayed();
	}

	public WebElement verifyUserName() {
		return ElementUtils.waitForElementPresence(driver, userNameLabel, 30);
	}

	public WebElement verifyUserPassword() {
		return ElementUtils.waitForElementPresence(driver, userPasswordLabel, 30);
	}

	public WebElement verifyclickMouseLink() {
		return ElementUtils.waitForElementPresence(driver, mouseLink, 30);
	}
	
	public WebElement verifyChatIcon() {
		return ElementUtils.waitForElementPresence(driver, interactionChat, 30);
	}

	public WebElement verifyLoginBtn() {
		return ElementUtils.waitToBeClickable(driver, loginBtn, 30);
	}

	public void clickSigninLink() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(singUpLink));
	}

	public void clickOnPricingLink() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
		
	}

	public void clickOnFeaturesLink() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
		
	}

	public void clickOnCustomersLink() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
		
	}

	public void clickOnContactsLink() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(loginBtn));		
	}
}
