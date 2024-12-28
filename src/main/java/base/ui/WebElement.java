package base.ui;

import java.util.List;

public interface WebElement {

	boolean isEnabled();
	boolean isDisplayed();

	String getText();
	String getValue();

	String visualHTMLElement();

	String getAttribute(String attribute);

	WebElement click();
	WebElement clear();

	WebElement pressCtrlA();
	WebElement pressBackSpace();

	WebElement sendKeys(CharSequence... keys);

	WebElement findParentElement();
	WebElement findParentElement(int level);

	WebElement findElementByText(String text);
	WebElement findElementByText(String text, int seconds);
	WebElement findElementByTextContains(String text);
	WebElement findElementByTextContains(String text, int seconds);

	WebElement findElementByTitle(String title);
	WebElement findElementByTitle(String title, int seconds);

	WebElement findElementByType(Type type);
	WebElement findElementByType(Type type, int seconds);
	WebElement findElementByType(String type);
	WebElement findElementByType(String type, int seconds);

	WebElement findElementByTag(Tag tag);
	WebElement findElementByTag(Tag tag, int seconds);
	WebElement findElementByTag(String tag);
	WebElement findElementByTag(String tag, int seconds);

	WebElement findElementById(String id);
	WebElement findElementById(String id, int seconds);

	WebElement findElementByClassName(String className);
	WebElement findElementByClassName(String className, int seconds);
	WebElement findElementByClassNameContains(String className);
	WebElement findElementByClassNameContains(String className, int seconds);

	WebElement findElementByXpath(String xpath);
	WebElement findElementByXpath(String xpath, int seconds);

	WebElement findElementByCssSelector(String cssSelector);
	WebElement findElementByCssSelector(String cssSelector, int seconds);

	List<WebElement> findChildElements();

	List<WebElement> findElementsByText(String text);
	List<WebElement> findElementsByTextContains(String text);

	List<WebElement> findElementsByType(Type type);
	List<WebElement> findElementsByType(String type);

	List<WebElement> findElementsByTag(Tag tag);
	List<WebElement> findElementsByTag(String tag);

	List<WebElement> findElementsByClassName(String className);
	List<WebElement> findElementsByClassNameContains(String className);

	List<WebElement> findElementsByXpath(String xpath);

	List<WebElement> findElementsByCssSelector(String cssSelector);

}
