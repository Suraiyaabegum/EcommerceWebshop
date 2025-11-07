package com.qa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;

public class LoginPageObject extends BaseClass {

	public LoginPageObject(WebDriver driver) {
		PageFactory.initElements(driver,this );
	}

	@FindBy(xpath="//a[@class='ico-login']")
	WebElement loginButtonLink;

	@FindBy(xpath="//input[@id='Email']")
	WebElement email2_txtbox;

	@FindBy(xpath="//input[@id='Password']")
	WebElement password2_txtbox;

	@FindBy(xpath="//input[@class='button-1 login-button']")
	WebElement login_btn;

	@FindBy(xpath="(//a[@class='account'])[1]")
	WebElement accountLink;

	public void LoginCredentials(String id, String pass) {
		loginButtonLink.click();
		email2_txtbox.sendKeys(id);
		password2_txtbox.sendKeys(pass);
		
	}

	public void clicklogInButton()
	{
		login_btn.click();
	}
	
	public String accountVerify() {
		return accountLink.getText();		
	}
}
