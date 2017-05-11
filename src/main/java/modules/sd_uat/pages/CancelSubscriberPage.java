package modules.sd_uat.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import telus.itsuppt.automation.support.ReportingTools;

public class CancelSubscriberPage extends HomePage {

	public CancelSubscriberPage(WebDriver driver) {
		super(driver);
	}

	// -------------------------------------------------------------------
	@FindBy(xpath = "//td[.='cancel subscriber']/../..")
	protected WebElement cancelSubscriberWebtable;

	protected void waitForPageToLoad() {

		new WebDriverWait(driver, 60).until(ExpectedConditions
				.visibilityOf(cancelSubscriberWebtable));
		ReportingTools.takeScreenshot("the cancel sub page has loaded");
	}

	// -------------------------------------------------------------------

	@FindBy(xpath = "//select[@name = 'effective']")
	protected WebElement effectiveDate;

	protected void selectEffectiveDate(String date) {
		new Select(effectiveDate).selectByVisibleText(date);
	}

	// -------------------------------------------------------------------

	@FindBy(xpath = "//select[@id = 'cancellationReason']")
	protected WebElement cancellationReason;

	protected void selectCancellationReason(String cancelReason) {
		new Select(cancellationReason).selectByValue(cancelReason);
	}

	// -------------------------------------------------------------------
	
	 
	
	 /*@FindBy(xpath = "//select[@id = 'idReturnPolicy']")
		protected WebElement returnPolicy;*/
	protected void selectReturnPolicy(String retPolicy) {
		 try {
			 WebElement returnPolicy = driver.findElement(By.xpath("//select[@id = 'idReturnPolicy']"));	
			 new WebDriverWait(driver, 10).until(ExpectedConditions
						.visibilityOf(returnPolicy));
				new Select(returnPolicy).selectByVisibleText(retPolicy);
			} catch (Exception e) {
				e.printStackTrace();
			} 
		 
	}

	// -------------------------------------------------------------------
	@FindBy(xpath = "//td[text() = 'cancel subscriber confirmation']/../..")
	protected WebElement cancelSubscriberConfirmationWebtable;

	protected void waitForCancelSubscriberConfirmation() {

		new WebDriverWait(driver, 60).until(ExpectedConditions
				.visibilityOf(cancelSubscriberConfirmationWebtable));
		ReportingTools.highlightElement(cancelSubscriberConfirmationWebtable);
	}

	// -------------------------------------------------------------------
	@FindBy(xpath = "//td[text() = 'cancel subscriber summary']/../..")
	protected WebElement cancelSubscriberSummaryWebtable;

	protected void waitForCancelSubscriberSummary() {

		new WebDriverWait(driver, 60).until(ExpectedConditions
				.visibilityOf(cancelSubscriberSummaryWebtable));
		ReportingTools.highlightElement(cancelSubscriberSummaryWebtable);
		ReportingTools.takeScreenshot("the subscriber cancel confirmation");
	}

	// -------------------------------------------------------------------
	public void cancelSubscriber(String date, String cancelReason,
			String retPolicy, String comment) {
		waitForPageToLoad();
		selectEffectiveDate(date);
		selectCancellationReason(cancelReason);
		selectReturnPolicy(retPolicy);
		enterComment(comment);
		clickOnSubmitButton();
	}

	public void confirmSubscribercancellation() {

		waitForCancelSubscriberConfirmation();
		clickOnAcceptButton();
		waitForCancelSubscriberSummary();
	}
}
