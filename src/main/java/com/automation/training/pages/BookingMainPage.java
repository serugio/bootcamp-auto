package com.automation.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class BookingMainPage extends BasePage {

	protected String url = "https://www.booking.com/index.es.html";


	public BookingMainPage(WebDriver driver) {
		super(driver);
		driver.get(url);
		bookingData = new HashMap<String, String>();
	}

	//+++++++++++++++++++++++++++ LOCATORS AND WEB ELEMENTS +++++++++++++++++++++++++++

	@FindBy(css ="#cross-product-bar > div > span")
	private WebElement sleepOption;
	@FindBy(css="#ss")
	private WebElement searchTextInput;
	@FindBy(css="[data-mode='checkin']")
	private WebElement datePicker;
	@FindBy(css="[data-bui-ref='calendar-next']")
	private WebElement calendarNextOption;
	@FindBy(css="[id='xp__guests__toggle']")
	private WebElement passengersPicker;
	@FindBy(css="[data-bui-ref='input-stepper-add-button'][aria-describedby='group_adults_desc']")
	private WebElement adultsPlusButton;
	@FindBy(css="[data-bui-ref='input-stepper-subtract-button'][aria-describedby='group_adults_desc']")
	private WebElement adultsMinusButton;
	@FindBy(css="[data-bui-ref='input-stepper-add-button'][aria-describedby='group_children_desc']")
	private WebElement childrenPlusButton;
	@FindBy(css="[data-bui-ref='input-stepper-subtract-button'][aria-describedby='group_children_desc']")
	private WebElement childrenMinusButton;
	@FindBy(css="[data-bui-ref='input-stepper-add-button'][aria-describedby='no_rooms_desc']")
	private WebElement roomPlusButton;
	@FindBy(css="[data-bui-ref='input-stepper-subtract-button'][aria-describedby='no_rooms_desc']")
	private WebElement roomMinusButton;
	@FindBy(css="[class='sb-group__field sb-group__field-adults'] span.bui-stepper__display")
	private WebElement adultsCurrentValueLabel;
	@FindBy(css="[id='group_children']")
	private WebElement childrenCurrentValueLabel;
	@FindBy(css="[id='no_rooms']")
	private WebElement roomsCurrentValueLabel;
	@FindBy(css="[name='age']")
	private WebElement childrenAgePicker;
	private WebElement childrenAgeOption;
	@FindBy(css="button[data-sb-id='main']")
	private WebElement searchButton;




	//+++++++++++++++++++++++++++ ACTIONS +++++++++++++++++++++++++++

	public void clickSleepOption() { clickInElement(sleepOption);}
	public void clickDatePicker() { clickInElement(datePicker);}
	public void clickCalendarNextOption() { clickInElement(calendarNextOption);}
	public void clickPassengersPicker() { clickInElement(passengersPicker);}
	public void clickChildrenAgePicker() { clickInElement(childrenAgePicker);}
	public BookingSearchResultsPage clickSearchButton() {
		clickInElement(searchButton);
		return new BookingSearchResultsPage(getDriver());
	}

	public void typeInSearchInputText(String textToType) {typeInTextInputElement(textToType, searchTextInput);	}


	public void selectDateFromCalendarPicker() {
		String checkInDate =  LocalDate.now().plusDays(30).toString();
		String checkOutDate =  LocalDate.now().plusDays(45).toString();

		clickInElement(getDriver().findElement(By.cssSelector("[data-date='" + checkInDate + "']")));
		try {
			clickInElement(getDriver().findElement(By.cssSelector("[data-date='" + checkOutDate + "']")));
		}catch (Exception e){
			clickCalendarNextOption();
			clickInElement(getDriver().findElement(By.cssSelector("[data-date='" + checkOutDate + "']")));
		}
	}

	public void selectNumberOfAdults(int desiredNumber){
		int currentNumber = Integer.parseInt(adultsCurrentValueLabel.getText());
		if(desiredNumber < currentNumber){
			for (int i = 0; i < (currentNumber - desiredNumber) ; i++) {
				clickInElement(adultsMinusButton);
			}
		}
		if(desiredNumber > currentNumber){
			for (int i = 0; i < (desiredNumber - currentNumber) ; i++) {
				clickInElement(adultsPlusButton);
			}
		}
		bookingData.put("numberOfAdults", adultsCurrentValueLabel.getText());
	}

	public void selectNumberOfChildren(int desiredNumber){
		int currentNumber = Integer.parseInt(childrenCurrentValueLabel.getAttribute("value"));
		if(desiredNumber < currentNumber){
			for (int i = 0; i < (currentNumber - desiredNumber) ; i++) {
				clickInElement(childrenMinusButton);
			}
		}
		if(desiredNumber > currentNumber){
			for (int i = 0; i < (desiredNumber - currentNumber) ; i++) {
				clickInElement(childrenPlusButton);
			}
		}
		bookingData.put("numberOfChildren", childrenCurrentValueLabel.getAttribute("value"));
	}

	public void selectNumberOfRooms(int desiredNumber){
		int currentNumber = Integer.parseInt(roomsCurrentValueLabel.getAttribute("value"));
		if(desiredNumber < currentNumber){
			for (int i = 0; i < (currentNumber - desiredNumber) ; i++) {
				clickInElement(roomMinusButton);
			}
		}
		if(desiredNumber > currentNumber){
			for (int i = 0; i < (desiredNumber - currentNumber) ; i++) {
				clickInElement(roomPlusButton);
			}
		}
	}

	/**
	 *
	 * @param age = valid options 0 - 17
	 */
	public void selectChildrenAge(int age){
		childrenAgeOption = getDriver().findElement(By.cssSelector("option[value='" + age + "']"));
		clickInElement(childrenAgePicker);
	}


}
