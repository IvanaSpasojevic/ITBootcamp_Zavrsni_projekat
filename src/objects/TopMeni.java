package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TopMeni {

	public static String topMeni(WebDriver driver, String elementId) {

		driver.findElement(By.id(elementId)).click();

		try {
			Thread.sleep(5000);
		} catch (Exception e) {
		}

		String curenntUrl = driver.getCurrentUrl();

		return curenntUrl;
	}

}
