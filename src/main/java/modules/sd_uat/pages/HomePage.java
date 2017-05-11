package modules.sd_uat.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import telus.itsuppt.automation.support.ReportingTools;

/**
 * @author mayank.c.joshi
 * 
 */

public class HomePage extends CommonPage

{

	public HomePage(WebDriver driver) {
		super(driver);
	}

	// -------------------------------------------------------------------

	@FindBy(linkText = "change equipment")
	protected WebElement changeEquipmentLink;

	public void clickChangeEquipment() {

		new WebDriverWait(driver, 30).until(ExpectedConditions
				.visibilityOf(changeEquipmentlink));
		changeEquipmentlink.click();
	}

	@FindBy(linkText = "plan")
	protected WebElement planLink;

	public void clickOnPlanLink() {
		new WebDriverWait(driver, 10).until(ExpectedConditions
				.visibilityOf(planLink));
		ReportingTools.highlightElement(planLink);
		ReportingTools.takeScreenshot("Clicking on plan link");
		planLink.click();
		ReportingTools.takeScreenshot("After Clicking on plan link");
	}

	// -------------------------------------------------------------------

	@FindBy(xpath = "//td[@class='viewHeaderMenu']/div/a[.='edit']")
	protected WebElement editLink;

	public void clickOnEditLink() {
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(editLink));
		ReportingTools.highlightElement(editLink);
		ReportingTools.takeScreenshot("Clicking on edit link");
		editLink.click();
	}

	// --------------------------------------------------------------------

	@FindBy(xpath = "//td[.='Notes']/../../../following-sibling::table[1]/tbody/tr/td/a[.='all']")
	protected WebElement viewAllNotesLink;

	public void clickViewAllNotesLink() throws InterruptedException {
		new WebDriverWait(driver, 40).until(ExpectedConditions
				.visibilityOf(viewAllNotesLink));
		ReportingTools.highlightElement(viewAllNotesLink);
		ReportingTools.takeScreenshot("clicking on the All link in notes tab");
		viewAllNotesLink.click();
	}

	@FindBy(xpath = "//td[.='Notes']/../../../following-sibling::table[1]/tbody/tr/td/a[.='search']")
	protected WebElement clickSearchLink;
	public void clickSearchMemo() throws InterruptedException {
		new WebDriverWait(driver, 40).until(ExpectedConditions
				.visibilityOf(clickSearchLink));
		ReportingTools.highlightElement(clickSearchLink);
		ReportingTools.takeScreenshot("clicking on the Search link in notes tab");
		clickSearchLink.click();
		ReportingTools.takeScreenshot("After Clicking on the Search link in notes tab");
	}

	// --------------------------------------------------------------------

	@FindBy(xpath = "//a[.='koodo tab']")
	protected WebElement koodoTabLink;

	public void clickOnKoodoTabLink() {
		new WebDriverWait(driver, 10).ignoring(NoSuchElementException.class)
				.until(ExpectedConditions.visibilityOf(koodoTabLink));
		ReportingTools.takeScreenshot("Clicking on koodo tab link");
		koodoTabLink.click();
	}

	// -------------------------------------------------------------------

	@FindBy(xpath = "//a[.='town']")
	protected WebElement townLink;

	public void clickTownLink() {
		new WebDriverWait(driver, 10).ignoring(NoSuchElementException.class)
				.until(ExpectedConditions.visibilityOf(townLink));
		ReportingTools.takeScreenshot("Clicking on town link");
		townLink.click();
		ReportingTools.takeScreenshot("After Clicking on town link");
	}

	@FindBy(xpath = "//a[.='business']")
	protected WebElement businessLink;

	public void clickBusinessLink() {
		new WebDriverWait(driver, 10).ignoring(NoSuchElementException.class)
				.until(ExpectedConditions.visibilityOf(businessLink));
		ReportingTools.takeScreenshot("Clicking on business link");
		businessLink.click();
	}

	@FindBy(xpath = "//a[.='balance types']")
	protected WebElement balanceTypesLink;

	public void clickOnBalanceTypesLink() {
		new WebDriverWait(driver, 10).ignoring(NoSuchElementException.class)
				.until(ExpectedConditions.visibilityOf(balanceTypesLink));
		ReportingTools.takeScreenshot("Clicking on balance types link");
		balanceTypesLink.click();
	}

	// -------------------------------------------------------------------

	@FindBy(linkText = "change equipment")
	protected WebElement changeEquipmentlink;

	public void clickChangeEquipmentlink() {
		changeEquipmentlink.click();
	}

	// -------------------------------------------------------------------

	@FindBy(xpath = "//a[.='topup']")
	protected WebElement topUpLink;

	public void clickOnTopUpLink() {
		new WebDriverWait(driver, 10).ignoring(NoSuchElementException.class)
				.until(ExpectedConditions.visibilityOf(topUpLink));
		ReportingTools.takeScreenshot("Clicking on top up link");
		topUpLink.click();
	}

	// -------------------------------------------------------------------

	@FindBy(xpath = "//a[.='services']")
	protected WebElement servicesLink;

	public void clickOnServicesLink() {
		new WebDriverWait(driver, 10).ignoring(NoSuchElementException.class)
				.until(ExpectedConditions.visibilityOf(servicesLink));
		ReportingTools.highlightElement(servicesLink);
		ReportingTools.takeScreenshot("Clicking on Services link");
		servicesLink.click();
	}

	@FindBy(xpath = "//a[.='invoice']")
	protected WebElement invoiceLink;

	public void clickOnInvoiceLink() {
		new WebDriverWait(driver, 10).ignoring(NoSuchElementException.class)
				.until(ExpectedConditions.visibilityOf(invoiceLink));
		ReportingTools.takeScreenshot("Clicking on invoice link");
		invoiceLink.click();
		ReportingTools.takeScreenshot("After Clicking on invoice link");
	}

	// -------------------------------------------------------------------

	@FindBy(xpath = "//a[.='adjust balance']")
	protected WebElement adjustBalanceLink;

	protected void waitForAdjustBalanceLinkToLoad() {
		new WebDriverWait(driver, 40).until(ExpectedConditions
				.visibilityOf(adjustBalanceLink));
	}

	// -------------------------------------------------------------------
	@FindBy(xpath = "//td[.='Notes']/../../../following-sibling::table[1]/tbody/tr/td/a[.='new']")
	protected WebElement newLinkNotesTab;

	public void clickOnNewLinkNotesTab() {
		new WebDriverWait(driver, 60).until(ExpectedConditions
				.visibilityOf(newLinkNotesTab));
		ReportingTools.highlightElement(newLinkNotesTab);
		ReportingTools
				.takeScreenshot("we nevigate to NEW link under the notes tab");
		newLinkNotesTab.click();
	}

	// -------------------------------------------------------------------
	public void clickOnAdjustBalanceLinkOnTheHomePage() {
		waitForAdjustBalanceLinkToLoad();
		adjustBalanceLink.click();
		ReportingTools.takeScreenshot("nevigating to adjust balance section");
	}

	// -------------------------------------------------------------------
	@FindBy(xpath = "//a[contains(.,'register credit card')]")
	protected WebElement registerCreditCardLink;

	public void clickOnregisterCreditCardLink() {
		new WebDriverWait(driver, 60).until(ExpectedConditions
				.visibilityOf(registerCreditCardLink));
		ReportingTools.highlightElement(registerCreditCardLink);
		ReportingTools
				.takeScreenshot("We navigate to register credit card link under the financial tab");
		registerCreditCardLink.click();
	}

	// -------------------------------------------------------------------

	@FindBy(linkText = "pymt method")
	protected WebElement paymentMethodLink;

	public void clickOnPaymentMethodLink() {
		new WebDriverWait(driver, 10).ignoring(NoSuchElementException.class)
				.until(ExpectedConditions.visibilityOf(paymentMethodLink));
		ReportingTools.takeScreenshot("Clicking on paymentMethod link");
		paymentMethodLink.click();
	}

	// -------------------------------------------------------------------

	@FindBy(linkText = "pymt")
	protected WebElement paymentLink;

	public void clickOnPaymentLink() {
		new WebDriverWait(driver, 10).ignoring(NoSuchElementException.class)
				.until(ExpectedConditions.visibilityOf(paymentLink));
		ReportingTools.takeScreenshot("Clicking on payment link");
		paymentLink.click();
	}

	// -------------------------------------------------------------------

	@FindBy(xpath = "//a[.='cncl']")
	protected WebElement cnclLinkSubscriberTab;

	public void clickOnCnclLinkSubscriberTab() {
		new WebDriverWait(driver, 40).ignoring(NoSuchElementException.class)
				.until(ExpectedConditions.visibilityOf(cnclLinkSubscriberTab));
		ReportingTools.takeScreenshot("Clicking on cncl link");
		cnclLinkSubscriberTab.click();
	}

	// -------------------------------------------------------------------

	@FindBy(xpath = "//a[.='lost/stolen/found']")
	protected WebElement linkLostStolen;

	public void clickOnLinkLostStolen() {
		new WebDriverWait(driver, 40).ignoring(NoSuchElementException.class)
				.until(ExpectedConditions.visibilityOf(linkLostStolen));
		ReportingTools.highlightElement(linkLostStolen);
		ReportingTools.takeScreenshot("linkLostStolen");
		linkLostStolen.click();
	}

	// -------------------------------------------------------------------

	@FindBy(xpath = "//a[.='resume']")
//	@FindBy(xpath = "//tr/td[text() = 'Subscriber']/../../../../table[@class = 'viewPane']//a[text() = 'resume']")
	
	protected WebElement linkresume;

	public void clickOnLinkCancelresume() {
		new WebDriverWait(driver, 40).ignoring(NoSuchElementException.class)
				.until(ExpectedConditions.visibilityOf(linkresume));
		ReportingTools.takeScreenshot("linkresume");
		linkresume.click();
	}

	// -------------------------------------------------------------------

	@FindBy(xpath = "//td[text() = 'Subscriber']/../../../../table[2]//a[.='suspend']")
	protected WebElement linkSuspend;

	public void clickOnLinkSuspend() {
		new WebDriverWait(driver, 40).ignoring(NoSuchElementException.class)
				.until(ExpectedConditions.visibilityOf(linkSuspend));
		ReportingTools.takeScreenshot("linkSuspend");
		linkSuspend.click();
	}

	// -------------------------------------------------------------------

	@FindBy(xpath = "//a[.='switch']")
	protected WebElement linkSwitch;

	public void clickOnLinkSwitch() {
		new WebDriverWait(driver, 40).ignoring(NoSuchElementException.class)
				.until(ExpectedConditions.visibilityOf(linkSwitch));
		ReportingTools.takeScreenshot("clicked on link Switch");
		linkSwitch.click();
	}

	// -------------------------------------------------------------------

	@FindBy(xpath = "//a[.='change #']")
	protected WebElement linkChange;

	public void clickOnlinkChange() {
		new WebDriverWait(driver, 40).ignoring(NoSuchElementException.class)
				.until(ExpectedConditions.visibilityOf(linkChange));
		ReportingTools.takeScreenshot("clicked on link Change #");
		linkChange.click();
	}

	// -------------------------------------------------------------------

	@FindBy(linkText = "financial history")
	protected WebElement financialHistory;

	public void clickOnFinancialHistoryLink() {
		new WebDriverWait(driver, 40).ignoring(NoSuchElementException.class)
				.until(ExpectedConditions.visibilityOf(financialHistory));
		ReportingTools.takeScreenshot("Clicking on financialHistory link");
		financialHistory.click();
	}

	// -------------------------------------------------------------------

	/**
	 * @author dey.kumar
	 * 
	 */
	@FindBy(xpath = "//table[@class = 'viewPane']/tbody[1]/tr[1]/td[3]/span[3]/strong/font")
	protected WebElement pin;

	public void validatingPin(String PIN) {

		new WebDriverWait(driver, 40).ignoring(NoSuchElementException.class)
				.until(ExpectedConditions.visibilityOf(pin));
		String elementContent = pin.getAttribute("textContent");

		if (PIN.equalsIgnoreCase(elementContent.trim())) {

			ReportingTools.takeScreenshot("PIN Validated" + elementContent);
		} else {
			Assert.fail("Wrong PIN is given");
		}
	}

	@FindBy(xpath = "//body/table[1]/tbody[1]/tr[2]/td[1]/table[@class = 'viewPane']/tbody[1]/tr[1]/td[1]/span[1]")
	protected WebElement address;

	public void validatingAddress(String Address) {

		new WebDriverWait(driver, 40).ignoring(NoSuchElementException.class)
				.until(ExpectedConditions.visibilityOf(address));

		if (address.getText().trim().contains(Address)) {

			ReportingTools.takeScreenshot("Successfully validated the address");
		} else {

			Assert.fail("Address is different");
		}
	}

	@FindBy(xpath = "//strong[contains(text(),'status:')]/following-sibling::a[span[strong[font]]]")
	protected WebElement banStatusValue;

	public void ValidatingStatus(String status) {
		ReportingTools.highlightElement(banStatusValue);
		if (banStatusValue.getText().trim().equalsIgnoreCase(status.trim())) {
			ReportingTools.takeScreenshot("Ban status is "
					+ banStatusValue.getText());
		} else {
			Assert.fail("Ban status does not match");
		}

	}

	@FindBy(xpath = "//strong[text() ='credit class:']/following-sibling::a[1]/span")
	protected WebElement creditClass;

	public void validatingCreditClass(String CreditClass) {

		new WebDriverWait(driver, 40).ignoring(NoSuchElementException.class)
				.until(ExpectedConditions.visibilityOf(creditClass));
		ReportingTools.highlightElement(creditClass);
		if (creditClass.getText().trim().equalsIgnoreCase(CreditClass)) {

			ReportingTools.takeScreenshot("Credit Class successfully matched");
		} else {

			Assert.fail("Credit Class is different " + creditClass.getText()
					+ "It should be " + CreditClass);
		}

	}

	@FindBy(xpath = "//body/table[1]/tbody[1]/tr[2]/td[1]/table[@class = 'viewPane']/tbody[1]/tr[1]/td[2]/span[3]")
	protected WebElement subscriberName;

	public void validatingSubscibername(String Subscibername) {

		new WebDriverWait(driver, 40).ignoring(NoSuchElementException.class)
				.until(ExpectedConditions.visibilityOf(subscriberName));
		ReportingTools.highlightElement(subscriberName);

		if (subscriberName.getText().trim().contains(Subscibername)) {

			ReportingTools.takeScreenshot("Subscriber name Validated");
		} else {

			Assert.fail("Subscriber has different name");
		}
	}

	@FindBy(xpath = "//span[text() ='imei:']/following-sibling::span[1]")
	protected WebElement IMEI;

	public void validatingIMEI(String imei) {

		new WebDriverWait(driver, 40).ignoring(NoSuchElementException.class)
				.until(ExpectedConditions.visibilityOf(subscriberName));
		ReportingTools.highlightElement(IMEI);
		if (IMEI.getText().trim().equalsIgnoreCase(imei)) {

			ReportingTools.takeScreenshot("IMEI Matched");
		} else {

			Assert.fail("IMEI not  Matched");
		}
	}

	
	@FindBy(xpath = "//span[text() ='imei:']/following-sibling::span[6]/span")
	protected WebElement SIM;
	
	public void  validatingSIM(String sim) {
		new WebDriverWait(driver, 40).ignoring(NoSuchElementException.class)
		.until(ExpectedConditions.visibilityOf(SIM));
		
		ReportingTools.highlightElement(SIM);
		
	}
	
	
}
