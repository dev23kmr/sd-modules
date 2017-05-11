package modules.sd_uat.pages;

/**
 * @author mayank.c.joshi
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import telus.itsuppt.automation.support.ReportingTools;

public class ChangePricePlanPage extends HomePage {

	public ChangePricePlanPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// -------------------------------------------------------------------

	@FindBy(xpath = "//select[@name='effective']")
	protected WebElement effectiveDateFeild;

	public void selectEffectiveDate(String effectiveDate) {

		new WebDriverWait(driver, 10).until(ExpectedConditions
				.visibilityOf(effectiveDateFeild));
		ReportingTools.highlightElement(effectiveDateFeild);
		new Select(effectiveDateFeild).selectByValue(effectiveDate);
		ReportingTools.takeScreenshot("Effective Date selected");
	}

	// -------------------------------------------------------------------

	@FindBy(xpath = "//select[@name='pricePlan']")
	protected WebElement pricePlanTab;

	protected void selectPricePlanByIndex(int index) {
		new WebDriverWait(driver, 10).until(ExpectedConditions
				.visibilityOf(pricePlanTab));
		new Select(pricePlanTab).selectByIndex(index);
	}

	protected void selectPricePlanByValue(String value) {
		new WebDriverWait(driver, 10).until(ExpectedConditions
				.visibilityOf(pricePlanTab));
		ReportingTools.highlightElement(pricePlanTab);
		new Select(pricePlanTab).selectByVisibleText(value);
		ReportingTools.takeScreenshot("Price plan selected");
	}

	// -------------------------------------------------------------------

	@FindBy(xpath = "//input[@name='advancedEdit']")
	protected WebElement advancedEditCheckBox;

	// -------------------------------------------------------------------

	@FindBy(xpath = "//input[@name='noEmailProvided']")
	protected WebElement noEmailProvidedCheckBox;

	// -------------------------------------------------------------------

	@FindBy(xpath = "//form[@name='Soc_plan']/table/tbody/tr[3]/td[2]//tr[1]//a[1]")
	protected WebElement addServicesButton;

	// -------------------------------------------------------------------

	@FindBy(xpath = "//select[@name='optionalSocs']")
	protected WebElement availableServicesList;

	public void addService(String service) {
		new WebDriverWait(driver, 10).until(ExpectedConditions
				.visibilityOf(availableServicesList));
		ReportingTools.takeScreenshot("Change services page displayed");
		new Select(availableServicesList).selectByVisibleText(service);
		ReportingTools.takeScreenshot("Selected the required service");
		addServicesButton.click();
		ReportingTools.takeScreenshot("Selected service added");
	}

	// -------------------------------------------------------------------

	/**
	 * 
	 * @param effectiveDate
	 *            :Mostly immediate
	 * @param planSelection
	 *            :yes or no depending whether you want to select plan or not
	 *            from dropdown.
	 * @param planName
	 *            :if planSelection is yes,provide the plan name
	 * @param serviceSelection
	 *            :yes or no depending whether you want to select service or not
	 *            from list.
	 * @param service
	 *            :select the service from available list,varies from ban to ban
	 * @param comment
	 */

	public void ratePlanChange(String effectiveDate, String planSelection,
			String planName, String serviceSelection, String service,
			String comment) {

		selectEffectiveDate(effectiveDate);

		if (planSelection.equalsIgnoreCase("yes")) {
			if (planName.equals("")) {
				selectPricePlanByIndex(0);
			} else {
				selectPricePlanByValue(planName);
			}

		}

		clickOnSubmitButton();

		if (serviceSelection.equalsIgnoreCase("yes")) {
			addService(service);
		}

		advancedEditCheckBox.click();
		ReportingTools
				.takeScreenshot("Advanced edit checkbox selected and clicking on submit button");
		clickOnSubmitButton();
		clickOnSubmitButton();
		enterComments(comment);
		ReportingTools
				.takeScreenshot("Entered the comments on Change services confirmation page and clicking on accept button");
		clickOnAcceptButton();

		// In the below code we are clicking on no email provided check-box
		// which only appears if ban doesn't have email id registered

		/*
		 * try{
		 * 
		 * new WebDriverWait(driver,
		 * 10).until(ExpectedConditions.visibilityOf(noEmailProvidedCheckBox
		 * )).click(); clickOnAcceptButton(); }
		 * 
		 * catch(Exception e){ ReportingTools.takeScreenshot(
		 * "No email provided checkbox page not displayed,Email already present"
		 * ); }
		 */

	}

}
