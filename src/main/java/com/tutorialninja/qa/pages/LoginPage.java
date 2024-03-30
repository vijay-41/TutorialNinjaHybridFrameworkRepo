package com.tutorialninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	//Objects
	@FindBy(xpath = "//h2[text()='New Customer']")
	private WebElement verifyLoginPageIsOpen;
	
	@FindBy(id = "input-email")
	private WebElement emailAddressField;
	
	@FindBy(id = "input-password")
	private WebElement passwordFeild;
	
	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginButton;
	
	@FindBy(xpath = "//div[contains(@class,'alert')]")
	private WebElement loginWarningMessage;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public boolean getDisplayStatusOfLoginPage() {
		boolean displayStatus = verifyLoginPageIsOpen.isDisplayed();
		return displayStatus;
	}
	
	public void enterEmailAddress(String EmailText) {
		emailAddressField.sendKeys(EmailText);
	}
	
	public void enterPassword(String PasswordText) {
		passwordFeild.sendKeys(PasswordText);
	}
	
	public AccountPage clickOnLoginButton() {
		loginButton.click();
		return new AccountPage(driver);
	}
	
	public String verifyLoginWarningMessage() {
		String warningMessage = loginWarningMessage.getText();
		return warningMessage;
	}
}
