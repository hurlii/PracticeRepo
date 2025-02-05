package com.neotech.review01;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//@Listeners(com.neotech.utils.Listener.class)
public class UsingListener {

	@BeforeMethod
	public void before() {
		System.out.println("Before");
	}

	@AfterMethod
	public void after() {
		System.out.println("After");
	}

	@Test
	public void testMethod1() {
		System.out.println("-> testMethod1");

		Assert.assertTrue(false); // Test is failing
	}

	@Test
	public void testMethod2() {
		System.out.println("-> testMethod2");

		Assert.assertEquals("Denise", "Denise"); // Test is passing
	}

}

//onStart (ONE TIME) - At the Beginning
//
////////////////////////////////
//
//@BeforeMethod
//
//onTestStart()
//testMethod1()
//onTestFailure()
//
//@AfterMethod
//
////////////////////////////////
//
//@BeforeMethod
//
//onTestStart()
//testMethod2()
//onTestSuccess()
//
//@AfterMethod
//
////////////////////////////////
//
//onFinish (ONE TIME) - At the End