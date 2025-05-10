package tests;

import static org.testng.Assert.assertEquals;

import java.lang.annotation.ElementType;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.w3c.dom.Text;

import common.TestBase;
import pages.ElementsPage;
import pages.HomePage;
import pages.TextboxPage;

public class TextBoxTest extends TestCase {
    @Test(description ="[TextBox] Submit successfully")
    public void submitSuccessfully() {
    	String fullName = "Oanh";
    	String email = "oanhnt@gmail.com";
    	String currentAddress = "Ha Noi";
    	String permanentAddress ="Ha Noi";
    	HomePage homePage = new HomePage(testBase.driver);
    	ElementsPage elementPage = homePage.clickOnElements();
    	TextboxPage textBoxPage = elementPage.clickOnTextBox();
    	textBoxPage.inputData(fullName, email, currentAddress, permanentAddress);
    	
    	testBase.debugSleep(2);
    	
//    	WebDriverWait wait = new WebDriverWait(testBase.driver, Duration.ofSeconds(10)); // tối đa 10s
//    	WebElement outputDiv = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("output")));
//    	
//    	WebElement nameField = testBase.driver.findElement(By.id("name"));
//    	WebElement emailField = testBase.driver.findElement(By.id("email"));
//    	WebElement currentAddressField = testBase.driver.findElement(By.xpath("//p[@id='currentAddress']"));
//    	WebElement permanentAddressField = testBase.driver.findElement(By.xpath("//p[@id='permanentAddress']"));
//
//    	// So sánh từng cái
//    	Assert.assertEquals(nameField.getText(), "Name:" + fullName, "Full Name không đúng");
//    	Assert.assertEquals(emailField.getText(), "Email:" + email, "Email không đúng");
//    	Assert.assertEquals(currentAddressField.getText(), "Current Address :" + currentAddress, "Current Address không đúng");
//    	Assert.assertEquals(permanentAddressField.getText(), "Permananet Address :" + permanentAddress, "Permanent Address không đúng");
//    
    	
    	
    	String actualFullName = textBoxPage.getActualFullName();
    	assertEquals(actualFullName, fullName);
    	String actualEmail = textBoxPage.getActualEmail();
    	assertEquals(actualEmail, email);
    	String actualCurrentAddress = textBoxPage.getActualCurrentAddress();
    	assertEquals(actualCurrentAddress, currentAddress);
    	String actualPermanentAddress = textBoxPage.getActualPermanentAddress();
    	assertEquals(actualPermanentAddress, permanentAddress);
    }

    @Test(description ="[TextBox] Email format is wrong (without \"@\")")
    public void validateEmail() {
    	String fullName = "Oanh";
    	String email = "oanhntgmail.com";
    	String currentAddress = "Ha Noi";
    	String permanentAddress ="Ha Noi";
    	HomePage homePage = new HomePage(testBase.driver);
    	ElementsPage elementPage = homePage.clickOnElements();
    	TextboxPage textBoxPage = elementPage.clickOnTextBox();
    	textBoxPage.inputData(fullName, email, currentAddress, permanentAddress);
    	testBase.debugSleep(5);
    	WebElement element = testBase.driver.findElement(By.id("userName"));
    	String className = element.getAttribute("class");
    	if (className != null && className.contains("field-error")) {
    	    System.out.println("Phần tử có chứa class 'field-error'");
    	} else {
    	    System.out.println("Phần tử KHÔNG chứa class 'field-error'");
    	}
    	
    }
    @Test(description = "[TextBox] Email format is wrong (without domain name)")
    public void validateEmail2() {
    	String fullName = "Oanh";
    	String email = "oanhnt";
    	String currentAddress = "Ha Noi";
    	String permanentAddress ="Ha Noi";
    	HomePage homePage = new HomePage(testBase.driver);
    	ElementsPage elementPage = homePage.clickOnElements();
    	TextboxPage textBoxPage = elementPage.clickOnTextBox();
    	textBoxPage.inputData(fullName, email, currentAddress, permanentAddress);
    	testBase.debugSleep(5);
    	WebElement element = testBase.driver.findElement(By.id("userName"));
    	String className = element.getAttribute("class");
    	if (className != null && className.contains("field-error")) {
    	    System.out.println("Phần tử có chứa class 'field-error'");
    	} else {
    	    System.out.println("Phần tử KHÔNG chứa class 'field-error'");
    	}

    }
    
}
