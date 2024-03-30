package com.tutorialninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccessPage {
	WebDriver driver;
	
	//Objects
	@FindBy(xpath = "//div[@id='content']/h1")
	private WebElement verifyRegistrationIsSuccess;
	
	public AccountSuccessPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getRegistrationSuccessMessage() {
		 String displayMessage = verifyRegistrationIsSuccess.getText();
		 return displayMessage;
	}
}
