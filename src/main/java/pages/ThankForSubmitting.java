package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ThankForSubmitting extends Page {
	public ThankForSubmitting(WebDriver dr) {
		super(dr);
		// TODO Auto-generated constructor stub
	}

	public String valueXpath="//td[text()='{@param}']/following-sibling::td";

}
