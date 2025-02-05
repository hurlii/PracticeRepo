package com.neotech.lesson03;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.google.common.io.Files;
import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

public class HW1 extends CommonMethods {

	/*
	 * Open chrome browser Go to "https://hrm.neotechacademy.com/" Login to the
	 * application Add 3 different Employees and Create Login Details by providing:
	 * First Name Last Name Username Password Verify Employee has been added
	 * successfully and take screenshot (you must have 3 different screenshots)
	 * Close the browser Specify a group for this test case, add it into specific
	 * suite and execute from the xml file.
	 */

//	@BeforeMethod
//	public void openAndNavigate() {
//		setUp();
//	}
//
//	@AfterMethod
//	public void quitBrowser() {
//		tearDown();
//	}

	@Test(dataProvider = "userData")
	public void labelsValidation(String name, String lastname) {

		sendText(driver.findElement(By.id("txtUsername")), ConfigsReader.getProperty("username"));
		sendText(driver.findElement(By.id("txtPassword")), ConfigsReader.getProperty("password"));

		click(driver.findElement(By.xpath("//button")));
		wait(2);
		click(driver.findElement(By.id("menu_pim_viewPimModule")));
		click(driver.findElement(By.id("menu_pim_addEmployee")));

		driver.findElement(By.id("first-name-box")).sendKeys(name);
		driver.findElement(By.id("last-name-box")).sendKeys(lastname);

		Select locationSelect = new Select(driver.findElement(By.id("location")));
		locationSelect.selectByVisibleText("New York Sales Office");
		wait(2);
		click(driver.findElement(By.id("modal-save-button")));

		waitForVisibility(By.id("firstName"));
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		try {
			Files.copy(source, new File("screenshots/HRM/" + name + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Unable to save the screenshot!");
		}
	}
	@DataProvider(name = "userData")
	public Object[][] getData() {
		Object[][] credentials = { 
				{ "Secil", "Cam" }, 
				{ "Jason", "Robin" }, 
				{ "Hannah", "Brown" } 
				};
		return credentials;
	}

	@DataProvider(name="excelData")
	public Object[][] getExcelData(){
		Object [][] data = null;
		return data;
	}
}
