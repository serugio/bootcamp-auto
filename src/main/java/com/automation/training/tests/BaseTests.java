package com.automation.training.tests;

import com.automation.training.pages.BookingMainPage;
import org.testng.annotations.*;

import com.automation.training.MyDriver;

public class BaseTests {
	
	MyDriver myDriver;
	
	private BookingMainPage bookingMainPage;
	
	@BeforeClass(alwaysRun=true)
	@Parameters({"browser"})
	public void beforeSuite(String browser) {
		myDriver = new MyDriver(browser);
		bookingMainPage = new BookingMainPage(myDriver.getDriver());
	}
	
	@AfterClass(alwaysRun=true)
	public void afterSuite() {
//		bookingMainPage.dispose();
	}
	public BookingMainPage getBookingMainPage() {
		return bookingMainPage;
	}
}
