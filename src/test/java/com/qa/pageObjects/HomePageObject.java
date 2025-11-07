package com.qa.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;

public class HomePageObject extends BaseClass {

	public HomePageObject(WebDriver driver) {
		PageFactory.initElements(driver,this );
	}

	@FindBy(tagName="a")
	List<WebElement> links;
	
	@FindBy(xpath="//ul[@class='top-menu']/li")
	List<WebElement> mainElements;

	public int linksCount() {
		int totalLinks= links.size();
		System.out.println("Total no of Links :"+totalLinks);
		return totalLinks;
	}

	public int displayLinks() {
		int count=0;
		for (WebElement link : links) {
			if(link.isDisplayed()) {
				count++;
			}		
		}
		return  count;
	}

	public void verifyLinks() {
		for (WebElement element : links) {
			System.out.println(element.getText());
		}		
	}
	
	public int elementsCount() {
		int size=mainElements.size();
		return size;
	}
	
	public void validateText() {
		for(WebElement element: mainElements) {
			System.out.println(element.getText());
		}
	}
}