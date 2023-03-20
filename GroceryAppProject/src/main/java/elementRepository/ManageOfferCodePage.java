package elementRepository;

import java.awt.AWTException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GeneralUtilities;

public class ManageOfferCodePage {

	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public ManageOfferCodePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
    }
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	WebElement newBtn;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	WebElement searchBtn;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-warning'] ")
	WebElement resetBtn;
	
	@FindBy(xpath="//input[@class='form-control']")
	WebElement offercode;
	
	@FindBy(xpath="(//input[@type='radio'])[1]")
	WebElement radioBtn1;
	@FindBy(xpath="(//input[@type='radio'])[2]")
	WebElement radioBtn2;
	
	@FindBy(id="offer_per")
	WebElement percentage;
	
	@FindBy(id="offer_price")
	WebElement amount;
	
	
	@FindBy(id="main_img")
	WebElement chooseFile;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement saveBtn;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;
	
	public boolean presenceofOfferCode() {
		return gu.presenceofWebElement(offercode);
	}
	
	public void clickOnSaveButton() {
		JavascriptExecutor js = (JavascriptExecutor) driver; //We use the Javascript interface to perform actions.
		js.executeScript("window.scrollBy(0,3000)");
		js.executeScript("arguments[0].click();",saveBtn );
		
	}
	public void clickOnNewBtn() {
		newBtn.click();
	}
	
	public void clickOnSearchBtn() {
		searchBtn.click();
	}
	public void clickOnResetBtn() {
		resetBtn.click();
	}
	
	public void enterOfferCode(String code) {
		offercode.sendKeys(code);
		
	}
	public void enterPercentage(String p) {
		percentage.sendKeys(p);
		
	}
	public void enterAmount(String amnt) {
		amount.sendKeys(amnt);
		
	}
	
	public boolean isRadioButtonFirstOrderSelected() {

		return gu.radioButtonIsSelected(radioBtn1);

	}

	public boolean RadioButtonFirstOrderSelected() {

		return gu.radioButtonIsSelected(radioBtn2);

	}
	public void FileUpload() throws AWTException {
		gu.fileUploads(driver,chooseFile, System.getProperty("user.dir")+"\\src\\main\\resources\\UploadFiles\\offer.jpg");
	}
	
	public boolean getErrorMessage(String text) {
		boolean actual=gu.getexpectedResultAlert(alert, text);
		return text.contains(text);
	}
	public String getAlertMessage() {
		
		
	   return gu.getElementText(alert);
	}
	
	
}