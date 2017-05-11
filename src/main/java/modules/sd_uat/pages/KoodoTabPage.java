package modules.sd_uat.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import telus.itsuppt.automation.support.ReportingTools;

public class KoodoTabPage extends HomePage {

	public KoodoTabPage(WebDriver driver) {
		super(driver);
	}

	// -------------------------------------------------------------------

	@FindBy(name = "period")
	protected WebElement selectPeriod;

	public void selectValuePeriod(String value) {
		new Select(selectPeriod).selectByVisibleText(value);

	}

	// -------------------------------------------------------------------

	@FindBy(xpath = "//td[text()='solde actuel (fixe) :']//following::td[1]")
	protected WebElement tabBalanceFrench;

	@FindBy(xpath = "//td[.='current balance :']//following::td[1]")
	protected WebElement tabBalance;
	
	// -------------------------------------------------------------------
	
	
	@FindBy(xpath="//a[.='balance adjustment']")
	protected WebElement balanceAdjustmentLink;
	
	protected void clickOnBalanceAdjustmentLink()
	{
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(balanceAdjustmentLink));
		ReportingTools.highlightElement(balanceAdjustmentLink);
		ReportingTools.takeScreenshot("Clicking on balance Adjustment link");
		balanceAdjustmentLink.click();
	}
	
	// -------------------------------------------------------------------

	/**
	 * @author naitik.kumar.tarway
	 */
	// -------------------------------------------------------------------

	@FindBy(xpath = "//a[text() = 'change tab type']")
	protected WebElement changeTabTypeTab;

	protected void clickOnChangeTabType() {
		ReportingTools.highlightElement(changeTabTypeTab);
		ReportingTools.takeScreenshot("changing the tab type ");
		changeTabTypeTab.click();
	}

	// -------------------------------------------------------------------
	@FindBy(xpath = "//td[text() = 'current balance:']/../td[2]")
	protected WebElement currentBalance;

	protected void getCurrentBalance() {
		String currentBal = currentBalance.getText();
		ReportingTools.highlightElement(currentBalance);
		ReportingTools.takeScreenshot("the current Balance is " + currentBal);
	}


	@FindBy(xpath="//select[@id='reasonType']")
	protected WebElement adjustmentReasonDropdown;
	
	protected void selectAdjustmentReason(String reason)
	
	{
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(adjustmentReasonDropdown));
		new Select(adjustmentReasonDropdown).selectByVisibleText(reason);
		ReportingTools.highlightElement(adjustmentReasonDropdown);
		ReportingTools.takeScreenshot("Adjustment reason selected");
	}
	
	
	// -------------------------------------------------------------------
	
	@FindBy(xpath="//input[@id='amount']")
	protected WebElement amountField;
	
	protected void enterAmount(String amount) 
	
	{
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(amountField)).sendKeys(amount);
		ReportingTools.takeScreenshot("Entered the amount");
	}
	
	// -------------------------------------------------------------------
	
	
	@FindBy(xpath="//td[contains(text(),'adjust balance confirmation')]")
	protected WebElement adjustBalanceConfirmationTab;
	
	
	// -------------------------------------------------------------------
	
	
	@FindBy(xpath="//td[contains(text(),'Tab balance adjusted successfully.')]")
	protected WebElement successfulBalanceAdjustmentMessage;
	
	// -------------------------------------------------------------------
	
	
	@FindBy(xpath = "//textarea[@name='noteText']")
	protected WebElement commentField;

	// -------------------------------------------------------------------
	
	
	public void enterComments(String comment) {
		new WebDriverWait(driver, 10).until(ExpectedConditions
				.visibilityOf(commentField));
		commentField.clear();
		commentField.sendKeys(comment);
		ReportingTools.takeScreenshot("Entered the comments");
	}
	
	/*
	 * Methods
	 */

	
	/**
	 * 
	 * @param reason:Select the reason(mostly we use Goodwill)
	 * @param amount:Enter the amount to be charged
	 * @param comment:Enter the comments
	 */
	public void chargeTab(String reason,String amount,String comment)
	{
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(balanceAdjustmentLink));
		ReportingTools.takeScreenshot("Page loaded after clicking on koodo tab link");
		clickOnBalanceAdjustmentLink();
		selectAdjustmentReason(reason);
		enterAmount(amount);
		enterComments(comment);
		clickOnSubmitButton();
		
	}
	
	
	/**
	 * 
	 * @param reason:Select the reason(mostly we use Goodwill)
	 * @param amount:Enter the amount to be charged
	 * @param comment:Enter the comments
	 */
	public void creditTab(String reason,String amount,String comment)
	{
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(balanceAdjustmentLink));
		ReportingTools.takeScreenshot("Page loaded after clicking on koodo tab link");
		clickOnBalanceAdjustmentLink();
		selectAdjustmentReason(reason);
		enterAmount(amount);
		enterComments(comment);
		clickOnSubmitButton();
		
	}
	
	
	/**
	 * Validate balance adjusted successfully
	 */
	
	public void validateTabAdjustmentSuccessful()
	{
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(adjustBalanceConfirmationTab));
		ReportingTools.highlightElement(adjustBalanceConfirmationTab);
		ReportingTools.takeScreenshot("Adjust Balance Confirmation page displayed");
		clickOnAcceptButton();
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(successfulBalanceAdjustmentMessage));
		ReportingTools.highlightElement(successfulBalanceAdjustmentMessage);
		ReportingTools.takeScreenshot("Tab Balance adjusted successfully");
	}

}
