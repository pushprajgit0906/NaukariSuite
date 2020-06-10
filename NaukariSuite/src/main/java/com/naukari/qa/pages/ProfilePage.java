package com.naukari.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naukari.qa.base.TestBase;

public class ProfilePage extends TestBase{
	
	public ProfilePage() {
		PageFactory.initElements(driver, this);
	}
	
	//Page Factory
	@FindBy(xpath="//div[@class='hdn mb5']//em[@class='icon edit']")
	WebElement PencilImgForBasicInfo;
	
	@FindBy(xpath="//a[contains(text(),'DELETE RESUME')]")
	WebElement DeleteResumeLink;
	
	@FindBy(xpath="//p[text()='Are you sure you want to delete the Resume?']/following-sibling::div//button[text()='DELETE']")
	WebElement DeleteButtonFromConfirmBox;	
	
	@FindBy(xpath="//p[contains(text(),'Attached Resume has been successfully deleted.')]")
	WebElement DeleteResumeConfirmationMessage;
	
	
	@FindBy(xpath="//input[@id='attachCV']")
	WebElement UploadResumeButton;
	
	/*@FindBy(xpath="")
	WebElement UploadResumeConfirmationMessage*/
	
	
	//Action
	public String profilePageTitle() {
		return driver.getTitle();
	}
	
	public void ClickPencilImgForBasicInfo() {
		PencilImgForBasicInfo.click();
	}
	
	public void ClickDELETERESUME() throws InterruptedException{
		Thread.sleep(3000);
		DeleteResumeLink.click();
		Thread.sleep(3000);
		DeleteButtonFromConfirmBox.click();
	}
	
	public String DeleteResumeConfirmation() {
		 return DeleteResumeConfirmationMessage.getText();
	}
	
	public void uploadResumeFromPath(String fpath) throws Exception {
		Thread.sleep(3000);
		UploadResumeButton.sendKeys(fpath);
	}
	
	/*public String UploadResumeConfirmation() {
		return UploadResumeConfirmationMessage.getText();
	}*/

	
	
	
	
	
	
	
	
	
	
	
	
	
	// write a separate method to handle all the drop down and Radio button
	public void UpdateBasicDetails(String name, String mobileNumber, String telephoneCountryCode, String telephoneAreaCode, String telephonePhoneNumber) throws Exception {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='mob_number']")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='mob_number']")).sendKeys(mobileNumber);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='name']")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys(name);
		//driver.findElement(By.xpath("//input[@id='exp-years-droopeFor']")).sendKeys(" 16 Years ");
		//driver.findElement(By.xpath("//input[@id='salary-lakh-droopeFor']")).sendKeys(" 9 Lacs ");
		//driver.findElement(By.xpath("//input[@id='salary-thousand-droopeFor']")).sendKeys(" 85 Thousands ");
		//driver.findElement(By.xpath("//input[@id='locationSugg']")).clear();
		//driver.findElement(By.xpath("//input[@id='locationSugg']")).sendKeys("Bangalore/Bengaluru");
		
		driver.findElement(By.xpath("//input[@id='tel_cCode']")).clear();
		driver.findElement(By.xpath("//input[@id='tel_cCode']")).sendKeys(telephoneCountryCode);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='tel_aCode']")).clear();
		driver.findElement(By.xpath("//input[@id='tel_aCode']")).sendKeys(telephoneAreaCode);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='tel_pNumber']")).clear();
		driver.findElement(By.xpath("//input[@id='tel_pNumber']")).sendKeys(telephoneAreaCode);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='saveBasicDetailsBtn']")).click();
		
	}


	
	

}
