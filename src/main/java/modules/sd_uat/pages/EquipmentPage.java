package modules.sd_uat.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import telus.itsuppt.automation.support.ReportingTools;

public class EquipmentPage extends HomePage {

	public EquipmentPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//td[text()='equipment change confirmation']")
	protected WebElement equipmentChangeMesage;

	@FindBy(name = "primarySerialNumber")
	protected WebElement primarySerialNumberLabel;

	protected void enterPrimarySerialNo(String serialNo) {
		primarySerialNumberLabel.clear();
		primarySerialNumberLabel.sendKeys(serialNo);
	}

	public void changeNetworkType(String serialNo, String comment) {
		enterPrimarySerialNo(serialNo);
		enterComments(comment);
		clickOnSubmitButton();
	}

	@FindBy(name = "primarySerialNumber")
	protected WebElement adjustDbConfirmationTab;

	public void validateChangeNetwork() {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(adjustDbConfirmationTab));
		ReportingTools.highlightElement(adjustDbConfirmationTab);
		ReportingTools.takeScreenshot("Network change Confirmation page displayed");
		clickOnAcceptButton();
	}

	public void clickAccept() {
		
		clickOnAcceptButton();
	}
	
}