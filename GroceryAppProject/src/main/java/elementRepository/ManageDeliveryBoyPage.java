package elementRepository;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.GeneralUtilities;
import utilities.RandomDataGeneratorUtility;

public class ManageDeliveryBoyPage {

	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public ManageDeliveryBoyPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Deliveryboy/add']")
	WebElement newBtn;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchBtn;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning'] ")
	WebElement resetBtn;

	@FindBy(xpath = "//input[@type='text'][1]")
	WebElement nam;

	@FindBy(id = "email")
	WebElement emailId;

	@FindBy(id = "phone")
	WebElement phonenumber;

	@FindBy(id = "address")
	WebElement addresss;

	@FindBy(id = "username")
	WebElement newUsername;

	@FindBy(id = "password")
	WebElement newPassword;

	@FindBy(xpath = "//button[@name='create']")
	WebElement saveBtn;

	@FindBy(xpath = "//a[text()='Cancel']")
	WebElement cancelBtn;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement AlertMsg;

	public boolean presenceofName() {
		return gu.presenceofWebElement(nam);
	}

	public String getAlertMessage() {

		return gu.getElementText(AlertMsg);
	}

	public boolean getErrorMessage(String text) {
		boolean actual = gu.getexpectedResultAlert(AlertMsg, text);
		return text.contains(text);
	}

	public void enterName(String na) {

		gu.enterText(na, nam);

	}

	public void enterPhoneNumber(String no) {

		gu.enterText(no, phonenumber);
	}

	public void enterEmailId(String eid) {

		gu.enterText(eid, emailId);

	}

	public void enterAddress(String adr) {

		gu.enterText(adr, addresss);

	}

	public void enterUserName(String user) {

		gu.enterUserNameWithRandomNumber(user, newUsername);

	}

	public void eneterPassWord(String pass) {

		gu.enterText(pass, newPassword);
	}

	public void clickOnNewBtn() {

		gu.clickOnWebElement(newBtn);

	}

	public void clickOnSearchBtn() {

		gu.clickOnWebElement(searchBtn);

	}

	public void clickOnResetBtn() {

		gu.clickOnWebElement(resetBtn);

	}

	public void clickOnCancelBtn() {

		gu.clickOnWebElement(cancelBtn);

	}

	public void clickOnSaveBtn() {
		JavascriptExecutor js = (JavascriptExecutor) driver; // We use the Javascript interface to perform actions.
		js.executeScript("window.scrollBy(0,3000)");
		js.executeScript("arguments[0].click();", saveBtn);

	}
}
