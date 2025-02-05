package com.neotech.lesson02;

import org.testng.annotations.Test;

public class DependsDemo {
	
	@Test
	public void firstTest() throws Exception
	{
		System.out.println("firstTest");
		//throw new Exception();
	}
	
	@Test
	public void secondTest()
	{
		System.out.println("secondTest");
	}
	
	@Test(dependsOnMethods = {"firstTest", "secondTest"})
	public void thirdTest() throws Exception
	{
		System.out.println("thirdTest");
		throw new Exception();
	}
	
	@Test(dependsOnMethods = "thirdTest")
	public void forthTest()
	{
		System.out.println("forthTest");
	}


}