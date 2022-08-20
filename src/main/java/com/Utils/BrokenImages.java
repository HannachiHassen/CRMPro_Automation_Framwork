package com.Utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.Base.BaseClass;

public class BrokenImages extends BaseClass{
	
	public static void myBrokenImages() {
		
	// Storing all elements with img tag in a list of WebElements
    List<WebElement> images = driver.findElements(By.tagName("img"));
    System.out.println("Total number of Images on the Page are " + images.size());
	
	}

}
