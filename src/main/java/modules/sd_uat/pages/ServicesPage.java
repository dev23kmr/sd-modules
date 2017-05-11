package modules.sd_uat.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import telus.itsuppt.automation.support.ReportingTools;

public class ServicesPage extends HomePage {

	public ServicesPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// -------------------------------Methods------------------------------

	@FindBy(xpath = "//tr[@class='formPane']/td[2]/table/tbody/tr[1]/td[1]/div/a[text()='add >']")
	protected WebElement addServicesButton;

	// -------------------------------------------------------------------

	@FindBy(xpath = "//select[@id='optionalSocs']")
	protected WebElement availableServicesList;

	/**
	 * @param service
	 *            :Adding a particular service
	 * @author dey.kumar
	 */

	public void add_Service(String service) {

		List<WebElement> childElements = driver.findElements(By
				.xpath("//select[@id='optionalSocs']/option"));

		for (WebElement option : childElements) {

			if (service.trim().equalsIgnoreCase(option.getText().trim())) {
				ReportingTools.highlightElement(option);
				ReportingTools.takeScreenshot("Change services page displayed");
				ReportingTools.takeScreenshot("Selected the required service");
				option.click();
				break;
			}
		}

	}

	public void addOn() {

		new WebDriverWait(driver, 10).until(ExpectedConditions
				.visibilityOf(addServicesButton));
		ReportingTools.highlightElement(addServicesButton);
		addServicesButton.click();
		ReportingTools.takeScreenshot("Selected service added");

	}

	public void addFeature(String service) {
        System.out.println("Inside");
        add_Service(service);
		addOn();
		clickOnSubmitButton();
	}

	// -------------------------------------------------------------------

	@FindBy(xpath = "//form[@id = 'featureChangeCommitForm']/table[1]/tbody[1]/tr[13]/td[@class ='formDataConfirmUpdated']")
	WebElement serviceGained;

	public void validateChangeServicesConfirmation(String comment) {

		/*
		 * new WebDriverWait(driver, 10).until(ExpectedConditions
		 * .visibilityOf(serviceGained));
		 * ReportingTools.highlightElement(serviceGained); ReportingTools
		 * .takeScreenshot("Change Services Confirmation page displayed");
		 */
		ReportingTools.takeScreenshot("Before comment added");
		enterComments(comment);
		clickOnAcceptButton();
		ReportingTools.takeScreenshot("After comment added");

	}
	
}
