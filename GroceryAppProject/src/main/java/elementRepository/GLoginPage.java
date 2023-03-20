package elementRepository;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import utilities.GeneralUtilities;

public class GLoginPage {

	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	
	public GLoginPage(WebDriver driver) {
		
			this.driver=driver;
			PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@type='text']")
	WebElement UserName;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement PassWord;
	
	//@FindBy(id="remember")
	//WebElement rememberMe;
	
	@FindBy(xpath=" //input[@type='checkbox']")
	WebElement checkbox;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	WebElement loginAlertMsg;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement SignInButton;
	
	/*public boolean presenceofSignInButton() {
		String presence=SignInButton.isDisplayed();
		return presence;
	}*/
	
	public void enterUserName(String user) {
		UserName.sendKeys(user);
		
	}
	
	public void eneterPassWord(String pass) {
		PassWord.sendKeys(pass);
	}
	
	public void clickSignInButton() {
		
		SignInButton.click();
	
	}
	
	public boolean getErrorMessage(String text) {
		boolean actual=gu.getexpectedResultAlert(loginAlertMsg, text);
		return text.contains(text);
	}
	

	public boolean checkRememberMe() {
		
		
		return gu.checkBoxIsSelected(checkbox);
	}
	
	
		
	public String SignInButtonColour() {
		
		String c=SignInButton.getCssValue("background-color");
		return c;
		
	}
	
    public String getTextOfSignInButton() {
		
	 return gu.getElementText(SignInButton);//calling general utility function for getelementtext();
	}
	
 
}
