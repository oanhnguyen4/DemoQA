package pages;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextboxPage extends Page {
	public By txtFullName = By.id("userName");
	public By txtEmail = By.id("userEmail");
	public By txtCurrentAddress = By.xpath("//textarea[@id='currentAddress']");
	public By txtPermanentAddress = By.xpath("//textarea[@id='permanentAddress']");
	public By btnSubmit = By.id("submit");
	public By lblName = By.xpath("//p[@id='name']");
	public By lblMail = By.xpath("//p[@id='email']");
	public By lblCurrentAddress = By.xpath("//p[@id='currentAddress']");
	public By lblPermanentAddress = By.xpath("//p[@id='permanentAddress']");
	public TextboxPage(WebDriver driver) {
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
	
	public String getActualFullName() {
		String originalStr = driver.findElement(lblName).getText();
		String [] splittedStr = originalStr.split(":");
		String actualFullName = splittedStr[1].trim();
		return actualFullName;
	
	
	}
	
	public String getActualEmail() {
		String originalStr1 = driver.findElement(lblMail).getText();
		String [] splittedStr1 = originalStr1.split(":");
		String actualEmail = splittedStr1[1].trim();
		return actualEmail;
	
	
	}
	public String getActualCurrentAddress() {
		String originalStr2 = driver.findElement(lblCurrentAddress).getText();
		String [] splittedStr2 = originalStr2.split(":");
		String actualCurrentAddress = splittedStr2[1].trim();
		return actualCurrentAddress;
	
	
	}
	public String getActualPermanentAddress() {
		String originalStr3 = driver.findElement(lblPermanentAddress).getText();
		String [] splittedStr3 = originalStr3.split(":");
		String actualPermanentAddress = splittedStr3[1].trim();
		return actualPermanentAddress;
	
	
	}

}
