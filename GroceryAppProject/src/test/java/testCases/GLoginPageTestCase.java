package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import constant.Constant;
import elementRepository.GLoginPage;
import utilities.DataProviderUtility;
import utilities.RetryUtils;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;

public class GLoginPageTestCase extends BaseClass {// inheritance

	GLoginPage gp;

	@Test(dataProvider = "dataProvider", dataProviderClass = DataProviderUtility.class, groups = "critical")
	public void verifyLoginwithInvalidCredentialss(String user, String pass) throws IOException {

		gp = new GLoginPage(driver);
		gp.enterUserName(user);
		gp.eneterPassWord(pass);
		gp.clickSignInButton();
		boolean actualResult = gp.getErrorMessage(Constant.EXPECTEDINVALIDLOGINALERT);
		Assert.assertTrue(actualResult, Constant.COMMONERRORMESSAGE);

	}

	@Test(retryAnalyzer = RetryUtils.class,groups = "critical")
	public void verifyLoginwithInvalidCredentials() throws IOException {

		gp = new GLoginPage(driver);
		gp.enterUserName(Constant.INVALIDUSERNAME);
		gp.eneterPassWord(Constant.LOGINPASSWORD);
		gp.clickSignInButton();
		boolean actualResult = gp.getErrorMessage(Constant.EXPECTEDINVALIDLOGINALERT);
		Assert.assertTrue(actualResult, Constant.COMMONERRORMESSAGE);
	}

	@Test
	public void verifyThetextOfSignInButton() {

		gp = new GLoginPage(driver);
		String actualResult = gp.getTextOfSignInButton();
		String expectedResult = Constant.EXPECTEDTEXTOFSIGNINBUTTON;
		Assert.assertEquals(actualResult, expectedResult, Constant.COMMONERRORMESSAGE);
	}

	@Test
	public void VerifyBackgroundColourOfSignInButton() {

		gp = new GLoginPage(driver);
		String actualresult = gp.SignInButtonColour();
		String expectedresult = Constant.EXPECTEDBGCOLORSIGNINBTN;
		Assert.assertEquals(actualresult, expectedresult, Constant.COMMONERRORMESSAGE);
	}

	@Test
	public void VerifyingRememberMeCheckBoxIsUnselectedInSignIn() {
		gp = new GLoginPage(driver);
		boolean actualResult = gp.checkRememberMe();
		boolean expectedResult = false;
		Assert.assertEquals(actualResult, expectedResult, Constant.REMEMBERMECHECKBOXERRORMESSAGE);
	}

	@Test
	public void verifyingCurrentUrlOfTheSignInPage() {

		gp = new GLoginPage(driver);
		String ActualResult = driver.getCurrentUrl();
		String expectedResult = Constant.EXPECTEDURLOFSIGNINPAGE;
		Assert.assertEquals(ActualResult, expectedResult, Constant.COMMONERRORMESSAGEOFURL);
		String actualResult = gp.getTextOfSignInButton();
		String expectedResult2 = Constant.EXPECTEDTEXTOFSIGNINBUTTON;
		Assert.assertEquals(actualResult, expectedResult2, Constant.COMMONERRORMESSAGE);

	}

}
