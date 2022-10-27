package CommonFunctions;

import org.junit.Assert;
import Setup.SetupBrowser;

public class CommonFunctions extends SetupBrowser {

	// Method to verify page titles.
	public static void verifyTitle(String pageTitle) {
		Assert.assertEquals(driver.getTitle(), pageTitle);
		log.info("Page title is " + pageTitle);
	}
}
