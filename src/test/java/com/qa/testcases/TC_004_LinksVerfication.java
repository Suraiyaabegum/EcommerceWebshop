package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;
import com.qa.pageObjects.HomePageObject;

public class TC_004_LinksVerfication extends BaseClass  {

	

	@Ignore
	@Test(priority=1)
	public void test1() {
		TC_001_linkTest tc1=new TC_001_linkTest();
		tc1.linkTest();
	}  

	@Test(priority=2)
	public void test2() {
		homePageObject= new HomePageObject(driver);

		int expectedLinks=95;
		System.out.println("expected Links are :"+expectedLinks);

		int actualLinks=homePageObject.linksCount();
		System.out.println("actual Links are :"+actualLinks);

		Assert.assertEquals(actualLinks, expectedLinks);
	}

	@Test(priority=3)
	public void test3() {
		int displayLinks=homePageObject.displayLinks();
		System.out.println("The Display Links Counts are :"+displayLinks);
	}
}
