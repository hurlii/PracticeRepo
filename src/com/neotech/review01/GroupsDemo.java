package com.neotech.review01;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GroupsDemo {

	@Test(groups = "smoke")
	public void smokeTest() {
		System.out.println("-> Smoke Test");
	}

	@Test(groups = { "smoke", "regression" })
	public void generalTest() {
		System.out.println("-> General Test");
	}

	@BeforeMethod(alwaysRun = true)
	public void beforeTestMethod() {
		System.out.println("Just before test method!");
	}

}