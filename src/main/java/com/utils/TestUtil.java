package com.utils;

import java.util.Iterator;
import java.util.Set;

import com.base.BasePage;

public class TestUtil {
	
	public static void shortWait(){
		try {
			Thread.sleep(Constants.SHORT_WAIT);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void mediumWait(){
		try {
			Thread.sleep(Constants.MEDIUM_WAIT);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void longWait(){
		try {
			Thread.sleep(Constants.LONG_WAIT);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void multipleChildWinows () {
		String mainWindow = BasePage.getDriver().getWindowHandle();
	    System.out.println("Main window handle is " + mainWindow);
	    
	    // To handle all new opened window
	    Set<String> allWindowHandles = BasePage.getDriver().getWindowHandles();
	    System.out.println("Child window handle is" + allWindowHandles);
	    
	    Iterator<String> iterator = allWindowHandles.iterator();  
	    // Here we will check if child window has other child windows and will fetch the heading of the child window
	    // and when child window is the main window it will come out of loop.
	    while (iterator.hasNext()) {
	          String ChildWindow = iterator.next();
	          if (!mainWindow.equalsIgnoreCase(ChildWindow)) {
	        	  BasePage.getDriver().switchTo().window(ChildWindow);
	           }	         
	      }
	    //BasePage.getDriver().switchTo().window(mainWindow);
        //BasePage.getDriver().close();
	}
	
}
