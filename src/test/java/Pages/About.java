package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import CommonFunctions.CommonFunctions;
import Setup.SetupBrowser;

public class About extends SetupBrowser {
	
	private static String aboutTitle = "About - i6 Group";
	private static By contactUS = By.xpath("//a[text()='Contact Us']");

	public static void navigateToContactUs() {
		CommonFunctions.verifyTitle(aboutTitle);
		wait.until(ExpectedConditions.presenceOfElementLocated(contactUS));
		driver.findElement(contactUS).sendKeys(Keys.ENTER);
	}
}
