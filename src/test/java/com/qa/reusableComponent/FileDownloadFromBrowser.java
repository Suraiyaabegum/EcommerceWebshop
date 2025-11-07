package com.qa.reusableComponent;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileDownloadFromBrowser {

	public static void main(String[] args) {
		WebDriver driver=null;
      String fileLocation= System.getProperty("user.dir")+ ".\\Download";
      
      // we have to create a bopwser setting, so we use Hashmap
      
      HashMap preferences= new HashMap();
      preferences.put("download.default-directory", fileLocation);
      ChromeOptions  chromeOptions = new ChromeOptions();
      chromeOptions.setExperimentalOption("prefs",preferences);
      
      WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver(chromeOptions);
      
		/*
		 * driver.get(""); driver.manage().window().maximize();
		 * driver.findElement(By.xpath("")).click(); driver.close();
		 */
      
		/* For Edge: */
    
      preferences.put("plugins.always.open_pdf_externally", chromeOptions);
      preferences.put("download.default-directory", fileLocation);
      EdgeOptions  edgeOptions = new EdgeOptions();
      edgeOptions.setExperimentalOption("prefs",preferences);
      WebDriverManager.edgedriver().setup();
       driver = new EdgeDriver(edgeOptions);
	}

}
