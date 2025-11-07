package com.qa.testcases;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.pageObjects.AddToCartPageObject;
import com.qa.pageObjects.FeaturedProductsPageObject;
import com.qa.pageObjects.LoginPageObject;
import com.qa.pageObjects.RegistrationPageObject;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestingSeleniumGridTest  {

    private static final String SITE="http://demowebshop.tricentis.com";

    private WebDriver driver;
    
    public RegistrationPageObject registrationPageObject;

    @Parameters("browser")
    @BeforeTest
    public void setUp(String browser) throws MalformedURLException{
        DesiredCapabilities desiredCapabilities= new DesiredCapabilities();

        switch(browser.toLowerCase()){
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");
                desiredCapabilities.setBrowserName("chrome");
                desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--headless");
                desiredCapabilities.setBrowserName("firefox");
                desiredCapabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, firefoxOptions);
            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--headless");
                desiredCapabilities.setBrowserName("edge");
                desiredCapabilities.setCapability(EdgeOptions.CAPABILITY, edgeOptions);
            default:
                System.out.println("No Browser Found");
        }


        String seleniumGridURL = "http://192.168.1.14:4444";
        driver= new RemoteWebDriver(new URL(seleniumGridURL),desiredCapabilities);
        driver.manage().window().maximize();
        
         registrationPageObject=new RegistrationPageObject(driver) ;
        
        driver.get(SITE);
    }

    @Test
    public void fullFlow() throws InterruptedException {
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