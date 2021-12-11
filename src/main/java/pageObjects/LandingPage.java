package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	WebDriver driver;
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By signIn = By.cssSelector("a[href*='sign_in']");
	private By register = By.cssSelector("a[href*='sign_up']");
	private By home = By.linkText("Home");
	private By courses = By.linkText("Courses");
	private By videos = By.linkText("Videos");
	private By interview = By.linkText("Interview Guide");
	private By practice = By.linkText("Practice");
	private By blog = By.linkText("Blog");
	private By about = By.linkText("About");
	private By contact = By.linkText("Contact");
	private By title = By.cssSelector(".text-center>h2");
	private By navigate_Pages = By.cssSelector("ul.nav.navbar-nav.navbar-right");
	private By subBanner = By.cssSelector("div[class*='video-banner'] p");
	
	public LogInPage getSignIn() {
		//In this method we customize the page object of Login page
		//in such way the it return the Login page while the login
		//button is clicked.
		driver.findElement(signIn).click();
		return new LogInPage(driver);
//		LogInPage land = new LogInPage(driver);
//		return land;
	}

	
	/*
	public WebElement getSignIn() {
		return driver.findElement(signIn);
	}
	*/
	public WebElement getRegister() {
		return driver.findElement(register);
	}

	public WebElement getHome() {
		return driver.findElement(home);
	}

	public WebElement getCourse() {
		return driver.findElement(courses);
	}

	public WebElement getVideo() {
		return driver.findElement(videos);
	}

	public WebElement getInterview() {
		return driver.findElement(interview);
	}

	public WebElement getPractice() {
		return driver.findElement(practice);
	}

	public WebElement getBlog() {
		return driver.findElement(blog);
	}

	public WebElement getAbout() {
		return driver.findElement(about);
	}

	public WebElement getContact() {
		return driver.findElement(contact);
	}
	
	public WebElement getTitle() {
		return driver.findElement(title);
	}
	
	public WebElement getNavigate_Pages() {
		return driver.findElement(navigate_Pages);
	}
	
	public WebElement getSubBanner() {
		return driver.findElement(subBanner);
	}

}
