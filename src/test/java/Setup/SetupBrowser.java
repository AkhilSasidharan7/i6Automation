package Setup;

import java.time.Duration;
import java.util.NoSuchElementException;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.Home;


//WebDriver defined. Additional drivers can be added if required. 

public class SetupBrowser {
    public static Wait wait;
    public static Logger log;
    public static WebDriver driver;
    
    public static void setUp()
    {
        log = SetupLog.setUp();
        log.info("Initializing Browser");
        System.setProperty("webdriver.chrome.driver", "src/test/resources/Driver/chromedriver.exe");
        driver = new ChromeDriver();
        PageFactory.initElements(driver, Home.class);
      //  wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        log.info("Browser launched");
        wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(30))
                .ignoring(NoSuchElementException.class);
        
    }

    //Closing the browser
	public static void closeBrowser() {
		
		driver.quit();
	}

}
