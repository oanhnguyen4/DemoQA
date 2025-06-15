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
		
		String urlWeb = "https://demoqa.com/";
		
		String browser = "chrome";
		testBase.openWeb(browser, urlWeb);
		
//		testBase.sleepBase();
	}
	
//    @AfterMethod
//    public void tearDown() {
//		if (testBase.webDriver != null) {
//            testBase.webDriver.quit();  // Đóng browser và cleanup session
//        }
//		
//	}
}
