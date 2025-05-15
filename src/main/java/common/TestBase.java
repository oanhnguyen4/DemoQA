package common;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

/**
  Description: This class commmon
*/
public class TestBase {
	public WebDriver driver;
	public void openWeb(String browser, String url) {
		if(browser.equalsIgnoreCase("chrome")) {
			 //open browser
		  	  System.setProperty("webdriver.chrome.driver", "F:\\01AutomationClass\\02Practices\\Git\\DemoQA\\driver\\chromedriver.exe");
		  	  driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "F:\\01AutomationClass\\02Practices\\Git\\DemoQA\\driver\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		
  	  //open website
  	  driver.get("https://demoqa.com/");
  	  
	}
	
	public void sleepBase() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2 * 60));
	}
	
	public void debugSleep(int second_ts) {
		try {
			Thread.sleep(second_ts * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
