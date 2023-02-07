package stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.Base;

public class Login extends Base {
	WebDriver driver;
	LandingPage landingpage;
	LoginPage loginpage;
	
	@Given("^Open browser$")
    public void open_browser() throws IOException  {
		driver = initializeBrowser();
    }
	
	@And("^Navigate to Login Page$")
    public void navigate_to_login_page()  {
		driver.get(prop.getProperty("url"));
		landingpage = new LandingPage(driver);
		landingpage.myAccount().click();
		landingpage.login().click();
       
    }

    @When("^User enters username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void user_enters_username_as_something_and_password_as_something(String email, String password)  {
    	
    	loginpage = new LoginPage(driver);
		loginpage.email().sendKeys(email);
		loginpage.password().sendKeys(password);
    }
    

    @And("^User clicks on Login button$")
    public void user_clicks_on_login_button()  {
    	loginpage.loginbtn().click();
    }

    @Then("^Verify user is able to login successfully$")
    public void verify_user_is_able_to_login_successfully()  {
       Assert.assertTrue(loginpage.myAccountText().isDisplayed());
    }
    
    @After
    public void closeBrowser() {
    	driver.close();
    }

   }
