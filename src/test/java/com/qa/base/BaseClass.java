package com.qa.base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.qa.reusableComponent.PropertiesOperations;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass extends ObjectsRepo {

	//public static WebDriver driver; // public is used so it can be accessed in another package. static is used as it should not change
	
	@BeforeClass
	public void setup() throws IOException {
		PropertiesOperations propertiesOperations=new PropertiesOperations();
		String browser=propertiesOperations.getPropertyByValue("browser");
		String url=propertiesOperations.getPropertyByValue("url");
		System.out.println("the Value of the Broswer is :"+browser);
		
		//ChromeOptions options=new ChromeOptions();
		//options.addArguments("--disable-notifications");
	
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("MSedge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else if (browser.equalsIgnoreCase("safari")) {
			WebDriverManager.safaridriver().setup();
			driver=new SafariDriver();
		}
		else if (browser.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(100));
		driver.manage().window().maximize();
		driver.get(url);	
		}				
	
	@AfterClass
	public void teardown() {
		driver.close();
		driver.quit();
	}
}