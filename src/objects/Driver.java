package objects;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import resource.DriverConstants;

public class Driver {

	public static WebDriver createDrivver() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\spaso\\Desktop\\chromedriver\\chromedriver.exe");

		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		WebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.get(DriverConstants.HUMANITY_URL);
		return driver;
	}

}
