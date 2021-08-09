package com.guru.testcases;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.guru.testbase.Testbase;
import com.relevantcodes.extentreports.ExtentReports;

public class config extends Testbase {

	public config() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	@BeforeSuite
	public void start() {
		extent = new ExtentReports("E:\\workspace\\GuruProject\\Report\\index.html", true);
		extent.addSystemInfo("owner", "eslam");
	}
	
	
	@AfterSuite
	public void end() {
		extent.flush();
	}
	
	

}
