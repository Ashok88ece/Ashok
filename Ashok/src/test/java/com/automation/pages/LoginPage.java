package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver ldriver) {
		
		this.driver=ldriver;
		
	}
	
	@FindBy(name="username")
	WebElement Uname;
	
	@FindBy(name="password")
	WebElement Pword;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")
	WebElement Loginbtn;
	
	
	public void logintohrm(String username,String password) {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Uname.sendKeys(username);
		Pword.sendKeys(password);
		Loginbtn.click();
		
	}

}
