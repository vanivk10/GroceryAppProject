package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class AdminPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public AdminPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//li[@class='nav-item dropdown']")
	WebElement adminTab;

	@FindBy(xpath = "//i[@class='ace-icon fa fa-power-off']")
	WebElement logOutOption;

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-user' ]")
	WebElement manageUsersBtn;

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-page'][normalize-space()='More info']")
	WebElement managePagesBtn;

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-slider'][normalize-space()='More info']")
	WebElement manageSliderBtn;

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-notifications']")
	WebElement pushnotificationBtn;

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-order']")
	WebElement manageOrdersBtn;

	@FindBy(xpath = " (//a[@href='https://groceryapp.uniqassosiates.com/admin/list-deliveryboy'])[2]")
	WebElement manageDeliveryBoyBtn;

	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-location'])[2]")
	WebElement manageLocationBtn;

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-offercode']")
	WebElement manageOfferCodeBtn;

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-mobileslider'][normalize-space()='More info']")
	WebElement mobileSliderBtn;

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']")
	WebElement adminUser;

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news'][normalize-space()='More info']")
	WebElement manageNewsBtn;
	
	@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-location'])[2]")
	WebElement ManageLocationBtn;
	
	public void clickOnManageOfferCodeBtn() {

		manageOfferCodeBtn.click();
	}
	public void clickOnManageLocationBtn() {

		ManageLocationBtn.click();
	}

	public void clickOnmanageNewsBtn() {

		manageNewsBtn.click();
	}

	public void clickOnAdminUser() {

		adminUser.click();
	}

	public void clickmanageDeliveryBoy() {

		manageDeliveryBoyBtn.click();
	}

	public void clickOnmobileSlider() {

		mobileSliderBtn.click();
	}

	public void clickOnmanageOrders() {
		manageOrdersBtn.click();

	}

	public void clickOnAdmin() {
		adminTab.click();
	}

	public String clickOnLogout() {
		logOutOption.click();
		return driver.getCurrentUrl();

	}

	public String pageTitle() {
		return driver.getTitle();
	}

	public String clickOnManageUserBtn() {
		manageUsersBtn.click();
		return driver.getCurrentUrl();
	}

	public void ClickOnManagePagesBtn() {
		managePagesBtn.click();

	}

	public void clickmanageSliderBtn() {
		manageSliderBtn.click();
	}
}
