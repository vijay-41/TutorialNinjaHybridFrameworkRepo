package com.tutorialninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	WebDriver driver;
	
	//Objects
	@FindBy(xpath = "//h1[text()='Register Account']")
	private WebElement verifyRegisterPageIsOpen;
	
	@FindBy(id = "input-firstname")
	private WebElement firstNameField;
	
	@FindBy(id = "input-lastname")
	private WebElement lastNameField;
	
	@FindBy(id = "input-email")
	private WebElement emailAddressField;
	
	@FindBy(id = "input-telephone")
	private WebElement telephoneNumberField;
	
	@FindBy(id = "input-password")
	private WebElement passwordField;
	
	@FindBy(id = "input-confirm")
	private WebElement confirmPasswordField;
	
	@FindBy(name = "agree")
	private WebElement privacyPolicyAgreeCheckbox;
	
	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueButton;
	
	@FindBy(xpath = "//input[@name='newsletter'][@value='1']")
	private WebElement selectNewsletterToYes;
	
	@FindBy(xpath = "//div[contains(@class,'alert')]")
	private WebElement emailAlreadyExistWarningMessage;
	
	@FindBy(xpath = "//div[contains(@class,'alert')]")
	private WebElement privacyPolicyWarningMessage;
	
	@FindBy(xpath = "//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstNameWarningMessgae;
	
	@FindBy(xpath = "//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastNameWarningMessgae;
	
	@FindBy(xpath = "//input[@id='input-email']/following-sibling::div")
	private WebElement emailAddressWarningMessage;
	
	@FindBy(xpath = "//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephoneNumberWarningMessage;
	
	@FindBy(xpath = "//input[@id='input-password']/following-sibling::div")
	private WebElement passwordWarningMessage;
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Action
	
	public boolean getDisplayStatusOfRegisterPage() {
		boolean displayStatus = verifyRegisterPageIsOpen.isDisplayed();
		return displayStatus;
	}
	
	public void enterFirstName(String firstNameText) {
		firstNameField.sendKeys(firstNameText);
	}
	
	public void enterLastName(String lastNameText) {
		lastNameField.sendKeys(lastNameText);
	}
	
	public void enterEmailAddress(String emailText) {
		emailAddressField.sendKeys(emailText);
	}
	
	public void enterTelephoneNumber(String telephoneNumberText) {
		telephoneNumberField.sendKeys(telephoneNumberText);
	}
	
	public void enterPassowrd(String passowrdText) {
		passwordField.sendKeys(passowrdText);
	}
	
	public void enterConfirmPassword(String confirmPasswordText) {
		confirmPasswordField.sendKeys(confirmPasswordText);
	}
	
	public void clickPrivacyPolicyCheckbox() {
		privacyPolicyAgreeCheckbox.click();
	}
	
	public AccountSuccessPage clickContinueButton() {
		continueButton.click();
		return new AccountSuccessPage(driver);
	}
	
	public void clickNewslatterToYes() {
		selectNewsletterToYes.click();
	}
	
	public String getEmailAlreadyExistWarningMessage() {
		String displayMessage = emailAlreadyExistWarningMessage.getText();
		return displayMessage;
	}
	
	public String getPrivacyPolicyWarningMessage(){
		String displayMessage = privacyPolicyWarningMessage.getText();
		return displayMessage;
	}
	
	public String getFirstNameWarningMessage(){
		String displayMessage = firstNameWarningMessgae.getText();
		return displayMessage;
	}
	
	public String getLastNameWarningMessage(){
		String displayMessage = lastNameWarningMessgae.getText();
		return displayMessage;
	}
	
	public String getEmailAddressWarningMessage(){
		String displayMessage = emailAddressWarningMessage.getText();
		return displayMessage;
	}
	
	public String getTelephoneNumberWarningMessage(){
		String displayMessage = telephoneNumberWarningMessage.getText();
		return displayMessage;
	}
	
	public String getPasswordWarningMessage(){
		String displayMessage = passwordWarningMessage.getText();
		return displayMessage;
	}

}
