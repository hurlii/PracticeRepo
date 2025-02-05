package com.neotech.lesson02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

public class HW2 extends CommonMethods {

	/*
	 * HW2: OrangeHRM Add Employee:
	 * 
	 * Open chrome browser Go to "https://hrm.neotechacademy.com/" Login into the
	 * application Click on Add Employee Verify labels: Employee Full Name*,
	 * Employee Id, Location* are displayed Provide Employee First and Last Name
	 * Select a Location Verify Employee has been added successfully Close the
	 * browser
	 */

	@BeforeMethod
	public void openAndNavigate() {
		setUp();
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

	@Test
	public void addEmployeeValidation() {

		sendText(driver.findElement(By.id("txtUsername")), ConfigsReader.getProperty("username"));
		sendText(driver.findElement(By.id("txtPassword")), ConfigsReader.getProperty("password"));

		click(driver.findElement(By.xpath("//button")));
		wait(2);
		click(driver.findElement(By.id("menu_pim_viewPimModule")));
		click(driver.findElement(By.id("menu_pim_addEmployee")));
	}
	
	@Test (dependsOnMethods="addEmployeeValidation")
	public void labelsValidation() {
		
		addEmployeeValidation();	
			
		WebElement title = driver.findElement(By.xpath("//h5"));		
		Assert.assertTrue(title.isDisplayed(), "Title is NOT displayed!");
		
		driver.findElement(By.id("first-name-box")).sendKeys("Secil");
		driver.findElement(By.id("last-name-box")).sendKeys("Cam");

		Select locationSelect = new Select(driver.findElement(By.id("location")));
		locationSelect.selectByVisibleText("New York Sales Office");
		wait(2);
		click(driver.findElement(By.id("modal-save-button")));
		
		String actualName = driver.findElement(By.id("pim.navbar.employeeName")).getText();
		String expectedName = "Secil Cam";

		SoftAssert soft = new SoftAssert();	
		soft.assertEquals(actualName, expectedName, "Account name is NOT Secil Cam!");
		soft.assertAll();

		System.out.println("Test passed!");

	}
}
