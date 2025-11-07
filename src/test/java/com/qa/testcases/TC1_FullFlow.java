package com.qa.testcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.pageObjects.AddToCartPageObject;
import com.qa.pageObjects.FeaturedProductsPageObject;
import com.qa.pageObjects.LoginPageObject;
import com.qa.pageObjects.RegistrationPageObject;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC1_FullFlow  {

	@Test
	public void fullFlow() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(100));
		driver.manage().window().maximize();
		driver.get("http://demowebshop.tricentis.com");	
		
		RegistrationPageObject registrationPageObject=new RegistrationPageObject(driver) ;
		registrationPageObject.registerUser("Suraiya", "begum", "surai23@gmail.com");
		registrationPageObject.userPassword("Test@1234", "Test@1234");
		registrationPageObject.register();	
		System.out.println("Te Account mail ID is "+registrationPageObject.user());
		
		LoginPageObject loginPageObject=new LoginPageObject(driver);
		loginPageObject.LoginCredentials("surai23@gmail.com", "Test@1234");
		loginPageObject.clicklogInButton();
		loginPageObject.accountVerify();
		
		FeaturedProductsPageObject featuredProductsPageObject= new FeaturedProductsPageObject(driver);
		featuredProductsPageObject.totalFeaturedProductsCount();
		featuredProductsPageObject.getFeaturedProductsText();
		featuredProductsPageObject.addSimpleComputerToCart();
		
		AddToCartPageObject addToCartPage=new AddToCartPageObject(driver);
		Thread.sleep(2000);
		addToCartPage.selectProcessor();
		addToCartPage.clickAddToCart();
		Thread.sleep(2000);
		addToCartPage.isProductAddedToCartConfirmationTopMessage();
		Thread.sleep(3000);
		addToCartPage.goToPaymentPage();
		addToCartPage.selectTermsOfService();
		addToCartPage.clickCheckout();	
		
		driver.close();
		driver.quit();		
	}
}
