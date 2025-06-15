package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.TestBase;

public class HomePage extends Page {

	public String lblCard = "//h5[text()='{@param}']";

	public HomePage(WebDriver dr) {
		super(dr);
	}

	public ElementsPage clickOnElements() {
		base.scrollHomePage(base.getXpathByParam(lblCard, "Elements"));
		driver.findElement(base.getXpathByParam(lblCard,"Elements")).click();
        return new ElementsPage(driver);
	}

    public FormPage clickOnForm(){
          driver.findElement(base.getXpathByParam(lblCard,"Form")).click();
          return new FormPage(driver);
	}

}
