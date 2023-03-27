package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilities {
	RandomDataGeneratorUtility data=new RandomDataGeneratorUtility();
	Select obj;
	Robot obj1;
	
	
	public void enterUserNameWithRandomNumber(String user,WebElement element) {
		String randomString=data.randomPassword();
		element.sendKeys(user+randomString);
		
	}

	public void enterText(String str,WebElement element) {
		element.sendKeys(str);
	}
	
	public void clickOnWebElement(WebElement element){
		element.click();
	}
	
	public boolean getexpectedResultAlert(WebElement element,String text) {
		String alert=element.getText();
		return alert.contains(text);
	}
	
	
	public String getElementText(WebElement element) {
		String text = element.getText();
		return text;

	}

	public boolean checkBoxIsSelected(WebElement element) {
		boolean result = element.isSelected();
		return result;
	}

	public boolean radioButtonIsSelected(WebElement element) {

		element.click();
		boolean result = element.isSelected();
		return result;

	}

	public String dropDownIsSelected(WebElement element) {
		obj = new Select(element);
		obj.selectByIndex(1);
		String str = obj.getFirstSelectedOption().getText();
		return str;
	}
	
	

	public String toolTipContents(WebElement element, String value) {

		String t = element.getAttribute(value);
		return t;
	}

	public String getCssProperties(WebElement element, String cSSvalue) {

		String c = element.getCssValue(cSSvalue);
		return c;

	}
	
	public int getTableLocatorValue(List<WebElement> element, String text) {
		int index=0;
		for(int i=0;i<element.size();i++) {
			if(element.get(i).getText().equals(text)) {
				index=i;
				break;
			}
			
		}
		return index;

	}

	public void fileUploads(WebDriver driver, WebElement element, String filePath){

		try {
			obj1 = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Actions mouse = new Actions(driver);
		mouse.moveToElement(element).click().perform();
		StringSelection ss = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		obj1.keyPress(KeyEvent.VK_CONTROL);
		obj1.keyPress(KeyEvent.VK_V);
		obj1.delay(250);
		obj1.keyRelease(KeyEvent.VK_CONTROL);
		obj1.keyRelease(KeyEvent.VK_V);
		obj1.delay(250);
		obj1.keyPress(KeyEvent.VK_ENTER);
		obj1.keyRelease(KeyEvent.VK_ENTER);

	}
	
	public boolean presenceofWebElement(WebElement element) {
		boolean presence=element.isDisplayed();
		return presence;
	}

}
