package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-email")
	private WebElement email;
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//a[text()='Edit your account information']")
	private WebElement myAccountText;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginbtn;
	
	public WebElement email() {
		return email;
	}
	
	public WebElement password() {
		return password;
	}
	
	public WebElement myAccountText() {
		return myAccountText;
	}
	
	public WebElement loginbtn() {
		return loginbtn;
	}
}
