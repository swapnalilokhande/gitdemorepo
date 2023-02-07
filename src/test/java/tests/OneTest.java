package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.Base;

public class OneTest extends Base {
	
	@Test
	public void testone () throws IOException, InterruptedException {
		WebDriver driver = initializeBrowser();
		driver.get("https://maven.apache.org/plugins/maven-resources-plugin/examples/filter.html");
		System.out.println("Inside TestOne Method");
		Thread.sleep(3000);
		driver.close();
	}

}
