package test;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import objects.Driver;
import objects.Helper;
import objects.LogInPage;
import objects.UserTest;
import resource.DriverConstants;
import resource.LogInPageConstants;

public class TestLogInPage {

	WebDriver driver;

	@BeforeClass
	public void createDriver() {

	}

	@BeforeMethod
	public void closePopup() {
		driver = Driver.createDrivver();
		LogInPage.closePopups(driver);

	}

	@Test(priority = 1)
	public void goToLogInPage() {

		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = DriverConstants.HUMANITY_URL;

		Assert.assertEquals(currentUrl, expectedUrl);

	}

	@Test(priority = 2)
	public void aboutUs() {

		LogInPage.aboutUs(driver);

		String currentUrl = driver.getCurrentUrl();

		SoftAssert sa = new SoftAssert();

		sa.assertEquals(currentUrl, LogInPageConstants.ABOUTUS_URL);

		sa.assertTrue(Helper.chechFileExist(LogInPageConstants.SCREENSHOT_PATH));

		sa.assertAll();

	}

	@Test(priority = 3)
	public void logIn() {

		ArrayList<UserTest> users = LogInPage.getData(LogInPageConstants.LOGIN_DATA);

		for (int i = 0; i < users.size(); i++) {

			LogInPage.enterUser(driver, users.get(i).getUsername(), users.get(i).getPassword());

			try {
				Thread.sleep(5000);
			} catch (Exception e) {
			}

			String cuurentUrl = driver.getCurrentUrl();

			Assert.assertEquals(cuurentUrl, users.get(i).getExpected());

		}

	}

	@AfterMethod
	public void closeDriver() {

		driver.close();

	}

}
