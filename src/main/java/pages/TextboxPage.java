package pages;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextboxPage extends Page {

	public TextboxPage(WebDriver driver) {
		super(driver);
	}
	
	public void inputData(String fullName, String email, String currentAddress, String permanentAddress) {
		driver.findElement(By.id("userName")).sendKeys(fullName);
		driver.findElement(By.id("userEmail")).sendKeys(email);
		driver.findElement(By.id("currentAddress")).sendKeys(currentAddress);
		driver.findElement(By.id("permanentAddress")).sendKeys(permanentAddress);
		WebElement submitButton = driver.findElement(By.id("submit"));
		// scroll nút submit
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", submitButton);
        js.executeScript("arguments[0].click();", submitButton);
       
	}
	

}
