package com.automation.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

public class FillPersonalDataPage extends BasePage {




	public FillPersonalDataPage(WebDriver driver) {
		super(driver);

	}

	//+++++++++++++++++++++++++++ LOCATORS AND WEB ELEMENTS +++++++++++++++++++++++++++

	@FindBy(css ="iframe[title*='iframe']")
	private WebElement iframe;
	@FindBy(css ="button[class*='bui-modal__close']")
	private WebElement iframeCloseButton;
	@FindBy(css ="[id='firstname']")
	private WebElement firstNameInput;
	@FindBy(css ="[id='lastname']")
	private WebElement lastNameInput;
	@FindBy(css ="[id='email']")
	private WebElement emailInput;
	@FindBy(css ="[id='email_confirm']")
	private WebElement emailConfirmInput;
	@FindBy(css ="button[name*='book']")
	private WebElement nextLastStepsButton;






	//
	//+++++++++++++++++++++++++++ ACTIONS +++++++++++++++++++++++++++

	public void typePersonalData(String name, String lastName, String email){
		//getFluentWait().until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[class*='bp_hotel_details'], [class*='hotel-address']")));
		scrollToElement(firstNameInput);
		typeInTextInputElement(name, firstNameInput);
		typeInTextInputElement(lastName, lastNameInput);
		typeInTextInputElement(email, emailInput);
		typeInTextInputElement(email, emailConfirmInput);
		bookingData.put("firstName", name);
		bookingData.put("lastName", lastName);
		bookingData.put("email", email);
	}

	public LastPersonalDataPage clickNextStepsButton(){
		scrollToElement(nextLastStepsButton);
		clickInElement(nextLastStepsButton);
		return new LastPersonalDataPage(getDriver());
	}








}
