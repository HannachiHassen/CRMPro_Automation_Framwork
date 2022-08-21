package com.Utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.Base.BaseClass;

public class Brokenlinks{
	
	public static WebDriver driver;	

	public static void myBrokenLinks() {	
					
		String myurl = "";
	    HttpURLConnection myhuc = null;
	    int responseCode = 200;
		
		///Storing the links in a list and traversing through the links
        List<WebElement> links = driver.findElements(By.tagName("a"));

        // This line will print the number of links and the count of links.
        System.out.println("No of links are "+ links.size()); 
        
        Iterator < WebElement > myit = links.iterator();
      
        //checking the links fetched.
        while (myit.hasNext()) {
            myurl = myit.next().getAttribute("href");
            System.out.println(myurl);
            if (myurl == null || myurl.isEmpty()) {
              System.out.println("Empty URL or an Unconfigured URL");
              continue;
            }      
            if (!myurl.startsWith(prop.getProperty("url"))) {
                System.out.println("This URL is from another domain, skipping it.");
                continue;
              }
            try {
                myhuc = (HttpURLConnection)(new URL(myurl).openConnection());
                myhuc.setRequestMethod("HEAD");
                myhuc.setConnectTimeout(5000);
                myhuc.connect();
                responseCode = myhuc.getResponseCode();
                   if (responseCode >= 400) {
                      System.out.println(myurl + " This link is broken");
                   }
                   else {
                     System.out.println(myurl + " This link is valid");
                   }
          } catch(MalformedURLException ex) {
             ex.printStackTrace();
           } catch(IOException ex) {
             ex.printStackTrace();
           }
        }
    }
}	
	   
	