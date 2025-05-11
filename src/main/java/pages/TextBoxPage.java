package pages;


import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextBoxPage extends Page {
	public By txtFullName = By.id("userName");
	public By txtEmail = By.id("userEmail");
	public By txtCurrentAddress = By.xpath("//textarea[@id='currentAddress']");
	public By txtPermanentAddress = By.xpath("//textarea[@id='permanentAddress']");
	public By btnSubmit = By.id("submit");
	public By lblName = By.xpath("//p[@id='name']");
	public By lblMail = By.xpath("//p[@id='email']");
	public By lblCurrentAddress = By.xpath("//p[@id='currentAddress']");
	public By lblPermanentAddress = By.xpath("//p[@id='permanentAddress']");
	public TextBoxPage(WebDriver driver) {
		super(driver);
	}
	
	public void inputData(String fullName, String email, String currentAddress, String permanentAddress) {
		driver.findElement(txtFullName).sendKeys(fullName);
		driver.findElement(txtEmail).sendKeys(email);
		driver.findElement(txtCurrentAddress).sendKeys(currentAddress);
		driver.findElement(txtPermanentAddress).sendKeys(permanentAddress);
		WebElement submitButton = driver.findElement(By.id("submit"));
		// scroll nút submit
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", submitButton);
        js.executeScript("arguments[0].click();", submitButton);
       
	}
	
	public String getActualValue(By tagName) {
		String originalStr = driver.findElement(tagName).getText();
		String [] splittedStr = originalStr.split(":");
		String actualValue = splittedStr[1].trim();
		return actualValue;
	
	
	}
	
	
	public void validateEmail(String txtContain) {
		String className = driver.findElement(txtEmail).getAttribute("class");
		assertTrue(className.contains(txtContain));
	}

}
