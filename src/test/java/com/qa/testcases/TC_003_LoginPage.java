package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import com.qa.base.BaseClass;
import com.qa.pageObjects.LoginPageObject;

public class TC_003_LoginPage extends BaseClass{
	
	TC_002_RegisterPage tc2=new TC_002_RegisterPage();
	String newEmailID=tc2.newEmailID;
	
	@Ignore
 	@Test(priority=1)
	public void test1() {
		TC_001_linkTest tc1=new TC_001_linkTest();
		tc1.linkTest();
	}  

	@Test(priority=2)
	public void test2() {
		loginPageObject=new LoginPageObject(driver);
		loginPageObject.LoginCredentials(newEmailID,"Test@1234");
		loginPageObject.clicklogInButton();		
	}
	
	@Test(priority=3)
	public void test3() {
		String actualUserID=loginPageObject.accountVerify();
		System.out.println("Actual Email ID is :"+actualUserID);
		String expectedUserID=newEmailID;
		System.out.println("expected Email ID is :"+expectedUserID);
		Assert.assertEquals(actualUserID, expectedUserID);
	}
}