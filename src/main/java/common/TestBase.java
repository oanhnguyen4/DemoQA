package common;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Description: This class commmon
 */
public class TestBase {
	
	public WebDriver webDriver;
	

	public void openWeb(String browser, String url) {
		if (browser.equalsIgnoreCase("chrome")) {
			// open browser
			System.setProperty("webdriver.chrome.driver",
					"F:\\01AutomationClass\\02Practices\\Git\\DemoQA\\driver\\chromedriver.exe");
			webDriver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
//			System.setProperty("webdriver.edge.driver",
//					"F:\\01AutomationClass\\02Practices\\Git\\DemoQA\\driver\\msedgedriver.exe");
//			webDriver = new EdgeDriver();
		}

		// open website
		webDriver.get(url);
		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver.manage().window().maximize();

	}

	public void sleepBase() {
		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

//	public void debugSleep(int second_ts) {
//		try {
//			Thread.sleep(second_ts * 1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	public void scrollHomePage(By locator) {
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		js.executeScript("arguments[0].scrollIntoView(true);", webDriver.findElement(locator));
		
	}
	
	public void selectByVisibleText(By locator, String visibleText) {
		WebElement drElement = webDriver.findElement(locator);
		Select drSelect = new Select(drElement);
		drSelect.selectByVisibleText(visibleText);
	}
	
	public By getXpathByParam(String originalXpath, String replacement) {
		String newXpath = originalXpath.replace("{@param}", replacement);
		return By.xpath(newXpath);
	}
	
	public void clickOnRadioButton(String rdXpath, String rdText) {
		By rdButtonLocator = getXpathByParam(rdXpath, rdText);
		WebElement rdElement = webDriver.findElement(rdButtonLocator);
		scrollHomePage(rdButtonLocator);
		rdElement.click();
	}
	
	public void zoomOut(String percentage) {
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("document.body.style.zoom='80%'");
		
	}

	public String getTextByLocator(String xpath, String fieldName) {
		By fieldLocator = getXpathByParam(xpath, fieldName);
		return webDriver.findElement(fieldLocator).getText();
	}

	

	

}
