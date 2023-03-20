package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.AdminPage;
import elementRepository.GLoginPage;
import elementRepository.ManageOrdersPage;
import elementRepository.ManageUserPage;

public class ManageOrdersPageTestCase extends BaseClass {
	GLoginPage gp;
	AdminPage ap;
	ManageOrdersPage orders;

	@Test(groups = { "critical" })
	public void verifyAdminIsAbleToSearchTheOrderByOrderIdInListOrderPage() {

		gp = new GLoginPage(driver);
		ap = new AdminPage(driver);
		orders = new ManageOrdersPage(driver);
		gp.enterUserName(Constant.LOGINUSERNAME);
		gp.eneterPassWord(Constant.LOGINPASSWORD);
		gp.clickSignInButton();
		ap.clickOnmanageOrders();
		orders.clickOnSerachBtn();
		orders.enterOrderId(Constant.ORDERID);
		orders.clickOnSerachBtn1();
		String actualResult = orders.getSelectedItemFromSearchBtn1();
		String expectedResult = Constant.ORDERID;
		Assert.assertEquals(actualResult, expectedResult, Constant.COMMONERRORMESSAGE);
	}

	@Test
	public void verifyAdminIsAbleToSelectCODFromTheDropDownPayementMode() {
		gp = new GLoginPage(driver);
		ap = new AdminPage(driver);
		orders = new ManageOrdersPage(driver);
		gp.enterUserName(Constant.LOGINUSERNAME);
		gp.eneterPassWord(Constant.LOGINPASSWORD);
		gp.clickSignInButton();
		ap.clickOnmanageOrders();
		orders.clickOnSerachBtn();
		String actualResult = orders.getSelectedValueFromTheDropdownPaymentMode();
		String expectedResult = Constant.EXPECTEDSELECTEDVALUEFROMTHEDROPDOWNPAYMNETMODE;
		Assert.assertEquals(actualResult, expectedResult, Constant.COMMONERRORMESSAGE);
	}
}
