package modules.sd_uat.pages;

import org.openqa.selenium.By;
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

public class ResumeSuspendedSubscriberPage extends HomePage {

	public ResumeSuspendedSubscriberPage(WebDriver driver) {
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
	
	@FindBy(xpath = "(//td[.='Resume Subscriber']/../..) | (//td[.='resume multiple subscribers']/../..)")
	protected WebElement resumeWebtable1;

	
	//@Richa code modified for multiple subscriber
	protected void waitForMultiResumePageToLoad(String PhoneNumber) {

		new WebDriverWait(driver, 90).until(ExpectedConditions.visibilityOf(resumeWebtable1));
		ReportingTools.takeScreenshot("the Resume page has loaded");
		try {
			WebElement multipleSubCheckbox = driver.findElement(By.xpath("//input[@type = 'checkbox'][@name = 'chk_"+PhoneNumber+"']"));
			multipleSubCheckbox.click();
		} catch(Exception e)
		{
			System.out.println("No Multiple subscriber to Resume " + e);
		}
		
	}

	// -------------------------------------------------------------------

	@FindBy(xpath = "//textarea[@name = 'comment']")
	protected WebElement comments;

	protected void enterResumeComments(String suspendComment) {
		comments.sendKeys(suspendComment);
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

	public void resumeSuspendedSubscriber(String suspendComment) {
		waitForResumePageToLoad();
		//waitForMultiResumePageToLoad(PhoneNumber);
		enterResumeComments(suspendComment);
		clickSubmitButton();
		waitForResumeConfirmation();
		clickResumeAcceptButton();
		waitForResumeConfirmedWebtable();
	}
	
	public void resumeSuspendedSubscriber1(String PhoneNumber, String suspendComment) {
		//waitForResumePageToLoad();
		waitForMultiResumePageToLoad(PhoneNumber);
		enterResumeComments(suspendComment);
		clickSubmitButton();
		waitForResumeConfirmation();
		clickResumeAcceptButton();
		waitForResumeConfirmedWebtable();
	}
}
