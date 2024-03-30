package com.tutorialninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	WebDriver driver;
	
	//Objects
	
	@FindBy(linkText = "iMac")
	private WebElement validProduct;
	
	@FindBy(xpath = "//div[@id='content']//h2//following-sibling::p")
	private WebElement searchCriteriaMessage;
	
	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public boolean getValidProduct() {
		boolean displayProduct = validProduct.isDisplayed();
		return displayProduct;
	}
	
	public String getSearchCriteriaMessage() {
		String displayMessage = searchCriteriaMessage.getText();
		return displayMessage;
	}
}
