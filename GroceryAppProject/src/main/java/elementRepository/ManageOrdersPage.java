package elementRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageOrdersPage {

		WebDriver driver;
		GeneralUtilities gu=new GeneralUtilities();
		
		
		public ManageOrdersPage(WebDriver driver) {
			
			this.driver=driver;
			PageFactory.initElements(driver, this);
	}

		@FindBy(xpath="//i[@class=' fa fa-search']")
		WebElement blueSearchBtn;
		
		@FindBy(xpath="//button[@class='btn btn-danger btn-fix']")
		WebElement redserachBtn;
		
		@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[1]")
		WebElement searchOrderResult;
		
		@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-order' ]")
		WebElement resetBtn;
		
		@FindBy(xpath=" (//a[@type='button'])[1]")
		WebElement changeStatusBtn;
		
		@FindBy(id="od")
		WebElement orderId;
		
		@FindBy(id="um")
		WebElement userId;
		
		@FindBy(id="sd")
		WebElement startDate;
		
		@FindBy(id="ed")
		WebElement endDate;
		
		@FindBy(id="pt")
		WebElement paymentModeDropDown;
		
		@FindBy(id="st")
		WebElement status;
		
		@FindBy(xpath=" //button[@class='btn btn-default btn-fix']")
		WebElement  resetBtn1;
		
		@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr[8]//td[1]")
		List<WebElement> tableRow;
		
		public void enterOrderId(String id) {
			gu.enterText(id, orderId);
			
		}
		
		public void clickOnSerachBtn() {
			
			gu.clickOnWebElement(blueSearchBtn);
		}
		
		public void clickOnSerachBtn1() {
			
			gu.clickOnWebElement(redserachBtn);
		}
		
		
		public String getSelectedItemFromSearchBtn() {
			
	        return blueSearchBtn.getText();
	   }
		
		public String getSelectedItemFromSearchBtn1() {
			
	        return searchOrderResult.getText();
	   }
	
		public String getSelectedValueFromTheDropdownPaymentMode() {
			return gu.dropDownIsSelected(paymentModeDropDown);
			
		}
     
					
     }
		
 
   


