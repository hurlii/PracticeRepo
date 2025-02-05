package com.neotech.review01;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependsOnMethod {

	@Test
	public void firstTest() {
		System.out.println("-> The first Test Method");

		Assert.assertEquals("a", "b"); // We are failing this test on purpose
	}

	@Test(dependsOnMethods = "firstTest")
	public void secondTest() {
		System.out.println("-> The second Test Method");
	}

	// The first Test will be executed
	// The first Test will fail
	// The second Test will be skipped
	// One test fails, one test is skipped

}