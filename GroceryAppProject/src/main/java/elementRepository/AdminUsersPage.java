package elementRepository;

	import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;
import utilities.RandomDataGeneratorUtility;

	public class AdminUsersPage {
		WebDriver driver;
		GeneralUtilities gu=new GeneralUtilities();
		
			public AdminUsersPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
		List<WebElement> userName;
		
		@FindBy(xpath="//a[@href='javascript:void(0)']//i[@class='fas fa-edit']")
		WebElement newButton;
		@FindBy(id="username")
		WebElement username;
		@FindBy(id="password")
		WebElement password;
		@FindBy(id="user_type")
		WebElement useType;
		@FindBy(xpath="//button[@name='Create']")
		WebElement saveButton;
		@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
		WebElement alert;
		
		public boolean getErrorMessage(String text) {
			boolean actual=gu.getexpectedResultAlert(alert, text);
			return text.contains(text);
		}

		public void clickOnNewButton() {
			gu.clickOnWebElement(newButton);
		}
		public void enterUserName(String user) {
			
			gu.enterUserNameWithRandomNumber(user, username);
			
		}
		public void enterPassword(String paswd) {
			
			gu.enterText(paswd, password);
		}
		public String selectUserTypeFromDropDown() {
			return gu.dropDownIsSelected(useType);
		}
		public void clickSaveButton() {
			
			gu.clickOnWebElement(saveButton);
		}
		
	}


