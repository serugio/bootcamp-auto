package com.automation.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

	private WebDriver driver;
	private WebDriverWait wait;

	public BasePage(WebDriver pDriver) {
		PageFactory.initElements(pDriver, this);
		driver = pDriver;
		wait = new WebDriverWait(getDriver(), 10000);
	}

	protected WebDriver getDriver() {
		return driver;
	}

	protected WebDriverWait getWait() {
		return wait;
	}

	public void dispose() {
		if (driver != null) {
			driver.quit();
		}
	}

	public void typeInTextInputElement(String text, WebElement element){
		wait.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(text);
	}

	public void clickInElement(WebElement element){
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
	}

	public void scrollToElement(WebElement element){
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.perform();
	}







}
