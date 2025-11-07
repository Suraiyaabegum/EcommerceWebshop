package com.qa.testcases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import org.testng.TestNG;


import com.qa.base.BaseClass;

@Listeners(com.qa.reusableComponent.ListenersImplementation.class)
public class TC_001_linkTest extends BaseClass{
	
	@Test
	public void linkTest() {
		//TestNG test=new TestNG();
		//test.run();
		driver.get("http://demowebshop.tcentis.com");	
	}
}
