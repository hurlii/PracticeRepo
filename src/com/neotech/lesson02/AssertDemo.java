package com.neotech.lesson02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.neotech.utils.CommonMethods;


public class AssertDemo extends CommonMethods{
	
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
	
	@Test(enabled = false)
	public void titleValidation()
	{
		String expectedTitle = "OrangeHRM...";
		//Let's the test failed intentionally
		
		String actualTitle = driver.getTitle();
		
		// 1st way
		// Assert.assertEquals(actualTitle, expectedTitle);
		
		// 2nd way --> we can display a meaningful message --> displayed when the assertion fails 
		Assert.assertEquals(actualTitle, expectedTitle, "Title does NOT match!");
		
		// if hard assertion fails, the statements after the assertion will not be executed
		
		System.out.println("After the assertion");

	}
	
	@Test
	public void logoValidation() {
		WebElement logo = driver.findElement(By.xpath("//div[@class='orangehrm-logo']/img"));
		boolean logoDisplayed = logo.isDisplayed();
		
		// Let manually make the logoDisplayed = false --> failing the test
		logoDisplayed = false;
		
		//1st way 
		//Assert.assertEquals(logoDisplayed, true);
		
		// 2nd way
		
		//Assert.assertEquals(logoDisplayed, true, "Logo is NOT displayed!");
		
		// 3rd way
		Assert.assertTrue(logoDisplayed, "Logo is NOT displayed!");
		
		System.out.println("Continue after the assertion...");
	}
}