package com.qa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;

public class AddToCartPageObject extends BaseClass  {
	
	public AddToCartPageObject(WebDriver driver) {
		PageFactory.initElements(driver,this);	
	}
	
	@FindBy(xpath="//form/div/div[1]/div[2]/div[6]/dl/dd[1]/ul/li/input")
	WebElement processor;
	
	@FindBy(xpath="//form/div/div[1]//div[2]/div[8]/div/input[@type='button']")
	WebElement addToCart_btn;
	
	@FindBy(xpath="//p[@class='content']//a")
	WebElement confirmTopMessage ;
	
	@FindBy(xpath="//span[text()='Shopping cart']")
	WebElement shoppingCartLink ;
	
	@FindBy(xpath="//input[@id='termsofservice']")
	WebElement termsOfService ;
	
	@FindBy(xpath="//button[@id='checkout']")
	WebElement checkout_btn ;
	
	
	public void selectProcessor() {
		processor.click();
	}
	
	public void clickAddToCart() {
		addToCart_btn.click();
	}
	
	public void isProductAddedToCartConfirmationTopMessage() {
		confirmTopMessage.isDisplayed();
		
	}
	public void goToPaymentPage() {
		shoppingCartLink.click();
	}
	
	public void selectTermsOfService() {
		termsOfService.click();
	}

	public void clickCheckout() {
		checkout_btn.click();
	}
}
