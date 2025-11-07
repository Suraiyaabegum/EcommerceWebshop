package com.qa.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.BaseClass;

public class CheckoutPageObject extends BaseClass {

	public CheckoutPageObject(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//label[@for='billing-address-select']")
	WebElement selectABillingAddress_drp;

	@FindBy(xpath="//select[@id ='BillingNewAddress_CountryId']")
	WebElement country_drp;

	@FindBy(xpath="//select[@id ='BillingNewAddress_StateProvinceId']")
	WebElement us_state_drp;

	@FindBy(xpath="//select[@id ='BillingNewAddress_StateProvinceId']")
	WebElement state_drp;

	@FindBy(xpath="//input[@id ='BillingNewAddress_City']")
	WebElement city_txtbox;

	@FindBy(xpath="//input[@id ='BillingNewAddress_Address1']")
	WebElement address1_txtbox;

	@FindBy(xpath="//input[@id ='BillingNewAddress_Address2']")
	WebElement address2_txtbox;

	@FindBy(xpath="//input[@id ='BillingNewAddress_ZipPostalCode']")
	WebElement zipPostalCode_txtbox;

	@FindBy(xpath="//input[@id ='BillingNewAddress_PhoneNumber']")
	WebElement PhoneNumber_txtbox;

	@FindBy(xpath="//input[@id ='BillingNewAddress_FaxNumber']")
	WebElement faxNumber_txtbox;
	
	@FindBy(xpath="//ol/li/div[2]/div[@id='billing-buttons-container']/input")
	WebElement billingAddress_continue_btn;
	
	@FindBy(xpath="//div[@id='shipping-buttons-container']/input")
	WebElement shippingAddress_continue_btn;
	
	@FindBy(xpath="//div[@id='shipping-method-buttons-container']/input")
	WebElement shippingMethod_continue_btn;
	
	@FindBy(xpath="//div[@id='payment-method-buttons-container']/input")
	WebElement paymentMethod_continue_btn;
	
	@FindBy(xpath="//div[@id='payment-info-buttons-container']/input")
	WebElement paymentInformation_continue_btn;

	@FindBy(xpath="//div[@id='confirm-order-buttons-container']/input")
	WebElement confirmOrder_continue_btn;
	
	@FindBy(xpath="//div[@class='title']/strong[text()='Your order has been successfully processed!']")
	WebElement orderSuccessful_msg;
	
	@FindBy(xpath="//ul[@class='details']/li[1]")
	WebElement OrderNumber;
	
	@FindBy(xpath="//div[@class='buttons']/input")
	WebElement lastContinue_btn;
	
	public boolean verifySelectABillingAddressDropdownIsPresentOrNot() {
		return selectABillingAddress_drp.isDisplayed();
	}
	
	public void printCountriesList() {
		Select dropCountry=new Select(country_drp);
		List<WebElement> countriesList=dropCountry.getOptions();
		for (WebElement country : countriesList) {
			System.out.println("The value is :"+country.getText());
		}}

	public void printUSStatesList() {
		Select USdropCountry=new Select(us_state_drp);
		List<WebElement> UScountriesList=USdropCountry.getOptions();
		for (WebElement UScountry : UScountriesList) {
			System.out.println("The value is :"+UScountry.getText());
		}}

	public void selectCountryDropdown(String key) {
		Select drpCountry=new Select(country_drp);
		List<WebElement> countriesList=drpCountry.getOptions();
		for (WebElement country : countriesList) {
			if(country.getText().equals(key)) {
				country.click();
				break;
			}}}

	public void selectStateDropdown() {
		Select drpstate=new Select(state_drp);
		drpstate.selectByVisibleText("Other (Non US)");
	}

	public void selectUSStatesDropdown(String key) {
		Select USdrpState=new Select(us_state_drp);
		List<WebElement> USStateList=USdrpState.getOptions();
		for (WebElement state : USStateList) {
			if(state.getText().equals(key)) {
				state.click();
				break;
			}}}

	public void enterCity(String key) {
		city_txtbox.sendKeys(key);
	}

	public void enterAddress1(String key) {
		address1_txtbox.sendKeys(key);
	}

	public void enterAddress2(String key) {
		address2_txtbox.sendKeys(key);
	}

	public void enterZipOrPostalCode(String key) {
		zipPostalCode_txtbox.sendKeys(key);
	}

	public void enterPhoneNumber(String key) {
		PhoneNumber_txtbox.sendKeys(key);
	}

	public void enterFaxNumber(String key) {
		faxNumber_txtbox.sendKeys(key);
	}

	public void clickBillingAddressContinue() {
		billingAddress_continue_btn.click();
	}
	
	public void clickShippingAddressContinue() {
		shippingAddress_continue_btn.click();
	}
	
	public void clickShippingMethodContinue() {
		shippingMethod_continue_btn.click();
	}
	
	public void clickPaymentMethodContinue() {
		paymentMethod_continue_btn.click();
	}
	
	public void clickPaymentInformationContinue() {
		paymentInformation_continue_btn.click();
	}
	
	public void clickConfirmOrderContinue() {
		confirmOrder_continue_btn.click();
	}
	public void verfiyOrderSuccessfulMessage() {
		orderSuccessful_msg.isDisplayed();
	}
	
	public String getOrderNumber() {
		return OrderNumber.getText();
	}
	
	public void lastContinueButton() {
		lastContinue_btn.click();
	}
	
	public void closeAlert() {
		driver.switchTo().alert().dismiss();		
	}
	
	
	}