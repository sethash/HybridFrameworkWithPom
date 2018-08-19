package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;



public class ContactsPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactspage;
	String SheetName = "Sheet1";
	
	public ContactsPageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() throws Exception
	{
		initialisation();
		testutil = new TestUtil();
		contactspage = new ContactsPage();
		 loginpage = new LoginPage();
		 homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		 testutil.switchToFrame();
		 contactspage =homepage.clickOnContactsLink();
		 
		
	}
	
	@Test(priority=1)
	public void verifyContactsPageLabel()
	{
		Assert.assertTrue(contactspage.verifyContactsLabel(),"contacts label is missing");
	}
	
	@Test(priority=2)
	public void SelectContactsTest()
	{
		contactspage.selectContactByName("Tom peter");
	}
	
	@DataProvider
	public Object[][] getCRMTestData()
	{
		Object data[][] = TestUtil.getTestData(SheetName);
		return data;
	}
	
	@Test(priority=3, dataProvider = "getCRMTestData")
	public void validateCreateNewContact(String title,String firstname,String lastname,String company)
	{
		homepage.clickOnNewContactLink();
		contactspage.createNewContct(title, firstname, lastname, company);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
