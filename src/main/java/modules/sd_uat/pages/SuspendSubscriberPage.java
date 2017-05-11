package modules.sd_uat.pages;

/**
 * @author richa.a.mittal
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import telus.itsuppt.automation.support.ReportingTools;

public class SuspendSubscriberPage extends HomePage {

	public SuspendSubscriberPage(WebDriver driver) {
		super(driver);
	}

	// -------------------------------------------------------------------
	@FindBy(xpath = "//td[.='suspend subscriber']/../..")
	protected WebElement suspendSubscriberWebtable;

	protected void waitForsuspendSubscriberPageToLoad() {

		new WebDriverWait(driver, 90).until(ExpectedConditions.visibilityOf(suspendSubscriberWebtable));
		ReportingTools.takeScreenshot("the suspend subscriber page has loaded");
	}

	// -------------------------------------------------------------------

	@FindBy(xpath = "//select[@id = 'suspensionReason']")
	protected WebElement suspensionReason;

	protected void selectSuspensionReason(String SuspendReason) {
		new Select(suspensionReason).selectByValue(SuspendReason);
	}
	
	// -------------------------------------------------------------------
	
	@FindBy(xpath = "//textarea[@name = 'comment']")
	protected WebElement commentSuspend;

	protected void enterSuspendComments(String comment) {
		commentSuspend.sendKeys(comment);
		ReportingTools.takeScreenshot("Details filled in Suspend Subscriber Page");
	}

	// -------------------------------------------------------------------

	@FindBy(xpath = "//a[.='submit']")
	protected WebElement submitButton;

	protected void clickSubmitButton() {
		submitButton.click();
		ReportingTools.takeScreenshot("Submit button clicked");
	}

	// -------------------------------------------------------------------
	@FindBy(xpath = "//td[text() = 'suspend subscriber confirmation']/../..")
	protected WebElement suspendConfirmationWebtable;

	protected void waitForSuspendConfirmationWebtable() {

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(suspendConfirmationWebtable));
		ReportingTools.takeScreenshot("Confirmation of suspension");
	}

	// -------------------------------------------------------------------

	@FindBy(xpath = "//a[.='accept']")
	protected WebElement acceptButton;

	protected void clickSuspendAcceptButton() {
		acceptButton.click();
	}

	// -------------------------------------------------------------------
	@FindBy(xpath = "//td[text() = 'suspend subscriber summary']/../..")
	protected WebElement suspendConfirmedWebtable;

	protected void waitForSuspendConfirmedWebtable() {

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(suspendConfirmedWebtable));
		ReportingTools.takeScreenshot("suspend Confirmed Webtable");
	}

	// -------------------------------------------------------------------

	public void suspendSubscriberFlow(String SuspendReason, String comment) {
		waitForsuspendSubscriberPageToLoad();
		selectSuspensionReason(SuspendReason);
		enterSuspendComments(comment);
		clickSubmitButton();
		waitForSuspendConfirmationWebtable();
		clickSuspendAcceptButton();
		waitForSuspendConfirmedWebtable();
		
	}
}
