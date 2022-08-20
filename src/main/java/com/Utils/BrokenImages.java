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
	
  //checking the links fetched.
    for(int index=0;index<images.size();index++){
    	WebElement image= images.get(index);
        String imageURL= image.getAttribute("src");
        System.out.println("URL of Image " + (index+1) + " is: " + imageURL);
        verifyLinks(imageURL);
    }
	}
	
	public static void verifyLinks(String linkUrl) {
		
    }

}
