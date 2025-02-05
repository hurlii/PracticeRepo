package com.neotech.review01;

import org.testng.annotations.Test;

public class TestParameters {

	@Test(priority = 3)
	public void methodA() {
		System.out.println("-> Running Test Method A");
	}

	@Test(priority = 3, enabled = false)
	void methodB() {
		System.out.println("-> Running Test Method B");
	}

	@Test
	void methodC() {
		System.out.println("-> Running Test Method C");
	}

}