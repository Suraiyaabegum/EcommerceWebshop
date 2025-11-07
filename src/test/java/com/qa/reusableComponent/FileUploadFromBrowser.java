package com.qa.reusableComponent;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploadFromBrowser {

	public static void main(String[] args) throws AWTException {
		/* Way 1: using sendKeys() */
		/* if you have a attribute type-file in HTML tag, then sendKeys() can be used */
		
		 WebDriverManager.chromedriver().setup();
	     WebDriver driver = new ChromeDriver();
	     driver.findElement(By.xpath("inout[id='file-upload']")).sendKeys("C:\\SeleniumPractice\\sample.pdf");
	     
	     /* Way 2: using Robot Class */
	     Robot robot= new Robot();
	     robot.delay(1000);
	     StringSelection stringSelection = new StringSelection("C:\\SeleniumPractice\\sample.pdf");
	     Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null); // File Will be copied to the clipboard
	     
	     robot.keyPress(KeyEvent.VK_CONTROL); //CTRL+V
	     robot.keyPress(KeyEvent.VK_V);
	     robot.keyRelease(KeyEvent.VK_CONTROL);
	     robot.keyRelease(KeyEvent.VK_V);
	     
	     robot.keyPress(KeyEvent.VK_ENTER);
	     robot.keyRelease(KeyEvent.VK_ENTER);
	      
	}
}