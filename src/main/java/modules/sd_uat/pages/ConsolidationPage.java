package modules.sd_uat.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import telus.itsuppt.automation.support.ReportingTools;

public class ConsolidationPage extends HomePage {
	
	public ConsolidationPage(WebDriver driver){
		super(driver);
	}
	
	
	/*---------------------------------------------- OBJECTS --------------------------------------------*/
	
	//Customer Link
	@FindBy(id = "svc_customer")
	protected WebElement customerLink;
	
	protected void clickCustomer(){
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(customerLink));
		customerLink.click();
	}
	
	//Expand button
	@FindBy(xpath = "//span[@class = 'svcArrow']")
	protected List<WebElement> expandArrowButtons;
	
	//Mobility Account Status
	@FindBy(xpath = "//table[@class = 'svcPane']/tbody/tr[contains(.,'Mobility')]/following-sibling::tr/td/span/table/tbody/tr/td[@class = 'svcLine'][contains(.,'status')]")
	protected WebElement mobilityAccountStatus;
	
	//Wireline Account Status
	@FindBy(xpath = "//table[@class = 'svcPane']/tbody/tr[contains(.,'Wireline')]/following-sibling::tr/td/span/table/tbody/tr/td[@class = 'svcLine'][contains(.,'status')]")
	protected List<WebElement> wirelineAccountStatus;
	
	//Search Link
	@FindBy(id = "svc_search")
	protected WebElement searchSubscriberLink;
	
	protected void clickSearchLink(){
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(searchSubscriberLink)).click();
	}
	
	//Subscriber Type List
	@FindBy(name = "searchOption")
	protected WebElement subscriberTypeList;
	
	//Subscriber Search Value
	@FindBy(name = "searchValue")
	protected WebElement searchValue;
	
	protected void enterSearchValue(String accountNumber){
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(searchValue));
		searchValue.clear();
		searchValue.sendKeys(accountNumber);
	}
	
	//Subscriber Search Button
	@FindBy(xpath = "//a[contains(.,'search')][@onclick = 'form_submit(document.form_svc_search);']")
	protected WebElement subscriberSearchButton;
	
	protected void clickSearchButton(){
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(subscriberSearchButton));
		subscriberSearchButton.click();
	}
	
	//CRM Match Link
	@FindBy(partialLinkText = "CRM match")
	protected WebElement crmMatchLink;
	
	protected void clickCrmMatch(){
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(crmMatchLink));
		crmMatchLink.click();
	}
	
	//Change CRM Status Table
	@FindBy(xpath = "//table[contains(.,'change CRM status')][@class = 'svcPane']")
	protected WebElement changeCrmStatusTable;
	
	//CRM Value List
	@FindBy(name = "crmValue")
	protected WebElement crmValueType;
	
	//Confirm CRM Status Change Table
	@FindBy(xpath = "//table[contains(.,'confirm CRM status change')][@class = 'svcPane']")
	protected WebElement confirmCrmStatusChangeTable;
	
	//Authenticate Customer Button
	@FindBy(linkText = "authenticate customer")
	protected WebElement authenticateCustomerButton;
	
	protected void clickAuthenticateCustomer(){
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(authenticateCustomerButton));
		ReportingTools.highlightElement(authenticateCustomerButton);
		ReportingTools.takeScreenshot("Before clicking on authenticate customer");
		authenticateCustomerButton.click();
	}
	
	//Authenticate Customer Table
	@FindBy(name = "forms_authenticate_submit")
	protected WebElement authenticateCustomerTable;
	
	//Wireline Credit Profile
	@FindBy(xpath = "//input[@name = 'selectedPin'][@value = 'searched']")
	protected WebElement wirelineCreditProfile;
	
	//Wireless Credit profile
	@FindBy(xpath = "//input[@name = 'selectedPin'][@value = 'opened']")
	protected WebElement wirelessCreditProfile;
	
	protected void selectPinCreditProfile(String pinCreditProfile){
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(wirelessCreditProfile));
		if (pinCreditProfile.toUpperCase().contains("WIRELESS")) {
			wirelessCreditProfile.click();
		} else {
			wirelineCreditProfile.click();
		}
	}
	
	//Confirm Authentication Table
	@FindBy(name = "forms_authenticate_confirm")
	protected WebElement confirmAuthenticationTable;
	
	//WirelineAccountNumber
	//@FindBy(xpath = "//table[@class = 'svcPane']/tbody/tr/td[contains(.,'Wireline')]/preceding-sibling::td[contains(.,'BAN')]")
	@FindBy(xpath = "//td[contains(.,'Wireline')]/preceding-sibling::td[contains(.,'BAN')][@class='svcBanLine']")
	protected WebElement wirelineAccountNumber;

	
	//Consolidate Button
	@FindBy(linkText = "consolidate accounts")
	protected WebElement consolidateAccountsButton;
	
	protected void clickConsolidateAccounts(){
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(consolidateAccountsButton));
		ReportingTools.highlightElement(consolidateAccountsButton);
		ReportingTools.takeScreenshot("Before clicking on consolidate accounts button");
		consolidateAccountsButton.click();
	}
	
	//Continue Button
	@FindBy(linkText = "continue")
	protected WebElement continueButton;
	
	protected void clickContinue(){
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(continueButton)).click();
	}
	
	//Consolidate Accounts Consent table
	@FindBy(name = "forms_consolidate_bill_consent")
	protected WebElement consolidateAccountsConsentTable;
	
	//Wireline Billing Details
	@FindBy(xpath = "//input[@name = 'billingDetails'][@value = 'searchedBillingDetails']")
	protected WebElement wirelineBillingDetails;
	
	//Wireless billing Details
	@FindBy(xpath = "//input[@name = 'billingDetails'][@value = 'openedBillingDetails']")
	protected WebElement wirelessBillingDetails;
	
	protected void selectBillingDetails(String billingDetails){
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(wirelessBillingDetails));
		if (billingDetails.toUpperCase().contains("WIRELESS")) {
			wirelessBillingDetails.click();
		} else {
			wirelineBillingDetails.click();
		}
	}
	
	//Confirm Account Consolidation Table
	@FindBy(name = "forms_consolidate_confirm")
	protected WebElement confirmAccountConsolidationTable;
	
	//Accounts have been consolidated table
	@FindBy(name = "forms_consolidate_summary")
	protected WebElement consolidationSuccessfullTable;

	//Deconsolidate link
	@FindBy(linkText = "deconsolidate")
	protected WebElement deconsolidateLink;
	
	//Change nPlay button
	@FindBy(linkText = "change nPlay")
	protected WebElement changeNplayButton;
	
	protected void clickChangeNplay(){
		try {
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(changeNplayButton));
			ReportingTools.highlightElement(changeNplayButton);
			ReportingTools.takeScreenshot("Clicking change nPlay");
			changeNplayButton.click();
		} catch (Exception e) {
			Assert.fail("FAIL: Change nPlay button is not present");
		}

	}
	
	//nPlay value
	@FindBy(xpath = "//span[contains(@style,'inline')]/table/tbody/tr/td[contains(.,'nPlay enrolment')]")
	protected WebElement nPlayEnrolmentStatus;
	
	//nPlay discount enrollment table
	@FindBy(xpath = "//table[@class = 'svcPane'][contains(.,'new enrolment')]")
	protected WebElement nPlayDiscountEnrolmentTable;
	
	//New enrollment list
	@FindBy(name = "enrolmentOption")
	protected WebElement newEnrolmentList;
	
	
	
	
	/*---------------------------------------------- METHODS --------------------------------------------*/
	
	Boolean wlnBanFlag = false;
	
	/**
	 * Validate Wireline BAN number
	 */
	public boolean validateWirelineAccNumber(String wirelineAccNumber){
		if (wirelineAccountNumber.getText().contains(wirelineAccNumber)) {
			ReportingTools.highlightElement(wirelineAccountNumber);
			ReportingTools.takeScreenshot("Wireline account has already been authenticated");
			wlnBanFlag = true;
		} else {
			wlnBanFlag = false;
		}
		return wlnBanFlag;
		
	}
	
	
	/**
	 * Validate consolidated status
	 * Click on consolidate link
	 */
	public void validateConsolidationStatus(String consolidatedStatus){
		try {
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(consolidatedLink));
			String currentConsolidatedStatus = consolidatedLink.getText();
			if (currentConsolidatedStatus.toUpperCase().contains(consolidatedStatus.toUpperCase())) {
				ReportingTools.highlightElement(consolidatedLink);
				ReportingTools.takeScreenshot("Consolidated status is : "+ currentConsolidatedStatus);
				clickConsolidatedLink();
			} else {
				ReportingTools.highlightElement(consolidatedLink);
				Assert.fail("FAIL: Consolidated status is "+ currentConsolidatedStatus + " and not " + consolidatedStatus);
			}
		} catch (Exception e) {
			Assert.fail("FAIL: Consolidated link is not present");
		}

	}
	
	/**
	 * Expand all the arrows to the see the details
	 */
	public void expandArrows(){
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(expandArrowButtons.get(0)));
		for (int i = 0; i < expandArrowButtons.size(); i++) {
			expandArrowButtons.get(i).click();
		}
	}
	
	/**
	 * Validate Mobility Account status
	 */
	public void validateMobilityAccountStatus(String mobilityAccStatus){
		clickCustomer();
		expandArrows();
		if (mobilityAccountStatus.getText().toUpperCase().contains(mobilityAccStatus.toUpperCase())) {
			ReportingTools.highlightElement(mobilityAccountStatus);
			ReportingTools.takeScreenshot("Mobility account status is "+mobilityAccountStatus.getText());
		} else {
			ReportingTools.highlightElement(mobilityAccountStatus);
			Assert.fail("FAIL: Mobility account status is "+mobilityAccountStatus.getText()+"; Please use a different BAN");
		}
	}
	
	/**
	 * Validate Mobility Account status
	 */
	public void validateWirelineAccountStatus(String wirelineAccStatus){
		clickCustomer();
		expandArrows();
		if (wirelineAccountStatus.get(0).getText().toUpperCase().contains(wirelineAccStatus.toUpperCase())) {
			ReportingTools.highlightElement(wirelineAccountStatus.get(0));
			ReportingTools.takeScreenshot("Wireline account status is "+wirelineAccountStatus.get(0).getText());
		} else {
			ReportingTools.highlightElement(wirelineAccountStatus.get(0));
			Assert.fail("FAIL: Wireline account status is "+wirelineAccountStatus.get(0).getText()+"; Please use a different BAN");
		}
	}
	
	/**
	 * Search for Subscriber to be consolidated
	 */
	public void searchWirelineSubscriber(String wirelineAcc){
		clickSearchLink();
		new Select(subscriberTypeList).selectByVisibleText("Account Number - Wireline");
		enterSearchValue(wirelineAcc);
		ReportingTools.takeScreenshot("Before searching subscriber for consolidation");
		clickSearchButton();
	}
	
	/**
	 * Perform a CRM Match:
	 * Verify if CRM match status is None
	 * If none, click CRM match link
	 * Select verify, Submit and Accept
	 */
	public void crmMatch(){
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(crmMatchLink));
		if (crmMatchLink.getText().toUpperCase().contains("NONE")) {
			ReportingTools.highlightElement(crmMatchLink);
			ReportingTools.takeScreenshot("Before clicking on "+crmMatchLink.getText());
			clickCrmMatch();
			try {
				new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(changeCrmStatusTable));
				ReportingTools.highlightElement(changeCrmStatusTable);
				ReportingTools.takeScreenshot("'change CRM status' table is displayed");
				new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(crmValueType));
				new Select(crmValueType).selectByVisibleText("verify");
				clickOnSubmitButton();
			} catch (Exception e) {
				Assert.fail("FAIL: 'change CRM status' table is not displayed");
			}
			
			try {
				new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(confirmCrmStatusChangeTable));
				ReportingTools.highlightElement(confirmCrmStatusChangeTable);
				ReportingTools.takeScreenshot("'confirm CRM status change' table is displayed");
				clickOnAcceptButton();
			} catch (Exception e) {
				Assert.fail("FAIL: 'confirm CRM status change' table is not displayed");
			}
			
		}
	}
	
	/**
	 * Validate if CRM Match is verified
	 */
	public void verifyCrmStatus(){
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(crmMatchLink));
		if (crmMatchLink.getText().toUpperCase().contains("VERIFIED")) {
			ReportingTools.highlightElement(crmMatchLink);
			ReportingTools.takeScreenshot("CRM match is verified");
		} else {
			ReportingTools.highlightElement(crmMatchLink);
			Assert.fail("CRM match is not verified");
		}
	}
	
	
	/**
	 * Authenticate Customer
	 * Click authenticate customer button
	 * Select credit profile, submit and accept
	 */
	public void authenticateCustomer(String pinCreditProfile){
		expandArrows();
		clickAuthenticateCustomer();
		try {
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(authenticateCustomerTable));
			ReportingTools.highlightElement(authenticateCustomerTable);
			ReportingTools.takeScreenshot("'authenticate customer' table is displayed");
			selectPinCreditProfile(pinCreditProfile);
			clickOnSubmitButton();
		} catch (Exception e) {
			Assert.fail("FAIL: 'authenticate customer' table is not displayed");
		}
		
		try {
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(confirmAuthenticationTable));
			ReportingTools.highlightElement(confirmAuthenticationTable);
			ReportingTools.takeScreenshot("'confirm authentication' table is displayed");
			clickOnAcceptButton();
		} catch (Exception e) {
			Assert.fail("FAIL: 'confirm authentication' table is not displayed");
		}
		
	}
	
	/**
	 * Click Consolidate Accounts
	 * Validate if Consolidate Accounts consent table is displayed and click on continue
	 * Select Billing details and submit
	 * Validate if Confirm Account Consolidation table is displayed and click on accept
	 */
	public void performConsolidation(String billingDetailsAcc){
		clickConsolidateAccounts();
		try {
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(consolidateAccountsConsentTable));
			ReportingTools.highlightElement(consolidateAccountsConsentTable);
			ReportingTools.takeScreenshot("'consolidate accounts consent' table is displayed");
			clickContinue();
		} catch (Exception e) {
			Assert.fail("FAIL: 'consolidate accounts consent' table is not displayed");
		}

		selectBillingDetails(billingDetailsAcc);
		clickOnSubmitButton();
		
		try {
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(confirmAccountConsolidationTable));
			ReportingTools.highlightElement(confirmAccountConsolidationTable);
			ReportingTools.takeScreenshot("'confirm account consolidation' table is displayed");
			clickOnAcceptButton();
		} catch (Exception e) {
			Assert.fail("FAIL: 'confirm account consolidation' table is not displayed");
		}

	}
	
	/**
	 * Validate accounts have been consolidated table
	 */
	public void validateConsolidationSuccessfullTable(){
		try {
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(consolidationSuccessfullTable));
			ReportingTools.highlightElement(consolidationSuccessfullTable);
			ReportingTools.takeScreenshot("'accounts have been consolidated' table is displayed");
			clickContinue();
		} catch (Exception e) {
			Assert.fail("FAIL: 'accounts have been consolidated' table is not displayed");
		}
	}
	
	
	/**
	 * Validate deconsolidate link
	 */
	public void validateDeConsolidateLink(){
		try {
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(deconsolidateLink));
			ReportingTools.highlightElement(deconsolidateLink);
			ReportingTools.takeScreenshot("Deconsolidate link is present");
		} catch (Exception e) {
			Assert.fail("FAIL: Deconsolidate link is not present");
		}
	}

	
	
	/**
	 * Validate Mobility Acc Status
	 * Search for Wireline Subscriber
	 * Validate Wireline Acc Status
	 * Verify CRM Match
	 * Authenticate WLN Customer
	 * Consolidate Customers
	 * @throws InterruptedException 
	 */
	public void consolidateCustomers(String mobilityAccStatus, String wirelineAccountNumber, String pinCreditProfile, String billingDetailsAcc) throws InterruptedException{
		validateConsolidationStatus("no");
		validateMobilityAccountStatus(mobilityAccStatus);
		try {
			if (consolidateAccountsButton.isDisplayed()) {
				validateWirelineAccNumber(wirelineAccountNumber);
			} else {
				wlnBanFlag = false;
			}
		} catch (Exception e) {
			wlnBanFlag = false;
		}
		
		if (wlnBanFlag == false) {
			searchWirelineSubscriber(wirelineAccountNumber);
			crmMatch();
			verifyCrmStatus();
			authenticateCustomer(pinCreditProfile);
		} 
		performConsolidation(billingDetailsAcc);
		validateConsolidationSuccessfullTable();
		Thread.sleep(10000);
		clickRefreshLink();
		Thread.sleep(10000);
		validateConsolidationStatus("yes");
		validateDeConsolidateLink();
	}
	
	
	/**
	 * Validate nPlay Status
	 */
	public void validateNplayStatus(String nPlayStaus){
		try {
			clickRefreshLink();
			clickConsolidatedLink();
			expandArrows();			
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(nPlayEnrolmentStatus));
			if (nPlayEnrolmentStatus.getText().toUpperCase().contains(nPlayStaus.toUpperCase())) {
				ReportingTools.highlightElement(nPlayEnrolmentStatus);
				ReportingTools.takeScreenshot("nPlay enrolment status is " + nPlayStaus);
			} else {
				ReportingTools.highlightElement(nPlayEnrolmentStatus);
				Assert.fail("FAIL: " + nPlayEnrolmentStatus.getText() + " and not '" + nPlayStaus + "'");
			}
		} catch (Exception e) {
			Assert.fail("FAIL: nPlay enrolment status is not displayed");
		}
	}
	
	/**
	 * Select new enrollment option
	 */
	public String selectNewEnrolmentOption(String enrolmentValue){
		try {
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(nPlayDiscountEnrolmentTable));
			ReportingTools.highlightElement(nPlayDiscountEnrolmentTable);
			ReportingTools.takeScreenshot("'nPlay enrolment doscount' table is present");
		} catch (Exception e) {
			Assert.fail("FAIL: 'nPlay discount enrolment' table is not present");
		}
		
		try {
			driver.findElement(By.xpath("//option[contains(.,'"+enrolmentValue+"')]"));
		} catch (Exception e) {
			Assert.fail("FAIL: The required enrolment is not present in the list");
		}
		
		String enrolmentVal = driver.findElement(By.xpath("//option[contains(.,'"+enrolmentValue+"')]")).getText();
		new Select(newEnrolmentList).selectByVisibleText(enrolmentVal);
		clickOnSubmitButton();
		
		try {
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(nPlayDiscountEnrolmentTable));
			ReportingTools.highlightElement(nPlayDiscountEnrolmentTable);
			ReportingTools.takeScreenshot("'nPlay enrolment doscount' table is present");
			clickOnAcceptButton();
		} catch (Exception e) {
			Assert.fail("FAIL: 'nPlay discount enrolment' table is not present");
		}
		return enrolmentVal;
		
		

	}
	
	

	
	/**
	 * Add and Remove nPlay
	 * @throws InterruptedException 
	 */
	public String changeNplay(String enrolmentValue){
		clickChangeNplay();
		String selectedEnrolment = selectNewEnrolmentOption(enrolmentValue);
		return selectedEnrolment;
	}
	
}
