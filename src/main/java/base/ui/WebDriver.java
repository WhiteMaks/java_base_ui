package base.ui;

import java.util.Set;

public interface WebDriver {

	void quit();
	void refresh();

	void openUrl(String url);
	void switchToWindow(String window);

	void executeJavaScript(String script, Object... args);

	void clear(WebElement webElement);
	void hover(WebElement webElement);
	void contextMenu(WebElement	webElement);

	String getCurrentUrl();
	String getCurrentWindow();

	WebElement getRootElement();

	Set<String> getWindows();

}
