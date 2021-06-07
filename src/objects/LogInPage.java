package objects;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import resource.LogInPageConstants;

public class LogInPage {

	public static void closePopups(WebDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, 15);

		WebElement cookies = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LogInPageConstants.OKCOOKIES_XPATH)));
		cookies.click();

		WebElement xButton = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LogInPageConstants.XBUTTON_XPATH)));
		xButton.click();

	}

	public static void aboutUs(WebDriver driver) {

		driver.findElement(By.xpath(LogInPageConstants.ABOUTUSLINK_XPATH)).click();

		driver.findElement(By.xpath(LogInPageConstants.ABOUTUS_XPATH)).click();

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(LogInPageConstants.SCREENSHOT_PATH));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static ArrayList<UserTest> getData(String fileName) {

		File f = new File(fileName);

		ArrayList<UserTest> users = new ArrayList<UserTest>();

		try {
			InputStream is = new FileInputStream(f);

			XSSFWorkbook wb = new XSSFWorkbook(is);

			Sheet sheet = wb.getSheetAt(0);

			for (int i = 0; i < sheet.getLastRowNum(); i++) {

				Row row = sheet.getRow(i);

				Cell cell0 = row.getCell(0);
				Cell cell1 = row.getCell(1);
				Cell cell2 = row.getCell(2);

				UserTest user = new UserTest();

				if (cell0 == null || cell0.toString() == "") {
					break;
				}

				user.setUsername(cell0.toString());
				user.setPassword(cell1.toString());
				user.setExpected(cell2.toString());

				users.add(user);
			}

			wb.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return users;

	}

	public static void enterUser(WebDriver driver, String username, String password) {

		driver.findElement(By.xpath(LogInPageConstants.LOGINLINK_XPATH)).click();

		driver.findElement(By.id(LogInPageConstants.EMAIL_ID)).sendKeys(username);

		driver.findElement(By.id(LogInPageConstants.PASSWORD_ID)).sendKeys(password);

		driver.findElement(By.xpath(LogInPageConstants.LOGINBUTTON_XPATH)).click();

	}

}
