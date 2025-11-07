package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;
import com.qa.pageObjects.AddToCartPageObject;
import com.qa.pageObjects.FeaturedProductsPageObject;
import com.qa.pageObjects.LoginPageObject;


public class TC_006_AddToCart extends BaseClass {
		
	@Test(priority=1)
	public void test1() {
		LoginPageObject lp=new LoginPageObject(driver);
		lp.LoginCredentials("surai23@gmail.com", "Test@1234");
		lp.clicklogInButton();
		lp.accountVerify();
	}
	
	@Test(priority=2)
	public void test2() {
		featuredProductsPageObject= new FeaturedProductsPageObject(driver);
		int actualtotalFeaturedProductsCount=featuredProductsPageObject.totalFeaturedProductsCount();
		System.out.println("actualtotalFeaturedProductsCount is :"+actualtotalFeaturedProductsCount);
		
		int expectedtotalFeaturedProductsCount=6;
		System.out.println("expectedtotalFeaturedProductsCount is :"+expectedtotalFeaturedProductsCount);
		
		Assert.assertEquals(actualtotalFeaturedProductsCount, expectedtotalFeaturedProductsCount);
		
		featuredProductsPageObject.getFeaturedProductsText();
	}  
	
	@Test(priority=3)
	public void buySimpleComputer() throws InterruptedException {
		featuredProductsPageObject= new FeaturedProductsPageObject(driver);
		Thread.sleep(2000);
		featuredProductsPageObject.addSimpleComputerToCart();
		addToCartPage= new AddToCartPageObject(driver);
		Thread.sleep(2000);
		addToCartPage.selectProcessor();
		Thread.sleep(2000);
		addToCartPage.clickAddToCart();
		Thread.sleep(2000);
		addToCartPage.isProductAddedToCartConfirmationTopMessage();
		Thread.sleep(2000);
		addToCartPage.goToPaymentPage();
		addToCartPage.selectTermsOfService();
		addToCartPage.clickCheckout();	
	}	
}