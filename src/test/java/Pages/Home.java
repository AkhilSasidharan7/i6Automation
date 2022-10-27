package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

import CommonFunctions.CommonFunctions;
import Setup.SetupBrowser;


public class Home extends SetupBrowser{
	
	static String homeTitle ="i6 Group - Aviation Fuel Management Software"; 
	
	static By cookieAccept = By.xpath("//a[text()='Accept']");
	static By aboutPage = By.xpath("//a[text()='About']");

	public static void navigateToHomePage(String homeURL) {
		
		driver.manage().window().maximize();
		driver.navigate().to(homeURL);
		log.info("Home page opened.");
		wait.until(ExpectedConditions.elementToBeClickable(cookieAccept));
		driver.findElement(cookieAccept).click();	
		CommonFunctions.verifyTitle(homeTitle);

	}

	public static void navigateToAboutPage() {

		wait.until(ExpectedConditions.elementToBeClickable(aboutPage));
		driver.findElement(aboutPage).sendKeys(Keys.ENTER);
	}

}
