package modules.sd_uat.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import telus.itsuppt.automation.support.ReportingTools;

public class AdjustBalancePage extends HomePage {

	public AdjustBalancePage(WebDriver driver) {
		super(driver);
	}

	// -------------------------------------------------------------------
	@FindBy(name = "adjustmentType")
	protected WebElement adjustmentTypeSelect;

	protected void waitForPageToLoad() {

		new WebDriverWait(driver, 60).until(ExpectedConditions
				.visibilityOf(adjustmentTypeSelect));
	}

	// -------------------------------------------------------------------

	protected void selectAdjustmentBalanceType(String choice) {
		new Select(adjustmentTypeSelect).selectByVisibleText(choice);
	}

	// -------------------------------------------------------------------
	@FindBy(name = "ssfService")
	protected WebElement serviceSelect;

	public void selectServiceType(String typeOfAdjustment) {
		new Select(serviceSelect).selectByVisibleText(typeOfAdjustment);

	}

	// -------------------------------------------------------------------

	@FindBy(id = "creditReasonCode")
	protected WebElement reasonCode;

	protected void selectreasonCode(String reasonToSelect) {
		new WebDriverWait(driver, 10).until(ExpectedConditions
				.visibilityOf(reasonCode));
		new Select(reasonCode).selectByVisibleText(reasonToSelect);
	}

	// -------------------------------------------------------------------
	@FindBy(name = "amount")
	protected WebElement ammountInputLabel;

	public void enterAmmount(String ammountt) {
		ammountInputLabel.clear();
		ammountInputLabel.sendKeys(ammountt);
	}

	// -------------------------------------------------------------------

	@FindBy(xpath = "//td[contains(text(),'adjustment confirmation')]/../..")
	protected WebElement adjustmentConfirmationMessage;

	protected void validateAdjustConfirmationTableCOmesUp() {
		new WebDriverWait(driver, 60).until(ExpectedConditions
				.visibilityOf(adjustmentConfirmationMessage));
		ReportingTools.highlightElement(adjustmentConfirmationMessage);

	}

	// -------------------------------------------------------------------

	@FindBy(xpath = "//td[text()= 'adjustment summary']/../..")
	protected WebElement adjustmentSummaryMessage;

	protected void validateAdjustSummaryTableComesUp() {
		new WebDriverWait(driver, 60).until(ExpectedConditions
				.visibilityOf(adjustmentSummaryMessage));
		ReportingTools.highlightElement(adjustmentSummaryMessage);
		ReportingTools
				.takeScreenshot("the adjustment summary table was captured");

	}

	// -------------------------------------------------------------------
	@FindBy(xpath = "//select[@name='adjustmentLevel']")
	protected WebElement adjustmentLevelDropdown;

	protected void selectAdjustmentLevelType(String level) {
		new Select(adjustmentLevelDropdown).selectByVisibleText(level);
	}

	// -------------------------------------------------------------------
	@FindBy(xpath = "//select[@name='rootCause_1']")
	protected WebElement creditDriverDropdown;

	protected void selectCreditDriverType(String creditDriver) {
		new Select(creditDriverDropdown).selectByVisibleText(creditDriver);
	}

	// -------------------------------------------------------------------
	@FindBy(xpath = "//select[@name='rootCause_2']")
	protected WebElement descriptionDropdown;

	protected void selectDescriptionType(String description) {
		new Select(descriptionDropdown).selectByVisibleText(description);
	}

	// -------------------------------------------------------------------
	@FindBy(xpath = "//select[@name='rootCause_3']")
	protected WebElement reasonDropdown;

	protected void selectReasonType(String reason) {
		new Select(reasonDropdown).selectByVisibleText(reason);
	}

	// -------------------------------------------------------------------

	@FindBy(xpath = "//a[.='calc']")
	protected WebElement calcButton;

	protected void clickOnCalcButton() {
		((JavascriptExecutor) driver).executeScript("arguments[0].click()",

		calcButton);

	}

	// -------------------------------------------------------------------

	public void performBalanceAdjustment(String typeOfAdjustment,
			String reasonToSelect, String ammount, String comment) {
		waitForPageToLoad();
		selectAdjustmentBalanceType(typeOfAdjustment);
		selectreasonCode(reasonToSelect);
		enterAmmount(ammount);
		enterComment(comment);
		clickOnSubmitButton();
	}

	// -------------------------------------------------------------------

	public void validateAdjustmentConfirmation() {

		validateAdjustConfirmationTableCOmesUp();
		clickOnAcceptButton();
		validateAdjustSummaryTableComesUp();
	}

	// -------------------------------------------------------------------
	public void performBalanceAdjustment(String typeOfAdjustment) {

		waitForPageToLoad();
		selectAdjustmentBalanceType(typeOfAdjustment);
	}

	// -------------------------------------------------------------------
	public void adjustBalance(String adjustmentType, String adjustmentLevel,
			String creditDriver, String description, String reason,
			String amount, String comment) throws InterruptedException {

		new WebDriverWait(driver, 40).until(ExpectedConditions
				.visibilityOf(adjustmentTypeSelect));
		selectAdjustmentBalanceType(adjustmentType);
		Thread.sleep(2000);
		selectAdjustmentLevelType(adjustmentLevel);
		Thread.sleep(2000);
		selectCreditDriverType(creditDriver);
		Thread.sleep(2000);
		selectDescriptionType(description);
		Thread.sleep(2000);
		selectReasonType(reason);
		Thread.sleep(2000);
		enterAmmount(amount);
		Thread.sleep(2000);
		clickOnCalcButton();
		enterComment(comment);
		ReportingTools.takeScreenshot("Filling in all the required details");
		clickOnSubmitButton();

	}
}
