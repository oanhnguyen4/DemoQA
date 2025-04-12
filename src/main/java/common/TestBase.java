package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
  Description: This class commmon
*/
public class TestBase {
	public void openWeb() {
		 //open browser
  	  System.setProperty("webdriver.chrome.driver", "F:\\01AutomationClass\\02Practices\\Git\\SeleniumFramework\\DemoQA\\driver");
  	  WebDriver driver = new ChromeDriver();
  	  //open website
  	  driver.get("https://demoqa.com/");
	}
}
