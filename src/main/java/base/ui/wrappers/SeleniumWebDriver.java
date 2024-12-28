package base.ui.wrappers;

import base.ui.WebDriver;
import base.ui.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;

public final class SeleniumWebDriver implements WebDriver {
	private final org.openqa.selenium.WebDriver driver;

	public SeleniumWebDriver() {
		driver = init();
	}

	@Override
	public void quit() {
		driver.quit();
	}

	@Override
	public void refresh() {
		driver.navigate().refresh();
	}

	@Override
	public void openUrl(String url) {
		driver.get(url);
	}

	@Override
	public void switchToWindow(String window) {
		driver.switchTo().window(window);
	}

	@Override
	public void executeJavaScript(String script, Object... args) {
		var executor = (JavascriptExecutor) driver;

		if (args == null || args.length == 0) {
			executor.executeScript(script);
			return;
		}

		executor.executeScript(script, prepareArgs(args));
	}

	@Override
	public void clear(WebElement webElement) {
		executeJavaScript("arguments[0].value = '';", webElement);
	}

	@Override
	public void hover(WebElement webElement) {
		var baseElement = ((SeleniumWebElement) webElement).getBaseElement();

		new Actions(driver)
			.moveToElement(baseElement)
			.perform();
	}

	@Override
	public void contextMenu(WebElement webElement) {
		var baseElement = ((SeleniumWebElement) webElement).getBaseElement();

		new Actions(driver)
			.contextClick(baseElement)
			.perform();
	}

	@Override
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	@Override
	public String getCurrentWindow() {
		return driver.getWindowHandle();
	}

	@Override
	public WebElement getRootElement() {
		return new SeleniumWebElement(
			driver.findElement(By.xpath("//*"))
		);
	}

	@Override
	public Set<String> getWindows() {
		return driver.getWindowHandles();
	}

	private org.openqa.selenium.WebDriver init() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		var options = new ChromeOptions();
		options.addArguments("--start-maximized");

		return new ChromeDriver(options);
	}

	private Object[] prepareArgs(Object... args) {
		var result = new Object[args.length];

		for (int i = 0; i < args.length; i++) {
			if (args[i] instanceof SeleniumWebElement) {
				result[i] = ((SeleniumWebElement) args[i]).getBaseElement();
				continue;
			}

			result[i] = args[i];
		}

		return result;
	}
}
