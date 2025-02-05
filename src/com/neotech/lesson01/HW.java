package com.neotech.lesson01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

public class HW extends CommonMethods{
	/*
	 * Open chrome browser
	 * Go to "https://hrm.neotechacademy.com/"
	 * Enter valid username
	 * Leave password field empty
	 * Verify error message with text "Password cannot be empty" is displayed.
	 */

	@BeforeMethod
	public void openAndNavigate()
	{
		setUp();
	}
	
	@AfterMethod
	public void quitBrowser()
	{
		tearDown();
	}
	
	@Test
	public void errorMessageValidation()
	{
		sendText(driver.findElement(By.id("txtUsername")), ConfigsReader.getProperty("username"));
				
		click(driver.findElement(By.xpath("//button")));
		
		WebElement errorMessage = driver.findElement(By.id("txtPassword-error"));
		String actualMessage = errorMessage.getText();
		String expectedMessge = "Password cannot be empty";
		
		if (errorMessage.equals(expectedMessge))
		{
			System.out.println("Error Message Validation Passed!");
		}
		else
		{
			System.out.println("Error Message Validation Failed!");
		}
		
	}
}
