package testCases;

import static org.testng.Assert.assertEquals;

import java.io.File;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegisterPage;
import testBase.BaseTest;

public class Dummy extends BaseTest {

	@Test(dataProvider = "getaccountdata")
	public void login() throws InterruptedException {
		logger.info("Starting TestLogin");
		HomePage home = new HomePage(driver);
		RegisterPage reg = new RegisterPage(driver);

		home.clickAccountLink();
		home.clickRegisterLink();
		reg.enterFirstName(randomString());
		reg.enterLastName(randomString());
		reg.enterEmailName(randomString() + "@gmail.com");
		reg.enterPhone(randomNumber());
		String password = randomAlphaNumber();
		reg.enterPassword(password);
		reg.enterConfirmPassword(password);

		reg.clickPrivacy();
		reg.clickContinue();
		String Actual = reg.getConfirmation();
		System.out.println(Actual);
		// String Expected = "Your Account Has Been Created!";
		assertEquals(Actual, "Your Account Has Been Created!");

	}

	@DataProvider
	public Object[][] getaccountdata() {
		return getTestData(new File("testcases.json"), "TestCase_010");
	}
}
