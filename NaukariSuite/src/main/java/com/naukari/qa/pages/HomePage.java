package com.naukari.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naukari.qa.base.TestBase;

public class HomePage extends TestBase{
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	//Page Factory
	
	@FindBy(xpath="//a[@class=\"fl nLogo\"]")
	WebElement HomePageLogo;
	
	@FindBy(xpath="//a[@title='Search Jobs']")
	WebElement JobsMenu;
	
	@FindBy(xpath="//a[@title='Search Recruiters']")
	WebElement RecruitersMenu;
	
	@FindBy(xpath="//div[@class='personal-info col s12 center']//div[@class='user-name roboto-bold-text']")
	WebElement PictureImage;
	

		
	//Action
	public String homePageTitle() {
		return driver.getTitle();
	}
	
	public ProfilePage navigateToProfilePage() throws Exception {
		Thread.sleep(3000);
		PictureImage.click();
		return new ProfilePage();
	}
	

	public void clickOnJobsMenu() {
		JobsMenu.click();
	}
	
	public void UpdateBasicDetails() {
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("PUSHP RAJ");
		//driver.findElement(By.xpath("//label[@class='radio-lbl']")
		driver.findElement(By.xpath("//input[@id='exp-years-droopeFor']")).sendKeys("9 Years");
		driver.findElement(By.xpath("//input[@id='salary-lakh-droopeFor']")).sendKeys("7 Lacs");
		driver.findElement(By.xpath("//input[@id='salary-thousand-droopeFor']")).sendKeys("33 Thousands");
		
		//driver.findElement(By.xpath("//label[@class='radio-lbl']"))
		
		driver.findElement(By.xpath("//input[@id='locationSugg']")).sendKeys("Bengaluru / Bangalore");
		driver.findElement(By.xpath("//input[@id='mob_number']")).sendKeys("8409959851");
		driver.findElement(By.xpath("//input[@id='tel_cCode']")).sendKeys("+91");
		driver.findElement(By.xpath("//input[@id='tel_aCode']")).sendKeys("0651");
		driver.findElement(By.xpath("//input[@id='tel_pNumber']")).sendKeys("404241");
		driver.findElement(By.xpath("//button[@id='saveBasicDetailsBtn']")).click();
		
	}

}
