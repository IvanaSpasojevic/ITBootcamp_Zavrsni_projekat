package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import objects.Driver;
import objects.LogInPage;
import objects.Settings;

public class TestSettings {

	WebDriver driver;

	@BeforeClass
	public void createDriver() {

	}

	@BeforeMethod
	public void closePopup() {
		driver = Driver.createDrivver();
		LogInPage.closePopups(driver);
		LogInPage.enterUser(driver, "subotic88@gmail.com", "ivana88");
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
		}
	}

	@Test
	public void language() {

		Assert.assertTrue(Settings.changeLanguage(driver));

	}

	@Test
	public void chackNotificationStatus() {

		Settings.notificationDisable(driver);

		Assert.assertTrue(Settings.checkNotificationStatus(driver));

		Settings.notificationDisable(driver);

	}

	@AfterMethod
	public void closeDriver() {

		driver.close();

	}

}
