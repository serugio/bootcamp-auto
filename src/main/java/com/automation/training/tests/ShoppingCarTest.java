package com.automation.training.tests;

import com.automation.training.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShoppingCarTest extends BaseTests{

	@Test
	public void shoppingCartTest() throws InterruptedException {

		//given
		WoocommercePage woocommercePage = new WoocommercePage(myDriver.getDriver());
		woocommercePage.createProductViaAPI();
		Assert.assertTrue(woocommercePage.titleIsVisible());
		Assert.assertTrue(woocommercePage.priceIsVisible());

		//when
		woocommercePage.fillQuantity("7");
		woocommercePage.clickAddtoCartbutton();
		Assert.assertTrue(woocommercePage.itemCountIsUpdated("7"));
		CartPage cartPage = woocommercePage.clickCartIcon();

		//then
		Assert.assertTrue(cartPage.productNameCellContainsProductName("sergioGarcia"));
		Assert.assertTrue(cartPage.quantityCellContainsCorrectNumber("7"));

		//postCondition
		woocommercePage.deleteProductViaAPI();

	}

}
