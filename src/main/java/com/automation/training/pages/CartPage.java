package com.automation.training.pages;

import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class CartPage extends BasePage {

	protected String url = "http://34.205.174.166/product/sergioGarcia/";


	public CartPage(WebDriver driver) {
		super(driver);
	}

	//+++++++++++++++++++++++++++ LOCATORS AND WEB ELEMENTS +++++++++++++++++++++++++++

	@FindBy(css ="td[class='product-name']")
	private WebElement productNameCell;
	@FindBy(css ="[class='input-text qty text']")
	private WebElement quantityCell;










	//+++++++++++++++++++++++++++ ACTIONS +++++++++++++++++++++++++++
	public boolean productNameCellContainsProductName(String productName){
		getFluentWait().until(ExpectedConditions.visibilityOf(productNameCell));
		return productNameCell.getText().contains(productName);
	}

	public boolean quantityCellContainsCorrectNumber(String amountOfItems){
		return quantityCell.getAttribute("value").contains(amountOfItems);
	}





}
