package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ElementsPage extends Page{
	public By lblTextBox = By.xpath("//span[text() ='Text Box']");

	public ElementsPage(WebDriver dr) {
		super(dr);
		// TODO Auto-generated constructor stub
	}

	public TextboxPage clickOnTextBox() {
		
		driver.findElement(lblTextBox).click();
		return new TextboxPage(driver);
	}

}
