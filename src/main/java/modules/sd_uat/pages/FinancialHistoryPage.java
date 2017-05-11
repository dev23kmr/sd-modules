package modules.sd_uat.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import telus.itsuppt.automation.support.ReportingTools;

public class FinancialHistoryPage extends HomePage {

	public FinancialHistoryPage(WebDriver driver) {
		super(driver);
	}

	// -------------------------------------------------------------------
	@FindBy(name = "history")
	protected WebElement historyDropdown;

	protected void waitForPageToLoad() {

		new WebDriverWait(driver, 60).until(ExpectedConditions
				.visibilityOf(historyDropdown));
	}

	protected void selectHistory(String historySelect) {
		new Select(historyDropdown).selectByVisibleText(historySelect);
	}

	// -------------------------------------------------------------------

	@FindBy(name = "period")
	protected WebElement historyPeriod;

	protected void selectHistoryPeriod(String historyPd) {
		new Select(historyPeriod).selectByVisibleText(historyPd);
	}

	// -------------------------------------------------------------------

	@FindBy(xpath = "//div[@class = 'buttonbar']//a[.='search']")
	protected WebElement searchButton;

	protected void clickOnSearchButtonOnThisPage() {

		ReportingTools.takeScreenshot("before clicking on the search button");
		searchButton.click();
	}

	// -------------------------------------------------------------------
	@FindBy(xpath = "//div[@id = 'finhistorylistDiv']")
	protected WebElement pendingCreditsWebtable;

	protected void validatePendingCreditsWebtable() {

		new WebDriverWait(driver, 60).until(ExpectedConditions
				.visibilityOf(pendingCreditsWebtable));
		ReportingTools.highlightElement(pendingCreditsWebtable);
		ReportingTools.takeScreenshot("the pending credits webtable exists");
	}

	// -------------------------------------------------------------------
	public void viewFinancialHistory(String historySelect, String historyPd) {

		waitForPageToLoad();
		selectHistory(historySelect);
		selectHistoryPeriod(historyPd);
		clickOnSearchButtonOnThisPage();
		validatePendingCreditsWebtable();

	}
}
