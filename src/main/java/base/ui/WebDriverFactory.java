package base.ui;

import base.ui.wrappers.SeleniumWebDriver;

public abstract class WebDriverFactory {

	public static WebDriver create() {
		return new SeleniumWebDriver();
	}

}
