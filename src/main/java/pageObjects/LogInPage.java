package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {
	
	WebDriver driver;
	public LogInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user_email")
	private WebElement email;
	
	@FindBy(id="user_password")
	private WebElement password;
	
	@FindBy(name="commit")
	private WebElement login;
	
	@FindBy(linkText="Forgot Password?")
	private WebElement forgot;
	
	public WebElement getEmail() {
		return email;
	}
	
	public WebElement getPassword() {
		return password;
	}
	
	public WebElement getLoginButton() {
		return login;
	}
	/*
	public WebElement forgotLink() {
		return forgot;
	}*/
	
	public ForgotPasswordPage forgotLink() {
	//In this method we customize the page object of Forgot Password page
	//in such way the it return the Forgot password page while the 
	//Forgot password button is clicked.
		forgot.click();
		return new ForgotPasswordPage(driver);
//		ForgotPasswordPage fp = new ForgotPasswordPage(driver); 
//		return fp;
	}
	
}
