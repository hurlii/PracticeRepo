package com.neotech.lesson01;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGMoreAnnotations {

	@Test
	public void testOne()
	{
		System.out.println("Test case 1...");
	}
	
	@Test
	public void testTwo()
	{
		System.out.println("Test case 2...");
	}
	
	@AfterClass
	public void afterClass()
	{
		System.out.println("After Class!");
	}
	
	@BeforeClass
	public void beforeClass()
	{
		System.out.println("Before Class!");
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("Before Method!");
	}
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("After Method!");
	}
	
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("Before Test!");
	}
	
	@AfterTest
	public void afterTest()
	{
		System.out.println("After Test!");
	}
	
	/*
	 
	 BeforeTest ---> it does not mean before the test method. It means before every Test (as in Batch) 
	 
	 
	 Suite   -  a complete suite of tests (we are not using BeforeSuite) 
	 	TEST BATCH (BeforeTest)
	 		BeforeClass
	 			BeforeMethod
	 				Test1
	 			AfterMethod 
	 			BeforeMethod
	 				Test2
	 			AfterMethod
	 		AfterClass
	 		BeforeClass
	 			BeforeMethod
	 				Test3
	 			AfterMethod
	 		AfterClass
	 		
	 		
	 	AfterTest
	 AfterSuite (if any)
	 
	 */
}