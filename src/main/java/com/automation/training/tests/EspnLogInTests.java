package com.automation.training.tests;

import com.automation.training.pages.EspnMainPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class EspnLogInTests extends BaseTests{

	@Test
	public void testMakeLogIn()  {
		//load home
		EspnMainPage espnHome = getEspnMainPage();

		//start signIn process
		espnHome.clickUserIcon();
		espnHome.clickLogInButton();

		//fill form and send it
		espnHome.fillSignInForm("juanTe@test.com", "secretPass123" );
		espnHome.clickLoginModalLogInButton();

		//assert login made successfully
		Assert.assertEquals(espnHome.logInIframeIsDisplayed(), true);
	}



}
