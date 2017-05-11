package modules.sd_uat.pages;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import telus.itsuppt.automation.support.ReportingTools;

public class EditInformationPage extends HomePage {

	public EditInformationPage(WebDriver driver) {
		super(driver);
	}

	// -------------------------------------------------------------------

	@FindBy(xpath = "//td[contains(text(),'change contact/client information')]")
	protected WebElement changeContactAndClientInformationTab;

	// -------------------------------------------------------------------

	@FindBy(xpath = "//td[contains(text(),'Your updates have been sent to the back-end systems')]")
	protected WebElement changeAddressUpdateMessage;

	// -------------------------------------------------------------------

	@FindBy(xpath = "//a[.='client']")
	protected WebElement clientLink;

	// -------------------------------------------------------------------

	public void clickOnClientLink() {

		new WebDriverWait(driver, 10).until(
				ExpectedConditions.visibilityOf(clientLink)).click();

	}

	// -------------------------------------------------------------------

	@FindBy(name = "pin")
	protected WebElement pinTab;

	protected void enterPin(String text) {
		new WebDriverWait(driver, 10).until(ExpectedConditions
				.visibilityOf(pinTab));
		pinTab.clear();
		pinTab.sendKeys(text);
		ReportingTools.takeScreenshot("Entered the new pin");
	}

	// -------------------------------------------------------------------

	@FindBy(xpath = "//input[@id='streetNumber']")
	protected WebElement streetNumberField;

	protected void enterStreetNumber(String text) {
		new WebDriverWait(driver, 10).until(ExpectedConditions
				.visibilityOf(streetNumberField));
		streetNumberField.clear();
		streetNumberField.sendKeys(text);
		ReportingTools.takeScreenshot("Entered the Street Number");
	}

	// -------------------------------------------------------------------

	@FindBy(xpath = "//input[@id='streetName']")
	protected WebElement streetNameField;

	protected void enterStreetName(String text) {
		new WebDriverWait(driver, 10).until(ExpectedConditions
				.visibilityOf(streetNameField));
		streetNameField.clear();
		streetNameField.sendKeys(text);
		ReportingTools.takeScreenshot("Entered the Street Namer");
	}

	// -------------------------------------------------------------------

	@FindBy(xpath = "//select[@id='streetType']")
	protected WebElement streetTypeDropdown;

	protected void selectStreetType(String street) {

		new WebDriverWait(driver, 10).until(ExpectedConditions
				.visibilityOf(streetTypeDropdown));
		ReportingTools.highlightElement(streetTypeDropdown);
		new Select(streetTypeDropdown).selectByValue(street);
		ReportingTools.takeScreenshot("Street selected");
	}

	// -------------------------------------------------------------------

	@FindBy(xpath = "//input[@id='city']")
	protected WebElement cityField;

	protected void enterCityName(String text) {
		new WebDriverWait(driver, 10).until(ExpectedConditions
				.visibilityOf(cityField));
		cityField.clear();
		cityField.sendKeys(text);
		ReportingTools.takeScreenshot("Entered the City Name");
	}

	// -------------------------------------------------------------------

	@FindBy(xpath = "//select[@id='province']")
	protected WebElement provinceDropdown;

	protected void selectProvince(String province) {

		new WebDriverWait(driver, 10).until(ExpectedConditions
				.visibilityOf(provinceDropdown));
		ReportingTools.highlightElement(provinceDropdown);
		new Select(provinceDropdown).selectByVisibleText(province);
		ReportingTools.takeScreenshot("Province selected");
	}

	// -------------------------------------------------------------------

	@FindBy(xpath = "//input[@id='postalCode']")
	protected WebElement postalCodeField;

	protected void enterPostalCode(String text) {
		new WebDriverWait(driver, 10).until(ExpectedConditions
				.visibilityOf(postalCodeField));
		postalCodeField.clear();
		postalCodeField.sendKeys(text);
		ReportingTools.takeScreenshot("Entered the Postal Code");
	}

	// -------------------------------------------------------------------
	
	@FindBy(xpath = "//td[.='contact/client change confirmation']")
	protected WebElement changeCustomerInformationConfirmation;
	
	// -------------------------------------------------------------------
	
	//Driver's License Number
	@FindBy(name = "drvLicNumber")
	protected WebElement driversLicenseNumber;
	
	protected void enterDriversLicenseNumber(String driversLicenseNo){
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(driversLicenseNumber)).clear();
		driversLicenseNumber.sendKeys(driversLicenseNo);
	}
	
	//Driver's License Province
	@FindBy(name = "drvLicProv")
	protected WebElement driversLicenseProvince;
	
	protected void selectDriversLicenseProvince(String drvLicenseProvince){
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(driversLicenseProvince));
		new Select(driversLicenseProvince).selectByVisibleText(drvLicenseProvince);
	}
	
	//Driver's License Year
	@FindBy(name = "drvLicYear")
	protected WebElement driversLicenseExpiryYear;
	
	protected void selectDriversLicenseExpiryYear(String drvLicenseExpiryYear){
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(driversLicenseExpiryYear));
		new Select(driversLicenseExpiryYear).selectByVisibleText(drvLicenseExpiryYear);
	}
	
	//Driver's License date
	@FindBy(name = "drvLicDay")
	protected WebElement driversLicenseExpiryDate;
	
	protected void selectDriversLicenseExpiryDate(String drvLicenseExpiryDate){
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(driversLicenseExpiryDate));
		new Select(driversLicenseExpiryDate).selectByVisibleText(drvLicenseExpiryDate);
	}
	
	//Driver's License Year
	@FindBy(name = "drvLicMonth")
	protected WebElement driversLicenseExpiryMonth;
	
	protected void selectDriversLicenseExpiryMonth(String drvLicenseExpiryMonth){
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(driversLicenseExpiryMonth));
		new Select(driversLicenseExpiryMonth).selectByValue(drvLicenseExpiryMonth);
	}

	/********************************* METHODS ************************/

	public void changePin(String pin, String comment) {
		try {
			ReportingTools
					.highlightElement(changeContactAndClientInformationTab);
			ReportingTools
					.takeScreenshot("Change contact/client information page displayed");
			clickOnClientLink();
			enterPin(pin);
			clickOnSubmitButton();
			enterComments(comment);
			clickOnAcceptButton();
		} catch (NoSuchElementException ex) {
			Assert.fail("Not able to find an element on the client page");
		}

	}

	public void changeAddress(String streetNumber, String streetName,
			String streetType, String city, String province, String postalCode) {
		enterStreetNumber(streetNumber);
		enterStreetName(streetName);
		selectStreetType(streetType);
		enterCityName(city);
		selectProvince(province);
		enterPostalCode(postalCode);
		clickOnSubmitButton();

	}

	public void validateAddressChanged(String comment) {
		new WebDriverWait(driver, 10).until(ExpectedConditions
				.visibilityOf(changeCustomerInformationConfirmation));
		ReportingTools.highlightElement(changeCustomerInformationConfirmation);
		ReportingTools.takeScreenshot("Change information confirmation page");
		enterComment(comment);
		clickOnAcceptButton();
		
		ReportingTools.takeScreenshot("Entered comments and clicked on accept button");
		
		new WebDriverWait(driver, 10).until(ExpectedConditions
				.visibilityOf(changeAddressUpdateMessage));
		ReportingTools.highlightElement(changeAddressUpdateMessage);
		ReportingTools.takeScreenshot("Change Address Update Message displayed");
		

	}
	
	public void handleAddressSuggestion(){
		try {
			new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.linkText("force change"))).click();
		} catch (Exception e) {
			System.out.println("Address suggestion was not present");
		}
	}
	
	/**
	 * Change Drivers License details
	 */
	public void enterDriversLicenseDetails(String driversLicenseNo, String driversLicenseProvince,String comment){
		clickOnClientLink();
		enterDriversLicenseNumber(driversLicenseNo);
		selectDriversLicenseProvince(driversLicenseProvince);

		GregorianCalendar date = new GregorianCalendar();
		selectDriversLicenseExpiryDate(String.valueOf(date.get(Calendar.DATE)));
		selectDriversLicenseExpiryMonth(String.valueOf(date.get(Calendar.MONTH)));
		selectDriversLicenseExpiryYear(String.valueOf(date.get(Calendar.YEAR)+10));
		clickOnSubmitButton();
		enterComment(comment);
		clickOnAcceptButton();
	}

}
