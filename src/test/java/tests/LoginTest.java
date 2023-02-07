package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.Base;

@Test(dataProvider = "provideData")

public class LoginTest extends Base {

	public WebDriver driver;
	LoginPage loginpage;
	Logger log;

	public void login(String email, String password, String expectedResult) throws InterruptedException, IOException {

		LandingPage landingpage = new LandingPage(driver);

		landingpage.myAccount().click();
		log.debug("Clicked on My Account dropdown");
		landingpage.login().click();
		log.debug("Clicked on login option");

		loginpage = new LoginPage(driver);

		loginpage.email().sendKeys(email);
		log.debug("email is entered");
		loginpage.password().sendKeys(password);
		log.debug("password is entered");
		loginpage.loginbtn().click();
		log.debug("login button is clicked");
		String actualResult = null;
		try {
			if (loginpage.myAccountText().isDisplayed())
				actualResult = "successful";
			log.debug("User logged in Successfully");
		} catch (Exception e) {
			actualResult = "failure";
			log.debug("User is not able to login");
		}

		Assert.assertEquals(actualResult, expectedResult);
		log.info("Test is passed");
				
	}
	
	@BeforeMethod
	public void openUrl() throws IOException {
	log = LogManager.getLogger(LoginTest.class.getName());
		driver = initializeBrowser();
		log.debug("Browser is launched");
		driver.get(prop.getProperty("url"));
		log.debug("Application URL is opened");
	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

	@DataProvider
	public Object[][] provideData() {
		Object[][] testData = { { "swapnali123@gmail.com", "test1234", "successful" },
				{ "swapnali123@gmail.com", "test123", "successful" } };
		return testData;
	}
}
