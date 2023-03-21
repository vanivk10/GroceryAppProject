package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.AdminPage;
import elementRepository.GLoginPage;
import elementRepository.ManageUserPage;
import utilities.RetryUtils;

public class ManageUserTestCase extends BaseClass {

	GLoginPage gp;
	AdminPage ap;
	ManageUserPage user;

	@Test(retryAnalyzer = RetryUtils.class)
	public void verifyAdminIsAbleToSearchTheUserAndChangeTheStatuOfSearchResultUser() {

		gp = new GLoginPage(driver);
		ap = new AdminPage(driver);
		user = new ManageUserPage(driver);
		gp.enterUserName(Constant.LOGINUSERNAME);
		gp.eneterPassWord(Constant.LOGINPASSWORD);
		gp.clickSignInButton();
		user.clickOnManageusersBtn();
		user.clickOnSearchBtn();
		user.enteUserName(Constant.USERNAMEFORMANAGEUSERPAGE);
		user.clickOnSearchBtn1();
		user.getSelectedItemFromSearchBtn1();
		String actualResult = user.getSelectedItemFromSearchBtn1();
		String expectedResult = Constant.USERNAMEFORMANAGEUSERPAGE;
		Assert.assertEquals(actualResult, expectedResult, Constant.COMMONERRORMESSAGE);

	}

	@Test(groups = { "Sanity" })
	public void verifyAdminisAbleToSelectTheStatusFromTheStatusDropDown() {

		gp = new GLoginPage(driver);
		ap = new AdminPage(driver);
		user = new ManageUserPage(driver);
		gp.enterUserName(Constant.LOGINUSERNAME);
		gp.eneterPassWord(Constant.LOGINPASSWORD);
		gp.clickSignInButton();
		user.clickOnManageusersBtn();
		user.clickOnSearchBtn();
		String actualResult = user.isDropDownSelected();
		String expectedResult = Constant.EXPECTEDVALUEINDROPDOWNSTATUS;
		Assert.assertEquals(actualResult, expectedResult, Constant.DROPDOWNERRORMESSAGE);

	}

	@Test(groups = { "Regression" })
	public void verifyAdminIsAbleToSearchTheUserByPhoneNumber() {

		gp = new GLoginPage(driver);
		ap = new AdminPage(driver);
		user = new ManageUserPage(driver);
		gp.enterUserName(Constant.LOGINUSERNAME);
		gp.eneterPassWord(Constant.LOGINPASSWORD);
		gp.clickSignInButton();
		user.clickOnManageusersBtn();
		user.clickOnSearchBtn();
		user.enterPhoneNumber(Constant.PHONENUMBERFORMANAGEUSERPAGE);
		user.clickOnSearchBtn1();
		user.getSelectedItemFromSearchBtn1();
		String actualResult = user.getSelectedItemFromSearchBtn1();
		String expectedResult = Constant.EXPECTEDUSERNAMEFORMANAGEUSERPAGE;
		Assert.assertEquals(actualResult, expectedResult, Constant.COMMONERRORMESSAGE);

	}
}
