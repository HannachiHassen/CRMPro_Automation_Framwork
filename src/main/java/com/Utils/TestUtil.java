package com.Utils;

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
}
