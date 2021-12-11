package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	WebDriver driver;
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user_name")
	private WebElement fullName;
	
	@FindBy(id="user_email")
	private WebElement email;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(xpath="//input[@type='checkbox']")
	private WebElement checkbox;
	
	@FindBy(css="input[name='commit']")
	private WebElement signUp;
	
	@FindBy(linkText="Login")
	private WebElement login;
	
	public WebElement getFullName() {
		return fullName;
	}
	
	public WebElement getEmailField() {
		return email;
	}
	
	public WebElement getPassword() {
		return password;
	}
	
	public WebElement getCheckBox() {
		return checkbox;
	}
	
	public WebElement getSignUpButton() {
		return signUp;
	}
	
	public WebElement getLogIn() {
		return login;
	}
	
}
