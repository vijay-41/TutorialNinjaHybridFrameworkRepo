package com.tutorialninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialninja.qa.base.Base;
import com.tutorialninja.qa.pages.HomePage;
import com.tutorialninja.qa.pages.SearchPage;

public class Search extends Base{
	SearchPage searchpage;
	HomePage homepage;
	public WebDriver driver;
	@BeforeMethod
	public void setup() {
		loadPropertiesFile();
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browser"));
		homepage = new HomePage(driver);
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	@Test(priority = 1)
	public void verifySearchWithValidProduct() {
		homepage.enterValueInSearchBar(dataProp.getProperty("validProduct"));
		searchpage = homepage.selectSearchButton();
		Assert.assertTrue(searchpage.getValidProduct());
	}
	@Test(priority = 2)
	public void verifySearchWithInvalidProduct() {
		homepage.enterValueInSearchBar(dataProp.getProperty("invalidProduct"));
		searchpage = homepage.selectSearchButton();
		String actualSearchMessage = searchpage.getSearchCriteriaMessage();
		Assert.assertEquals(actualSearchMessage, dataProp.getProperty("searchCriteriaMessage"),"Correct error message is not displayed");
	}
	@Test(priority = 3, dependsOnMethods = {"verifySearchWithInvalidProduct"})
	public void verifySearchWithoutAnyProduct() {
		searchpage = homepage.selectSearchButton();
		String actualSearchMessage = searchpage.getSearchCriteriaMessage();
		Assert.assertEquals(actualSearchMessage, dataProp.getProperty("searchCriteriaMessage"),"Correct error message is not displayed");
	}
}
