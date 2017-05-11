package modules.sd_uat.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import telus.itsuppt.automation.support.ReportingTools;

public class ReportLostStolenEquipmentPage extends HomePage {

	public ReportLostStolenEquipmentPage(WebDriver driver) {
		super(driver);
	}

	// -------------------------------------------------------------------
/*//	@FindBy(xpath = "//td[.='lost/stolen/found']/../..")
	@FindBy(xpath = "//td[.='lost/stolen/found']")
	protected WebElement lostStolenWebtable;

	protected void waitForPageToLoad() {

		new WebDriverWait(driver, 60).until(ExpectedConditions
				.visibilityOf(lostStolenWebtable));
		ReportingTools.takeScreenshot("the report stolen page has loaded");
	}
*/
	// -------------------------------------------------------------------

	@FindBy(xpath = "//input[@type = 'radio'][@value = '0']")
	protected WebElement lostradioButton;

	protected void selectLostRadioButton() {
		lostradioButton.click();
	}

	/*
	  @Richa 29 September - Change in Lost/Stolen functionality 
	  3 functions
	 */
	// -------------------------------------------------------------------

	@FindBy(xpath = "//input[@id = 'whichDevice'][@onclick = 'showMarkSimDevice();']")
	protected WebElement currentSIMDeviceRadioButton;

	protected void selectCurrentSIMDeviceRadioButton() throws InterruptedException {
		Thread.sleep(7000);
		currentSIMDeviceRadioButton.click();
	}
	
	// -------------------------------------------------------------------

	@FindBy(xpath = "//table[@class = 'formPane']//tr[@class = 'formFooter']/..//tr/td/textarea")
	protected WebElement lostComment;

	protected void enterLostComments() {
		lostComment.sendKeys("Automation Test - Lost/Stolen - Lost");
		ReportingTools.takeScreenshot("Details filled in Lost Stolen Page");
	}
	
	// -------------------------------------------------------------------

		@FindBy(xpath = "//a[text()='flag lost']")
		protected WebElement flagLostButton;

		protected void clickFlagLostButton() {
			ReportingTools.takeScreenshot("Before click flag lost button");
			flagLostButton.click();
		}
	
	// -------------------------------------------------------------------

	@FindBy(xpath = "//textarea[@name = 'comment']")
	protected WebElement comment;

	protected void enterComments() {
		comment.sendKeys("Automation Test - Lost/Stolen - Lost");
		ReportingTools.takeScreenshot("Details filled in Lost Stolen Page");
	}

	// -------------------------------------------------------------------

	@FindBy(xpath = "//a[.='submit']")
	protected WebElement submitButton;

	protected void clickSubmitButton() {
		submitButton.click();
		ReportingTools.takeScreenshot("Submit button clicked");
	}

	// -------------------------------------------------------------------
	@FindBy(xpath = "//td[text() = 'lost/stolen confirmation']/../..")
	protected WebElement lostStolenConfirmationWebtable;

	protected void waitForlostStolenConfirmation() {

		new WebDriverWait(driver, 60).until(ExpectedConditions
				.visibilityOf(lostStolenConfirmationWebtable));
		ReportingTools.takeScreenshot("Confirmation of Lost Stolen");
		//ReportingTools.highlightElement(lostStolenConfirmationWebtable);
	}
	
	// -------------------------------------------------------------------
	
	@FindBy(xpath = "//a[.='accept']")
	protected WebElement acceptButton;

	protected void clickAcceptButton() {
		acceptButton.click();
	}

	// -------------------------------------------------------------------

	public void lostStolen() {
		//waitForPageToLoad();
		selectLostRadioButton();
		enterComments();
		clickSubmitButton();
		waitForlostStolenConfirmation();
		clickAcceptButton();
		
	}
	
	public void lostStolenTest() throws InterruptedException {
		//waitForPageToLoad();
		selectCurrentSIMDeviceRadioButton();
		enterLostComments();
		clickFlagLostButton();
		waitForlostStolenConfirmation();
		clickAcceptButton();
	}

}
