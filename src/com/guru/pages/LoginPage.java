package com.guru.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru.testbase.Testbase;

public class LoginPage extends Testbase {

	public LoginPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "uid")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = ("//input[@value='LOGIN']"))
	WebElement login;
	
	@FindBy(xpath = "//img[@src='/logo.png']")
	WebElement logo;
	
	@FindBy(xpath = "//*[contains(text(),usernametext)]")
	WebElement confirm;
	
	public String getTitle() {
		String actualResult = driver.getTitle();
		return actualResult;
	}
	
	public String URL() {
		String actualResult = driver.getCurrentUrl();
		return actualResult;
	}
	
	
	public boolean Logo() {
		boolean actualResult = logo.isDisplayed();
		return actualResult;
	}
	
	public void PerformLogin(String usernametext, String passwordtext) {
		username.sendKeys(usernametext);
		password.sendKeys(passwordtext);
		login.click();
	}
	
	public boolean confirm() {
		boolean actualResult = confirm.isDisplayed();
		return actualResult;
	}
	
	
	

}
