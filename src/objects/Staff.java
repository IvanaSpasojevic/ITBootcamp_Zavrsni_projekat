package objects;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import resource.StaffConstants;

public class Staff {

	public static void addEmployee(WebDriver driver, String firstName, String lastName, String email) {

		fillEmployeeData(driver, firstName, lastName, email, 1);

		driver.findElement(By.id(StaffConstants.SAVEBUTTON_ID)).click();

	}

	private static void fillEmployeeData(WebDriver driver, String firstName, String lastName, String email, int index) {

		driver.findElement(By.id(StaffConstants.ADDBUTTON_ID)).click();
		
		try {
			Thread.sleep(4000);
			} catch (Exception e) {}
		
		driver.findElement(By.id(StaffConstants.FIRSTNAME_ID + index)).sendKeys(firstName);

		driver.findElement(By.id(StaffConstants.LASTNAME_ID + index)).sendKeys(lastName);

		driver.findElement(By.id(StaffConstants.EMAIL_ID + index)).sendKeys(email);

	}

	public static void addEmployees(WebDriver driver) {

		File f = new File(StaffConstants.EXCEL_PATH);

		try {
			InputStream is = new FileInputStream(f);

			XSSFWorkbook wb = new XSSFWorkbook(is);

			Sheet sheet = wb.getSheetAt(0);

			for (int i = 0; i < sheet.getLastRowNum(); i++) {

				Row row = sheet.getRow(i);

				Cell cell0 = row.getCell(0);
				Cell cell1 = row.getCell(1);
				Cell cell2 = row.getCell(2);

				if (cell0 == null || cell0.toString() == "") {
					break;
				}

				String firstName = cell0.toString();
				String lastName = cell1.toString();
				String email = cell2.toString();

				fillEmployeeData(driver, firstName, lastName, email, i + 1);

			}

			driver.findElement(By.id(StaffConstants.SAVEBUTTON_ID)).click();

			wb.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static boolean checkAllEmployees(WebDriver driver) {

		File f = new File(StaffConstants.EXCEL_PATH);

		try {
			InputStream is = new FileInputStream(f);

			XSSFWorkbook wb = new XSSFWorkbook(is);

			Sheet sheet = wb.getSheetAt(0);

			for (int i = 0; i < sheet.getLastRowNum(); i++) {

				Row row = sheet.getRow(i);

				Cell cell0 = row.getCell(0);
				Cell cell1 = row.getCell(1);

				if (cell0 == null || cell0.toString() == "") {
					break;
				}

				String firstName = cell0.toString();
				String lastName = cell1.toString();

				boolean result = driver.findElement(By.xpath(StaffConstants.RESULTTABLE_XPATH))
						.getAttribute("innerHTML").contains(firstName + " " + lastName);

				if (!result) {
					wb.close();
					return result;
				}

			}

			wb.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	public static boolean checkEmployee(WebDriver driver, String firstName, String lastName) {
		
		boolean result = driver.findElement(By.xpath(StaffConstants.RESULTTABLE_XPATH))
				.getAttribute("innerHTML").contains(firstName + " " + lastName);

		return result;
		
		
		
	}
	
	
	
}
