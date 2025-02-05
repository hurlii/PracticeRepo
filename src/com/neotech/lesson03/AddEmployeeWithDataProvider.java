package com.neotech.lesson03;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.neotech.utils.CommonMethods;

public class AddEmployeeWithDataProvider extends CommonMethods {

	
	/*
 	--- Add 3 Employees with using DataProvider  ---
		Open chrome browser and navigate to Orange HRM website
		Login with valid credentials
		Navigate to addEmployee tab
		Add 3 different employees using data Provider 
 
 */
	
	@Test(dataProvider="employees")
	public void addEmployee(String firstName, String lastName)
	{
		//let us test if the DataProvider--Test connection is ok: 
		
		System.out.println(firstName + " " + lastName);
		
		//login
		
		
		//navigate to PIM menu
		
		
		//click on Add Employee
		
		
		// send employee details (name, lastName, select also a location) 
		
		
		//save employee
		
		
	}
	
	
	@DataProvider(name="employees")
	public Object[][] employeeData()
	{
		Object[][] data = {  {"John","Doe"}, {"Jane", "Doe"}};
		
		
		return data;
	}
	
	
}