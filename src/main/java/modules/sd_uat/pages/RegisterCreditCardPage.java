package modules.sd_uat.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import telus.itsuppt.automation.support.ReportingTools;

public class RegisterCreditCardPage extends CommonPage {
	
	public RegisterCreditCardPage(WebDriver driver){
		super(driver);
	}
	
	
	/*----------------------------------------------OBJECTS--------------------------------------------*/
	
	//Credit Card Type list
	@FindBy(xpath = "//select[@name = 'CardType' or @name = 'cardType']")
	private WebElement creditCardTypeList;
	
	public void selectCreditCardType(String creditCardType){
		try {
			Select ccType = new Select(creditCardTypeList);
			ccType.selectByVisibleText(creditCardType);
			ReportingTools.takeScreenshot("Credit card type is selected");
		} catch (Exception e) {
			Assert.fail("Not able to select Credit card type");
		}
	}
	
	//Credit Card Number
	@FindBy(xpath = "//input[@name = 'number' or @name = 'cardNumber']")
	private WebElement creditCardNumberField;
	
	public void enterCreditCardNumber(String creditCardNumber){
		try {
			creditCardNumberField.clear();
			creditCardNumberField.sendKeys(creditCardNumber);
			ReportingTools.takeScreenshot("Credit card number is entered");
		} catch (Exception e) {
			Assert.fail("Not able to enter Credit card number");
		}
	}
	
	//Expiry month list
	@FindBy(name = "expiryMonth")
	private WebElement expiryMonthList;
	
	public void selectExpiryMonth(String expiryMonth){
		try {
			Select expMonth = new Select(expiryMonthList);
			expMonth.selectByVisibleText(expiryMonth);
		} catch (Exception e) {
			Assert.fail("Not able to select expiry month");
		}
	}
	
	//Expiry year list
	@FindBy(name = "expiryYear")
	private WebElement expiryYearList;
	
	public void selectExpiryYear(String expiryYear){
		try {
			Select expMonth = new Select(expiryYearList);
		
			expMonth.selectByVisibleText(expiryYear);
		
		} catch (Exception e) {
			Assert.fail("Not able to select expiry year");
		}
	}
	
	//Update button
	@FindBy(xpath = "//a[contains(.,'update')]")
	private WebElement updateButton;
	
	public void clickUpdateButton(){
		try {
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(updateButton));
			ReportingTools.takeScreenshot("Update button is clicked");
			updateButton.click();
		} catch (Exception e) {
			Assert.fail("Not able to click update button");
		}
	}
	
	//Update button
	@FindBy(xpath = "//a[contains(.,'remove')]")
	private WebElement removeButton;
	
	public void clickRemoveButton(){
		try {
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(removeButton));
			ReportingTools.takeScreenshot("Remove button is clicked");
			removeButton.click();
		} catch (Exception e) {
			Assert.fail("Not able to click remove button");
		}
	}
	
	/*----------------------------------------------METHODS--------------------------------------------*/
	
	/**
	 * Register a Credit Card
	 */
	public void registerCreditCard(String creditCardType,String creditCardNumber,String expiryMonth,String expiryYear){
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(creditCardNumberField));
		selectCreditCardType(creditCardType);
		enterCreditCardNumber(creditCardNumber);
		selectExpiryMonth(expiryMonth);
		selectExpiryYear(expiryYear);
		clickUpdateButton();
		clickOnAcceptButton();
	}
	
	/**
	 * Remove Credit Card
	 */
	public void removeCreditCard(){
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(creditCardNumberField));
		clickRemoveButton();
		clickOnAcceptButton();
	}
}
