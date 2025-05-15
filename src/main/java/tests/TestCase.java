package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import common.TestBase;

public class TestCase {
	public TestBase testBase = new TestBase();
	
	@BeforeMethod
	public void setUp() {
		String url = "https://demoqa.com/";
		String browser = "chrome";
		testBase.openWeb(browser, url);
		testBase.sleepBase();
	}
	
	@AfterMethod
	public void tearDown() {
		if (testBase.driver != null) {
            testBase.driver.quit();  // Đóng browser và cleanup session
        }
		
	}

}
