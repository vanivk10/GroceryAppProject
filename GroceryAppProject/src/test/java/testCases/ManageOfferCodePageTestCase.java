package testCases;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.AdminPage;
import elementRepository.GLoginPage;
import elementRepository.ManageOfferCodePage;
import elementRepository.ManageProductPage;

public class ManageOfferCodePageTestCase extends BaseClass {

	GLoginPage gp;
	AdminPage ap;
	ManageOfferCodePage offer;

	@Test
	public void verifyFuctionalityOfResetButton() {

		gp = new GLoginPage(driver);
		ap = new AdminPage(driver);
		offer = new ManageOfferCodePage(driver);
		gp.enterUserName(prop.getProperty("username"));
		gp.eneterPassWord(prop.getProperty("password"));
		gp.clickSignInButton();
		ap.clickOnManageOfferCodeBtn();
		offer.clickOnSearchBtn();
		offer.enterOfferCode(Constant.OFFERCODE);
		offer.clickOnResetBtn();
		boolean actualResult = offer.presenceofOfferCode();
		boolean expectedResult = false;
		Assert.assertEquals(actualResult, expectedResult, Constant.COMMONERRORMESSAGE);

	}

	@Test
	public void verifyAdminIsAbleToAddOfferCode(){

		gp = new GLoginPage(driver);
		ap = new AdminPage(driver);
		offer = new ManageOfferCodePage(driver);
		gp.enterUserName(Constant.LOGINUSERNAME);
		gp.eneterPassWord(Constant.LOGINPASSWORD);
		gp.clickSignInButton();
		ap.clickOnManageOfferCodeBtn();
		offer.clickOnNewBtn();
		offer.enterOfferCode(Constant.OFFERCODE);
		offer.isRadioButtonFirstOrderSelected();
		offer.enterPercentage(Constant.PERCENTAGE);
		offer.enterAmount(Constant.AMOUNT);
		offer.clickOnSaveButton();
		boolean actualResult = offer.getErrorMessage(Constant.EXPECTEDOFFERCOODEALERTMESSAGE);
		Assert.assertTrue(actualResult, Constant.COMMONERRORMESSAGE);

	}

	@Test
	public void verifyAdminIsAbleToSelectFirstOrderUserRadioButtonValueYES() {

		gp = new GLoginPage(driver);
		ap = new AdminPage(driver);
		offer = new ManageOfferCodePage(driver);
		gp.enterUserName(Constant.LOGINUSERNAME);
		gp.eneterPassWord(Constant.LOGINPASSWORD);
		gp.clickSignInButton();
		ap.clickOnManageOfferCodeBtn();
		offer.clickOnNewBtn();
		boolean actualResult = offer.isRadioButtonFirstOrderSelected();
		boolean expectedResult = true;
		Assert.assertEquals(actualResult, expectedResult, Constant.COMMONERRORMESSAGE);

	}

}
