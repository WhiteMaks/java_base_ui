package base.ui;

public abstract class BaseWebElement {
	protected final WebDriver driver;
	protected final WebElement element;

	protected BaseWebElement(WebDriver driver) {
		this(driver, driver.getRootElement());
	}

	protected BaseWebElement(WebDriver driver, WebElement element) {
		this.driver = driver;
		this.element = element;
	}

	public WebElement findButtonByName(String name) {
		try {
			return findSpecificElementByName(Tag.BUTTON, name);
		} catch (Exception ignore) {}

		try {
			return findSpecificElementByName(Tag.INPUT, name);
		} catch (Exception ignore) {}

		return findSpecificElementByName(Tag.A, name);
	}

	public WebElement findButtonByName(String name, int seconds) {
		return WebElementWaiter.waitForElementTextToBeVisible(() -> findButtonByName(name), seconds);
	}

	public WebElement findInputByPlaceholder(String placeholder) {
		try {
			return findSpecificElementByName(Tag.INPUT, placeholder);
		} catch (Exception ignore) {}

		return findSpecificElementByName(Tag.TEXTAREA, placeholder);
	}

	public WebElement findInputByPlaceholder(String placeholder, int seconds) {
		return WebElementWaiter.waitForElementTextToBeVisible(() -> findInputByPlaceholder(placeholder), seconds);
	}

	private WebElement findSpecificElementByName(Tag tag, String name) {
		return findSpecificElementByName(tag.name().toLowerCase(), name);
	}

	private WebElement findSpecificElementByName(String tag, String name) {
		try {
			return element.findElementByXpath(String.format(".//%s[contains(text(), '%s')]", tag, name));
		} catch (Exception ignore) {}

		try {
			return element.findElementByXpath(String.format(".//%s[contains(@value, '%s')]", tag, name));
		} catch (Exception ignore) {}

		return element.findElementByXpath(String.format(".//%s[contains(., '%s')]", tag, name));
	}

	private WebElement findSpecificElementByPlaceholder(Tag tag, String placeholder) {
		return findSpecificElementByPlaceholder(tag.name().toLowerCase(), placeholder);
	}

	private WebElement findSpecificElementByPlaceholder(String tag, String placeholder) {
		return element.findElementByXpath(String.format(".//%s[@placeholder = '%s')]", tag, placeholder));
	}

	public WebElement getElement() {
		return element;
	}

	public WebDriver getDriver() {
		return driver;
	}

}
