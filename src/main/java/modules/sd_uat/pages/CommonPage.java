package modules.sd_uat.pages;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import telus.itsuppt.automation.support.ReportingTools;

/**
 * 
 * @author mayank.c.joshi
 * 
 */
public class CommonPage {
	protected WebDriver driver;
	protected String parent;

	public CommonPage(WebDriver driver) {
		this.driver = driver;
	}

	// -------------------------------------------------------------------

	@FindBy(linkText = "submit")
	// @FindBy(xpath = "//a[text()='submit']")
	protected WebElement submitButton;

	public void clickOnSubmitButton() {
		new WebDriverWait(driver, 10).until(ExpectedConditions
				.visibilityOf(submitButton));
		ReportingTools.highlightElement(submitButton);
		ReportingTools.takeScreenshot("Before clicking on submit button");
		submitButton.click();

	}

	//-----------------------Refresh Link
	@FindBy(linkText = "refresh")
	protected WebElement refreshLink;
	
	protected void clickRefreshLink(){
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(refreshLink)).click();
	}
	
	// -------------------------------------------------------------------

	@FindBy(linkText = "accept")
	protected WebElement acceptButton;

	public void clickOnAcceptButton() {
		new WebDriverWait(driver, 10).until(ExpectedConditions
				.visibilityOf(acceptButton));
		ReportingTools.highlightElement(acceptButton);
		ReportingTools.takeScreenshot("Before clicking on accept button");
		acceptButton.click();
	}

	// -------------------------------------------------------------------

	@FindBy(linkText = "credit profile")
	protected WebElement creditProfileLink;

	public void clickOnCreditProfile() {
		new WebDriverWait(driver, 10).until(ExpectedConditions
				.visibilityOf(acceptButton));
		ReportingTools.highlightElement(creditProfileLink);
		ReportingTools.takeScreenshot("Before clicking on credit profile link");
		creditProfileLink.click();
	}

	// -------------------------------------------------------------------

	@FindBy(xpath = "//textarea[@name='comment' or @name='commentInput' or @name='smartnoteComment']")
	protected WebElement commentField;

	public void enterComments(String comment) {
		new WebDriverWait(driver, 10).until(ExpectedConditions
				.visibilityOf(commentField));
		commentField.clear();
		commentField.sendKeys(comment);
		ReportingTools.takeScreenshot("Entered the comments");
	}

	// -------------------------------------------------------------------

	@FindBy(xpath = "//textarea[@name='comment']")
	protected WebElement smartNoteCommentField;

	public void enterComment(String comment) {
		new WebDriverWait(driver, 10).until(ExpectedConditions
				.visibilityOf(smartNoteCommentField));
		smartNoteCommentField.clear();
		smartNoteCommentField.sendKeys(comment);
		ReportingTools.takeScreenshot("Entered the comments");
	}

	// -------------------------------------------------------------------

	@FindBy(xpath = "//textarea[@name='noteText']")
	protected WebElement commentFieldKoodo;

	public void enterCommentsKoodo(String comment) {
		commentFieldKoodo.clear();
		commentFieldKoodo.sendKeys(comment);

	}

	// -------------------------------------------------------------------

	@FindBy(xpath = "//td/div[contains(.,'Search')]")
	protected WebElement searchTab;

	protected void waitForPageToLoad() {
		new WebDriverWait(driver, 60).until(ExpectedConditions
				.visibilityOf(searchTab));
	}

	public void clickSearchTab() {
		waitForPageToLoad();
		((JavascriptExecutor) driver).executeScript("arguments[0].click()",
				searchTab);

	}

	// -------------------------------------------------------------------

	@FindBy(linkText = "search")
	protected WebElement searchButton;

	public void clickOnSearchButton() {
		new WebDriverWait(driver, 10).until(ExpectedConditions
				.visibilityOf(searchButton));
		ReportingTools.takeScreenshot("Before clicking on search button");
		searchButton.click();
	}

	// -------------------------------------------------------------------

	@FindBy(linkText = "logout")
	protected WebElement logoutLink;

	public void clickOnLogoutLink() throws InterruptedException {
		logoutLink.click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(5000);
		ReportingTools.takeScreenshot("successfully logged out");
	}

	// --------------------------------------------------------------------

	public String getCurrentWindowHandle() {
		return driver.getWindowHandle();
	}

	// --------------------------------------------------------------------

	public void switchToChildWindow(String... windowToBeRemoved)
			throws InterruptedException {
		Thread.sleep(15000);
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles);
		windowHandles.remove(windowToBeRemoved);
		System.out.println(windowHandles);
		for (String windowHandle : windowHandles) {
			driver.switchTo().window(windowHandle);
		}
		System.out
				.println("the heading of the window is :" + driver.getTitle());
	}

	// -------------------------------------------------------------------

	@FindBy(xpath = "//a[contains(.,'consolidated')]/following-sibling::a/span")
	// @FindBy(linkText = "consolidated")
	protected WebElement consolidatedLink;

	public void clickConsolidatedLink() {
		new WebDriverWait(driver, 60).until(
				ExpectedConditions.visibilityOf(consolidatedLink)).click();
	}

	// --------------------Validate PIN-----------------------------

	@FindBy(xpath = "//strong[contains(.,'pin')]/following-sibling::span/strong/font")
	protected List<WebElement> pinInHeaderTab;

	public void validatePin(String pin) {
		try {
			new WebDriverWait(driver, 30).until(ExpectedConditions
					.visibilityOf(pinInHeaderTab.get(0)));
			if (pinInHeaderTab.get(0).getText().contains(pin)) {
				ReportingTools.highlightElement(pinInHeaderTab.get(0));
				ReportingTools.takeScreenshot("PIN is " + pin);
			} else {
				ReportingTools.highlightElement(pinInHeaderTab.get(0));
				Assert.fail("FAIL: PIN is " + pinInHeaderTab.get(0)
						+ " and not " + pin);
			}
		} catch (Exception e) {
			Assert.fail("PIN is not present");
		}
	}

	// -----------------------Validate Address-------------------------------

	@FindBy(xpath = "//strong[contains(.,'verified date')]/preceding-sibling::span")
	protected WebElement addressInHeaderTab;

	public void validateAddress(String streetNumber, String streetName,
			String streetType, String city, String province, String postalCode) {
		clickRefreshLink();
		try {
			new WebDriverWait(driver, 30).until(ExpectedConditions
					.visibilityOf(addressInHeaderTab));
			String address = addressInHeaderTab.getText().toUpperCase().replaceAll("\\r\\n|\\r|\\n", " ");
			if (address.contains(streetNumber.toUpperCase())
					&& address.contains(streetName.toUpperCase())
					&& address.contains(streetType.toUpperCase())
					&& address.contains(city.toUpperCase())
					&& address.contains(postalCode.toUpperCase())) {
				ReportingTools.highlightElement(addressInHeaderTab);
				ReportingTools.takeScreenshot("Address in header tab is "+ address);
			} else {
				ReportingTools.highlightElement(addressInHeaderTab);
				Assert.fail("FAIL: Address is " + address + " and not "+streetNumber + " " + streetName + " " + streetType
						+ " " + city + " " + province + " " + postalCode+ " in the header");
			}
		} catch (Exception e) {
			Assert.fail("FAIL: Address is not present in the header tab");
		}
	}
	
	// -----------------------Validate Drivers License-------------------------------
	
	@FindBy(xpath = "//strong[contains(.,'Lic')]/following-sibling::span")
	protected List<WebElement> licenseNumber;
	
	public void validateLicenseNumber(String drivingLicenseNo){
		try {
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(licenseNumber.get(0)));
			if (licenseNumber.get(0).getText().toUpperCase().contains(drivingLicenseNo.toUpperCase())) {
				ReportingTools.highlightElement(licenseNumber.get(0));
				ReportingTools.takeScreenshot("License# is " + drivingLicenseNo);
			} else {
				ReportingTools.highlightElement(licenseNumber.get(0));
				Assert.fail("FALSE: License# is "+ licenseNumber.get(0).getText() + " and not " + drivingLicenseNo);
			}
		} catch (Exception e) {
			Assert.fail("FAIL: License# is not present in the header tab");
		}
	}

}
