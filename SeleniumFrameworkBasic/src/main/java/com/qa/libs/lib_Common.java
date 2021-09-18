package com.qa.libs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.qa.pages.*;

public class lib_Common {

	//Method to open browser
	public final static void bc_OpenBrowser(WebDriver driver,final String url) {

		driver.get(url);
	}

	//Method to verify page title
	public final static void bc_VerifyTitle(WebDriver driver,final String titleExpected) {

		String titleActual = driver.getTitle();
		Assert.assertEquals(titleActual, titleExpected, "Title not displayed");

	}

	//Method to verify search bar
	public final static void bc_VerifySearchBar(WebDriver driver) {

		WebElement textField = driver.findElement(By.xpath(pg_GoogleHome.txt_GoogleSearchBar));
		//If field is available then type
		if(textField.isEnabled()) 
		{
			textField.sendKeys("Test Text");
			System.out.println("bc_VerifySearchBar Success");
		}else {System.out.println("bc_VerifySearchBar Failed");}

	}

	//Type in textfield
	public final static void bc_Type(WebDriver driver,String object, String text) {

		WebElement textField = driver.findElement(By.xpath(object));
		//If field is available then type
		if(textField.isEnabled()) 
		{
			textField.sendKeys(text);
			System.out.println("bc_Type Success");
		}else {System.out.println("bc_Type Failed");}

	}

	//Pause 
	public final static void bc_Pause(long time) throws InterruptedException {

		Thread.sleep(time);

	}

}
