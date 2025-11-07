package com.qa.reusableComponent;


import java.io.File;

public class FileOpeartions {

	public static void main(String[] args) {
		// File name specified
     
        File file=new File(System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\testdata.xlsx");
        System.out.println("File Created!");

	}

}
