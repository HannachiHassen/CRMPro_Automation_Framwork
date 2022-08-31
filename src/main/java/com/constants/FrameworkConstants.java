package com.constants;

public final class FrameworkConstants {
	
	private FrameworkConstants() {
		
	}	

	private static final int PAGELOADTIMEOUT=60;
	private static final int IMPLICITWAIT=30;    
	
	private static final int SHORTWAIT = 3000;
	private static final int MEDIUMWAIT = 6000;
	private static final int LONGWAIT = 10000;	

	private static final String RESOURCESPATH= System.getProperty("user.dir") +"/resources/";
	
	private static final String CHROMEDRIVERPATH= RESOURCESPATH + "/executables/chromedriver.exe";
	private static final String FIREFOXDRIVERPATH= RESOURCESPATH + "/executables/geckodriver.exe";	
	private static final String CONFIGFILEPATH= RESOURCESPATH + "/config/config.properties";
	private static final String QACONFIGPATH= RESOURCESPATH + "/config/qa.config.properties";
	private static final String DEVCONFIGPATH= RESOURCESPATH + "/config/dev.config.properties";
	private static final String STAGECONFIGPATH= RESOURCESPATH + "/config/stage.config.properties";
	private static final String UATCONFIGPATH= RESOURCESPATH + "/config/uat.config.properties";
	private static final String PRODCONFIGPATH= RESOURCESPATH + "/config/prod.config.properties";	

	private static final String EXCELFILEPATH = RESOURCESPATH + "/testData/HubSpotTestData.xlsx";
	
	private static final String QAENV = "qa";
	private static final String STAGEENV = "stage";
	private static final String DEVENV = "dev";
	private static final String UATENV = "uat";
	private static final String PRODENV = "prod";	
	
	public static int getPageLoadTimeout() {
		return PAGELOADTIMEOUT;
	}

	public static  int getImplicitWait() {
		return IMPLICITWAIT;
	}
	
	public static int getShortwait() {
		return SHORTWAIT;
	}

	public static int getMediumwait() {
		return MEDIUMWAIT;
	}

	public static int getLongwait() {
		return LONGWAIT;
	}
	public static String getChromedriverpath() {
		return CHROMEDRIVERPATH;
	}

	public static String getFirefoxdriverpath() {
		return FIREFOXDRIVERPATH;
	}
	
	public static String getConfigfilepath() {
		return CONFIGFILEPATH;
	}

	public static String getTestdatasheetpath() {
		return EXCELFILEPATH;
	}	

	public static String getQaenv() {
		return QAENV;
	}

	public static String getStageenv() {
		return STAGEENV;
	}

	public static String getDevenv() {
		return DEVENV;
	}

	public static String getUatenv() {
		return UATENV;
	}

	public static String getProdenv() {
		return PRODENV;
	}
	
	public static String getQaconfigfilepath() {
		return QACONFIGPATH;
	}

	public static String getDevconfigfilepath() {
		return DEVCONFIGPATH;
	}

	public static String getStageconfigfilepath() {
		return STAGECONFIGPATH;
	}

	public static String getUatconfigfilepath() {
		return UATCONFIGPATH;
	}

	public static String getProdconfigfilepath() {
		return PRODCONFIGPATH;
	}
	
}
