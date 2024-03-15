package com.automation.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.pages.BaseClass;
import com.automation.pages.LoginPage;
import com.automation.utility.BrowserFactory;
import com.automation.utility.ExcelDataProvider;
import com.automation.utility.Helper;

public class LoginTest extends BaseClass{
	
	
	
	@Test
	public void loginapp() {
		
		logger = report.createTest("Login to HRM");		
		LoginPage loginpage =PageFactory.initElements(driver,LoginPage.class);
		logger.info("Starting Application");
		loginpage.logintohrm(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
		System.out.println("Logged into Application");
		
		logger.pass("Logged into HMR Success");
		//Helper.captureScreenshot(driver);
		
		
	}
	
	
}
