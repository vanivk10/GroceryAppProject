package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageUserPage {
	
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	
	public ManageUserPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="(//i[@class='fas fa-arrow-circle-right'])[10]")
	WebElement manageUserBtn;
	
	@FindBy(xpath="//i[@class=' fa fa-search']")
	WebElement serachBtn;
	
	
	@FindBy(xpath="//button[@name='Search']")
	WebElement searchBtn1;
	
	@FindBy(xpath="")
	WebElement resetBtn;
	
	@FindBy(xpath="")
	WebElement statusBtn;
	
	@FindBy(id="un")
	WebElement uName;
	
	@FindBy(id="ut")
	WebElement emailId;
	
	@FindBy(id="ph")
	WebElement phoneNumber;
	
	@FindBy(id="st")
	WebElement status;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[1]")
	WebElement  searchResult;
	
	
	public void clickOnManageusersBtn() {
	
		gu.clickOnWebElement(manageUserBtn);

	}
	
	public void clickOnSearchBtn() {
		
		gu.clickOnWebElement(serachBtn);
	}
	
	public void clickOnSearchBtn1() {
		
		gu.clickOnWebElement(searchBtn1);
	}
	
	
	public void clickOnResetBtn() {
		gu.clickOnWebElement(resetBtn);
		
	}
	
	public void enteUserName(String user) {
		
		gu.enterText(user, uName);
	}
	public void enterEmailId(String eId) {
		
		gu.enterText(eId, emailId);
	}
	
	public void enterPhoneNumber(String pNum) {
		
		gu.enterText(pNum, phoneNumber);
	}
	
	public String isDropDownSelected() {
		return gu.dropDownIsSelected(status);
		
	}
	public String getSelectedItemFromSearchBtn1() {
	
        return searchResult.getText();
   }
	
	public String getTextOfSearchButtonInListUsersPage() {
		
	 return gu.getElementText(searchBtn1);//calling general utility function for getelementtext();
		}
	
}
