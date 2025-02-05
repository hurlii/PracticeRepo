package com.neotech.review01;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAndHardAssert {

	@Test
	public void testHardAssert() {

		System.out.println("Step1");
		System.out.println("Step2");
		System.out.println("Step3");

		String expectedAccount = "Jacqueline";
		String actualAccount = "Aaron";

		Assert.assertEquals(actualAccount, expectedAccount, "The account is wrong!");

		// After Hard Assert fails, the Test Method will stop executing

		System.out.println("Step4");
	}

	@Test
	public void testSoftAssert() {

		SoftAssert soft = new SoftAssert();

		System.out.println("Step1");

		String expectedGOAT = "Ronaldo";
		String actualGOAT = "Messi";

		soft.assertEquals(actualGOAT, expectedGOAT); // This assertion will fail

		System.out.println("Step2");

		soft.assertTrue(true); // This assertion will pass

		System.out.println("Step3");

		// This assertAll() method will collect all soft assertions
		// And will decide if the Test Method will pass or fail
		// If all assertions pass, the test will pass
		// If one of the assertions fails, the test will fail
		soft.assertAll();

		System.out.println("Step4");
		
	}

}