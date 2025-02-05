package com.neotech.lesson04;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;
import com.neotech.utils.ExcelUtility;

public class Homework1 extends CommonMethods {
	/*
	 * 
	 	Open chrome browser 
	 	Go to "https://hrm.neotechacademy.com/" 
	 	Login to the application Add 3 different Employees and Create Login Details by providing:
	 	First Name 
	 	Last Name 
	 	Username 
	 	Password 
	 	Verify Employee has been added successfully and take screenshot (you must have 3 different screenshots)
	 	Close the browser Specify a group for this test case, add it into specific suite and execute from the xml file.
	  
	 */
	
	@Test(dataProvider="excelData", groups = {"homework", "smoke"})
	public void addEmployee(String firstName, String lastName, String userName, String password)
	{
		// login
		sendText(driver.findElement(By.id("txtUsername")), ConfigsReader.getProperty("username"));
		sendText(driver.findElement(By.id("txtPassword")), ConfigsReader.getProperty("password"));
		
		click(driver.findElement(By.xpath("//button")));
		
		// go to add employee
		click(driver.findElement(By.id("menu_pim_viewPimModule")));
		click(driver.findElement(By.id("menu_pim_addEmployee")));
		
		//wait for the add employee form to be loaded
		waitForVisibility(By.id("first-name-box"));
		
		// enter new employee data
		sendText(driver.findElement(By.id("first-name-box")), firstName);
		sendText(driver.findElement(By.id("last-name-box")), lastName);
		
		// get the employee id to verify the employee added
		// we used firstName for assertion
		//String empId = driver.findElement(By.id("employeeId")).getDomProperty("value");
		
		selectDropdown(driver.findElement(By.id("location")), "Chinese Development Center");
		
		// activate and enter the login details
		click(driver.findElement(By.xpath("//div[@class='custom-control custom-switch']")));
		
		sendText(driver.findElement(By.id("username")), userName);
		sendText(driver.findElement(By.id("password")), password);
		sendText(driver.findElement(By.id("confirmPassword")), password);
		
		// save the employee details
		wait(2);
		click(driver.findElement(By.id("modal-save-button")));
		
		// verify employee details
		// make sure the employee details are visible/displayed
		waitForVisibility(By.id("firstName"));
		
		// Let's assert the actual employee firstName with expected employee firstName
		String actualFirstName = driver.findElement(By.id("firstName")).getDomProperty("value");
		Assert.assertEquals(actualFirstName, firstName, "Employee first name does not match!!");
		
		// take a screenshot
		
		// First way:
		// we do all step here
		/*
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		File source  = ts.getScreenshotAs(OutputType.FILE);
		
		try {
			Files.copy(source, new File("screenshots/"+firstName+"_"+lastName+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
		
		//OR -> more professional style --> we create a takeScreenshot() method in CommonMethods
		String fullName = firstName + "_" + lastName;
		takeScreenshot(fullName);
	}
	
	@DataProvider(name="getData")
	public Object[][] createData()
	{
		Object[][] data = { 
							{"Emp01", "L_Emp01", "employee01", "!emP0001"},
							{"Emp02", "L_Emp02", "employee02", "!emP0002"},
							{"Emp03", "L_Emp03", "employee03", "!emP0003"}
				
							};
		
		return data;
	}
	
	@DataProvider(name="excelData")
	public Object[][] getExcelData()
	{
		String filePath = System.getProperty("user.dir") + "/testdata/Excel.xlsx";
		
		String sheetName = "Employee";
		
		return ExcelUtility.excelIntoArray(filePath, sheetName);
	}
}
