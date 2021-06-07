package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import objects.Driver;
import objects.Helper;
import objects.LogInPage;
import objects.TopMeni;
import resource.TopMeniConstants;

public class TestTopMeni {

	WebDriver driver;

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

	@Test(priority = 1)
	public void dashboard() {
		Assert.assertEquals(TopMeni.topMeni(driver, TopMeniConstants.DASHBOARD_ID), TopMeniConstants.DASHBOARD_URL);

	}

	@Test(priority = 2)
	public void shiftplanning() {
		Assert.assertEquals(TopMeni.topMeni(driver, TopMeniConstants.SHIFTPLANNING_ID),
				TopMeniConstants.SHIFTPLANNING_URL + Helper.getDateShiftPlanning() + "/");
	}

	@Test(priority = 3)
	public void timeClock() {
		Assert.assertEquals(TopMeni.topMeni(driver, TopMeniConstants.TIMECLOCK_ID), TopMeniConstants.TIMECLOCK_URL);
	}

	@Test(priority = 4)
	public void leaveVacation() {
		Assert.assertEquals(TopMeni.topMeni(driver, TopMeniConstants.REQUESTS_ID), TopMeniConstants.REQUESTS_URL);
	}

	@Test(priority = 5)
	public void training() {
		Assert.assertEquals(TopMeni.topMeni(driver, TopMeniConstants.TRAINING_ID), TopMeniConstants.TRAINING_URL);
	}

	@Test(priority = 6)
	public void staff() {
		Assert.assertEquals(TopMeni.topMeni(driver, TopMeniConstants.STAFF_ID), TopMeniConstants.STAFF_URL);
	}

	@Test(priority = 7)
	public void aviability() {
		Assert.assertEquals(TopMeni.topMeni(driver, TopMeniConstants.AVAILABILITY_ID),
				TopMeniConstants.AVAILABILITY_URL + Helper.getDateAvailability() + "/1");
	}

	@Test(priority = 8)
	public void payroll() {
		Assert.assertEquals(TopMeni.topMeni(driver, TopMeniConstants.PAYROLL_ID), TopMeniConstants.PAYROLL_URL);
	}

	@Test(priority = 9)
	public void reports() {
		Assert.assertEquals(TopMeni.topMeni(driver, TopMeniConstants.REPORTS_ID), TopMeniConstants.REPORTS_URL);
	}

	@AfterMethod
	public void closeDriver() {

		driver.close();

	}

}
