package modules.sd_uat.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import telus.itsuppt.automation.support.ReportingTools;
import telus.itsuppt.automation.support.SoftAssert;

public class ResumeSuspendedSmartNoteListPage extends HomePage {

	public ResumeSuspendedSmartNoteListPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//td[.='note type']/following-sibling::td")
	protected WebElement noteTypeValueColumn;

	@FindBy(xpath = "//td[.='text']/following-sibling::td")
	protected WebElement textValueColumn;

	@FindBy(xpath = "//div[@id='outterPaginatedList']/table")
	protected WebElement smartNoteTable;

	


	/*-----------------METHODS--------------------------*/

	
	/**
	 * 
	 * @param smartNoteName
	 */
	public void isSmartNoteDisplayed(String smartNoteNameResumeSuspended)

	{
		new WebDriverWait(driver, 20).until(ExpectedConditions
				.presenceOfElementLocated(By
						.xpath("//div[@id='outterPaginatedList']/table")));

		List<WebElement> requiredSmartNotes = smartNoteTable.findElements(By
				.partialLinkText(smartNoteNameResumeSuspended));
		if (requiredSmartNotes.isEmpty()) {
			Assert.fail("Smart note, " + smartNoteNameResumeSuspended + ", not found");
		}

		ReportingTools.takeScreenshot("List of Smart Notes");
		requiredSmartNotes.get(0).click();

		new WebDriverWait(driver, 10).ignoring(NoSuchElementException.class)
				.until(ExpectedConditions.visibilityOf(noteTypeValueColumn));

		ReportingTools.highlightElement(noteTypeValueColumn);

		if (!noteTypeValueColumn.getText().equals(smartNoteNameResumeSuspended)) {
			Assert.fail("The smart note name is wrong");
		}

		ReportingTools.takeScreenshot("Note, " + smartNoteNameResumeSuspended
				+ ", is displayed");
	}
	
	
	/**
	 * 
	 * @param smartNoteName
	 * @param smartNoteText
	 */
	public boolean isSmartNoteTextDisplayed(String smartNoteName,
			String smartNoteText) {

		ReportingTools.highlightElement(textValueColumn);
		if (!textValueColumn.getText().contains(smartNoteText)) {
			return false;
		}

		ReportingTools.takeScreenshot("Note, " + smartNoteName
				+ ", contains text (" + smartNoteText + ") ");
		return true;
	}

	/**
	 * 
	 * @param smartNoteName
	 * @throws InterruptedException
	 */
	public void validateSmartNoteAndSmartNoteText(String smartNoteName,
			String smartNoteText) throws InterruptedException {

		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(smartNoteTable));

		List<WebElement> requiredSmartNotes = smartNoteTable.findElements(By
				.partialLinkText(smartNoteName));

		if (requiredSmartNotes.isEmpty()) {
			Assert.fail("Smart note, " + smartNoteName + ", not found");
		}

		ReportingTools.takeScreenshot("List of Smart Notes");

		for (int smartNoteCount = 0; smartNoteCount < requiredSmartNotes.size(); smartNoteCount++) {
			clickViewAllNotesLink();
			requiredSmartNotes = smartNoteTable.findElements(By
					.partialLinkText(smartNoteName));
			requiredSmartNotes.get(smartNoteCount).click();

			new WebDriverWait(driver, 10)
					.ignoring(NoSuchElementException.class).until(
							ExpectedConditions
									.visibilityOf(noteTypeValueColumn));

			if (isSmartNoteTextDisplayed(smartNoteName, smartNoteText)) {

				ReportingTools.highlightElement(noteTypeValueColumn);
				if (!noteTypeValueColumn.getText().equals(smartNoteName)) {
					SoftAssert.fail("The smart note name is wrong");
				}
				ReportingTools.takeScreenshot("Note, " + smartNoteName
						+ ", is displayed");
				return;
			}
		}

		SoftAssert.fail("The smart note does not contain the memo text");
	}

	

	

	

}
