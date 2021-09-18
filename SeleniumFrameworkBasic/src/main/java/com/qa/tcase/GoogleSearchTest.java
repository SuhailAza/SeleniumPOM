package com.qa.tcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.libs.lib_Common;
import com.qa.testBase.TestBase;
import com.qa.pages.pg_GoogleHome;

public class GoogleSearchTest {
	
	//Assign testbase object
	TestBase objDriver = new TestBase();
	
	//Setup driver and open browser
	@BeforeMethod
	public void setup() {
		//Call DriverConfiguration to setup driver
		objDriver.DriverConfiguration();
		lib_Common.bc_OpenBrowser(objDriver.driver, "https://www.google.com/");
	}
	//Verify Search Bar
	@Test(priority = 1)
	public void verifyGoogleSearch() {
		
		System.out.println("Test One");
		lib_Common.bc_VerifySearchBar(objDriver.driver);
		
	}
	
	//Type in Search Bar
	@Test(priority = 2)
	public void verifyGoogleSearchType() {
		
		System.out.println("Test One");
		lib_Common.bc_Type(objDriver.driver, pg_GoogleHome.txt_GoogleSearchBar, "Cats");
		
	}
	
	@AfterMethod
	public void killBrowser() {
		objDriver.driver.quit();
	}

}
