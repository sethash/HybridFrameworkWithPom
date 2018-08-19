package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement ContactsLabel;
	
	@FindBy(xpath="//input[@id='first_name']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@id='surname']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@name='client_lookup']")
	WebElement companyName;
	
	@FindBy(xpath="//input[@type='submit' and @value ='Save']")
	WebElement saveBtn;
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);	
	}
	
	public boolean verifyContactsLabel()
	{
		return ContactsLabel.isDisplayed();
	}
	public void selectContactByName(String name) {
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td//preceding-sibling::td[@class='datalistrow']//input[@type='checkbox']"));
	}
	
	public void createNewContct(String title,String ftName, String ltName, String comp)
	{
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		companyName.sendKeys(comp);
		saveBtn.click();
		
	}
	
}
