package CommonFunctions;

import org.junit.Assert;

import Setup.SetupBrowser;

public class CommonFunctions extends SetupBrowser{

	//Method to verify page titles.
	public static void verifyTitle(String homeTitle)
	{
		Assert.assertEquals(driver.getTitle(), homeTitle);
		log.info("Home page title Verified");
	}
	
	
}
