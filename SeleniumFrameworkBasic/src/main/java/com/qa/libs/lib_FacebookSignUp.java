package com.qa.libs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.qa.pages.pg_FacebookSignUp;

public class lib_FacebookSignUp {
	
	//Method to fill signup form
		public final static void bc_FillSignUpForm(WebDriver driver, String firstName, String lastName, String email, String password,
				String BDay, String Month, String Year) {
			
			//Get page elements
			WebElement txt_FirstName = driver.findElement(By.xpath(pg_FacebookSignUp.txt_FirstName));
			WebElement txt_LastName = driver.findElement(By.xpath(pg_FacebookSignUp.txt_LastName));
			WebElement txt_Email = driver.findElement(By.xpath(pg_FacebookSignUp.txt_Email));
			WebElement txt_Password = driver.findElement(By.xpath(pg_FacebookSignUp.txt_Password));
			Select dd_BDay = new Select(driver.findElement(By.xpath(pg_FacebookSignUp.dd_BDay)));
			Select dd_Month = new Select(driver.findElement(By.xpath(pg_FacebookSignUp.dd_Month)));
			Select dd_Year = new Select (driver.findElement(By.xpath(pg_FacebookSignUp.dd_Year)));
			WebElement rb_Gender = driver.findElement(By.xpath(pg_FacebookSignUp.rb_GenderMale));
			WebElement btn_SignUp = driver.findElement(By.xpath(pg_FacebookSignUp.btn_Submit));
			
			//Type in fields
			txt_FirstName.sendKeys(firstName);
			txt_LastName.sendKeys(lastName);
			txt_Email.sendKeys(email);
			txt_Password.sendKeys(password);
			//Select date of birth from dropdown
			dd_BDay.selectByVisibleText(BDay);
			dd_Month.selectByVisibleText(Month);
			dd_Year.selectByVisibleText(Year);
			//Select gender
			rb_Gender.click();
			//Click SignUp
			btn_SignUp.click();
		}
	

}
