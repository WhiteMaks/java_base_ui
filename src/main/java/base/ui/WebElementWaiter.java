package base.ui;

public final class WebElementWaiter {
	private final static int pollingInterval = 150;

	public static void waitForElementTextToBeContains(WebElement element, String text, int seconds) {
		var totalTime = 0;

		while (totalTime < seconds * 1_000) {
			if (element.getText().contains(text)) {
				return;
			}

			sleep(pollingInterval);

			totalTime += pollingInterval;
		}

		throw new RuntimeException("Превышено время ожидания изменений текста у элемента");
	}

	public static WebElement waitForElementTextToBeVisible(Waitable waitable, int seconds) {
		var totalTime = 0;

		while (totalTime < seconds * 1_000) {
			try {
				var element = waitable.waitFor();
				if (element.isDisplayed()) {
					return element;
				}
			} catch (Exception ignore) {}

			sleep(pollingInterval);

			totalTime += pollingInterval;
		}

		return waitable.waitFor();
	}

	private static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

}
