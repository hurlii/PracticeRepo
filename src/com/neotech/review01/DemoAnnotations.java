package com.neotech.review01;

import org.testng.annotations.*;

public class DemoAnnotations {

	@Test
	public void test1() {
		System.out.println("-> Review Test1");
	}

	@Test
	public void test2() {
		System.out.println("-> Review Test2");
	}

	@BeforeMethod
	public void beforeM() {
		System.out.println("Just before the Test Method");
	}

	@AfterMethod
	public void afterM() {
		System.out.println("Just after the Test Method");
	}

	@BeforeTest
	public void beforeT() {
		System.out.println("Just before the Functionality Test");
	}

	@AfterTest
	public void afterT() {
		System.out.println("Just after the Functionality Test");
	}

}
//@BeforeTest
//
//@BeforeMethod
//test1()
//@AfterMethod
//
//@BeforeMethod
//test2()
//@AfterMethod
//
//@AfterTest