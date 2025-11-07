package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;
import com.qa.pageObjects.RegistrationPageObject;

public class TC_002_RegisterPage extends BaseClass {
	
	String newEmailID="suraiyabem11@gmail.com";
	
	@Ignore
	@Test(priority=1)
	public void test1() {
		TC_001_linkTest tc1=new TC_001_linkTest();
		tc1.linkTest();
	}

	
	@Test(priority=2)
	public void test2() {
		registrationPageObject=new RegistrationPageObject(driver) ;
		registrationPageObject.registerUser("Suraiya", "begum", newEmailID);
		registrationPageObject.userPassword("Test@1234", "Test@1234");
		registrationPageObject.register();
	}

	@Test(priority=3)
	public void testUserVerify() {
		String actualUser=registrationPageObject.user();
		System.out.println("Actual User is : "+actualUser);
		String expectedUser=newEmailID;
		System.out.println("Expected User is : "+expectedUser);
		Assert.assertEquals(actualUser, expectedUser);
	}
}
