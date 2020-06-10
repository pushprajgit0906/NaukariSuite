package com.naukari.qa.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naukari.qa.base.TestBase;
import com.naukari.qa.pages.BrowseJobPage;
import com.naukari.qa.pages.HomePage;
import com.naukari.qa.pages.LoginPage;
import com.naukari.qa.pages.ProfilePage;

public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	ProfilePage profilePage;
	BrowseJobPage browseJobPage;
	
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup() {
		driver = initializtion();
		loginPage = new LoginPage();
		homePage = loginPage.Login(prop.getProperty("Username"), prop.getProperty("password"));
	}
	
	
	@Test(priority =1)
	public void verifyHomePageTitleTest() throws Exception {
		Thread.sleep(10000);
		String title =homePage.homePageTitle();
		Thread.sleep(4000);
		Assert.assertEquals(title, "Home | Mynaukri","HomePage not displayed");
	}
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	

}
