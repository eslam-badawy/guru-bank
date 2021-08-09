package com.guru.testcases;


import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.guru.pages.LoginPage;
import com.guru.testbase.Testbase;
import com.guru.util.TestUtils;
import com.relevantcodes.extentreports.LogStatus;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

public class LoginPageTest extends Testbase{
	
	public LoginPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	@Parameters({"browser"})
	@BeforeMethod
	public void setup(String browser, Method method) throws IOException, ATUTestRecorderException {
		logger = extent.startTest(method.getName());
		initialization(browser);
		loginpage = new LoginPage();
		recorder = new ATUTestRecorder("E:\\workspace\\GuruProject\\Report" , method.getName() , false);
		recorder.start();                  
		
	}
	
	@AfterMethod
	public void TearDown(Method method, ITestResult result) throws IOException, ATUTestRecorderException {
		recorder.stop();
		TestUtils.takescreenshot(method.getName());
		
		if(result.getStatus() == ITestResult.SUCCESS)
		{
			logger.log(LogStatus.PASS, "test passed");
			logger.log(LogStatus.PASS, "<a href='" + result.getName() + ".png" + "'><span class='lable info'>Download Snapshot</span></a>");
			logger.log(LogStatus.PASS, "<a href='" + result.getName() + ".mov" + "'><span class='lable info'>Download Video</span></a>");
			
		}
		else if(result.getStatus() == ITestResult.FAILURE)
		{
			logger.log(LogStatus.FAIL, result.getThrowable());
			logger.log(LogStatus.FAIL, "<a href='" + result.getName() + ".png" + "'><span class='lable info'>Download Snapshot</span></a>");
			logger.log(LogStatus.FAIL, "<a href='" + result.getName() + ".mov" + "'><span class='lable info'>Download Video</span></a>");
			
		}
		else
		{
			logger.log(LogStatus.SKIP, "test skipped");

		}
		driver.quit();
	}
	
	@Test (priority = 1)
	public void TitleTest() {
		String ExpectedResult = "Guru99 Bank Home Page";
		String ActualResult = loginpage.getTitle();
		Assert.assertEquals(ActualResult, ExpectedResult, "the title is not correct");
		
	}
	
	@Test (priority = 2)
	public void URLTest() {
		String ExpectedResult = "http://www.demo.guru99.com/V4/";
		String ActualResult = loginpage.URL();
		Assert.assertEquals(ActualResult, ExpectedResult, "the URL is not correct");

	}
	
	@Test (priority = 3)
	public void LogoTest() {
		boolean ActualResult = loginpage.Logo();
		Assert.assertTrue(ActualResult, "the logo is not displayed");

	}
	
	@Test (priority = 4, dataProvider = "TestData")
	public void LoginTest(String usernametext, String passwordtext) {
		loginpage.PerformLogin(usernametext, passwordtext);
		boolean ActualResult = loginpage.confirm();
		Assert.assertTrue(ActualResult, "login failed");
		
	}
	
	@DataProvider
	public static Object[][] TestData() throws IOException {
		Object data[][] = TestUtils.getdDataFromExcell("Sheet1");
		return data;
	}
	

}
