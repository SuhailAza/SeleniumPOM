package com.qa.tcase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.libs.lib_Common;
import com.qa.libs.lib_FacebookSignUp;
import com.qa.testBase.TestBase;
import com.qa.util.testUtil;

//Basic facebbok signup without re-enter email
public class tc_FacebookSignUp {
	
	//Assign testbase object
	TestBase objDriver = new TestBase();
	
	//Variables
	//Properties to read url
	public static Properties propURL;
	//url string
	public static String url;
	//excelData path
	public static String excelDataPath;
	//excelData Sheet
	public static String excelDataSheet;

	
	//Read config to get url, Excel Path and Sheet Name
	@BeforeSuite
	public void getURL() {
		//Read properties file
		try {
			propURL = new Properties();
			FileInputStream propFile = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/qa"
					+ "/config/config.properties");
			propURL.load(propFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		//Get url from property file
		url = propURL.getProperty("url");
		//Get url from property file
		excelDataPath = propURL.getProperty("excelDataPath");
		//Get url from property file
		excelDataSheet = propURL.getProperty("excelDataSheet");
	}

	
	//Data Provider to get data from excel
	@DataProvider(name="excelData")
	public Object[][] getTestData() throws IOException {

		//getDataFromExcel method to get and pass values. Parameters are <excelPath> and <sheetName> 
		Object[][] arrObj = testUtil.getDataFromExcel(excelDataPath,excelDataSheet);
		return arrObj;

	}

	//Configure Driver and Open Browser
	@BeforeMethod
	public void setup() {
		//Call DriverConfiguration to setup driver
		objDriver.DriverConfiguration();
		lib_Common.bc_OpenBrowser(objDriver.driver, url);
	}

	//Verify Page Title
	@Test(priority = 1)
	public void verifyPageTitle() {

		lib_Common.bc_VerifyTitle(objDriver.driver, "Sign up for Facebook | Facebook");

	}

	//If Page title passed then fill signup form
	@Test(priority = 2, dependsOnMethods = "verifyPageTitle", dataProvider = "excelData")
	public void filleSignUpForm(String firstName, String lastName, String email, String password, String BDay, String Month, String Year) {

		System.out.println("filleSignUpForm Start");
		lib_FacebookSignUp.bc_FillSignUpForm(objDriver.driver, firstName, lastName, email, password, BDay, Month, Year);

	}

	//Kill Browser
	@AfterMethod
	public void killBrowser() {
		objDriver.QuitDriver();
	}

}
