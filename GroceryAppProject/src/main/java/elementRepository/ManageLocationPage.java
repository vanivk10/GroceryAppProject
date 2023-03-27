package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageLocationPage {

	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public ManageLocationPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Location/add']")
	WebElement newBtn;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchBtn;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")
	WebElement resetBtn;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveBtn;

	@FindBy(xpath = "//a[@class= 'btn btn-default btn-fix']")
	WebElement cancelBtn;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement AlertMsg;
	
	@FindBy(id="location")
	WebElement locn;
	
	@FindBy(id="delivery")
	WebElement deliveryCharg;
	
	@FindBy(id="country_id")
	WebElement dropDownCountry;
	
	@FindBy(id="st_id")
	WebElement dropDownState;
	
	public String getValueFromTheDropdownCountry() {
		return gu.dropDownIsSelected(dropDownCountry);
		
	}
	
	public String getValuesFromTheDropDownSate() {
		return gu.dropDownIsSelected(dropDownState);
		
	}

	public void enterLocation(String ln) {
	
		gu.enterText(ln, locn);
		
	}
	
	public void enterDeliveryCharg(String charge) {
		
		gu.enterText(charge, deliveryCharg);
		
	}
	public void clickOnSaveButton() {

		gu.clickOnWebElement(saveBtn);

	}

	public void clickOncancelButton() {

		gu.clickOnWebElement(cancelBtn);

	}

	public void clickOnNewButton() {

		gu.clickOnWebElement(newBtn);


	}

	public boolean getErrorMessage(String text) {
		boolean actual=gu.getexpectedResultAlert(AlertMsg, text);
		return text.contains(text);
	}
	
	public String backGroundColourOfSearchButton() {
	
		return gu.getCssProperties(searchBtn,"background-color");
		
	}

}
