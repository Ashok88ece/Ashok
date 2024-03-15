package com.automation.pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.automation.utility.BrowserFactory;
import com.automation.utility.ConfigDataProvider;
import com.automation.utility.ExcelDataProvider;
import com.automation.utility.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {
	
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;

	
	@BeforeSuite
	public void setupsuite() {
		
		 excel = new ExcelDataProvider();
		 config = new ConfigDataProvider();
		
		 
		 report = new ExtentReports();
		 //report.attachReporter(extent);
	}
	@Parameters({"browser","UrlToBeTested"})
	@BeforeClass
	public void setup(String browser,String url) {
		//driver = BrowserFactory.startapplication(driver, config.getBrowser(), config.getURL());
		
		driver = BrowserFactory.startapplication(driver, browser, url);
		
	}
	@AfterClass
	public void teardown() {
		BrowserFactory.quitBrowser(driver);
	}
	
	@BeforeMethod
	public void teardownmethod(ITestResult result) {
		
		if(result.getStatus()==ITestResult.FAILURE) {
			
			Helper.captureScreenshot(driver);
		}
		report.flush();
		
	}


}
