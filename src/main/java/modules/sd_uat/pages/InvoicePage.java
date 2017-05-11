package modules.sd_uat.pages;

import java.util.Set;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import telus.itsuppt.automation.support.ReportingTools;

public class InvoicePage extends HomePage {

	public InvoicePage(WebDriver driver) {
		super(driver);
	}

	// @FindBy(xpath =
	// "//div[@id='divTabContent']/table[1]//div[@id='outterPaginatedList']/table/tbody/tr[2]/td[1]/a")
	// "//td[.='invoice history']/../following::tr[2]//div[@id='outterPaginatedList']//tr[@class='list_tr_odd'][1]/td[1]/a"
	@FindBy(xpath = "//div[@id='divTabContent']/table[1]//div[@id='outterPaginatedList']//tr[@class='list_tr_odd'][1]/td[1]/a")
	protected WebElement clientsInvoicesDate;

	public void clickOnClientsInvoicesDateColumn() {
		try {
			clientsInvoicesDate.click();
		} catch (NoSuchElementException e) {
			Assert.fail("element not found");

		}

	}

	//@FindBy(xpath = "//h2[.='Bill Viewer']")
	@FindBy(xpath = "//div[text()='Bill Viewer']")
	protected WebElement billViewerHeading;

	/***************** METHODS ***********************/

	/**
	 * verifies the invoice generated
	 * 
	 * @author mayank.c.joshi
	 * @throws InterruptedException
	 */
	public void verifyInvoice() throws InterruptedException

	{
		String parent = driver.getWindowHandle();
		System.out.println("the parent is " + parent);
		clickOnClientsInvoicesDateColumn();

		Set<String> windowHandles = driver.getWindowHandles();
		windowHandles.remove(parent);
		
		int a=windowHandles.size();
		System.out.println("the number of windows are"+a);

		System.out.println("the current window is" + windowHandles);
		Thread.sleep(20000);
		

		for (String windowHandle : windowHandles) {
			driver.switchTo().window(windowHandle);
		}

		try {
	
			System.out.println("the title is"+driver.getTitle());
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(billViewerHeading));
				ReportingTools.highlightElement(billViewerHeading);
			ReportingTools.takeScreenshot("Bill found");

		} catch (NoSuchElementException e) {
			Assert.fail("Bill viewer heading not found");
		}

		driver.close();

		driver.switchTo().window(parent);
		ReportingTools.takeScreenshot("Back to original page");
	}

}
