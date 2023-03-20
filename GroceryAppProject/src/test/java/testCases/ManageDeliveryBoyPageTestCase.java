package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.AdminPage;
import elementRepository.GLoginPage;
import elementRepository.ManageDeliveryBoyPage;
import utilities.ExcelReadUtility;

public class ManageDeliveryBoyPageTestCase extends BaseClass {

	AdminPage ap;
	GLoginPage gp;
	ManageDeliveryBoyPage deliveryby;

	@Test
	public void verifyingAdminAbleToAddNewDeliveryBoyDetailsWhileClickingNewButtonInManageDeliveryBoyPage()
			throws IOException {

		gp = new GLoginPage(driver);
		ap = new AdminPage(driver);
		deliveryby = new ManageDeliveryBoyPage(driver);
		gp.enterUserName(Constant.LOGINUSERNAME);
		gp.eneterPassWord(Constant.LOGINPASSWORD);
		gp.clickSignInButton();
		ap.clickmanageDeliveryBoy();
		deliveryby.clickOnNewBtn();
		deliveryby.enterName(Constant.DELIVERYBOYNAME);
		deliveryby.enterEmailId(Constant.DELIVERYBOYEID);
		deliveryby.enterPhoneNumber(Constant.DELIVERYBOYNUMBER);
		deliveryby.enterAddress(Constant.DELIVERYBOYADDRESS);
		deliveryby.enterUserName(Constant.DELIVERYBOYUNAME);
		deliveryby.eneterPassWord(Constant.DELIVERYBOYPASWD);
		deliveryby.clickOnSaveBtn();
		boolean actualResult = deliveryby.getErrorMessage(Constant.EXPECTEDALERTMESSAGEOFDELIVERYBOYDETAILS);
		Assert.assertTrue(actualResult, Constant.COMMONERRORMESSAGE);

	}

	@Test
	public void verifyTheFuctionalityOfTheResetButton() throws IOException {

		gp = new GLoginPage(driver);
		ap = new AdminPage(driver);
		deliveryby = new ManageDeliveryBoyPage(driver);
		gp.enterUserName(prop.getProperty("username"));
		gp.eneterPassWord(prop.getProperty("password"));
		gp.clickSignInButton();
		ap.clickmanageDeliveryBoy();
		deliveryby.clickOnSearchBtn();
		deliveryby.enterName(Constant.NAMEMANAGEDELIVERYBOY);
		deliveryby.clickOnResetBtn();
		boolean actualResult = deliveryby.presenceofName();
		boolean expectedResult = false;
		Assert.assertEquals(actualResult, expectedResult, Constant.COMMONERRORMESSAGE);

	}

}
