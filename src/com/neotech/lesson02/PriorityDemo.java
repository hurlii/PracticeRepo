package com.neotech.lesson02;

import org.testng.annotations.Test;

public class PriorityDemo {
	
	@Test(priority = 1)
	public void firstTest()
	{
		System.out.println("firstTest");
	}
	
	@Test(priority = 2)
	public void secondTest()
	{
		System.out.println("secondTest");
	}
	
	@Test
	public void thirdTest()
	{
		System.out.println("thirdTest");
	}
	
	@Test(priority = 10)
	public void forthTest()
	{
		System.out.println("forthTest");
	}

}
