package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends Page{
	
	public By lblElements = By.xpath("//h5[text()='Elements']");

	public HomePage(WebDriver dr) {
		super(dr);
	}
	
	
	public ElementsPage clickOnElements() {
		WebElement e = driver.findElement(lblElements);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", e);
		
		e.click();
		
		return new ElementsPage(driver);
	}
	

}
