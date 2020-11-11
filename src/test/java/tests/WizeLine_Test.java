package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClass.TestBase;
import pageObject.WizeLine_Page;
import utility.ReadPropertyConfig;
import utility.ReportsClass;

public class WizeLine_Test extends TestBase {
	ReadPropertyConfig readPro = new ReadPropertyConfig();
	String URL = readPro.getTestURL();
	String firstName = readPro.getFirstName();
	String lastName = readPro.getLastName();
	String incorrectEmail = readPro.getIncorrectEmail();
	String correctEmail = readPro.getCorrectEmail();
	String birthMonth = "number:8";
	String birthDay = "number:18";
	String birthYear = "number:1994";
	String city = readPro.getCity();
	String zipCode = readPro.getZipCode();
	String country = readPro.getCountry();
	String password = readPro.getPassword();
	String confirmPassword = readPro.getConfirmPassword();

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Start Test: WizeLine_Test");

		// Launch MasterQA URL
		openURL(URL);
	}

	@Test
	public void demoTest() throws Exception {
		ReportsClass.initialisation("WizeLine_Test");
		WizeLine_Page wizeLinePage = new WizeLine_Page();

		// Enter Details about yourself
		wizeLinePage.tellUsAboutYourselfForm(firstName, lastName, incorrectEmail, correctEmail, birthMonth, birthDay,
				birthYear);

		// Enter Password
		wizeLinePage.enterPassword(password, confirmPassword);
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("End Test: WizeLine_Test");
	}
}
