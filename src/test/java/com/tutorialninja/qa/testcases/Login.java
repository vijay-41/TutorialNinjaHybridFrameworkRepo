package com.tutorialninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialninja.qa.base.Base;
import com.tutorialninja.qa.pages.AccountPage;
import com.tutorialninja.qa.pages.HomePage;
import com.tutorialninja.qa.pages.LoginPage;
import com.tutorialninja.qa.utils.Utilities;
public class Login extends Base{
	LoginPage loginpage;
	AccountPage accountpage;
	public WebDriver driver;
	@BeforeMethod
	public void setup() {
		loadPropertiesFile();
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browser"));
		HomePage homepage = new HomePage(driver);
		homepage.clickOnMyAccount();
		loginpage = homepage.selectLoginOption();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	@Test(priority = 1)
	public void verifyLoginWithValidCredentials() {
		Assert.assertTrue(loginpage.getDisplayStatusOfLoginPage());
		loginpage.enterEmailAddress(prop.getProperty("validEmail"));
		loginpage.enterPassword(prop.getProperty("validPassword"));
		accountpage = loginpage.clickOnLoginButton();
		Assert.assertTrue(accountpage.getDisplayStatusOfMyAccount());
	}
	@Test(priority = 2)
	public void verifyLoginWithInvalidCredentials() {
		Assert.assertTrue(loginpage.getDisplayStatusOfLoginPage());
		loginpage.enterEmailAddress(Utilities.generateEmailWithTimeStamp());
		loginpage.enterPassword(dataProp.getProperty("invalidPassword"));
		loginpage.clickOnLoginButton();
		String actualWarningMessage = loginpage.verifyLoginWarningMessage();
		String expectedWarningMessage = dataProp.getProperty("emailPasswordNoMatchWarning");
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));
	}
	@Test(priority = 3)
	public void verifyLoginWithInvalidEmailAndValidPassword() {
		Assert.assertTrue(loginpage.getDisplayStatusOfLoginPage());
		loginpage.enterEmailAddress(Utilities.generateEmailWithTimeStamp());
		loginpage.enterPassword(prop.getProperty("validPassword"));
		loginpage.clickOnLoginButton();
		String actualWarningMessage = loginpage.verifyLoginWarningMessage();
		String expectedWarningMessage = dataProp.getProperty("emailPasswordNoMatchWarning");
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));
	}
	@Test(priority = 4)
	public void verifyLoginWithValidEmailAndInvalidPassword() {
		Assert.assertTrue(loginpage.getDisplayStatusOfLoginPage());
		loginpage.enterEmailAddress(prop.getProperty("validEmail"));
		loginpage.enterPassword(dataProp.getProperty("invalidPassword"));
		loginpage.clickOnLoginButton();
		String actualWarningMessage = loginpage.verifyLoginWarningMessage();
		String expectedWarningMessage = dataProp.getProperty("emailPasswordNoMatchWarning");
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));
	}
	@Test(priority = 5)
	public void verifyLoginWithoutProvidingAnyCredentials() {
		Assert.assertTrue(loginpage.getDisplayStatusOfLoginPage());
		loginpage.clickOnLoginButton();
		String actualWarningMessage = loginpage.verifyLoginWarningMessage();
		String expectedWarningMessage = dataProp.getProperty("emailPasswordNoMatchWarning");
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));
	}
	@Test(priority = 6,dataProvider = "validCredentialSupplier")
	public void withData(String email, String password) {
		Assert.assertTrue(loginpage.getDisplayStatusOfLoginPage());//Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='New Customer']")).isDisplayed());
		loginpage.enterEmailAddress(email);//driver.findElement(By.id("input-email")).sendKeys(email);
		loginpage.enterPassword(password);//driver.findElement(By.id("input-password")).sendKeys(password);
		accountpage = loginpage.clickOnLoginButton();//driver.findElement(By.xpath("//input[@value='Login']")).click();
		Assert.assertTrue(accountpage.getDisplayStatusOfMyAccount());//Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='My Account']")).isDisplayed());
	}
	@DataProvider(name = "validCredentialSupplier")
	public Object[][] supplyTestData() {
		Object[][] data= Utilities.getTestDataFromExcel("Login");
		return data;
	}
	}