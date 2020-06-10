package com.naukari.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.naukari.qa.base.TestBase;
import com.naukari.qa.pages.HomePage;
import com.naukari.qa.pages.LoginPage;
import com.naukari.qa.pages.ProfilePage;
import com.naukari.qa.util.TestUtil;

public class ProfilePageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	ProfilePage profilePage;
	
	
	public ProfilePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws Exception {
		driver =initializtion();
		loginPage = new LoginPage();
		homePage = loginPage.Login(prop.getProperty("Username"), prop.getProperty("password"));
		homePage = new HomePage();
		profilePage= homePage.navigateToProfilePage();
	}
	
	
	@Test(priority=1)
	public void verifyProfilePageTitleTest() throws Exception {
		Thread.sleep(5000);
		String title =profilePage.profilePageTitle();
		Assert.assertEquals(title, "Profile | Mynaukri","Profile page is not displayed");
	}
	
	/*	@DataProvider
	public Object[][] readTestData() {
		Object testData[][]= TestUtil.readTestData("BasicDetail");
		return testData;
	}
	
	@Test(priority =2,dataProvider = "readTestData")
	public void updateAndVerifyBasicDetail(String Name, String MobileNumber, String TelephoneCountryCode, 
			String TelephoneAreaCode,String TelephonePhoneNumber ) throws Exception {
		
		profilePage.ClickPencilImgForBasicInfo();
		profilePage.UpdateBasicDetails(Name,MobileNumber,TelephoneCountryCode,TelephoneAreaCode,TelephonePhoneNumber);
			//Assert.assertEquals(actual, expected);
	}*/
	
	
	//Create a test to Delete resume
	@Test(priority=2)
	public void deleteResumefromProfile() throws Exception {
		
		profilePage.ClickDELETERESUME();
		Thread.sleep(3000);
		String DeleteMsg = profilePage.DeleteResumeConfirmation();
		Assert.assertEquals(DeleteMsg, "Attached Resume has been successfully deleted.");
		
	}
	
	//Upload the resume from resources/Upload folder to profile
	@Test(priority=3)
	public void uploadResumeToProfile() throws Exception {
		String  filePath= System.getProperty("user.dir") + "/src/main/resources/FileToUpload/Pushp RajResume.docx";
		profilePage.uploadResumeFromPath(filePath);	
		Thread.sleep(6000);
	}
	
/*	// Update ResumeHeadline from resources/Upload/ResumeHEadline.txt
	@Test
	public void updateResumeHeadline() {
		
	}*/
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
