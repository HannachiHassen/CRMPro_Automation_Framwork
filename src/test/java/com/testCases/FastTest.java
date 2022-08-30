package com.testCases;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.listeners.Listener;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FastTest {
	
	public WebDriver driver;
		
	@Test
	public void verifyTest() {
		ChromeOptions chromeOptions = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(chromeOptions);
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://classic.crmpro.com/index.html");
		
		Listener.extentTestThread.get().log(Status.INFO, " Hey I'm in FastTest");
   		Listener.extentTestThread.get().log(Status.INFO, "Hellooo verifyTest Method Started ");		
		Listener.extentTestThread.get().assignAuthor("QA Tester 1").assignCategory("Dummy Test");
		
		driver.findElement(By.cssSelector("li:nth-child(2) > a")).click();
        
		String mainWindow = driver.getWindowHandle();
	    System.out.println("Main window handle is " + mainWindow);
	    
	    // To handle all new opened window
	    Set<String> allWindowHandles = driver.getWindowHandles();
	    System.out.println("Child window handle is" + allWindowHandles);
	    
	    Iterator<String> iterator = allWindowHandles.iterator();  
	    // Here we will check if child window has other child windows and will fetch the heading of the child window
	    // and when child window is the main window it will come out of loop.
	    while (iterator.hasNext()) {
	          String ChildWindow = iterator.next();
	          if (!mainWindow.equalsIgnoreCase(ChildWindow)) {
	        	  driver.switchTo().window(ChildWindow);
	           }	         
	      }
		
		String title=driver.getTitle();
		System.out.println(title);	
		
		driver.close();
	}
}
