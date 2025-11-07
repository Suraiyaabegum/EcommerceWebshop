package com.qa.base;

import org.openqa.selenium.WebDriver;

import com.qa.pageObjects.AddToCartPageObject;
import com.qa.pageObjects.CheckoutPageObject;
import com.qa.pageObjects.FeaturedProductsPageObject;
import com.qa.pageObjects.HomePageObject;
import com.qa.pageObjects.LoginPageObject;
import com.qa.pageObjects.RegistrationPageObject;

public class ObjectsRepo {
	public static WebDriver driver;
	public static LoginPageObject loginPageObject;
	public static RegistrationPageObject registrationPageObject;
	public static HomePageObject homePageObject;
	public static FeaturedProductsPageObject featuredProductsPageObject;
	public static AddToCartPageObject addToCartPage;
	public static CheckoutPageObject checkoutPageObject;
}
