package com.automation.training.pages;

import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class WoocommercePage extends BasePage {

	protected String url = "http://34.205.174.166/product/sergioGarcia/";


	public WoocommercePage(WebDriver driver) {
		super(driver);
		driver.get(url);
		bookingData = new HashMap<String, String>();
	}

	//+++++++++++++++++++++++++++ LOCATORS AND WEB ELEMENTS +++++++++++++++++++++++++++

	@FindBy(css ="[class='product_title entry-title']")
	private WebElement title;
	@FindBy(css ="p [class='woocommerce-Price-amount amount']")
	private WebElement price;
	@FindBy(css ="[name='quantity']")
	private WebElement quantityInput;
	@FindBy(css ="[name='add-to-cart']")
	private WebElement addToCartbutton;
	@FindBy(css ="[id='site-header-cart'] a span[class='count']")
	private WebElement itemCount;
	@FindBy(css ="[class='cart-contents']")
	private WebElement cartIcon;









	//+++++++++++++++++++++++++++ ACTIONS +++++++++++++++++++++++++++

	public Response createProductViaAPI(){

		JSONObject body = new JSONObject();

		body.put("name", "sergioGarcia");
		body.put("type", "simple");
		body.put("regular_price", "99");
		body.put("description", "test");
		body.put("short_description", "test");

		Response response = given()
				.header("Authorization", "Basic " + "4oCLc2hvcG1hbmFnZXI6YXhZMiByaW1jIFN6TzkgY29iZiBBWkJ3IE5Mblg=")
				.contentType("application/json")
				.body(body)
				.post("http://34.205.174.166/wp-json/wc/v3/products");

		String productID = Integer.toString(response.then().extract().path("id")) ;

		bookingData.put("productId", productID);
		System.out.println(bookingData);

		return response;
	}


	public boolean titleIsVisible(){
		getFluentWait().until(ExpectedConditions.visibilityOf(title));
		return title.isDisplayed();
	}
	public boolean priceIsVisible(){
		getFluentWait().until(ExpectedConditions.visibilityOf(price));
		return price.isDisplayed();
	}

	public void fillQuantity( String quantity){
		quantityInput.clear();
		quantityInput.sendKeys(quantity);
	}
	public void clickAddtoCartbutton(){
		clickInElement(addToCartbutton);

	}

	public boolean itemCountIsUpdated(String amountOfItems){
		itemCount = getDriver().findElement(By.cssSelector("[id='site-header-cart'] a span[class='count']"));
		return itemCount.getText().contains(amountOfItems);
	}

	public CartPage clickCartIcon(){
		clickInElement(cartIcon);
		return new CartPage(getDriver());
	}

	public Response deleteProductViaAPI(){


		Response response = given()
				.header("Authorization", "Basic " + "4oCLc2hvcG1hbmFnZXI6YXhZMiByaW1jIFN6TzkgY29iZiBBWkJ3IE5Mblg=")
				.contentType("application/json")
				.queryParam("force", "true")
				.delete("http://34.205.174.166/wp-json/wc/v3/products/" + bookingData.get("productId"));
		System.out.println("delete body " + response.getBody());
		return response;
	}








}
