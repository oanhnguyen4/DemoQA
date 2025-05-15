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
import pages.TextBoxPage;

public class TextBoxTest extends TestCase {
    @Test(description ="[TextBox] Submit successfully")
    public void submitSuccessfully() {
    	String fullName = "Oanh";
    	String email = "oanhnt@gmail.com";
    	String currentAddress = "Ha Noi";
    	String permanentAddress ="Ha Noi";
    	HomePage homePage = new HomePage(testBase.driver);
    	ElementsPage elementPage = homePage.clickOnElements();
    	TextBoxPage textBoxPage = elementPage.clickOnTextBox();
    	textBoxPage.inputData(fullName, email, currentAddress, permanentAddress);
    	
    	testBase.debugSleep(2);
    
    	String actualFullName = textBoxPage.getActualValue(textBoxPage.lblName);
    	assertEquals(actualFullName, fullName);
    	String actualEmail = textBoxPage.getActualValue(textBoxPage.lblMail);
    	assertEquals(actualEmail, email);
    	String actualCurrentAddress = textBoxPage.getActualValue(textBoxPage.lblCurrentAddress);
    	assertEquals(actualCurrentAddress, currentAddress);
    	String actualPermanentAddress = textBoxPage.getActualValue(textBoxPage.lblPermanentAddress);
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
    	TextBoxPage textBoxPage = elementPage.clickOnTextBox();
    	textBoxPage.inputData(fullName, email, currentAddress, permanentAddress);
    	testBase.debugSleep(5);
    	textBoxPage.validateEmail("field-error");
    	
    }
    @Test(description = "[TextBox] Email format is wrong (without domain name)")
    public void validateEmail2() {
    	String fullName = "Oanh";
    	String email = "oanhnt";
    	String currentAddress = "Ha Noi";
    	String permanentAddress ="Ha Noi";
    	HomePage homePage = new HomePage(testBase.driver);
    	ElementsPage elementPage = homePage.clickOnElements();
    	TextBoxPage textBoxPage = elementPage.clickOnTextBox();
    	textBoxPage.inputData(fullName, email, currentAddress, permanentAddress);
    	testBase.debugSleep(5);
		textBoxPage.validateEmail("field-error");
    }
    
}
