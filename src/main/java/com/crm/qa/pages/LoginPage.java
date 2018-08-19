package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//PageFactory or OR
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@class='btn btn-small']")
	WebElement LoginBtn;
	
	@FindBy(xpath="//font[contains(text(),'Sign Up')]")
	WebElement SignUp;
	
	@FindBy(xpath="//img[@class ='img-responsive']")
	WebElement crmLogo;

	//Initialisation the page objects
	public LoginPage()
	{
		PageFactory.initElements(driver, this);	
	}
	//Actions:
	public String ValidateLoginPageTitle()
	{
		return driver.getTitle();
	}
	public boolean ValidateCrmImage()
	{
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) throws Exception
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		Thread.sleep(5000);
		LoginBtn.click();
		
		return new HomePage();
	}
}
