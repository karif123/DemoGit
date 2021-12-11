package E2EFrameWork;

import java.io.IOException;

import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPasswordPage;
import pageObjects.LandingPage;
import pageObjects.LogInPage;
import resources.base;


public class HomePage extends base {
	public WebDriver driver; //It solves the parallel execution
	private static Logger log = LogManager.getLogger(HomePage.class.getName());
	
	@BeforeTest
	public void launchBrowser() throws IOException {
		driver = initializeDriver();
		log.info("Browser is launched.");		
	}
	
		@Test(dataProvider="getData")
	public void homePageOpen(String email, String password, String text) throws IOException {
		String url = getURL();
		//driver.get("https://rahulshettyacademy.com");
		//driver.get("https://qaclickacademy.com");
		driver.get(url);
		log.info("Application is opened.");
		LandingPage land = new LandingPage(driver);
		//Through optimizing the Page Object model
		LogInPage login = land.getSignIn();
//		land.getSignIn().click();
//		LogInPage login = new LogInPage(driver);
		login.getEmail().sendKeys(email);
		login.getPassword().sendKeys(password);
		log.info("User type is: "+text);
		login.getLoginButton().click();
		log.info("Successfully clicked on log in button.");
//		login.forgotLink().click();
//		ForgotPasswordPage fp = new ForgotPasswordPage(driver);
//		fp.getEmail().sendKeys("test@test123.xxx");
//		fp.getInstruction().click();
		
		//Through optimizing the Page Object model
		ForgotPasswordPage fp = login.forgotLink();
		fp.getEmail().sendKeys("test@test123.xxx");
		log.info("Forgot page is opened and user email is entered successfully");
		fp.getInstruction().click();
		
		
	//diver.close();
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[3][3];
		
		//Three type of users
		data[0][0] = "nonrestrict@test.com";
		data[0][1] = "password1";
		data[0][2] = "Non Restricted User";
				
		data[1][0] = "restrict@test.com";
		data[1][1] = "password2";
		data[1][2] = "Restricted User";
				
		data[2][0] = "default@test.com";
		data[2][1] = "password3";
		data[2][2] = "Default User";
				
		return data;
	}
	
	@AfterTest
	public void browseClose() {
		driver.quit();
		log.info("Browser and application are closed.");
	}
}
