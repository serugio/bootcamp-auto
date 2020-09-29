package com.automation.training.tests;

import com.automation.training.pages.EspnMainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EspnDeleteAccountTests extends BaseTests{

	@Test
	public void testDeleteAccount()  {

		//start background
		EspnMainPage espnHome = getEspnMainPage();
		espnHome.clickUserIcon();
		espnHome.clickLogInButton();
		espnHome.fillSignInForm("juanTe@test.com", "secretPass123" );
		espnHome.clickLoginModalLogInButton();

		//start delete account path
		espnHome.clickUserIcon();
		espnHome.clickProfileButton();
		espnHome.clickProfileModalDeleteAccount();
		espnHome.clickProfileModalConfirmDeleteAccountButton();

		//assert login made successfully
		Assert.assertEquals(espnHome.logInIframeIsDisplayed(), true);
	}



}
