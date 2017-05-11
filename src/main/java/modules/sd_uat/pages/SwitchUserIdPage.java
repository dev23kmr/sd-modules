package modules.sd_uat.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import telus.itsuppt.automation.support.ReportingTools;

public class SwitchUserIdPage extends CommonPage {
	

	public SwitchUserIdPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(name = "userId")
	protected WebElement userIdField;

	protected void enterUserId(String userId) {
		userIdField.sendKeys(userId);
	}

	@FindBy(name = "password")
	protected WebElement passwordField;

	protected void enterPassword(String password) {
		passwordField.sendKeys(password);
	}

	
	@FindBy(name="language")
	protected WebElement languageField;
	
	protected void selectLanguage(String languageType) {
		new Select(languageField).selectByVisibleText(languageType);
	}

	/*-----------METHODS------------------------*/

	/**
	 * 
	 * @param kbUserID
	 * @param kbPassword
	 */
	public void switchUserId(String kbUserID, String kbPassword) {
		enterUserId(kbUserID);
		enterPassword(kbPassword);
		ReportingTools.takeScreenshot("KB userid and password entered");
		clickOnSubmitButton();
	}
	

}
