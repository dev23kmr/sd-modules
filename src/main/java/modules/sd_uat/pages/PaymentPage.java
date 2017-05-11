package modules.sd_uat.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import telus.itsuppt.automation.support.ReportingTools;

/**
 * 
 * @author mayank.c.joshi
 *
 */

public class PaymentPage extends HomePage

  {
	public PaymentPage(WebDriver driver) 
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}


	@FindBy(xpath = "//select[@id='cardType']")
	protected WebElement cardTypeTab;

	protected void selectCardType(String choice) {
		new Select(cardTypeTab).selectByVisibleText(choice);
	}
	
	
	@FindBy(xpath = "//input[@id='cardNumber']")
	protected WebElement creditcardNumberTab;

	protected void enterCreditCardNumber(String number) {
		creditcardNumberTab.sendKeys(number);
	}
	
	
	
	@FindBy(xpath = "//select[@id='expiryMonth']")
	protected WebElement expiryMonthTab;

	protected void selectedExpiryMonth(String month) {
		new Select(expiryMonthTab).selectByVisibleText(month);
	}

	@FindBy(xpath = "//select[@id='expiryYear']")
	protected WebElement expiryYearTab;

	protected void selectExpiryYear(String year) {
		new Select(expiryYearTab).selectByValue(year);

	}
  @FindBy(xpath = "//input[@id='amount']")
  protected WebElement amountTab;
  
  protected void enterAmount(String amount)
  {
	  amountTab.clear();
	  amountTab.sendKeys(amount);
  }
  @FindBy(xpath = "//td[contains(text(),'credit card payment confirmation')]")
  protected WebElement paymentConfirmationTab;
  
  @FindBy(name="isDeposit")
  protected WebElement depositPaymentCheckbox;
  
  @FindBy(xpath = "//td[contains(text(),'credit card payment summary')]")
  protected WebElement paymentSummaryTab;
  
	/**
	 * @author mayank.c.joshi
	 * make a payment selection method(for make payment amex script)
	 */
	public void makePayment(String choice,String number,String month,String year
			,String amount)
	{
		ReportingTools.takeScreenshot("Credit card payment page displayed");
		selectCardType(choice);
		enterCreditCardNumber(number);
		selectedExpiryMonth(month);
		selectExpiryYear(year);
		enterAmount(amount);
		depositPaymentCheckbox.click();
		clickOnSubmitButton();
				
	}
	
	
	public void verifyPaymentConfirmation(String comment)
	{
		new WebDriverWait(driver, 10).until(ExpectedConditions
				.visibilityOf(paymentConfirmationTab));
		ReportingTools.highlightElement(paymentConfirmationTab);
		ReportingTools.takeScreenshot("Successfully located the payment confirmation tab");
		enterComment(comment);
		clickOnAcceptButton();
		new WebDriverWait(driver, 10).until(ExpectedConditions
				.visibilityOf(paymentSummaryTab));
		ReportingTools.highlightElement(paymentSummaryTab);
		ReportingTools.takeScreenshot("Payment done Succesfully");	
		
	}

	
	
	
	

}

