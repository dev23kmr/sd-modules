package modules.sd_uat.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import telus.itsuppt.automation.support.ReportingTools;

public class TopUpPage extends HomePage {

	public TopUpPage(WebDriver driver) {
		super(driver);

	}

	// -------------------------------------------------------------------

	@FindBy(xpath = "//select[@id='paymentMethod']")
	protected WebElement topUpMethod;

	protected void selectTopUpMethod(String topUpValue) {
		new WebDriverWait(driver, 10).until(ExpectedConditions
				.visibilityOf(topUpMethod));
		ReportingTools.highlightElement(topUpMethod);
		new Select(topUpMethod).selectByVisibleText(topUpValue);
		ReportingTools.takeScreenshot("Top up method selected");
	}

	// -------------------------------------------------------------------

	@FindBy(xpath = "//input[@id='aircardNumber']")
	protected WebElement aircardNumberField;

	protected void enterAircardNumber(String aircardNumber) {

		aircardNumberField.clear();
		aircardNumberField.sendKeys(aircardNumber);
		ReportingTools.takeScreenshot("Entered the aircard number");

	}

	// -------------------------------------------------------------------

	@FindBy(xpath = "//td[contains(text(),'prepaid top-up confirmation')]")
	protected WebElement topUpConfirmationTab;

	// -------------------------------------------------------------------

	@FindBy(xpath = "//td[contains(text(),'prepaid top-up summary')]")
	protected WebElement topUpSummaryTab;

	// -------------------------------------------------------------------

	@FindBy(xpath = "//a[text() = 'rate details']")
	protected WebElement rateDetailsLink;

	protected void clickOnRateDeatilsLink() {

		new WebDriverWait(driver, 40).until(ExpectedConditions
				.visibilityOf(rateDetailsLink));
		ReportingTools.highlightElement(rateDetailsLink);
		rateDetailsLink.click();
		ReportingTools.takeScreenshot("Navigate to RATE DETAILS section");
	}

	// -------------------------------------------------------------------
	@FindBy(xpath = "//select[@id = 'airTimeRate']")
	protected WebElement airTimerateDropDown;

	protected void selectAirtimeRate(String airtimeRate) {
		new WebDriverWait(driver, 10).until(ExpectedConditions
				.visibilityOf(airTimerateDropDown));
		new Select(airTimerateDropDown).selectByVisibleText(airtimeRate);
	}

	// -------------------------------------------------------------------

	@FindBy(xpath = "//select[@id = 'balanceExpiryDay']")
	protected WebElement balanceExpDay;

	protected void selectbalanceExpDay(String day) {
		new Select(balanceExpDay).selectByVisibleText(day);
	}

	// -------------------------------------------------------------------
	@FindBy(xpath = "//select[@id = 'balanceExpiryMonth']")
	protected WebElement balanceExpMonth;

	protected void selectbalanceExpMonth(String month) {
		new Select(balanceExpMonth).selectByVisibleText(month);
	}

	// -------------------------------------------------------------------
	@FindBy(xpath = "//select[@id = 'balanceExpiryYear']")
	protected WebElement balanceExpYear;

	protected void selectbalanceExpYear(String year) {
		new Select(balanceExpYear).selectByVisibleText(year);
	}

	// -------------------------------------------------------------------

	/**
	 * 
	 * @param topUpMethod
	 *            select the type of top up method
	 * @param aircardNumber
	 *            enter the aircard number
	 * @param comment
	 *            enter comments
	 */

	public void performTopUpOfAccount(String topUpMethod, String aircardNumber,
			String comment) {
		selectTopUpMethod(topUpMethod);
		enterAircardNumber(aircardNumber);
		enterComments(comment);
		clickOnSubmitButton();

	}

	/**
	 * validating top up confirmation
	 */
	public void validateTopUpConfirmation()

	{
		new WebDriverWait(driver, 40).until(ExpectedConditions
				.visibilityOf(topUpConfirmationTab));
		ReportingTools.highlightElement(topUpConfirmationTab);
		ReportingTools.takeScreenshot("Top-up Confirmation page displayed");
		clickOnAcceptButton();
		new WebDriverWait(driver, 30).until(ExpectedConditions
				.visibilityOf(topUpSummaryTab));
		ReportingTools.highlightElement(topUpSummaryTab);
		ReportingTools.takeScreenshot("Top Up summary page displayed");

	}

	// -------------------------------------------------------------------
	public void navigateToRateDetailsSection(String airtimeRate, String day,
			String month, String year) {

		clickOnRateDeatilsLink();
		selectAirtimeRate(airtimeRate);
		selectbalanceExpDay(day);
		selectbalanceExpMonth(month);
		selectbalanceExpYear(year);
		clickOnSubmitButton();
	}
}
