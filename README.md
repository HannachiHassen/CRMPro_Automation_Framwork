
\# Hello, folks! <img src="https://raw.githubusercontent.com/MartinHeinz/MartinHeinz/master/wave.gif" width="30px">

# CRMPro_Automation_Framwork

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites
```
Developing Software 
```
1. Download Java JDK 
2. Download Eclipse or IntelliJ IDEA
3. Download Apache Maven

## Built With

* [Java](https://www.oracle.com/java/) - Java JDK
* [Eclipse](https://www.eclipse.org/) - Eclipse IDE
* [Maven](https://maven.apache.org/) - Dependency Management

##Technologies Used:

* Eclipse/IntelliJ (Java Editor)  
* JDK 12 (Java Development Kit) 
* Selenium WebDriver 
* TestNG (Test Unit Framework) - Data Driven Approach 
* Log4j (logging API) 
* Maven (Build Automation Tool) 
* Apache POI API (Read-Write utilities for Excel - Test Data Handling) 
* Browser - Google Chrome/FireFox

##Automation Framework Architecture: 
* POM (Page Object Model) Design Page Factory API of WebDriver 
* Maven (Build Automation Tool) 
* Test Libraries for different UI Pages 
* Test Utilities for different generic functions 
* Report - Dashboard (Pass/Fail Test) by using Extent Report 
* API Jenkins - Continuous Integration Tool 
* git and GITHub Repo (Code Versioning Tool)

##Features 
* Webdriver Fire Event/WebEventListener - improved console logs and screenshot on failure Location: src\main\java\com\Utils\WebEventListener 
* Extent Report Listener with IReporter Interface (available at TestNG) Location: src\main\java\com\ExtentReport\ExtentReportListener 
* @CacheLookup implementation improves script performance 
* Data Driven approach (xml file reader through TestNG Data Provider)

##Note Make sure you are using the correct browser version. 
You can update to your browser version by putting the driver file into the drivers folder at the root of the project.

##Prerequisites: 
* If config file is not populated set up the account at https://classic.crmpro.com/index.html. 
* Then populate your config.properties with your account values. 
* Set up several contacts at the "Contacts page" - these are the values you are using in your ContactsPage.

##Running Test Cases 
* You can run test cases per each page object separately from each class in src\main\java\com\PageObject
* Or the whole suite through the test runner file located here: \CRM_Automation_Framwork\Config File\testng.xml file.

##Checking TestNG Reports 
* Right click on the project name and select "Refresh". 
* Go to test-output folder -> right click on index.html -> Properties -> copy file location -> run index.html file in your browser to see the report.
* To see Extent Report do the same for ExtentReport.html file

##Emailable TestNG Report Email 
* File name: emailable-report.html 
* Go to test-output folder -> right click on emailable-report.html -> copy file location -> run index.html file in your browser to see the report.


## Versioning

For the versions available, see the [tags on this repository](https://github.com/HannachiHassen/project/tags). 

## Authors

* **Hassen Hannachi** - *Initial work* - [HassenHannachi](https://github.com/HannachiHassen)

## License

This project is not under any License - Open source 
