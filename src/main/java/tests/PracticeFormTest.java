package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import common.Utils;
import pages.AutomationPracticeFormPage;
import pages.FormPage;
import pages.HomePage;
import pages.ThankForSubmitting;
import tests.entities.StudentRegistrationForm;

public class PracticeFormTest extends TestCase{
	
	@Test
	public void submitDataSuccessfully(){
		Utils utils = new Utils();
		String fileName = "RegistrationData.xls";
		String sheetName = "Sheet1";
		String projectFolder = System.getProperty("user.dir");
//		String excelFile = projectFolder + "\\testcase\\testdata\\" + fileName;
		String[][] registrationData = utils.getTableObject(fileName, sheetName);

    	StudentRegistrationForm studentRegistrationForm = new StudentRegistrationForm();
		
		testBase.webDriver.navigate().to("https://demoqa.com/automation-practice-form");
//		studentRegistrationForm.setFirstName("Oanh");
		studentRegistrationForm.firstName = registrationData[0][0];
//		studentRegistrationForm.setLastName("Nguyen");
		studentRegistrationForm.lastName=registrationData[0][1];
		
//		studentRegistrationForm.setEmail("oanhnt199@gmail.com");
		studentRegistrationForm.email=registrationData[0][2];
//		studentRegistrationForm.setGender("Male");
		studentRegistrationForm.gender=registrationData[0][3];
//		studentRegistrationForm.setMobile("0359247405");
		studentRegistrationForm.mobile=registrationData[0][4];
//		studentRegistrationForm.setDateOfBirth("26 May 2025");
		studentRegistrationForm.dateOfBirth=registrationData[0][5];
//		studentRegistrationForm.setSubjects("Maths, Chemistry, Computer Science");
		studentRegistrationForm.subjects=registrationData[0][6];
//		studentRegistrationForm.setHobbies("Sports, Reading, Music");
		studentRegistrationForm.hobbies=registrationData[0][7];
//		studentRegistrationForm.setPicture = projectFolder + "\\testcase\\hoa.jpg";
//		studentRegistrationForm.setPicture=projectFolder + "\\testcase\\testdata\\" + registrationData[0][8];
		studentRegistrationForm.picture= registrationData[0][8];
        System.out.println( registrationData[0][8]);
//		studentRegistrationForm.setCurrentAddress("Ha Noi");
		studentRegistrationForm.currentAddress=registrationData[0][9];
//		studentRegistrationForm.state="NCR";
		studentRegistrationForm.state=registrationData[0][10];
//		studentRegistrationForm.city="Delhi";
		studentRegistrationForm.city=registrationData[0][11];
		
		AutomationPracticeFormPage automationPracticeFormPage= new AutomationPracticeFormPage(testBase.webDriver);
		
        ThankForSubmitting thanksForSubmitting= automationPracticeFormPage.inputData(studentRegistrationForm);
		
		String expectedStudentName = studentRegistrationForm.firstName + " " + studentRegistrationForm.lastName;
		String actualStudentName = thanksForSubmitting.base.getTextByLocator(thanksForSubmitting.valueXpath, "Student Name");
		assertEquals(expectedStudentName, actualStudentName);
		   
	}
	
	
	}

