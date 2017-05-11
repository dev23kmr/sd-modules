package modules.sd_uat.pages;

import java.util.Calendar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreditProfilePage extends CommonPage {
	
	public CreditProfilePage(WebDriver driver){
		super(driver);
	}
	
	
	/*---------------------------------------------- OBJECTS --------------------------------------------*/
	
	
	//Driver's License Number
	@FindBy(name = "driverLicense")
	protected WebElement driversLicenseNumber;
	
	protected void enterDriversLicenseNumber(String driversLicenseNo){
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(driversLicenseNumber)).clear();
		driversLicenseNumber.sendKeys(driversLicenseNo);
	}
	
	//Driver's License Province
	@FindBy(name = "drvLicProv")
	protected WebElement driversLicenseProvince;
	
	protected void selectDriversLicenseProvince(String drvLicenseProvince){
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(driversLicenseProvince));
		new Select(driversLicenseProvince).selectByVisibleText(drvLicenseProvince);
	}
	
	//Driver's License Year
	@FindBy(name = "drvLicYear")
	protected WebElement driversLicenseExpiryYear;
	
	protected void selectDriversLicenseExpiryYear(String drvLicenseExpiryYear){
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(driversLicenseExpiryYear));
		new Select(driversLicenseExpiryYear).selectByVisibleText(drvLicenseExpiryYear);
	}
	
	//Send request button
	@FindBy(linkText = "send request")
	protected WebElement sendRequestButton;
	
	protected void clickSendRequestButton(){
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(sendRequestButton)).click();
	}
	
	
	/*---------------------------------------------- METHODS --------------------------------------------*/
	
	
	/**
	 * Change Drivers License details
	 */
	public void enterDriversLicenseDetails(String driversLicenseNo, String driversLicenseProvince){
		enterDriversLicenseNumber(driversLicenseNo);
		selectDriversLicenseProvince(driversLicenseProvince);
		Calendar cal = Calendar.getInstance();
		Integer year = cal.get((Calendar.YEAR) + 1);
		String driversLicenseExpiryYear = year.toString();
		selectDriversLicenseExpiryYear(driversLicenseExpiryYear);
		clickSendRequestButton();
	}

}
