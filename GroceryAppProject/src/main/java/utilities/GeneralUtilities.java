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
	Select obj;

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

	public void fileUploads(WebDriver driver, WebElement element, String filePath) throws AWTException {

		Robot obj = new Robot();
		Actions mouse = new Actions(driver);
		mouse.moveToElement(element).click().perform();
		StringSelection ss = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		obj.keyPress(KeyEvent.VK_CONTROL);
		obj.keyPress(KeyEvent.VK_V);
		obj.delay(250);
		obj.keyRelease(KeyEvent.VK_CONTROL);
		obj.keyRelease(KeyEvent.VK_V);
		obj.delay(250);
		obj.keyPress(KeyEvent.VK_ENTER);
		obj.keyRelease(KeyEvent.VK_ENTER);

	}
	
	public boolean presenceofWebElement(WebElement element) {
		boolean presence=element.isDisplayed();
		return presence;
	}

}
