package com.qa.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;
import com.qa.pageObjects.LoginPageObject;

public class TC2_LoginUsingDataProviderMethod extends BaseClass {

	@Test(dataProvider="testdata")
	public void loginUsingDataFromExcel(String email, String password) {
		LoginPageObject loginPageObject=new LoginPageObject(driver);
		loginPageObject.LoginCredentials(email, password);
		loginPageObject.clicklogInButton();
	}

	@DataProvider(name="testdata")
	public Object[][] tdata(){
		return new Object[][]	{
			{"suraiyabum400@gmail.com", "Hap@2024"},
			{"suraabegum400@gmail.com", "Happy@24"},
			{"saiyabegum400@gmail.com", "Happy@20"},
			{"suraiyabegum11@gmail.com","Test@1234"}

		};
	}
}
