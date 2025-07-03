package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import tests.entities.StudentRegistrationForm;

public class AutomationPracticeFormPage extends Page{
	public By txtFirstName = By.id("firstName");
	public By txtLastName = By.id("lastName");
	public By txtEmail = By.id("userEmail");
	public String rdGender = "//label[text()='{@param}']";
	public By txtMobile = By.id("userNumber");
	public By txtDateOfBirth = By.id("dateOfBirthInput");
	public By drYear = By.className("react-datepicker__year-select");
	public By drMonth = By.className("react-datepicker__month-select");
	public String lblDateXpath = "//*[text()='{@param}']";
	
	public By txtSubjects = By.id("subjectsInput");
	
	public String hobbiesXpath = "//label[text()='{@param}']";
	public By txtPicture = By.id("uploadPicture");
	public By txtCurrentAddress = By.id("currentAddress");
	public By cbState=By.id("state");
	public By cbStateInput = By.xpath("//*[@id='state']//input");
	public By cbCity =By.id("city");
	public By cbCityInput =By.xpath("//*[@id='city']//input");
	public By btnSubmit = By.id("submit");

	public AutomationPracticeFormPage(WebDriver dr) {
		super(dr);
		// TODO Auto-generated constructor stub
	}

	public ThankForSubmitting inputData(StudentRegistrationForm st) {
		driver.findElement(txtFirstName).sendKeys(st.getFirstName());
		driver.findElement(txtLastName).sendKeys(st.getLastName());
		driver.findElement(txtEmail).sendKeys(st.getEmail());
//		driver.findElement(testBase.getXpathByParam(rdGender, st.gender())).click();
		base.clickOnRadioButton(rdGender, st.getGender());
		
		driver.findElement(txtMobile).sendKeys(st.getMobile());
		driver.findElement(txtDateOfBirth).click();
		inputDateOfBirth(st.getDateOfBirth());
		inputSubject(st.getSubjects());
		selectHobbies(st.getHobbies());
		driver.findElement(txtPicture).sendKeys(st.getPicture());
		driver.findElement(txtSubjects).sendKeys(st.getSubjects());
		
		driver.findElement(txtCurrentAddress).sendKeys(st.getCurrentAddress());
		return new ThankForSubmitting(driver);
		
		
		
	}
	public void inputDateOfBirth(String dateOfBirth) {
//		String [] dateOfBirths = dateOfBirth.split(" ");
//		driver.findElement(txtDateOfBirth).click();
//		WebElement drYearElement = driver.findElement(drYear);
//		Select drYearSelect = new Select(drYearElement);
//		drYearSelect.selectByVisibleText(dateOfBirths[2]);
		String[] dateOfBirths = dateOfBirth.split(" ");
		String date = dateOfBirths[0];
		String month = dateOfBirths[1];
		String year = dateOfBirths[2];
		
		base.selectByVisibleText(drYear, year);
		base.selectByVisibleText(drMonth, month);
		driver.findElement(base.getXpathByParam(lblDateXpath, date)).click();	
		
	}
	
	public void inputSubject(String subject) {
		String[] subjects = subject.split(",");
		WebElement subjectElement = driver.findElement(txtSubjects);
		for (int i=0; i<subjects.length; i++) {
			subjectElement.sendKeys(subjects[i].trim());
			subjectElement.sendKeys(Keys.ENTER);
		}
	}
	
	public void selectHobbies(String hobbies) {
		String[] hobbiesArr = hobbies.split(",");
		for(int i=0; i<hobbiesArr.length; i++) {
			By hobbiesLocator = base.getXpathByParam(hobbiesXpath, hobbiesArr[i].trim());
			driver.findElement(hobbiesLocator).click();
		}
	}
	
	
}
