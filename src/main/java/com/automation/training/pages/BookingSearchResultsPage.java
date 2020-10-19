package com.automation.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BookingSearchResultsPage extends BasePage {




	public BookingSearchResultsPage(WebDriver driver) {
		super(driver);
	}

	//+++++++++++++++++++++++++++ LOCATORS AND WEB ELEMENTS +++++++++++++++++++++++++++

	@FindBy(css ="[id='hotellist_inner']")
	private WebElement bookingOptionsList;
	@FindBy(css ="[data-id='class-5']")
	private WebElement fiveStarsCheckbox;
	@FindBy(css ="[class='sr-hotel__title'], [class*='sr-hotel__name']")
	private WebElement hotelName;

	//
	//+++++++++++++++++++++++++++ ACTIONS +++++++++++++++++++++++++++


	public void clickFiveStarsCheckbox() throws InterruptedException {
		getFluentWait().until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div[class='sr_item_content sr_item_content_slider_wrapper ']")));
		((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView();", fiveStarsCheckbox);
		clickInElement(fiveStarsCheckbox);
		getFluentWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div[class='sr_item_content sr_item_content_slider_wrapper ']"))); Thread.sleep(1500);
	}

	public boolean validateBookingOptionsData() {
		boolean allDataIsDisplayed = true;

		getFluentWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("[class='sr-hotel__title'], [class*='sr-hotel__name']")));
		getFluentWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("[class='bui-price-display__value prco-inline-block-maker-helper']"))); ;
		getFluentWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("[class='bui-review-score__badge']")));
		List<WebElement> bookingOptions = bookingOptionsList.findElements(By.cssSelector("div[class='sr_item_content sr_item_content_slider_wrapper ']"));
		for (WebElement bookingOption: bookingOptions ) {
			if(!bookingOption.findElement(By.cssSelector("[class='sr-hotel__title'], [class*='sr-hotel__name']")).isDisplayed())
				allDataIsDisplayed = false;
			if(!bookingOption.findElement(By.cssSelector("[class='bui-review-score__badge']")).isDisplayed())
				allDataIsDisplayed = false;
			if(!bookingOption.findElement(By.cssSelector("[class='bui-price-display__value prco-inline-block-maker-helper']")).isDisplayed())
				allDataIsDisplayed = false;
		}
		return allDataIsDisplayed;
	}

	public ConfirmHotelPage selectSearchResult(int numberOfResult) {

		List<WebElement> bookingOptions = bookingOptionsList.findElements(By.cssSelector("div[class='sr_item_content sr_item_content_slider_wrapper ']"));
		WebElement bookingOption = bookingOptions.get(1);

		bookingData.put("hotelName", bookingOption.findElement(By.cssSelector("[class='sr-hotel__title'], [class*='sr-hotel__name']")).getText());
		bookingData.put("hotelScore", bookingOption.findElement(By.cssSelector("[class='bui-review-score__badge']")).getText());
		bookingData.put("hotelPrice", bookingOption.findElement(By.cssSelector("[class='bui-price-display__value prco-inline-block-maker-helper']")).getText());
		bookingOption.findElement(By.cssSelector("a[class*='sr_cta_button']")).click();
		ArrayList<String> tabs = new ArrayList (getDriver().getWindowHandles());
		getDriver().switchTo().window(tabs.get(1));
		return new ConfirmHotelPage(getDriver());
	}


}
