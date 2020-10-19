package com.automation.training.tests;

import com.automation.training.pages.WoocommercePage;
import org.testng.annotations.*;

import com.automation.training.MyDriver;

public class BaseTests {
	
	MyDriver myDriver;
	
	private WoocommercePage woocommercePage;
	
	@BeforeMethod(alwaysRun=true)
	@Parameters({"browser"})
	public void beforeSuite(String browser) {
		myDriver = new MyDriver(browser);
		woocommercePage = new WoocommercePage(myDriver.getDriver());
	}
	
	@AfterMethod(alwaysRun=true)
	public void afterSuite() {
//		woocommercePage.dispose();
	}
	public WoocommercePage getBookingMainPage() {
		return woocommercePage;
	}
}
