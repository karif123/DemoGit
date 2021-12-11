package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage  {
	
	WebDriver driver;
	public ForgotPasswordPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	private By email = By.id("user_email");
	private By sendInstruction = By.cssSelector("[type='submit']");
	
	public WebElement getEmail() {
		return driver.findElement(email);
	}
	
	public WebElement getInstruction() {
		return driver.findElement(sendInstruction);
	} 

}
