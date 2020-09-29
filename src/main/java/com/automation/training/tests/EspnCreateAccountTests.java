package com.automation.training.tests;

import com.automation.training.pages.EspnMainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EspnCreateAccountTests extends BaseTests{
	

	
	@Test
	public void testCreateAccount()  {
		//load home
		EspnMainPage espnHome = getEspnMainPage();

		//start sign up process
		espnHome.clickUserIcon();
		espnHome.clickLogInButton();
		espnHome.clickSignUpButton();

		//fill user account data
		espnHome.fillSignUpForm("juan", "lozano", "juanTe@test.com", "secretPass123");
		espnHome.clickSignUpModalButton();

		//assert account created successfully
		Assert.assertEquals(espnHome.logInIframeIsDisplayed(), true);
	}





}
