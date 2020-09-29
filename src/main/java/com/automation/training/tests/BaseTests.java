package com.automation.training.tests;

import com.automation.training.pages.EspnMainPage;
import org.testng.annotations.*;

import com.automation.training.MyDriver;

public class BaseTests {
	
	MyDriver myDriver;
	
	private EspnMainPage espnHome;
	
	@BeforeClass(alwaysRun=true)
	@Parameters({"browser"})
	public void beforeSuite(String browser) {
		myDriver = new MyDriver(browser);
		espnHome = new EspnMainPage(myDriver.getDriver());
	}
	
	@AfterClass(alwaysRun=true)
	public void afterSuite() {
//		espnHome.dispose();
	}
	public EspnMainPage getEspnMainPage() {
		return espnHome;
	}
}
