package modules.sd_uat.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EquipmentList extends HomePage {

	public EquipmentList(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	@FindBy(name="comment")
	protected WebElement commentField;
	
	@FindBy(name="primarySerialNumber")
	protected WebElement serialNumberField;
	
	@FindBy(xpath="//a[contains(text(),'submit')]")
	protected WebElement submitButton;
	
	@FindBy(xpath="//a[contains(text(),'accept')]")
	protected WebElement acceptButton;
	
	public void clickAccept(){
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(acceptButton));
		acceptButton.click();
	}
	
	public void addEquipmentDetails(String serialNumber){
		serialNumberField.sendKeys(serialNumber);
		commentField.sendKeys("comment");
		submitButton.click();
	}
	
}
