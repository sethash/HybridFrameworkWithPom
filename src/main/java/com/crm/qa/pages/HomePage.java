package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath="//td[contains(text(),'User: ashish sethi')]")
	@CacheLookup //it is used to cache the data , to make the script fast , in this case script will not look for xpath rather it will check in the cache.
	WebElement userNamelabel;
	
	@FindBy(xpath = "//a[text()='New Contact']")
	WebElement newContactLink;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	//Initialisation the page objects
	public HomePage()
	{
		PageFactory.initElements(driver, this);	
	}
	
	//Actions
	public String verifyHomePageTitle()
	{
		return driver.getTitle();
	}
	public ContactsPage clickOnContactsLink()
{
		contactsLink.click();
		return new ContactsPage();
		
}
	
	public DealsPage clickOnDealsLink()
{
		dealsLink.click();
		return new DealsPage();
		
}
	public TaskPage clickOnTasksLink()
{
		tasksLink.click();
		return new TaskPage();
		
}
	public boolean verifyCorrectUserName()
	{
		return userNamelabel.isDisplayed();
	}
	
	public void clickOnNewContactLink()
	{
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
		
	}
}
