package testCases;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.AdminPage;
import elementRepository.GLoginPage;

import elementRepository.ManageSliderPage;

public class ManageSliderPageTestCase extends BaseClass {
	GLoginPage gp;
	AdminPage ap;
	ManageSliderPage slider;

	@Test(groups = { "critical" })

	public void verifyBackgroundColorOfResetButtonInListSliderPage() {

		slider = new ManageSliderPage(driver);
		gp = new GLoginPage(driver);
		ap = new AdminPage(driver);
		gp.enterUserName(Constant.LOGINUSERNAME);
		gp.eneterPassWord(Constant.LOGINPASSWORD);
		gp.clickSignInButton();
		ap.clickmanageSliderBtn();
		String actualResult = slider.getResetBtnBgColor();
		String expectedResult = Constant.EXPECTEDRGBCOLORFORMANAGESLIDER;
		Assert.assertEquals(actualResult, expectedResult, Constant.BACKGROUNDCOLOURERRORMESSAGE);
	}

	@Test
	public void verifyAdminCanAccessAddSliderPageWhileClikingOnNewButton() {

		slider = new ManageSliderPage(driver);
		gp = new GLoginPage(driver);
		ap = new AdminPage(driver);
		gp.enterUserName(Constant.LOGINUSERNAME);
		gp.eneterPassWord(Constant.LOGINPASSWORD);
		gp.clickSignInButton();
		ap.clickmanageSliderBtn();
		slider.clickNewBtn();
		String actualResult = slider.getTitle();
		String expectedresult = Constant.EXPECTEDTITLEOFMANAGESLIDER;
		Assert.assertEquals(actualResult, expectedresult, Constant.COMMONERRORMESSAGE);

	}

	@Test
	public void verifyAlertMessageIsShownWhenFileUplaodedSuccessfullyInAddSliderPage() throws AWTException {

		slider = new ManageSliderPage(driver);
		gp = new GLoginPage(driver);
		ap = new AdminPage(driver);
		gp.enterUserName(Constant.LOGINUSERNAME);
		gp.eneterPassWord(Constant.LOGINPASSWORD);
		gp.clickSignInButton();
		ap.clickmanageSliderBtn();
		slider.clickNewBtn();
		slider.FileUpload();
		slider.enterlinkText(Constant.LINKTEXT);
		slider.clickOnSaveeBtn();
		boolean actualResult = slider.getErrorMessage(Constant.EXPECTEDRESULTOFCREATEDSLIDER);
		Assert.assertTrue(actualResult, Constant.COMMONERRORMESSAGE);

	}

}
