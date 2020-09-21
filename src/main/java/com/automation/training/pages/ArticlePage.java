package com.automation.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ArticlePage extends BasePage{
	
	public ArticlePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="firstHeading")
	private WebElement pageTitle;
	
	@FindBy(linkText="Privacy policy")
	private WebElement privacyLink;

	@FindBy(id="searchInput")
	private WebElement searchInput;

	@FindBy(id="searchButton")
	private WebElement searchButton;

	public ArticlePage buscar(String busqueda) {
		searchInput.sendKeys(busqueda);
		searchButton.click();
		return new ArticlePage(getDriver());
	}


	
	public String getPageTitle() {
		return pageTitle.getText();
	}
	
}
