package com.automation.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public abstract class BasePage {

	private WebDriver driver;
	private FluentWait fluentWait;
	protected static HashMap<String, String> bookingData;

	public BasePage(WebDriver pDriver) {
		this.driver = pDriver;
		PageFactory.initElements(pDriver, this);
		fluentWait = new FluentWait<WebDriver>( getDriver())
				.withTimeout(18, TimeUnit.SECONDS)
				.pollingEvery(1, TimeUnit.SECONDS);

	}

	protected WebDriver getDriver() {
		return driver;
	}


	protected FluentWait getFluentWait() {
		return fluentWait;
	}

	public void dispose() {
		if (driver != null) {
			driver.quit();
		}
	}

	/**
	 *
	 * @param text = text to type
	 * @param element = web element to type in
	 */
	public void typeInTextInputElement(String text, WebElement element){
		fluentWait.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(text);
	}

	public void clickInElement(WebElement element){
		fluentWait.until(ExpectedConditions.visibilityOf(element));
		element.click();
	}

	public void scrollToElement(WebElement element){
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.perform();
	}

	public static String getDateYYYYMMDD() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		return dateFormat.format(date);
	}

	public static HashMap<String, String> getBookingData() {
		return bookingData;
	}

}
