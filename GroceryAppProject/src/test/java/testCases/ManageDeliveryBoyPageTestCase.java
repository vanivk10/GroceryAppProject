package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.AdminPage;
import elementRepository.GLoginPage;
import elementRepository.ManageDeliveryBoyPage;
import utilities.ExcelReadUtility;
import utilities.RetryUtils;

public class ManageDeliveryBoyPageTestCase extends BaseClass {

	AdminPage ap;
	GLoginPage gp;
	ManageDeliveryBoyPage deliveryby;

	@Test(retryAnalyzer = RetryUtils.class,groups = "critical")
	public void verifyingAdminAbleToAddNewDeliveryBoyDetailsWhileClickingNewButtonInManageDeliveryBoyPage(){

		gp = new GLoginPage(driver);
		ap = new AdminPage(driver);
		deliveryby = new ManageDeliveryBoyPage(driver);
		gp.enterUserName(Constant.LOGINUSERNAME);
		gp.eneterPassWord(Constant.LOGINPASSWORD);
		gp.clickSignInButton();
		ap.clickmanageDeliveryBoy();
		deliveryby.clickOnNewBtn();
		deliveryby.enterName(faker.name().firstName());
		deliveryby.enterEmailId(Constant.DELIVERYBOYEID);
		deliveryby.enterPhoneNumber(faker.phoneNumber().cellPhone());
		deliveryby.enterAddress(faker.address().state());
		deliveryby.enterUserName(faker.name().username());
		deliveryby.eneterPassWord(faker.internet().password());
		deliveryby.clickOnSaveBtn();
		boolean actualResult = deliveryby.getErrorMessage(Constant.EXPECTEDALERTMESSAGEOFDELIVERYBOYDETAILS);
		Assert.assertTrue(actualResult, Constant.COMMONERRORMESSAGE);

	}

	@Test
	public void verifyTheFuctionalityOfTheResetButton(){

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
