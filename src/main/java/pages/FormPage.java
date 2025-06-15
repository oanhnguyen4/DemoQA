package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormPage extends Page{
	public By lblPracticeForm = By.xpath("//span[text()='Practice Form']");
	public FormPage(WebDriver dr) {
		super(dr);
		// TODO Auto-generated constructor stub
	}
    public AutomationPracticeFormPage clickOnPracticeForm() {
    	 driver.findElement(lblPracticeForm).click();
    	 return new AutomationPracticeFormPage(driver);
    }
}
