package com.automation.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ConfirmHotelPage extends BasePage {




	public ConfirmHotelPage(WebDriver driver) {
		super(driver);

	}

	//+++++++++++++++++++++++++++ LOCATORS AND WEB ELEMENTS +++++++++++++++++++++++++++

	@FindBy(css ="[id='group_recommendation']")
	private WebElement recommendationTable;
	@FindBy(css ="[id='group_recommendation'] [class='totalPrice'] [class='bui-price-display__label '] ")
	private WebElement reservationDataLabel;
	@FindBy(css ="[id='group_recommendation'] td[class='totalPrice'] [class*='bui-price-display__value ']")
	private WebElement reservationPriceLabel;
	@FindBy(css ="[id='group_recommendation'] [class*='js-group-recommendation-reserve-btn']")
	private WebElement reserveThisRoomButton;
	@FindBy(css ="[id='hprt-form'] tr:nth-child(1) [data-component='hotel/new-rooms-table/select-rooms']")
	private WebElement numberOfRoomsDropdown;
	@FindBy(css ="[class='hprt-reservation-cta'], [class*='js-reservation-button']")
	private WebElement willReserveButton;



	//
	//+++++++++++++++++++++++++++ ACTIONS +++++++++++++++++++++++++++
	public boolean validateDataFromPreviousPage() throws InterruptedException {
		boolean dataMatches = true;
		getFluentWait().until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[id='group_recommendation'] [class='totalPrice'] [class='bui-price-display__label '] ")));
		((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView();", recommendationTable);

		System.out.println(BasePage.bookingData);
		if(!reservationDataLabel.getText().contains(bookingData.get("numberOfAdults")+ " adulto") ||
				!reservationDataLabel.getText().contains(bookingData.get("numberOfChildren")+ " niño") ||
				!reservationPriceLabel.getText().contains(bookingData.get("hotelPrice"))){
			dataMatches = false;
		}
		return dataMatches;
	}

	public void clickReserveThisRoomButton(){
		clickInElement(reserveThisRoomButton);
	}
	public void clickNumberOfRoomsDropdown(){
		getFluentWait().until(ExpectedConditions.visibilityOf(numberOfRoomsDropdown));
		clickInElement(numberOfRoomsDropdown);
	}
	public void selectNumberOfRooms(int desiredNumber){
		numberOfRoomsDropdown.findElement(By.cssSelector("option[value='" +desiredNumber + "']")).click();
	}

	public FillPersonalDataPage clickWillReserveButton(){
		getFluentWait().until(ExpectedConditions.elementToBeClickable(willReserveButton));
		clickInElement(willReserveButton);
		getFluentWait().withTimeout(3, TimeUnit.SECONDS);
		return new FillPersonalDataPage(getDriver());
		}







}
