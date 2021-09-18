package com.qa.testBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;



public class TestBase {

	public WebDriver driver;
	public static Properties prop;


	public void DriverConfiguration(){

		//Read properties file
		try {
			prop = new Properties();
			FileInputStream propFile = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/qa"
					+ "/config/config.properties");
			prop.load(propFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		//Get browser name from property file
		String browserName = prop.getProperty("browser");

		//If browser = chrome then setup chromedriver
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\browserdrivers\\Chrome92\\chromedriver.exe");	
			driver = new ChromeDriver(); 
			driver.manage().window().maximize();
		}
		//If browser = firefox then setup geckodriver
		else if(browserName.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", "C:\\browserdrivers\\geckodriver-v0.29.1\\geckodriver");	
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}



	}

	//Method to quit driver
	public void QuitDriver(){
		driver.quit();
	}


}
