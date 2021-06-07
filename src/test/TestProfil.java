package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import objects.Driver;
import objects.LogInPage;
import objects.Profil;

public class TestProfil {

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
	public void profilSettings1() {

		Assert.assertTrue(Profil.profilSettings1(driver, "spasojevic"));

	}

	@Test
	public void profilSettings2() {

		Assert.assertTrue(Profil.profilSettings2(driver, "QA"));

	}

	@AfterMethod
	public void closeDriver() {

		driver.close();

	}

}
