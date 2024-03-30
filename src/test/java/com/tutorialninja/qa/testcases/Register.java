package com.tutorialninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialninja.qa.base.Base;
import com.tutorialninja.qa.pages.AccountSuccessPage;
import com.tutorialninja.qa.pages.HomePage;
import com.tutorialninja.qa.pages.RegisterPage;
import com.tutorialninja.qa.utils.Utilities;

public class Register extends Base {
	RegisterPage registerpage;
	AccountSuccessPage accountsuccesspage;
	public WebDriver driver;
	@BeforeMethod
	public void setup() {
		loadPropertiesFile();
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browser"));
		HomePage homepage = new HomePage(driver);
		homepage.clickOnMyAccount();
		registerpage = homepage.selectRegisterOption();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	@Test(priority = 1)
	public void verifyRegisteringAnAccountWithMandatoryFeilds() {
		Assert.assertTrue(registerpage.getDisplayStatusOfRegisterPage());
		registerpage.enterFirstName(dataProp.getProperty("firstName"));
		registerpage.enterLastName(dataProp.getProperty("lastName"));
		registerpage.enterEmailAddress(Utilities.generateEmailWithTimeStamp());
		registerpage.enterTelephoneNumber(dataProp.getProperty("telephoneNumber"));
		registerpage.enterPassowrd(prop.getProperty("validPassword"));
		registerpage.enterConfirmPassword(prop.getProperty("validPassword"));
		registerpage.clickPrivacyPolicyCheckbox();
		accountsuccesspage = registerpage.clickContinueButton();
		String actualSuccessHeading = accountsuccesspage.getRegistrationSuccessMessage();
		Assert.assertEquals(actualSuccessHeading, dataProp.getProperty("accountCreationSuccessMessage"));
	}
	@Test(priority = 2)
	public void verifyRegisteringAnAccountWithAllTheFields() {
		Assert.assertTrue(registerpage.getDisplayStatusOfRegisterPage());
		registerpage.enterFirstName(dataProp.getProperty("firstName"));
		registerpage.enterLastName(dataProp.getProperty("lastName"));
		registerpage.enterEmailAddress(Utilities.generateEmailWithTimeStamp());
		registerpage.enterTelephoneNumber(dataProp.getProperty("telephoneNumber"));
		registerpage.enterPassowrd(prop.getProperty("validPassword"));
		registerpage.enterConfirmPassword(prop.getProperty("validPassword"));
		registerpage.clickNewslatterToYes();
		registerpage.clickPrivacyPolicyCheckbox();
		accountsuccesspage = registerpage.clickContinueButton();
		String actualSuccessHeading = accountsuccesspage.getRegistrationSuccessMessage();
		Assert.assertEquals(actualSuccessHeading,dataProp.getProperty("accountCreationSuccessMessage"));
	}
	@Test(priority = 3)
	public void verifyRegisteringAnAccountWithTheExistingEmail() {
		Assert.assertTrue(registerpage.getDisplayStatusOfRegisterPage());
		registerpage.enterFirstName(dataProp.getProperty("firstName"));
		registerpage.enterLastName(dataProp.getProperty("lastName"));
		registerpage.enterEmailAddress(prop.getProperty("validEmail"));
		registerpage.enterTelephoneNumber(dataProp.getProperty("telephoneNumber"));
		registerpage.enterPassowrd(prop.getProperty("validPassword"));
		registerpage.enterConfirmPassword(prop.getProperty("validPassword"));
		registerpage.clickNewslatterToYes();
		registerpage.clickPrivacyPolicyCheckbox();
		registerpage.clickContinueButton();
		String actualWarningMessage = registerpage.getEmailAlreadyExistWarningMessage();
		String expectedWarningMessage = dataProp.getProperty("emailAlreadyRegistered");
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));
	}
	@Test(priority = 4)
	public void verifyRegisteringAnAccountWithoutFillingAnyDetails() {
		Assert.assertTrue(registerpage.getDisplayStatusOfRegisterPage());
		registerpage.clickContinueButton();
		String actualPrivacyPolicyWarning = registerpage.getPrivacyPolicyWarningMessage();
		Assert.assertTrue(actualPrivacyPolicyWarning.contains(dataProp.getProperty("privacyPolicyWarning")));
		String actualFirstNameWarning = registerpage.getFirstNameWarningMessage();
		Assert.assertTrue(actualFirstNameWarning.contains(dataProp.getProperty("firstNameWarning")));
		String actualLastNameWarning = registerpage.getLastNameWarningMessage();
		Assert.assertTrue(actualLastNameWarning.contains(dataProp.getProperty("lastNameWarning")));
		String actualEmailWarning = registerpage.getEmailAddressWarningMessage();
		Assert.assertTrue(actualEmailWarning.contains(dataProp.getProperty("emailWarning")));
		String actualTelephoneWarning = registerpage.getTelephoneNumberWarningMessage();
		Assert.assertTrue(actualTelephoneWarning.contains(dataProp.getProperty("telephoneNumberWarning")));
		String actualPasswordWarning = registerpage.getPasswordWarningMessage();
		Assert.assertTrue(actualPasswordWarning.contains(dataProp.getProperty("passwordWarning")));
	}
}
