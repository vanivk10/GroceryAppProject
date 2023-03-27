package testCases;

import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import constant.Constant;
import elementRepository.AdminPage;
import elementRepository.AdminUsersPage;
import elementRepository.GLoginPage;
import utilities.RetryUtils;

public class adminUsersPageTestCase extends BaseClass {
	AdminPage ap;
	GLoginPage gp;
	AdminUsersPage user;

	@Test(retryAnalyzer = RetryUtils.class,groups = "critical")
	public void verifyTheAdminIsAbleToCreateANewUserTypeStaff() {

		ap = new AdminPage(driver);
		gp = new GLoginPage(driver);
		user = new AdminUsersPage(driver);
		gp.enterUserName(Constant.LOGINUSERNAME);
		gp.eneterPassWord(Constant.LOGINPASSWORD);
		gp.clickSignInButton();
		ap.clickOnAdminUser();
		user.clickOnNewButton();
		user.enterUserName(faker.name().username());
		user.enterPassword(faker.internet().password());
		user.selectUserTypeFromDropDown();
		user.clickSaveButton();
		boolean actualResult = user.getErrorMessage(Constant.EXPECTEDALERTINADMINUSERSPAGE);
		Assert.assertTrue(actualResult, Constant.COMMONERRORMESSAGE);

	}

	@Test
	public void verifyTheAdminIsAbleToSelectTheValuesFromTheDropdownUserType() {

		ap = new AdminPage(driver);
		gp = new GLoginPage(driver);
		user = new AdminUsersPage(driver);
		gp.enterUserName(Constant.LOGINUSERNAME);
		gp.eneterPassWord(Constant.LOGINPASSWORD);
		gp.clickSignInButton();
		ap.clickOnAdminUser();
		user.clickOnNewButton();
		user.selectUserTypeFromDropDown();
		String actualResult = user.selectUserTypeFromDropDown();
		String expectedResult = Constant.SELECTEDUSERTYPE;
		Assert.assertEquals(actualResult, expectedResult, Constant.COMMONERRORMESSAGE);
	}

}