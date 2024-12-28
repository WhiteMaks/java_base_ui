package base.ui;

import java.util.HashMap;
import java.util.Map;

public abstract class WebDriverManager {
	private final static Map<String, WebDriver> drivers = new HashMap<>();

	public static WebDriver getWebDriver() {
		var threadName = Thread.currentThread().getName();

		var driver = drivers.get(threadName);
		if (driver != null) {
			return driver;
		}

		driver = WebDriverFactory.create();

		drivers.put(threadName, driver);

		return driver;
	}

	public static void eliminateWebDriver() {
		var threadName = Thread.currentThread().getName();

		var driver = drivers.get(threadName);
		if (driver != null) {
			driver.quit();
			drivers.remove(threadName);
		}
	}
}
