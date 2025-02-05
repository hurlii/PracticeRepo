package com.neotech.lesson03;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.neotech.utils.CommonMethods;

public class DataProviderDemo extends CommonMethods {

	//We added @BeforeMethod and @AfterMethod in BaseClass at the top of setUp() and tearDown().
	//They already apply since we are inheriting them 
	
	
	@Test(dataProvider="userData")
	public void loginFunctionality(String username, String password)
	{
		//send username
		sendText(driver.findElement(By.id("txtUsername")), username);
		//send password
		sendText(driver.findElement(By.id("txtPassword")), password);
		
		//click on login
		click(driver.findElement(By.xpath("//button")));
	}
	

	
	@DataProvider(name="userData")
	public Object[][] getData()
	{
		//this is what I want to send as data: 
	
		//1st test: Admin, Admin123 -->  {"Admin", "Admin123"}
		//2nd test: John, John123	-->  {"John", "John123"}
		//3rd test: Jane, Jane123   -->  {"Jane", "Jane123"}
		
		Object[][] credentials = {
									{"Admin", "Admin123"}, 
									{"John", "John123"},
									{"Jane", "Jane123"}
								  };
		
		
		
		
		return credentials;
	}
	
	
	
}
