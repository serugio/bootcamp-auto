package com.automation.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LastPersonalDataPage extends BasePage {




	public LastPersonalDataPage(WebDriver driver) {
		super(driver);

	}

	//+++++++++++++++++++++++++++ LOCATORS AND WEB ELEMENTS +++++++++++++++++++++++++++

	@FindBy(css ="[id='cc1']")
	private WebElement countryDropdown;
	@FindBy(css ="[id='phone']")
	private WebElement phoneInput;
	@FindBy(css ="[id='cc_type']")
	private WebElement creditCardTypeDropdown;
	@FindBy(css ="[id='cc_number']")
	private WebElement creditCardNumberInput;
	@FindBy(css ="[id='cc_month']")
	private WebElement expirationMonthDropdown;
	@FindBy(css ="[id='ccYear']")
	private WebElement expirationYearDropdown;
	@FindBy(css ="[id='cc_cvc']")
	private WebElement cvcInput;
	@FindBy(css ="[id='bp_form_cc_number_msg']")
	private WebElement creditCardInvalidNumberErrorMessage;
	@FindBy(css ="[id='bp_form_cc_expiry_msg']")
	private WebElement creditCardInvalidExpirationDateErrorMessage;
	@FindBy(css ="div[class*='field_name_full_name'] > div.book-form-field-value")
	private WebElement confirmFullNameLabel;
	@FindBy(css ="ins[class*='personal_details_reassurance_email_text']")
	private WebElement confirmEmailLabel;












	//
	//+++++++++++++++++++++++++++ ACTIONS +++++++++++++++++++++++++++

	public void typeFinalPersonalData(String phoneNumber, String typeOfCard, String cardNumber, String expirationMonth, String expirationYear, String cvc ) throws InterruptedException { Thread.sleep(7000);
		getFluentWait().until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[id='cc1']")));
		scrollToElement(countryDropdown);
		typeInTextInputElement(phoneNumber, phoneInput);
		scrollToElement(creditCardTypeDropdown);
		selectCreditCardType(typeOfCard);
		typeInTextInputElement(cardNumber, creditCardNumberInput);
		selectExpirationDate(expirationMonth, expirationYear);
		new Actions(getDriver()).moveToElement(creditCardNumberInput).click().perform();
		typeInTextInputElement(cvc, cvcInput);
	}

	/**
	 *
	 * @param type posible values, MasterCard, Visa, Diners Club, American Express
	 */
	public void selectCreditCardType(String type){
		clickInElement(creditCardTypeDropdown);
		getDriver().findElement(By.cssSelector("option[value='"+ type + "']")).click();
	}

	/**
	 *
	 * @param expirationMonth  possible values, 01 - 12
	 * @param expirationYear possible values 2020 - 2050
	 */
	public void selectExpirationDate(String expirationMonth, String expirationYear){
		clickInElement(expirationMonthDropdown);
		getDriver().findElement(By.cssSelector("option[value='"+ expirationMonth + "']")).click();
		clickInElement(expirationYearDropdown);
		getDriver().findElement(By.cssSelector("option[value='"+ expirationYear + "']")).click();
	}

	public boolean creditCardInvalidNumberErrorMessageIsVisible(){
		return creditCardInvalidNumberErrorMessage.isDisplayed();
	}
	public boolean creditCardInvalidExpirationDateErrorMessageIsVisible(){
		return creditCardInvalidExpirationDateErrorMessage.isDisplayed();
	}

	public boolean validateNameLabel(){

		return confirmFullNameLabel.getText().contains(bookingData.get("firstName")) ;
	}
	public boolean validateLastNameLabel(){

		return confirmFullNameLabel.getText().contains(bookingData.get("lastName")) ;
	}

	public boolean validateEmailLabel(){

		return confirmEmailLabel.getText().contains(bookingData.get("email")) ;
	}












}
