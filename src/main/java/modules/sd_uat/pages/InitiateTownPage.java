package modules.sd_uat.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InitiateTownPage extends CommonPage {

	public InitiateTownPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id="newBAN")
	protected WebElement newBANField;
	
	protected void enterNewBAN(String ban) {
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(newBANField));
	newBANField.sendKeys(ban);
	}
	
	@FindBy(id="comment")
	protected WebElement commentField;
	
	public void enterComment() {
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(commentField));
	commentField.sendKeys("test");
	}
	
	@FindBy(id="letter")
	protected WebElement letterSelect;
	
	public void selectLetter() {
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(letterSelect));
	new Select(letterSelect).selectByIndex(1);
	}
	
	@FindBy(xpath="//input[@name='isNewPerson'][@value='true']")
	protected WebElement yesButton;
	
	protected void clickYesButton() {
		yesButton.click();
	}
	
	@FindBy(linkText="submit")
	protected WebElement submitLink;
	
	public void clickSubmitLink(){
		
		new WebDriverWait(driver, 30).until(ExpectedConditions
				.visibilityOf(submitLink));
		submitLink.click();
	}
	
	
	public void enterTownDetails(String ban){
		enterNewBAN(ban);
		enterComment();
		selectLetter();
		clickYesButton();
		clickSubmitLink();
	
	}
	
}
