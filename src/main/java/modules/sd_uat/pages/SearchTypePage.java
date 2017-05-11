package modules.sd_uat.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import telus.itsuppt.automation.support.ReportingTools;
import telus.itsuppt.automation.support.SeleniumBaseTest;

/**
 * 
 * @author mayank.c.joshi
 * 
 */

public class SearchTypePage extends CommonPage {

	public SearchTypePage(WebDriver driver) {
		super(driver);
	}

	// -------------------------------------------------------------------

	@FindBy(xpath = "//select[@name='searchMethod']")
	protected WebElement searchTypeMethod;

	/**
	 * Method to choose what type of search method user wants.
	 * 
	 * @param searchType
	 *            -Signifies the type of search method to be used.
	 */
	protected void selectSearchType(String searchType)

	{
		new WebDriverWait(driver, 30).until(ExpectedConditions
				.visibilityOf(searchTypeMethod));
		new Select(searchTypeMethod).selectByVisibleText(searchType);
	}

	// -------------------------------------------------------------------

	@FindBy(xpath = "//input[@name='phoneNumberSearch_PhoneNumber']")
	protected WebElement phoneNumberField;

	protected void enterPhoneNumber(String phoneNumber) {
		phoneNumberField.sendKeys(phoneNumber);
	}

	// -------------------------------------------------------------------

	@FindBy(xpath = "//span[.='search results']")
	protected WebElement searchResultsHeading;

	// -------------------------------------------------------------------

	@FindBy(xpath = "//input[@name='accountNumberSearch_AccountNumber']")
	protected WebElement accountNumberField;

	protected void enterAccountNumber(String accountNumber) {
		accountNumberField.sendKeys(accountNumber);
	}

	// -------------------------------------------------------------------
	@FindBy(xpath = "//input[@name='serialNumberSearch_Name']")
	protected WebElement serialNumberField;

	protected void enterSerialNumber(String serialNumber) {
		serialNumberField.sendKeys(serialNumber);
	}

	// -------------------------------------------------------------------

	@FindBy(xpath = "//td[contains(.,'active')][contains(.,'status:')]/../td[1]/a")
	protected WebElement activeAccountNumber;

	// -------------------------------------------------------------------

	@FindBy(linkText = "switch user id")
	protected WebElement switchUserId;

	/**
	 * Clicking the switch user id link option after logging in the habitat page
	 */

	public void clickOnSwitchUserId() {
		new WebDriverWait(driver, 10).until(
				ExpectedConditions.visibilityOf(switchUserId)).click();
		ReportingTools.takeScreenshot();
	}

	// -------------------------------------------------------------------

	/**
	 * @dataTableParameters searchType, accountNumber, phoneNumber
	 */
	public void searchSubscriber(String searchType, String accountNumber,
			String phoneNumber) {
		selectSearchType(searchType);

		if (searchType.equals("Account Number")) {
			enterAccountNumber(accountNumber);
		} else if (searchType.equals("Phone Number")) {
			enterPhoneNumber(phoneNumber);
			
		}

		ReportingTools.takeScreenshot("Search Details entered");
		clickOnSubmitButton();

		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			searchResultsHeading.getText();

			driver.manage()
					.timeouts()
					.implicitlyWait(SeleniumBaseTest.getTimeout(),
							TimeUnit.SECONDS);
			try {
				if (accountNumber.trim().equals("")) {
					try {
						ReportingTools
								.takeScreenshot("Selecting the active account, "
										+ activeAccountNumber.getText());
						activeAccountNumber.click();
					} catch (NoSuchElementException e) {
						Assert.fail("No Active account is found for the telephone number, "
								+ phoneNumber + " " + e.getMessage());
					}

				} else {
					ReportingTools
							.takeScreenshot("Selecting the provided account, "
									+ accountNumber);
					driver.findElement(By.linkText(accountNumber)).click();
				}

			} catch (NoSuchElementException e) {
				Assert.fail("Account matching the account number provided,"
						+ accountNumber + " , is not found. " + e.getMessage());
			}
		} catch (Exception e) {
			System.out.println("Account number selection page not found");
			// e.printStackTrace();
		}

		ReportingTools.takeScreenshot();
	}

	public void performSearch(String searchType, String serialNumber)
			throws InterruptedException {

		selectSearchType(searchType);
		if (searchType.equals("Serial Number")) {
			enterSerialNumber(serialNumber);
		}

		clickOnSubmitButton();
		waitForPageToLoad();
		ReportingTools.takeScreenshot("Search Details entered");
	}
}
