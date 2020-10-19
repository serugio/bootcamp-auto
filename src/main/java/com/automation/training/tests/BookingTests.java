package com.automation.training.tests;

import com.automation.training.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookingTests extends BaseTests{

	@Test
	public void fiveStarsSearchResults() throws InterruptedException {

		//given
		getBookingMainPage().clickSleepOption();
		getBookingMainPage().typeInSearchInputText("Bogotá, Colombia");
		getBookingMainPage().clickDatePicker();
		getBookingMainPage().selectDateFromCalendarPicker();
		getBookingMainPage().clickPassengersPicker();
		getBookingMainPage().selectNumberOfAdults(3);
		getBookingMainPage().selectNumberOfChildren(1);
		getBookingMainPage().selectNumberOfRooms(1);
		getBookingMainPage().clickChildrenAgePicker();
		getBookingMainPage().selectChildrenAge(9);
		BookingSearchResultsPage resultsPage = getBookingMainPage().clickSearchButton();

		//when
		resultsPage.clickFiveStarsCheckbox();

		//then
		Assert.assertTrue(resultsPage.validateBookingOptionsData());

	}

	@Test
	public void testHotelBookingData() throws InterruptedException {
		//given
		getBookingMainPage().clickSleepOption();
		getBookingMainPage().typeInSearchInputText("Bogotá, Colombia");
		getBookingMainPage().clickDatePicker();
		getBookingMainPage().selectDateFromCalendarPicker();
		getBookingMainPage().clickPassengersPicker();
		getBookingMainPage().selectNumberOfAdults(3);
		getBookingMainPage().selectNumberOfChildren(1);
		getBookingMainPage().selectNumberOfRooms(1);
		getBookingMainPage().clickChildrenAgePicker();
		getBookingMainPage().selectChildrenAge(9);
		BookingSearchResultsPage resultsPage = getBookingMainPage().clickSearchButton();
		resultsPage.clickFiveStarsCheckbox();

		//when
		ConfirmHotelPage confirmHotelPage = resultsPage.selectSearchResult(1);

		//then
		Assert.assertTrue(confirmHotelPage.validateDataFromPreviousPage());
	}

	@Test
	public void testFivePageValidations() throws InterruptedException {
		//given
		getBookingMainPage().clickSleepOption();
		getBookingMainPage().typeInSearchInputText("Bogotá, Colombia");
		getBookingMainPage().clickDatePicker();
		getBookingMainPage().selectDateFromCalendarPicker();
		getBookingMainPage().clickPassengersPicker();
		getBookingMainPage().selectNumberOfAdults(3);
		getBookingMainPage().selectNumberOfChildren(1);
		getBookingMainPage().selectNumberOfRooms(1);
		getBookingMainPage().clickChildrenAgePicker();
		getBookingMainPage().selectChildrenAge(9);
		BookingSearchResultsPage resultsPage = getBookingMainPage().clickSearchButton();
		resultsPage.clickFiveStarsCheckbox();
		ConfirmHotelPage confirmHotelPage = resultsPage.selectSearchResult(1);
		confirmHotelPage.clickReserveThisRoomButton();
		confirmHotelPage.clickNumberOfRoomsDropdown();
		confirmHotelPage.selectNumberOfRooms(1);
		FillPersonalDataPage fillPersonalDataPage = confirmHotelPage.clickWillReserveButton();

		//when
		fillPersonalDataPage.typePersonalData("juan", "perez", "bootcampTest@globant.com");
		LastPersonalDataPage lastPersonalDataPage = fillPersonalDataPage.clickNextStepsButton();
		lastPersonalDataPage.typeFinalPersonalData("1234567", "Visa", "4515 4545 4545 4545",
				"01", "2020", "123");

		//then

		//validate if invalid number in credit card field is displayed after typing invalid number
		Assert.assertTrue(lastPersonalDataPage.creditCardInvalidNumberErrorMessageIsVisible());


		//validate if personal data matches with data from previous pages
		Assert.assertTrue(lastPersonalDataPage.validateNameLabel());
		Assert.assertTrue(lastPersonalDataPage.validateLastNameLabel());
		Assert.assertTrue(lastPersonalDataPage.validateEmailLabel());
	}



}
