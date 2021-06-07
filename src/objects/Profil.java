package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import resource.ProfilConstants;

public class Profil {

	public static boolean profilSettings1(WebDriver driver, String lastName) {

		driver.findElement(By.xpath(ProfilConstants.USERMENI_XPATH)).click();

		driver.findElement(By.xpath(ProfilConstants.SETTINGS_XPATH)).click();

		try {
			Thread.sleep(4000);
		} catch (Exception e) {
		}

		driver.findElement(By.id(ProfilConstants.LASTNAME_ID)).clear();

		driver.findElement(By.id(ProfilConstants.LASTNAME_ID)).sendKeys(lastName);

		driver.findElement(By.xpath(ProfilConstants.SAVE_XPATH)).click();

		driver.navigate().refresh();

		try {
			Thread.sleep(4000);
		} catch (Exception e) {
		}

		String newLastName = driver.findElement(By.xpath(ProfilConstants.NEWLASTNAME_XPATH)).getText();

		return newLastName.equals("ivana spasojevic");

	}

	public static boolean profilSettings2(WebDriver driver, String job) {

		driver.findElement(By.xpath(ProfilConstants.USERMENI_XPATH)).click();

		driver.findElement(By.xpath(ProfilConstants.SETTINGS_XPATH)).click();

		try {
			Thread.sleep(4000);
		} catch (Exception e) {
		}

		driver.findElement(By.id(ProfilConstants.JOBTITLE_ID)).clear();

		driver.findElement(By.id(ProfilConstants.JOBTITLE_ID)).sendKeys(job);

		driver.findElement(By.xpath(ProfilConstants.SAVE_XPATH)).click();

		driver.navigate().refresh();

		try {
			Thread.sleep(4000);
		} catch (Exception e) {
		}

		String jobTitle = driver.findElement(By.id(ProfilConstants.JOBTITLE_ID)).getAttribute("value");

		System.out.println(jobTitle);

		return jobTitle.equals(job);

	}

}
