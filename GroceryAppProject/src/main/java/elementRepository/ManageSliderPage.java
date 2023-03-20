package elementRepository;
import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageSliderPage  {
	
		WebDriver driver;
		GeneralUtilities gu=new GeneralUtilities();
		
		//String path="";
		public ManageSliderPage(WebDriver driver) {
			
				this.driver=driver;
				PageFactory.initElements(driver, this);
		}

		@FindBy(xpath="//a[@class='btn btn-sm btn btn-danger btncss']") 
		WebElement deleteBtn;
		
		@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
		WebElement newBtn;
		
		@FindBy(id="main_img")
		WebElement chooseFile;
		
		@FindBy(xpath="//span[@class='badge bg-success']")
		WebElement statusBtn;
		
		@FindBy(xpath="//i[@class='ace-icon fa fa-sync-alt']")
		WebElement resetBtn;
		
		@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
		WebElement imgAlertMsg;

		@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/slider/edit?edit=369&page_ad=1']") 
		WebElement editBtn;
		
		@FindBy(id="link")
		WebElement link;
		
		@FindBy(xpath="//button[@name='create']")
		WebElement saveBtn;
		
		@FindBy(xpath="//a[@type='button']")
		WebElement cancellBtn;
		
		public String getAlertMessage() {
		   return gu.getElementText(imgAlertMsg);
		}
		
		public boolean getErrorMessage(String text) {
			boolean actual=gu.getexpectedResultAlert(imgAlertMsg, text);
			return text.contains(text);
		}
		
		public void enterlinkText(String linkTxt) {
			link.sendKeys(linkTxt);	
		}
		
		public void clickNewBtn() {
			newBtn.click();
			
		}
		public String getTitle() {
			return driver.getTitle();	
				
		}
		public void clickOnSaveeBtn() {
			saveBtn.click();
		}
		public void clickOncancelBtn() {
			cancellBtn.click();
		}
		
		public void clickOnDeleteBtn() {
			deleteBtn.click();
		}
		public String Alert() {
			
			String alert=driver.switchTo().alert().getText();
			return alert;
			
		}
		
		public String getResetBtnBgColor() {
			return gu.getCssProperties(resetBtn, "background-color");
		}
		
		
		public void FileUpload() throws AWTException {
			gu.fileUploads(driver,chooseFile, System.getProperty("user.dir")+"\\src\\main\\resources");
		}
		
		
	}

