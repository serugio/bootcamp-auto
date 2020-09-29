package com.automation.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;

public class EspnMainPage extends BasePage {

	protected String url = "https://www.espn.com/?src=com&_adblock=true";

	
	public EspnMainPage(WebDriver driver) {
		super(driver);
		driver.get(url);
	}

	//+++++++++++++++++++++++++++ LOCATORS +++++++++++++++++++++++++++

	@FindBy(id = "global-user-trigger")
	private WebElement userIcon;
	
	@FindBy(css=".user a[tref*='login']")
	private WebElement logInButton;

	@FindBy(css="#did-ui-view a.btn")
	private WebElement signUpButton;

	@FindBy(id = "disneyid-iframe")
	private WebElement logInIframe;

	@FindBy(css="[name='firstName']")
	private WebElement firstNameTextInput;

	@FindBy(css="[name='lastName']")
	private WebElement lastNameTextInput;

	@FindBy(css="[name='email']")
	private WebElement emailTextInput;

	@FindBy(css="[name='newPassword']")
	private WebElement signUpModalPasswordTextInput;

	@FindBy(css="[id='did-ui-view'] [type='submit']")
	private WebElement signUpModalButton;

	@FindBy(css="[id='did-ui-view'] [type='email']")
	private WebElement loginModalUserNameTextInput;

	@FindBy(css="[id='did-ui-view'] [type='password']")
	private WebElement loginModalPasswordTextInput;

	@FindBy(css="[id='did-ui-view'] [type='submit']")
	private WebElement loginModalLogInButton;

	@FindBy(css=".user a[tref*='modifyAccount']")
	private WebElement profileButton;

	@FindBy(id="cancel-account")
	private WebElement profileModalDeleteAccount;

	@FindBy(css="[id='did-ui-view'] [type='submit']")
	private WebElement profileModalConfirmDeleteAccountButton;

	@FindBy(css="[id='did-ui-view'] [type='submit']")
	private WebElement deletionConfirmationIframe;


	//+++++++++++++++++++++++++++ ACTIONS +++++++++++++++++++++++++++

	public void clickUserIcon() {
		try {
			clickInElement(userIcon);
		}catch (Exception e){
			getDriver().navigate().refresh();
			getWait().until(ExpectedConditions.visibilityOfElementLocated(By.id("global-user-trigger")));
			userIcon = getDriver().findElement(By.id("global-user-trigger"));
			clickInElement(userIcon);
		}

	}

	public void clickLogInButton() {
		clickInElement(logInButton);
		getWait().until(ExpectedConditions.visibilityOf(logInIframe));
		getDriver().switchTo().frame("disneyid-iframe");
	}

	public void clickSignUpButton() {
		signUpButton.click();
	}

	public void fillSignUpForm(String name, String lastName, String email, String password) {
		getWait().until(ExpectedConditions.visibilityOf(firstNameTextInput));
		typeInTextInputElement(name, firstNameTextInput);
		typeInTextInputElement(lastName, lastNameTextInput);
		typeInTextInputElement(email, emailTextInput);
		typeInTextInputElement(password, signUpModalPasswordTextInput);
	}

	public void clickSignUpModalButton() {
		scrollToElement(signUpModalButton);
		clickInElement(signUpModalButton);
		getDriver().switchTo().defaultContent();
		getWait().until(ExpectedConditions.visibilityOfElementLocated(By.id("global-user-trigger")));
	}

	public void fillSignInForm(String userName, String password) {
		getWait().until(ExpectedConditions.visibilityOf(loginModalUserNameTextInput));
		typeInTextInputElement(userName, loginModalUserNameTextInput);
		typeInTextInputElement(password, loginModalPasswordTextInput);
	}

	public void clickLoginModalLogInButton(){
		clickInElement(loginModalLogInButton);
		getDriver().switchTo().defaultContent();
	}

	public boolean logInIframeIsDisplayed() {

		return logInIframe.isDisplayed();
	}

	public void clickProfileButton(){
		clickInElement(profileButton);
		getWait().until(ExpectedConditions.visibilityOf(logInIframe));
		getDriver().switchTo().frame("disneyid-iframe");
	}

	public void clickProfileModalDeleteAccount(){
		clickInElement(profileModalDeleteAccount);
	}

	public void clickProfileModalConfirmDeleteAccountButton(){
		clickInElement(profileModalConfirmDeleteAccountButton);
		getWait().until(ExpectedConditions.visibilityOfElementLocated(By.id("global-user-trigger")));
	}




}
