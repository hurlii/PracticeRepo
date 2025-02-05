package com.neotech.review01;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.neotech.utils.ExcelUtility;

public class DataDrivenTest {

	@BeforeMethod
	public void before() {
		System.out.println("*** Before the Test Method");
	}

	@Test(dataProvider = "data1")
	public void loginTest(String name, String company, String jobPosition) {
		System.out.println("--------------------------------");
		System.out.println(name + " - " + company);
		System.out.println("He/she works as -> " + jobPosition);
	}

	@DataProvider(name = "data2")
	public Object[][] createData() {

		Object[][] data = { 
				{ "Libia", "Facebook", "CFO" }, 
				{ "Yasmin", "Tesla", "CTO" },
				{ "Priya", "Google", "QA Lead" } 
		};

		return data;
	}

	@DataProvider(name = "data2")
	public Object[][] createFromExcel() {
		String filePath = System.getProperty("user.dir") + "/testdata/Employees.xlsx";
		String sheet = "Position";

		return ExcelUtility.excelIntoArray(filePath, sheet);
	}

}