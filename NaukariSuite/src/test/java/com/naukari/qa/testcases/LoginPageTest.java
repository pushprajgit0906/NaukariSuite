package com.naukari.qa.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naukari.qa.base.TestBase;
import com.naukari.qa.pages.HomePage;
import com.naukari.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	
	// this constructor will firstly call the TestBase constructor  and initialize the properties
	public LoginPageTest(){
		super();
	}
		
	@BeforeMethod
	public void setup() {
		driver = initializtion();
		loginPage = new LoginPage();
	}
	
	@Test
	public void LoginPageTitleTest() {
		String title = loginPage.LoginPageTitle();
		Assert.assertEquals(title,"Jobseeker's Login: Search the Best Jobs available in India & Abroad - Naukri.com","Login Page not displayed");
		
	}
	
	@Test
	public void LoginTest() {
		homePage = loginPage.Login(prop.getProperty("Username"), prop.getProperty("password"));
	}

		
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
