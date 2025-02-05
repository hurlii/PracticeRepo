package com.neotech.lesson01;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAnnotations {

	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("This method runs before the test methods!!!");
	}
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("This method runs after the test methods!!!");
	}
	
	@Test
	public void test1()
	{
		System.out.println("This is test 1!!!");
	}
	
	@Test
	public void test2()
	{
		System.out.println("This is test 2!!!");
	}
	
	@Test
	public void test3()
	{
		System.out.println("This is test 3!!!");
	}
	
	/*
	What do you think the execution order of these methods is: 
	
	WRONG ASSUMPTION!!!

	BeforeMethod
		test1()
		test2()
	AfterMethod
	
	CORRECT ORDER:
	
	BeforeMethod
		test1()
	AfterMethod
	BeforeMethod
		test2()
	AfterMethod
	
	
	
	
	
	*/
}