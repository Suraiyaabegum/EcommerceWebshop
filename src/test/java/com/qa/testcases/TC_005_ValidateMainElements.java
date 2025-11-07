package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;
import com.qa.pageObjects.HomePageObject;

public class TC_005_ValidateMainElements extends BaseClass {

	@Test(priority=2)
	public void test2() {
		homePageObject= new HomePageObject(driver);
		homePageObject.validateText();
	}


	@Test(priority=3)
	public void test3() {
		int expect=7;
		int actual=homePageObject.elementsCount();
		Assert.assertEquals(actual, expect);
	}
}