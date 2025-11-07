package com.qa.reusableComponent;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

public class PropertiesOperations {
 
	Properties prop=new Properties();

	public String getPropertyByValue(String key) throws IOException {
		
		String configPropertiesPath=System.getProperty("user.dir")+"\\src\\test\\resources\\testData\\config.properties";
		FileInputStream fs=new FileInputStream(configPropertiesPath);
		prop.load(fs);

		String value=prop.get(key).toString();
		if(StringUtils.isEmpty(value)) {
			System.out.println("The Value of the given key is Empty/null"+value);
		}
		return value;	 	
	}
}