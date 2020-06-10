package com.naukari.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naukari.qa.base.TestBase;

public class LoginPage extends TestBase{

	//Page Factory
	@FindBy(xpath="//input[@id='usernameField']")
	WebElement UserName;
	
	@FindBy(xpath="//input[@id='passwordField']")
	WebElement Password;
	
	@FindBy(xpath="//button[@class='waves-effect waves-light btn-large btn-block btn-bold blue-btn textTransform']")
	WebElement LoginButton;
	
	@FindBy(xpath="//a[@title='Search Jobs']//div[text()='Jobs']")
	WebElement JOBS_link;
	
	@FindBy(xpath="//a[@title='Advanced Search']")
	WebElement AdvanceSearch_sublink;
	
	@FindBy(xpath="//a[text()='Register for Free']")
	WebElement RegistrationForFree_lnk;
	
	@FindBy(xpath="//button[@class='action-btn fresh']")
	WebElement IamFresher_lnk;
	
	
	
	//initialize this page Object/ PAge Factory
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions:
	public String LoginPageTitle() {
		return driver.getTitle();
	}
	
	
	public HomePage Login(String UName, String Pwd) {
		UserName.sendKeys(UName);
		Password.sendKeys(Pwd);
		LoginButton.click();
		
		return new HomePage();
	}
	
	public void advanceSearchclick() {
		Actions action = new Actions(driver);
		action.moveToElement(JOBS_link).build().perform();
		AdvanceSearch_sublink.click();
		
	}
	
	public void FreeRegistrationClick() {
		RegistrationForFree_lnk.click();
		IamFresher_lnk.click();
	}	
	
	
	
}
