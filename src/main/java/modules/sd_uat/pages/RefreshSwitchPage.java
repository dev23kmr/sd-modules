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

public class RefreshSwitchPage extends HomePage {

	public RefreshSwitchPage(WebDriver driver) {
		super(driver);
	}

	// -------------------------------------------------------------------
	@FindBy(xpath = "//a[@id = '1'][text()='refresh switch']")
	protected WebElement linkRefreshSwitch;

	protected void waitForRefreshSwitchPageToLoad() {

		new WebDriverWait(driver, 90).until(ExpectedConditions.visibilityOf(linkRefreshSwitch));
		ReportingTools.takeScreenshot("the Refresh Switch page has loaded");
	}

	// -------------------------------------------------------------------

	@FindBy(xpath = "//a[@id = '1'][text()='refresh switch']")
	protected WebElement refreshSwitch;

	protected void clickRefreshSwitch() {
		refreshSwitch.click();
	}

	// -------------------------------------------------------------------
	@FindBy(xpath = "//td[text() = 'refresh switch']/../..")
	protected WebElement refreshSwitchConfirmationWebtable;

	protected void waitForRefreshSwitchConfirmationWebtable() {

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(refreshSwitchConfirmationWebtable));
		ReportingTools.takeScreenshot("Confirmation of Refresh Switch");
	}

	// -------------------------------------------------------------------

	@FindBy(xpath = "//a[text()='refresh switch'][@tabindex = '1']")
	protected WebElement refreshSwitchButton;

	protected void clickRefreshSwitchButton() {
		refreshSwitchButton.click();
	}

	// -------------------------------------------------------------------
	@FindBy(xpath = "//td[text() = 'refresh switch confirmation']/../..")
	protected WebElement refreshSwitchConfirmedWebtable;

	protected void waitForrefreshSwitchConfirmedWebtable() {

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(refreshSwitchConfirmedWebtable));
		ReportingTools.takeScreenshot("Refresh Switch Confirmed Webtable");
	}

	// -------------------------------------------------------------------

	@FindBy(xpath = "//a[.='accept']")
	protected WebElement refreshSwitchAcceptButton;

	protected void clickRefreshSwitchAcceptButton() {
		refreshSwitchAcceptButton.click();
	}

	// -------------------------------------------------------------------
	@FindBy(xpath = "//th[text() = 'refresh switch']/../..")
	protected WebElement refreshSwitchConfirmed;

	@FindBy(xpath = "//td[contains(text(),'Refresh Switch request has been submitted')]")
	protected WebElement refreshSwitchConfirmedText;

	protected void refreshSwitchConfirmed() {

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(refreshSwitchConfirmed));
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(refreshSwitchConfirmedText));
		ReportingTools.takeScreenshot("Refresh Switch Successful");

	}
	// -------------------------------------------------------------------

	public void refreshSwitchFlow() {
		waitForRefreshSwitchPageToLoad();
		clickRefreshSwitch();
		waitForRefreshSwitchConfirmationWebtable();
		clickRefreshSwitchButton();
		waitForrefreshSwitchConfirmedWebtable();
		clickRefreshSwitchAcceptButton();
		refreshSwitchConfirmed();

	}
}
