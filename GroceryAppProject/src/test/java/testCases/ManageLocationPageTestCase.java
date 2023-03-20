package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.AdminPage;
import elementRepository.GLoginPage;
import elementRepository.ManageLocationPage;

public class ManageLocationPageTestCase extends BaseClass {
	GLoginPage gp;
	AdminPage ap;
	ManageLocationPage location;

	@Test
	public void verifyAdminIsAbleToSelectTheValuesFromTheDropDownState() {

		gp = new GLoginPage(driver);
		ap = new AdminPage(driver);
		location = new ManageLocationPage(driver);
		gp.enterUserName(Constant.LOGINUSERNAME);
		gp.eneterPassWord(Constant.LOGINPASSWORD);
		gp.clickSignInButton();
		ap.clickOnManageLocationBtn();
		location.clickOnNewButton();
		String actualresult = location.getValuesFromTheDropDownSate();
		String expectedResult = Constant.EXPECTEDRESULTSELECTEDSTATEINADDLOCATIONPAGE;
		Assert.assertEquals(actualresult, expectedResult, Constant.COMMONERRORMESSAGE);

	}

	@Test
	public void verifyBackGroundColorOfSearchButton() {

		gp = new GLoginPage(driver);
		ap = new AdminPage(driver);
		location = new ManageLocationPage(driver);
		gp.enterUserName(Constant.LOGINUSERNAME);
		gp.eneterPassWord(Constant.LOGINPASSWORD);
		gp.clickSignInButton();
		ap.clickOnManageLocationBtn();
		String actualResult = location.backGroundColourOfSearchButton();
		String expectedResult = Constant.EXPECTEDBACKGROUNDCOLOUROFSEARCHBUTTONINLISTLOCATION;
		Assert.assertEquals(actualResult, expectedResult, Constant.COMMONERRORMESSAGE);
	}

}
