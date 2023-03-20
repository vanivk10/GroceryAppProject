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
	RandomDataGeneratorUtility data = new RandomDataGeneratorUtility();
	// WebDriverwait wait=new WebDriverWait(driver);

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
		nam.sendKeys(na);

	}

	public void enterPhoneNumber(String no) {
		phonenumber.sendKeys(no);

	}

	public void enterEmailId(String eid) {
		emailId.sendKeys(eid);

	}

	public void enterAddress(String adr) {
		addresss.sendKeys(adr);

	}

	public void enterUserName(String user) {

		String randomString = data.randomPassword();
		newUsername.sendKeys(user + randomString);

	}

	public void eneterPassWord(String pass) {
		newPassword.sendKeys(pass);
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

	public void clickOnCancelBtn() {
		cancelBtn.clear();

	}

	public void clickOnSaveBtn() {
		JavascriptExecutor js = (JavascriptExecutor) driver; // We use the Javascript interface to perform actions.
		js.executeScript("window.scrollBy(0,3000)");
		js.executeScript("arguments[0].click();", saveBtn);

	}
}
