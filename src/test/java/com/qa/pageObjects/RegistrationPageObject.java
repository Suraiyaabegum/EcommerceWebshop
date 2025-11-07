package com.qa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;

public class RegistrationPageObject extends BaseClass {

	public RegistrationPageObject(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="//a[@class='ico-register']")
	WebElement registerButtonLink;

	@FindBy(xpath="	//input[@id='gender-female']")
	WebElement genderRadioButton;

	@FindBy(xpath="//input[@id='FirstName']")
	WebElement firstName_txtbox;

	@FindBy(xpath="//input[@id='LastName']")
	WebElement lastName_txtbox;

	@FindBy(xpath="//input[@id='Email']")
	WebElement email1_txtbox;

	@FindBy(xpath="//input[@id='Password']")
	WebElement password1_txtbox;

	@FindBy(xpath="//input[@id='ConfirmPassword']")
	WebElement confirmPassword_txtbox;

	@FindBy(xpath="//input[@id='register-button']")
	WebElement confirmRegister_btn;
	
	@FindBy(xpath="(//a[@class='account'])[1]")
	WebElement accountLink;

	@FindBy(xpath="//input[@value='Continue']")
	WebElement continueButton;


	public void registerUser(String first, String last, String mailID) {
		registerButtonLink.click();
		genderRadioButton.click();
		firstName_txtbox.sendKeys(first);
		lastName_txtbox.sendKeys(last);
		email1_txtbox.sendKeys(mailID);	
	}

	public void userPassword(String pw, String confirmpassword) {
		password1_txtbox.sendKeys(pw);
		confirmPassword_txtbox.sendKeys(confirmpassword);
	}

	public void register() {
		confirmRegister_btn.click();
	}

	public String user() {
		return accountLink.getText();
	}
}