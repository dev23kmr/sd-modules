package modules.sd_uat.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateSmartNotePage extends HomePage {

	public CreateSmartNotePage(WebDriver driver) {
		super(driver);
	}

	// -------------------------------------------------------------------
	@FindBy(xpath = "//select[@id = 'noteCategory']")
	protected WebElement notesCategory;

	protected void selectNotesCategory(String categoryOfNote) {
		new WebDriverWait(driver, 60).until(ExpectedConditions
				.visibilityOf(notesType));
		new Select(notesCategory).selectByVisibleText(categoryOfNote);
	}

	// -------------------------------------------------------------------
	@FindBy(xpath = "//select[@id = 'noteType']")
	protected WebElement notesType;

	protected void selectNotesType(String typeOfNote) {
		new WebDriverWait(driver, 10).until(ExpectedConditions
				.visibilityOf(notesType));
		new Select(notesType).selectByVisibleText(typeOfNote);
	}

	// -------------------------------------------------------------------
	@FindBy(xpath = "//textarea[@id = 'noteText']")
	protected WebElement notesText;

	protected void enterNoteText(String textOfNote) {
		new WebDriverWait(driver, 10).until(
				ExpectedConditions.visibilityOf(notesText)).clear();
		notesText.sendKeys(textOfNote);
	}

	public void createNoteinSd(String categoryOfNote, String typeOfNote,
			String textOfNote) throws InterruptedException {
		selectNotesCategory(categoryOfNote);
		selectNotesType(typeOfNote);
		Thread.sleep(5000);
		enterNoteText(textOfNote);
		clickOnAcceptButton();
	}
}
