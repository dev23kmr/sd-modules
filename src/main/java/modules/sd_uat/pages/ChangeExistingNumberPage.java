package modules.sd_uat.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
/**
 * @author richa.a.mittal
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import telus.itsuppt.automation.support.ReportingTools;

public class ChangeExistingNumberPage extends HomePage {

	public ChangeExistingNumberPage(WebDriver driver) {
		super(driver);
	}

	// -------------------------------------------------------------------

	
	@FindBy(xpath = "//td[.='Change Phone # step 1']/../..")
	protected WebElement changeExisitngNoWebtable;

	protected void waitForChangeExisitngNoPageToLoad() {

		new WebDriverWait(driver, 90).until(ExpectedConditions.visibilityOf(changeExisitngNoWebtable));
		ReportingTools.takeScreenshot("the Change Phone # page has loaded");
	}
	
	// -------------------------------------------------------------------
	
	@FindBy(xpath = "//a[.='Exchange Tool.']")
	protected WebElement linkExchangeTool;

	public void clickOnlinkExchangeTool() {
		linkExchangeTool.click();
		ReportingTools.takeScreenshot("Exchange Tool Link clicked");
	}
	
	// -------------------------------------------------------------------

	@FindBy(xpath = "//input[@value = 'continue']")
	protected WebElement buttonContinue;

	protected void clickOnButtonContinue() {
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(buttonContinue));
		ReportingTools.takeScreenshot("Before clicking on Continue");
		buttonContinue.click();
		ReportingTools.takeScreenshot("Continue button clicked");
	}

	// -------------------------------------------------------------------

	@FindBy(xpath = "//input[@value = 'continue']")
	protected WebElement buttonContinueExchange;

	protected void clickOnButtonContinueExchange() {
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(buttonContinueExchange));
		ReportingTools.takeScreenshot("Before clicking on Continue");
		buttonContinueExchange.click();
		ReportingTools.takeScreenshot("Continue button clicked");
	}
	
	// -------------------------------------------------------------------
	@FindBy(xpath = "//td[.='suspend subscriber']/../..")
	protected WebElement suspendSubscriberWebtable;

	protected void waitForsuspendSubscriberPageToLoad() {

		new WebDriverWait(driver, 90).until(ExpectedConditions.visibilityOf(suspendSubscriberWebtable));
		ReportingTools.takeScreenshot("the suspend subscriber page has loaded");
	}

	// -------------------------------------------------------------------

//	@FindBy(xpath = "//select[@id = 'prov']")
	@FindBy(xpath = "//select[@id = 'province']")
	protected WebElement prov;
	
	protected void selectProvince(String province) {
		ReportingTools.takeScreenshot("the change phone number page has loaded");
		new WebDriverWait(driver, 90).until(ExpectedConditions.visibilityOf(prov));
		new Select(prov).selectByValue(province);
	}
	
	// -------------------------------------------------------------------

	//@FindBy(xpath = "//select[@id = 'city']")
	@FindBy(xpath = "//select[@id = 'numberGroup']")
	protected WebElement cityArea;

	protected void selectCity(String city) {
		new Select(cityArea).selectByValue(city);
	}
	
	// -------------------------------------------------------------------

	//@FindBy(xpath = "//select[@id = 'npaNXX']")
	@FindBy(xpath = "//select[@id = 'npaNxx']")
	protected WebElement npa;

	protected void selectnpa() {
		new WebDriverWait(driver, 90).until(ExpectedConditions.visibilityOf(npa));
		new Select(npa).selectByIndex(3);
	}
	
	// -------------------------------------------------------------------
	
	//@FindBy(xpath = "//input[@id = 'searchBtn']")
	@FindBy(xpath = "(//div[@class='buttonbar']/a[@tabindex = '1'])[2]")
	
	protected WebElement searchButton;

	protected void clickSearchButton() {
		new WebDriverWait(driver, 90).until(ExpectedConditions.visibilityOf(searchButton));
		searchButton.click();
		ReportingTools.takeScreenshot("Searched clicked and Phone Number appeared");
	}

	// -------------------------------------------------------------------
	
	@FindBy(xpath = "//a[.='submit']")
	protected WebElement submitChangePhnoButton;

	protected void clickSubmitChangePhnoButton() {
		new WebDriverWait(driver, 90).until(ExpectedConditions.visibilityOf(submitChangePhnoButton));
		ReportingTools.takeScreenshot("Before submit click");
		submitChangePhnoButton.click();
		ReportingTools.takeScreenshot("Searched clicked and Phone Number appeared");
	}

	
	//@FindBy(xpath = "//a[.='submit'][0]")
	
	@FindBy(xpath = "(//div[@class='buttonbar']/a[@tabindex = '1'])[0]")
	
	protected WebElement submitChangeNewPhnoButton;
	protected void clickSubmitChangeNewPhnoButton() {
		new WebDriverWait(driver, 90).until(ExpectedConditions.visibilityOf(submitChangeNewPhnoButton));
		ReportingTools.takeScreenshot("Before submit click");
		submitChangeNewPhnoButton.submit();
		ReportingTools.takeScreenshot("Searched clicked and Phone Number appeared");
	}

	
	// -------------------------------------------------------------------

	@FindBy(xpath = "//select[@id = 'phoneList']")
	protected WebElement phone;

	protected void selectphone() {
		new WebDriverWait(driver, 90).until(ExpectedConditions.visibilityOf(phone));
		new Select(phone).selectByIndex(1);
	}
	
	// -------------------------------------------------------------------

	
	@FindBy(xpath = "//input[@id = 'searchAssignBtn']")
	protected WebElement assignButton;

	protected void clickAssignButton() {
		assignButton.click();
		ReportingTools.takeScreenshot("Assign button clicked");
	}

	// -------------------------------------------------------------------

	
	@FindBy(xpath = "//input[@id = 'continueButton']")
	protected WebElement continueButton;

	protected void clickContinueButton() throws InterruptedException {
		Thread.sleep(4000);
		new WebDriverWait(driver, 90).until(ExpectedConditions.visibilityOf(continueButton));
		ReportingTools.takeScreenshot("Before clicking Continue button");
		continueButton.click();
		ReportingTools.takeScreenshot("Continue button clicked");
	}
	
	// -------------------------------------------------------------------
	
	@FindBy(xpath = "//input[@id = 'csaPrefPaper']")
	protected WebElement paperCopyRadio;
	
	@FindBy(xpath = "//input[@name = 'agreeCheck']")
	protected WebElement agreeCheckbox;

	@FindBy(xpath = "//input[@id = 'submitButton']")
	protected WebElement exchangeSummarySubmitButton;
	
	protected void clickSubmitOnExchangeSummary() {
		new WebDriverWait(driver, 90).until(ExpectedConditions.visibilityOf(exchangeSummarySubmitButton));
		ReportingTools.takeScreenshot("Exchange Page");
		paperCopyRadio.click();
		agreeCheckbox.click();
		exchangeSummarySubmitButton.click();
		ReportingTools.takeScreenshot("Clicked Submit");
	}
	
	// -------------------------------------------------------------------

	@FindBy(xpath = "//textarea[@name = 'comment']")
	protected WebElement commentsChangePhNoTelus;

	protected void enterChangePhNoTelusComments(String comment) {
		new WebDriverWait(driver, 90).until(ExpectedConditions.visibilityOf(commentsChangePhNoTelus));
		commentsChangePhNoTelus.sendKeys(comment);
		ReportingTools.takeScreenshot("Details filled in Resume Page");
	}
	
	// -------------------------------------------------------------------
	
	@FindBy(xpath = "//a[.='accept']")
	protected WebElement acceptButton;

	protected void clickChangePhNoTelusAcceptButton() {
		acceptButton.click();
	}
	
	// -------------------------------------------------------------------
	@FindBy(xpath = "//td[contains(text(),'change phone number summary')]/../..")
	protected WebElement changePhNoConfirmedWebtable;

	protected void waitForChangePhNoConfirmedWebtable() {

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(changePhNoConfirmedWebtable));
		ReportingTools.takeScreenshot("change phone number summary Webtable");
	}

	// --------------------------------------------------------------------

	public String getNewPhoneNumber() throws InterruptedException {
	Thread.sleep(5000);
	//WebElement newPhNo = driver.findElement(By.xpath("//tr/td[3][text() = 'Phone Number']/../td[4]"));		
	WebElement newPhNo = driver.findElement(By.xpath("//tr/td[1][text() = 'phone number']/../td[3]"));
	new WebDriverWait(driver, 40).until(ExpectedConditions
			.visibilityOf(newPhNo));
	String newPhoneNo = newPhNo.getText();
	ReportingTools.takeScreenshot("New Phone Number Captured at Run time is :: " +newPhoneNo);
     return newPhoneNo;
	
	}


	// -------------------------------------------------------------------
	
	@FindBy(xpath = "//td[contains(text(),'Your transaction has been submitted successfully.')]")
	protected WebElement successText;
	
	@FindBy(xpath = "//input[@value = 'done']")
	protected WebElement doneButton;

	protected void verifySuccess() throws InterruptedException {
		new WebDriverWait(driver, 90).until(ExpectedConditions.visibilityOf(successText));
		ReportingTools.takeScreenshot("Exchange succesful");
		Thread.sleep(19000);
		doneButton.click();
	}
	
	
	// -------------------------------------------------------------------

	public void changeExistingNumberNew(String province,String city) throws InterruptedException {
		waitForChangeExisitngNoPageToLoad();
		selectProvince(province);
		selectCity(city);
		selectnpa();
		clickSearchButton();
		clickSubmitChangePhnoButton();
	}
	
	public void changeExistingNumberFlow(String city,String province) throws InterruptedException {
		clickOnButtonContinue();
		clickOnButtonContinueExchange();
		selectProvince(province);
		selectCity(city);
		selectnpa();
		clickSearchButton();
		selectphone();
		clickAssignButton();
		clickContinueButton();
		
	}
	
	public void changePhoneNumber(String comment) throws InterruptedException {
	/*	clickSubmitOnExchangeSummary();
		verifySuccess();*/
		enterChangePhNoTelusComments(comment);
		clickChangePhNoTelusAcceptButton();
		waitForChangePhNoConfirmedWebtable();
		
	}
	
	public void changenewPhoneNumber(String province,String city) throws InterruptedException {
	
		waitForChangeExisitngNoPageToLoad();
		selectProvince(province);
		selectCity(city);
		clickSubmitChangeNewPhnoButton();
		
		}
}
