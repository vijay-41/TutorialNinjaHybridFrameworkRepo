package com.tutorialninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
	WebDriver driver;
	//Objects
	@FindBy(xpath = "//h2[text()='My Account']")
	private WebElement myAccount;
	
	public AccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public boolean getDisplayStatusOfMyAccount() {
		boolean displayStatus = myAccount.isDisplayed();
		return displayStatus;
	}
}
