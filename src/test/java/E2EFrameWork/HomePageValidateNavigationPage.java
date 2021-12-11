package E2EFrameWork;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.LandingPage;
import pageObjects.LogInPage;
import resources.base;



public class HomePageValidateNavigationPage extends base {
	
	public WebDriver driver; //It solves the parallel execution
	public static Logger log = LogManager.getLogger(HomePageValidateNavigationPage.class.getName());
	@BeforeTest
	public void launchApplication() throws IOException {
		driver = initializeDriver();
		log.info("Browser is launched.");
		String url = getURL();
		driver.get(url);
		log.info("Application is opened.");
	}
	@Test	
	public void validateNavigationPage() throws IOException {
		//	driver.get(prop.getProperty("url"));
		LandingPage land = new LandingPage(driver);
		//Verify whether the navigation bar is displayed 
		Boolean dispaly=land.getNavigate_Pages().isDisplayed();
		Assert.assertTrue(dispaly);
		log.info("Successfully verified that navigation tabs are present.");
	}
	
	@AfterTest
	public void browseClose() {
		driver.close();
		log.info("Browser and application are closed.");
	}
	
}
