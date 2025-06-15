package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.AutomationPracticeFormPage;
import pages.FormPage;
import pages.HomePage;
import pages.ThankForSubmitting;
import tests.entities.StudentRegistrationForm;

public class PracticeFormTest extends TestCase{
	
	@Test
	public void submitDataSuccessfully(){
		String projectFolder = System.getProperty("user.dir");
    	StudentRegistrationForm studentRegistrationForm = new StudentRegistrationForm();
//		studentRegistrationForm.firstName="Oanh";
//		studentRegistrationForm.lastName="Nguyễn";
//		studentRegistrationForm.email="oanh@gmail.com";
//		studentRegistrationForm.gender="Male";
		
		
//		HomePage homePage = new HomePage(testBase.webDriver);
//		testBase.scrollToElement(testBase.getXpathByParam(homePage.lblCard, "Forms"));
//		FormsPage formsPage = homePage.clickOnForms();
		//formsPage.clickOnPracticeForm();
		
		testBase.webDriver.navigate().to("https://demoqa.com/automation-practice-form");
		studentRegistrationForm.setFirstName("Oanh");
		studentRegistrationForm.setLastName("Nguyen");
		studentRegistrationForm.setEmail("oanhnt199@gmail.com");
		studentRegistrationForm.setGender("Nu");
		studentRegistrationForm.setMobile("0359247405");
		studentRegistrationForm.setDateOfBirth("26 May 2025");
		studentRegistrationForm.setSubjects("Maths, Chemistry, Computer Science");
		studentRegistrationForm.setHobbies("Sports, Reading, Music");
		studentRegistrationForm.setPicture = projectFolder + "F:\\01AutomationClass\\02Practices\\Git\\DemoQA\\testcase\\hoa.jpg";
		
		studentRegistrationForm.setCurrentAddress("Ha Noi");
		studentRegistrationForm.state="NCR";
		studentRegistrationForm.city="Delhi";
		
		AutomationPracticeFormPage automationPracticeFormPage= new AutomationPracticeFormPage(testBase.webDriver);
		automationPracticeFormPage.inputData(studentRegistrationForm);
		
        ThankForSubmitting thanksForSubmitting= automationPracticeFormPage.inputData(studentRegistrationForm);
		
		String expectedStudentName = studentRegistrationForm.getFirstName() + " " + studentRegistrationForm.getLastName();
		String actualStudentName = thanksForSubmitting.base.getTextByLocator(thanksForSubmitting.valueXpath, "Student Name");
		assertEquals(expectedStudentName, actualStudentName);
		   
	}
	
	}

