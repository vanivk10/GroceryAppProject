package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.AdminPage;
import elementRepository.GLoginPage;

public class AdminPageTestCase extends BaseClass {

	GLoginPage gp;
	AdminPage ap;

	@Test(groups = { "critical" })
	public void verifyingWorkingOfLogOutButtonInAdminPage() {
		gp = new GLoginPage(driver);
		ap = new AdminPage(driver);
		gp.enterUserName(prop.getProperty("username"));
		gp.eneterPassWord(prop.getProperty("password"));
		gp.clickSignInButton();
		ap.clickOnAdmin();
		String actualResult = ap.clickOnLogout();
		String expectedResult = Constant.EXPECTEDURLOFADMINPAGE;
		Assert.assertEquals(actualResult, expectedResult, Constant.COMMONERRORMESSAGE);

	}

	@Test(groups = { "Smoke" })
	public void verifyingPageTiTleOfAdminHomePage() {

		gp = new GLoginPage(driver);
		ap = new AdminPage(driver);
		gp.enterUserName(Constant.LOGINUSERNAME);
		gp.eneterPassWord(Constant.LOGINPASSWORD);
		gp.clickSignInButton();
		String actualResult = ap.pageTitle();
		String expectedResult = Constant.ADMINHOMEPAGETITLE;
		Assert.assertEquals(actualResult, expectedResult, Constant.COMMONEPAGETITLERRORMESSAGE);

	}

	@Test(groups = { "Sanity" })
	public void verifyingAdminCanAccessableManageOrdersPage() {

		gp = new GLoginPage(driver);
		ap = new AdminPage(driver);
		gp.enterUserName(Constant.LOGINUSERNAME);
		gp.eneterPassWord(Constant.LOGINPASSWORD);
		gp.clickSignInButton();
		ap.clickOnmanageOrders();
		String actualResult = ap.pageTitle();
		String expectedResult = Constant.LISTORDERPAGETITLE;
		Assert.assertEquals(actualResult, expectedResult, Constant.COMMONEPAGETITLERRORMESSAGE);

	}

	@Test(groups = { "Sanity" })
	public void verifyAdminIsAbleToAccessManageLocationPage() {
		gp = new GLoginPage(driver);
		ap = new AdminPage(driver);
		gp.enterUserName(Constant.LOGINUSERNAME);
		gp.eneterPassWord(Constant.LOGINPASSWORD);
		gp.clickSignInButton();
		ap.clickOnManageLocationBtn();
		String actualResutl = ap.pageTitle();
		String expectedResult = Constant.PAGETITLEOFMANAGELOCATIONPAGE;
		Assert.assertEquals(actualResutl, expectedResult, Constant.COMMONEPAGETITLERRORMESSAGE);
	}

}
