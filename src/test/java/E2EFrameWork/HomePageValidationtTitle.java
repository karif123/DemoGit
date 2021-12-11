package E2EFrameWork;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.LandingPage;
import pageObjects.LogInPage;
import resources.base;



public class HomePageValidationtTitle extends base {
	LandingPage land;
	public WebDriver driver; //It solves the parallel execution
	private static Logger log = LogManager.getLogger(HomePageValidationtTitle.class.getName());
	
	@BeforeTest
	public void launchApplication() throws IOException {
		driver = initializeDriver();
		log.info("Browser is launched.");
		String url = getURL();
		driver.get(url);
		log.info("Application is opened.");
	}

	@Test	
	public void validateTitle() throws IOException {
		
		land = new LandingPage(driver);
		//Compare the text of the title from the browser
        //with the actual value
		String title = land.getTitle().getText();
		Assert.assertEquals(title, "FEATURED COURSES123");
		//System.out.println("Title is displayed on Browser as: "+title);
		log.info("Title is displayed on Browser as: "+title);
	}
	
	@Test
	public void validateSubBannerTitle() throws IOException {
		land = new LandingPage(driver);
		String bn_title = land.getSubBanner().getText();
		Assert.assertEquals(bn_title, "Learn Hot tools like Selenium, Appium, JMeter, SoapUI,Database Testing and more..");
		log.info("Title is displayed on Sub Banner as: "+bn_title);
	}
	
	@AfterTest
	public void browseClose() {
		driver.close();
		log.info("Browser and application are closed.");
	}
	
}
