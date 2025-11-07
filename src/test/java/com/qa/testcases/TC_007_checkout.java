package com.qa.testcases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;
import com.qa.pageObjects.CheckoutPageObject;
import com.qa.pageObjects.LoginPageObject;
@Listeners(com.qa.reusableComponent.ListenersImplementation.class)
public class TC_007_checkout extends BaseClass{
	
	
	@Test(priority=1)
	public void test1() {
		loginPageObject=new LoginPageObject(driver);
		loginPageObject.LoginCredentials("suraiyabegum1@gmail.com", "Test@1234");
		loginPageObject.clicklogInButton();
		loginPageObject.accountVerify();
	}


	@Test(priority=2)
	public void checkout() throws InterruptedException {
		TC_006_AddToCart tc4=new TC_006_AddToCart();
		tc4.buySimpleComputer();
		checkoutPageObject=new CheckoutPageObject(driver);

		if (checkoutPageObject.verifySelectABillingAddressDropdownIsPresentOrNot()) {
			checkoutPageObject.clickBillingAddressContinue();
			Thread.sleep(2000);
			checkoutPageObject.clickShippingAddressContinue();
			Thread.sleep(2000);
			checkoutPageObject.clickShippingMethodContinue();
			Thread.sleep(2000);
			checkoutPageObject.clickPaymentMethodContinue();
			Thread.sleep(2000);
			checkoutPageObject.clickPaymentInformationContinue();
			Thread.sleep(2000);
			checkoutPageObject.clickConfirmOrderContinue();
			Thread.sleep(2000);
			checkoutPageObject.verfiyOrderSuccessfulMessage();
			Thread.sleep(2000);
			String orderNumber =checkoutPageObject.getOrderNumber();
			System.out.println(orderNumber);
			checkoutPageObject.lastContinueButton();
			loginPageObject.accountVerify();
		}
		else {
			//checkoutPageObject.printCountriesList();
			//checkoutPageObject.printUSStatesList();
			checkoutPageObject.selectCountryDropdown("United States");
			//checkoutPageObject.selectStateDropdown();
			Thread.sleep(3000);
			checkoutPageObject.selectUSStatesDropdown("Iowa");
			checkoutPageObject.enterCity("City Squares");
			checkoutPageObject.enterAddress1("4th cross Street");
			checkoutPageObject.enterAddress2("North Lane");
			checkoutPageObject.enterZipOrPostalCode("99873");
			checkoutPageObject.enterPhoneNumber("+1-7234983");
			checkoutPageObject.enterFaxNumber("8475345");

			checkoutPageObject.clickBillingAddressContinue();
			Thread.sleep(2000);
			checkoutPageObject.clickShippingAddressContinue();
			Thread.sleep(2000);
			checkoutPageObject.clickShippingMethodContinue();
			Thread.sleep(2000);
			checkoutPageObject.clickPaymentMethodContinue();
			Thread.sleep(2000);
			checkoutPageObject.clickPaymentInformationContinue();
			Thread.sleep(2000);
			checkoutPageObject.clickConfirmOrderContinue();
			Thread.sleep(2000);
			checkoutPageObject.verfiyOrderSuccessfulMessage();
			Thread.sleep(2000);
			String orderNumber =checkoutPageObject.getOrderNumber();
			System.out.println(orderNumber);	

		}}
}