package com.qa.pageObjects;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;


public class FeaturedProductsPageObject extends BaseClass {

	public FeaturedProductsPageObject(WebDriver driver) {
		PageFactory.initElements(driver,this );
	}

	@FindBy(xpath="//div[@class='add-info']//input[@type='button']")
	List<WebElement> featuredProductLists;

	@FindBy(xpath="//div[@data-productid='2']")
	WebElement virtualGiftCard;	

	@FindBy(xpath="//div[@data-productid='31']")
	WebElement laptop;

	@FindBy(xpath="//div[@data-productid='72']")
	WebElement cheapComputer;

	@FindBy(xpath="//div[@data-productid='16']")
	WebElement ownComputer;

	@FindBy(xpath="//div[@data-productid='74']")
	WebElement expensiveComputer;

	@FindBy(xpath="//div[@data-productid='75']//div[2]//div[3]//div[2]//input")
	WebElement simpleComputer;	


	public int totalFeaturedProductsCount() {
		int count=0;
		for(WebElement ele: featuredProductLists) {
			if(ele.isDisplayed()) {
				count++;			
			}	}		
		return count;		
	}

	public void getFeaturedProductsText() {	
		for(WebElement ele1: featuredProductLists) {
			System.out.println(ele1.getText());			
		}				
	}

	public void addVirtualGiftCardToCart() {
		virtualGiftCard.click();		
	}

	public void addLaptopToCart() {
		laptop.click();		
	}

	public void addCheapComputerToCart() {
		cheapComputer.click();		
	}

	public void addOwnComputerToCart() {
		ownComputer.click();		
	}

	public void addExpensiveComputeroCart() {
		expensiveComputer.click();		
	}
	public void addSimpleComputerToCart() {
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click()", simpleComputer);
		simpleComputer.click();
	}
}
