package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import resource.SettingsConstants;

public class Settings {

	public static boolean changeLanguage(WebDriver driver) {

		driver.findElement(By.id(SettingsConstants.SETTINGS_ID)).click();

		try {
			Thread.sleep(4000);
		} catch (Exception e) {
		}

		driver.findElement(By.xpath(SettingsConstants.LANGUAGE_XPATH)).click();

		driver.findElement(By.xpath(SettingsConstants.CROATIAN_XPATH)).click();

		driver.findElement(By.id(SettingsConstants.SAVE_ID)).click();

		driver.navigate().refresh();

		try {
			Thread.sleep(4000);
		} catch (Exception e) {
		}

		String text = driver.findElement(By.xpath(SettingsConstants.EXPECTEDLANGUAG_XPATH)).getText();

		System.out.println(text);

		return text.equals("Sat");

	}

	public static void notificationDisable(WebDriver driver) {

		driver.findElement(By.id(SettingsConstants.SETTINGS_ID)).click();

		try {
			Thread.sleep(4000);
		} catch (Exception e) {
		}

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)");

		driver.findElement(By.xpath(SettingsConstants.CHECKBOX1_XPATH)).click();

		driver.findElement(By.xpath(SettingsConstants.CHECKBOX2_XPATH)).click();

		driver.findElement(By.xpath(SettingsConstants.CHECKBOX3_XPATH)).click();

		driver.findElement(By.id(SettingsConstants.SAVE_ID)).click();
	}

	public static boolean checkNotificationStatus(WebDriver driver) {

		driver.navigate().refresh();

		try {
			Thread.sleep(4000);
		} catch (Exception e) {
		}

		boolean cb1 = driver.findElement(By.xpath(SettingsConstants.CHECKBOX1_XPATH)).isSelected();

		boolean cb2 = driver.findElement(By.xpath(SettingsConstants.CHECKBOX2_XPATH)).isSelected();

		boolean cb3 = driver.findElement(By.xpath(SettingsConstants.CHECKBOX3_XPATH)).isSelected();

		return !cb1 && !cb2 && !cb3;

	}

}
