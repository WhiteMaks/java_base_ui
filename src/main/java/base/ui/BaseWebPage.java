package base.ui;

public class BaseWebPage extends BaseWebElement {

	protected BaseWebPage(WebDriver driver) {
		super(driver);
	}

	public void refreshPage() {
		driver.refresh();
	}
}
