package com.neotech.lesson04;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//@Listeners(com.neotech.utils.Listener.class)
// instead of applying the Listeners to only this class, we can generalize it from xml
public class ListenerDemo {
	
	@BeforeMethod
	public void before()
	{
		System.out.println("Before Method!");
	}
	
	@AfterMethod
	public void after()
	{
		System.out.println("After Method!");
	}
	
	@Test
	public void test1()
	{
		System.out.println("This is test 1!");
		
		// pass this test
		Assert.assertTrue(true);
	}
	
	@Test
	public void test2()
	{
		System.out.println("This is test 2!");
		
		// fail this test
		Assert.assertTrue(false);
	}

}