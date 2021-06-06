package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import objects.Driver;
import objects.LogInPage;
import objects.Staff;
import objects.TopMeni;
import resource.TopMeniConstants;

public class TestStaff {

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
			} catch (Exception e) {}
	}
	
	@Test
	public void addEmployee() {
		
		TopMeni.topMeni(driver, TopMeniConstants.STAFF_ID);
		
		Staff.addEmployee(driver, "pera", "petrovic", "pera@address.com");
		
		try {
			Thread.sleep(4000);
			} catch (Exception e) {}
		
		Assert.assertTrue(Staff.checkEmployee(driver, "pera", "petrovic"));
		
		
		
		
	}
	
	
	
	
	@AfterMethod
	public void closeDriver() {
		
		driver.close();
		
	}
	
}
