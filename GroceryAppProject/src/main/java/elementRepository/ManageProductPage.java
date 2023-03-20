package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.GeneralUtilities;

public class ManageProductPage {

	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	Select obj;
	
	public ManageProductPage(WebDriver driver) {
		
			this.driver=driver;
			PageFactory.initElements(driver, this);
			
	}
	
	@FindBy(xpath="//input[@value='Veg']")
	WebElement radioBtn;
	
	@FindBy(xpath="//input[@value='Nonveg']")
	WebElement radioBtn2;
	
	@FindBy(xpath="//input[@value='Others']")
	WebElement radioBtn3;
	
	@FindBy(id="purpose")
	WebElement priceTypBtn;
	
	@FindBy(id="purpose1 ")
	WebElement priceTypBtn1;
	
	@FindBy(id=" purpose2")
	WebElement priceTypBtn2;
	
	@FindBy(id=" purpose3")
	WebElement priceTypBtn3;

	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-product']")
	WebElement managePrdcttab;
	@FindBy(xpath=" //a[@href='https://groceryapp.uniqassosiates.com/admin/Product/add']")
	WebElement newBtn;
	@FindBy(id="grp_id")
	WebElement groupDropDown;
	@FindBy(xpath="//i[@class='fa fa-search']")
	WebElement serachBtn1;
	@FindBy(xpath="//button[@class='btn btn-danger btn-fix']")
	WebElement serachBtn2;
	@FindBy(xpath="//button[@class='note-btn btn btn-light btn-sm dropdown-toggle']")
	WebElement toolTipStyle;
	@FindBy(xpath="//input[@name='cd']")
	WebElement prdctCode;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[1]")
	WebElement searchResult;
	
	public void clickManageProdcttab() {
		managePrdcttab.click();
	}
	
	public void clickNewButton() {
		
		newBtn.click();
	}
	
	public void clickSearchBtn1() {
		
		serachBtn1.click();
	}
	public void clickOnSearchBtn2() {
	
		serachBtn2.click();
	}
	
	public boolean isRadioButtonSelected() {
		
		return gu.radioButtonIsSelected(radioBtn);
		
	}
	
	public boolean isRadioButtonPriceTypeIsSelected() {
		
		return gu.radioButtonIsSelected(priceTypBtn);
		
	}
	
	public String isDropdownSelected() {
		return gu.dropDownIsSelected(groupDropDown);
		
	}
	
    public String toolTipContent(String attvalue) {
		
    	return gu.toolTipContents(toolTipStyle,attvalue);
	}
    
    public void enterProductCode(String code) {
    	
    	prdctCode.sendKeys(code);
    }
    
    public String getSelectedItemFromSearchBtn2() {
    	
        return searchResult.getText();
   }
}




