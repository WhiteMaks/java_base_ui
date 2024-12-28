package base.ui.wrappers;

import base.ui.Tag;
import base.ui.Type;
import base.ui.WebElement;
import base.ui.WebElementWaiter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.List;
import java.util.stream.Collectors;

public final class SeleniumWebElement implements WebElement {
	private final org.openqa.selenium.WebElement element;

	SeleniumWebElement(org.openqa.selenium.WebElement element) {
		this.element = element;
	}

	@Override
	public boolean isEnabled() {
		return element.isEnabled();
	}

	@Override
	public boolean isDisplayed() {
		return element.isDisplayed();
	}

	@Override
	public String getText() {
		return element.getText();
	}

	@Override
	public String getValue() {
		return getAttribute("value");
	}

	@Override
	public String visualHTMLElement() {
		return getAttribute("otherHTML");
	}

	@Override
	public String getAttribute(String attribute) {
		return element.getAttribute(attribute);
	}

	@Override
	public WebElement click() {
		element.click();
		return this;
	}

	@Override
	public WebElement clear() {
		element.clear();

		if (!getValue().isEmpty()) {
			pressCtrlA();
			pressBackSpace();
		}

		return this;
	}

	@Override
	public WebElement pressCtrlA() {
		sendKeys(Keys.CONTROL + "a");
		return this;
	}

	@Override
	public WebElement pressBackSpace() {
		sendKeys(Keys.BACK_SPACE);
		return this;
	}

	@Override
	public WebElement sendKeys(CharSequence... keys) {
		element.sendKeys(keys);
		return this;
	}

	@Override
	public WebElement findParentElement() {
		return findElementByXpath("./..");
	}

	@Override
	public WebElement findParentElement(int level) {
		if (level <= 0) {
			return this;
		}

		var result = findParentElement();

		for (int i = 1; i <= level; i++) {
			result = result.findParentElement();
		}

		return result;
	}

	@Override
	public WebElement findElementByText(String text) {
		return findElementByXpath(
			String.format(".//*[text() = '%s']", text)
		);
	}

	@Override
	public WebElement findElementByText(String text, int seconds) {
		return WebElementWaiter.waitForElementTextToBeVisible(() -> findElementByText(text), seconds);
	}

	@Override
	public WebElement findElementByTextContains(String text) {
		return findElementByXpath(
			String.format(".//*[contains(text(), '%s')]", text)
		);
	}

	@Override
	public WebElement findElementByTextContains(String text, int seconds) {
		return WebElementWaiter.waitForElementTextToBeVisible(() -> findElementByTextContains(text), seconds);
	}

	@Override
	public WebElement findElementByTitle(String title) {
		return findElementByXpath(
			String.format(".//*[@title = '%s']", title)
		);
	}

	@Override
	public WebElement findElementByTitle(String title, int seconds) {
		return WebElementWaiter.waitForElementTextToBeVisible(() -> findElementByTitle(title), seconds);
	}

	@Override
	public WebElement findElementByType(Type type) {
		return findElementByType(type.name().toLowerCase());
	}

	@Override
	public WebElement findElementByType(Type type, int seconds) {
		return WebElementWaiter.waitForElementTextToBeVisible(() -> findElementByType(type), seconds);
	}

	@Override
	public WebElement findElementByType(String type) {
		return findElementByXpath(
			String.format(".//*[@type = '%s']", type)
		);
	}

	@Override
	public WebElement findElementByType(String type, int seconds) {
		return WebElementWaiter.waitForElementTextToBeVisible(() -> findElementByType(type), seconds);
	}

	@Override
	public WebElement findElementByTag(Tag tag) {
		return findElementByTag(tag.name().toLowerCase());
	}

	@Override
	public WebElement findElementByTag(Tag tag, int seconds) {
		return WebElementWaiter.waitForElementTextToBeVisible(() -> findElementByTag(tag), seconds);
	}

	@Override
	public WebElement findElementByTag(String tag) {
		return new SeleniumWebElement(
			element.findElement(By.tagName(tag))
		);
	}

	@Override
	public WebElement findElementByTag(String tag, int seconds) {
		return WebElementWaiter.waitForElementTextToBeVisible(() -> findElementByTag(tag), seconds);
	}

	@Override
	public WebElement findElementById(String id) {
		return new SeleniumWebElement(
			element.findElement(By.id(id))
		);
	}

	@Override
	public WebElement findElementById(String id, int seconds) {
		return WebElementWaiter.waitForElementTextToBeVisible(() -> findElementById(id), seconds);
	}

	@Override
	public WebElement findElementByClassName(String className) {
		return new SeleniumWebElement(
			element.findElement(By.className(className))
		);
	}

	@Override
	public WebElement findElementByClassName(String className, int seconds) {
		return WebElementWaiter.waitForElementTextToBeVisible(() -> findElementByClassName(className), seconds);
	}

	@Override
	public WebElement findElementByClassNameContains(String className) {
		return findElementByXpath(
			String.format(".//*[contains(@class, '%s')]", className)
		);
	}

	@Override
	public WebElement findElementByClassNameContains(String className, int seconds) {
		return WebElementWaiter.waitForElementTextToBeVisible(() -> findElementByClassNameContains(className), seconds);
	}

	@Override
	public WebElement findElementByXpath(String xpath) {
		return new SeleniumWebElement(
			element.findElement(By.xpath(xpath))
		);
	}

	@Override
	public WebElement findElementByXpath(String xpath, int seconds) {
		return WebElementWaiter.waitForElementTextToBeVisible(() -> findElementByXpath(xpath), seconds);
	}

	@Override
	public WebElement findElementByCssSelector(String cssSelector) {
		return new SeleniumWebElement(
			element.findElement(By.cssSelector(cssSelector))
		);
	}

	@Override
	public WebElement findElementByCssSelector(String cssSelector, int seconds) {
		return WebElementWaiter.waitForElementTextToBeVisible(() -> findElementByCssSelector(cssSelector), seconds);
	}

	@Override
	public List<WebElement> findChildElements() {
		return findElementsByXpath("./*");
	}

	@Override
	public List<WebElement> findElementsByText(String text) {
		return findElementsByXpath(
			String.format(".//*[text() = '%s']", text)
		);
	}

	@Override
	public List<WebElement> findElementsByTextContains(String text) {
		return findElementsByXpath(
			String.format(".//*[contains(text(), '%s')]", text)
		);
	}

	@Override
	public List<WebElement> findElementsByType(Type type) {
		return findElementsByType(type.name().toLowerCase());
	}

	@Override
	public List<WebElement> findElementsByType(String type) {
		return findElementsByXpath(
			String.format(".//*[@type = '%s']", type)
		);
	}

	@Override
	public List<WebElement> findElementsByTag(Tag tag) {
		return findElementsByTag(tag.name().toLowerCase());
	}

	@Override
	public List<WebElement> findElementsByTag(String tag) {
		return convert(element.findElements(By.tagName(tag)));
	}

	@Override
	public List<WebElement> findElementsByClassName(String className) {
		return convert(element.findElements(By.className(className)));
	}

	@Override
	public List<WebElement> findElementsByClassNameContains(String className) {
		return findElementsByXpath(
			String.format(".//*[contains(@class, '%s')]", className)
		);
	}

	@Override
	public List<WebElement> findElementsByXpath(String xpath) {
		return convert(element.findElements(By.xpath(xpath)));
	}

	@Override
	public List<WebElement> findElementsByCssSelector(String cssSelector) {
		return convert(element.findElements(By.cssSelector(cssSelector)));
	}

	private List<WebElement> convert(List<org.openqa.selenium.WebElement> elements) {
		return elements.stream()
			.map(SeleniumWebElement::new)
			.collect(Collectors.toList());
	}

	org.openqa.selenium.WebElement getBaseElement() {
		return element;
	}
}
