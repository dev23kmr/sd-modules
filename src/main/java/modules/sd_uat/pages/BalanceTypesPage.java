package modules.sd_uat.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import telus.itsuppt.automation.support.ReportingTools;

public class BalanceTypesPage extends HomePage {

	public BalanceTypesPage(WebDriver driver) {
		super(driver);

	}

	// --------------------------------------------------------------------

	@FindBy(xpath = "//a[.='adjust db']")
	protected WebElement adjustDBLink;

	protected void clickOnAdjustDBLink() {
		new WebDriverWait(driver, 60).until(ExpectedConditions
				.visibilityOf(adjustDBLink));
		ReportingTools.highlightElement(adjustDBLink);

		ReportingTools.takeScreenshot("Clicking on adjust DB link");
		adjustDBLink.click();
	}

	// --------------------------------------------------------------------

	@FindBy(xpath = "//a[.='reverse db']")
	protected WebElement reverseDBLink;

	protected void clickOnReverseDBLink() {
		new WebDriverWait(driver, 60).until(ExpectedConditions
				.visibilityOf(reverseDBLink));
		ReportingTools.highlightElement(reverseDBLink);

		ReportingTools.takeScreenshot("Clicking on reverse DB link");
		reverseDBLink.click();
	}

	// --------------------------------------------------------------------

	@FindBy(xpath = "//select[@id='deviceBalanceReason']")
	protected WebElement adjustmentReason;

	protected void selectAdjustmentReason(String reason)

	{
		new WebDriverWait(driver, 10).until(ExpectedConditions
				.visibilityOf(adjustmentReason));
		new Select(adjustmentReason).selectByVisibleText(reason);
		ReportingTools.highlightElement(adjustmentReason);
		ReportingTools.takeScreenshot("Adjustment reason selected");
	}

	@FindBy(xpath = "//td[contains(text(),'adjust device balance confirmation')]")
	protected WebElement adjustDbConfirmationTab;

	// --------------------------------------------------------------------

	@FindBy(xpath = "//input[@id='amountInput']")
	protected WebElement amountField;

	protected void enterAmount(String amount)

	{
		new WebDriverWait(driver, 10).until(
				ExpectedConditions.visibilityOf(amountField)).sendKeys(amount);
		ReportingTools.takeScreenshot("Entered the amount");
	}

	// --------------------------------------------------------------------

	@FindBy(xpath = "//a[text() = 'balance history']")
	protected WebElement balanceHistoryLink;

	protected void clickOnBalanceHistoryLink() {

		new WebDriverWait(driver, 40).until(ExpectedConditions
				.visibilityOf(balanceHistoryLink));
		ReportingTools.highlightElement(balanceHistoryLink);
		ReportingTools.takeScreenshot("navigate to balance history section");
		balanceHistoryLink.click();
	}

	// ------------------------------------------------------------------
	@FindBy(xpath = "//select[@id = 'period']")
	protected WebElement selectPeriodDropdown;

	protected void selectPeriod(String period) {
		new WebDriverWait(driver, 30).until(ExpectedConditions
				.visibilityOf(selectPeriodDropdown));
		ReportingTools.highlightElement(selectPeriodDropdown);
		new Select(selectPeriodDropdown).selectByValue(period);
	}

	// -------------------------------------------------------------------
	@FindBy(xpath = "//table[@class = 'formPane']//a[.='search']")
	protected WebElement searchButton;

	public void clickOnSearchButton() {
		new WebDriverWait(driver, 10).until(ExpectedConditions
				.visibilityOf(searchButton));
		ReportingTools.takeScreenshot("Before clicking on search button");
		searchButton.click();
	}

	// -------------------------------------------------------------------
	@FindBy(xpath = "//td[@class = 'formPane']")
	protected WebElement transactionHistoryWebtable;

	protected void validateIfTransactionHistoryDetailsAppear() {

		try {
			new WebDriverWait(driver, 30).until(ExpectedConditions
					.visibilityOf(transactionHistoryWebtable));
			ReportingTools.highlightElement(transactionHistoryWebtable);
			ReportingTools.takeScreenshot("the transaction history appears");
		} catch (Exception ex) {
			Assert.fail("the transaction history doesnot appear");
		}

	}

	/**
	 * 
	 * @param reason
	 *            :Select the reason(mostly we use Goodwill)
	 * @param amount
	 *            :Enter the amount to be charged
	 * @param comment
	 *            :Enter the comments
	 */
	public void adjustDeviceBalance(String reason, String amount, String comment) {
		clickOnAdjustDBLink();
		selectAdjustmentReason(reason);
		enterAmount(amount);
		enterComments(comment);
		clickOnSubmitButton();

	}

	/**
	 * Validating Device Balance adjusted
	 */

	public void validateDBAdjustment() {
		new WebDriverWait(driver, 10).until(ExpectedConditions
				.visibilityOf(adjustDbConfirmationTab));
		ReportingTools.highlightElement(adjustDbConfirmationTab);
		ReportingTools
				.takeScreenshot("Adjust Balance Confirmation page displayed");
		clickOnAcceptButton();
	}

	/**
	 * Reversing the device balance
	 * 
	 * @param comment
	 */
	public void reverseDeviceBalance(String comment) {
		clickOnReverseDBLink();
		ReportingTools.takeScreenshot("Reverse device balance confirmation");
		enterComment(comment);
     	clickOnAcceptButton();

	}

	public void validateBalanceHistory(String period) {

		clickOnBalanceHistoryLink();
		selectPeriod(period);
		clickOnSearchButton();
		validateIfTransactionHistoryDetailsAppear();
	}
}
