package com.neotech.lesson01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

public class TitleAndLogoValidation extends CommonMethods {

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
	public void titleValidation()
	{
		String expectedTitle = "OrangeHR";
		//I am intentionally failing this test
		String actualTitle = driver.getTitle();
		
		if (expectedTitle.equals(actualTitle))
		{
			System.out.println("Title Validation Passed!!!");
		}
		else
		{
			System.out.println("Title Validation Failed!!!");
			System.out.println("The title is " + actualTitle);
			
			//later on we will use Assertions, but for now we can fail the test case by throwing an Exception
			throw new RuntimeException();
			
		}
		
	}
	
	@Test
	public void logoValidation()
	{
		WebElement logo = driver.findElement(By.xpath("//div[@class='orangehrm-logo']/img"));
		
		if (logo.isDisplayed())
		{
			System.out.println("Logo Validation Passed!");
		}
		else
		{
			System.out.println("Logo Validation Failed!");
		}
	}
	
	@Test
	public void loginValidation()
	{
		sendText(driver.findElement(By.id("txtUsername")), ConfigsReader.getProperty("username"));
		sendText(driver.findElement(By.id("txtPassword")), ConfigsReader.getProperty("password"));
		
		click(driver.findElement(By.xpath("//button")));
		
		WebElement userImg = driver.findElement(By.xpath("//div[@id='menu-profile']/img"));
		
		if (userImg.isDisplayed())
		{
			System.out.println("Login Validation Passed!");
		}
		else
		{
			System.out.println("Login Validation Failed!");
		}
		
		
	}
	
}