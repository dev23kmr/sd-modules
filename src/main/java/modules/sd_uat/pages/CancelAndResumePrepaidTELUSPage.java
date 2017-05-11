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

public class CancelAndResumePrepaidTELUSPage extends HomePage {

	public CancelAndResumePrepaidTELUSPage(WebDriver driver) {
		super(driver);
	}

	// -------------------------------------------------------------------
	@FindBy(xpath = "//td[.='Resume Subscriber']/../..")
	protected WebElement resumeWebtable;

	protected void waitForResumePageToLoad() {

		new WebDriverWait(driver, 90).until(ExpectedConditions.visibilityOf(resumeWebtable));
		ReportingTools.takeScreenshot("the Resume page has loaded");
	}

	// -------------------------------------------------------------------

	@FindBy(xpath = "//textarea[@name = 'comment']")
	protected WebElement comments;

	protected void enterResumeComments(String commentResume) {
		comments.sendKeys(commentResume);
		ReportingTools.takeScreenshot("Details filled in Resume Page");
	}

	// -------------------------------------------------------------------

	@FindBy(xpath = "//a[.='submit']")
	protected WebElement submitButton;

	protected void clickSubmitButton() {
		submitButton.click();
		ReportingTools.takeScreenshot("Submit button clicked");
	}

	// -------------------------------------------------------------------
	@FindBy(xpath = "//td[text() = 'resume subscriber confirmation']/../..")
	protected WebElement resumeConfirmationWebtable;

	protected void waitForResumeConfirmation() {

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(resumeConfirmationWebtable));
		ReportingTools.takeScreenshot("Confirmation of Resume");
	}

	// -------------------------------------------------------------------

	@FindBy(xpath = "//a[.='accept']")
	protected WebElement acceptButton;

	protected void clickResumeAcceptButton() {
		acceptButton.click();
	}

	// -------------------------------------------------------------------
	@FindBy(xpath = "//td[text() = 'resume subscriber summary']/../..")
	protected WebElement resumeConfirmedWebtable;

	@FindBy(xpath = "//td[text() = 'subscriber was resumed successfully']")
	protected WebElement resumeConfirmationText;

	protected void waitForResumeConfirmedWebtable() {

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(resumeConfirmedWebtable));
		ReportingTools.takeScreenshot("resumeConfirmedWebtable");

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(resumeConfirmationText));
		ReportingTools.takeScreenshot("resumeConfirmationText");
	}

	// -------------------------------------------------------------------

	public void resumeFlow(String commentResume) {
		waitForResumePageToLoad();
		enterResumeComments(commentResume);
		clickSubmitButton();
		waitForResumeConfirmation();
		clickResumeAcceptButton();
		waitForResumeConfirmedWebtable();
	}
}
