package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class browserLaunch {
	
	public static void main(String[] args) {
		

		
		System.out.println("first Program"); 
		//Create object for Chrome browser   		
		System.setProperty("webdriver.chrome.driver", "D:/selenium-Workspace/NaukariSuite/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver(); 	
		driver.get("https://www.google.com/intl/en-GB/gmail/about/");	
		String str = driver.getTitle(); 
		System.out.println("The title of the page is  " + str); 
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 		 
		driver.quit();
	
	}

}
