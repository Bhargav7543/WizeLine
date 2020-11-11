package pageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;

import baseClass.TestBase;
import locators.Locators.wizeLineLocators;
import utility.ReportsClass;

public class WizeLine_Page extends TestBase implements wizeLineLocators {

	// Tell us about yourself form Locators
	@FindBy(id = "firstName")
	WebElement firstName_field;
	@FindBy(id = "lastName")
	WebElement lastName_field;
	@FindBy(id = "email")
	WebElement emailAddress_field;
	@FindBy(id = "birthMonth")
	WebElement birthMonth_field;
	@FindBy(id = "birthDay")
	WebElement birthDay_field;
	@FindBy(id = "birthYear")
	WebElement birthYear_field;
	@FindBy(xpath = NEXT_LOCATION_BUTTON)
	WebElement nextLocationButton_field;

	// Add your address form Locators
	@FindBy(id = "city")
	WebElement city_field;
	@FindBy(id = "zip")
	WebElement zip_field;
	@FindBy(xpath = COUNTRY)
	WebElement country_field;
	@FindBy(xpath = NEXT_DEVIC_BUTTON)
	WebElement nextDeviceButton_field;
	@FindBy(xpath = NEXT_LAST_STEP_BUTTON)
	WebElement nextLastStepButton_field;

	// Enter password form Locators
	@FindBy(id = "password")
	WebElement password_field;
	@FindBy(id = "confirmPassword")
	WebElement confirmPassword_field;
	@FindBy(xpath = STAY_INFORMED_CHECKBOX)
	WebElement stayInformedCheckbox_field;
	@FindBy(xpath = READ_AND_ACCEPT_TERM_CHECKBOX)
	WebElement readAndAcceptTermCheckbox_field;
	@FindBy(xpath = PRIVACY_POLICY_CHECKBOX)
	WebElement privacyAndPolicyCheckbox_field;
	@FindBy(id = "laddaBtn")
	WebElement completeSetupButton_field;

	public WizeLine_Page() {
		PageFactory.initElements(driver, this);
	}

	// Tell about yourself form
	public void tellUsAboutYourselfForm(String firstName, String lastName, String incorrectEmail, String correctEmail,
			String birthMonth, String birthDay, String birthYear) throws Exception {
		firstName_field.sendKeys(firstName);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		lastName_field.sendKeys(lastName);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		emailAddress_field.sendKeys(incorrectEmail);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		// Select Birth Month
		Select drpBirthMonth = new Select(birthMonth_field);
		try {
			drpBirthMonth.selectByValue(birthMonth);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		} catch (Exception e) {
			System.out.println("");
		}

		// Select Birth Day
		Select drpBirthDay = new Select(birthDay_field);
		try {
			drpBirthDay.selectByValue(birthDay);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		} catch (Exception e) {
			System.out.println("");
		}

		// Select Birth Year
		Select drpBirthYear = new Select(birthYear_field);

		try {
			drpBirthYear.selectByValue(birthYear);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		} catch (Exception e) {
			System.out.println("");
		}

		nextLocationButton_field.click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		if (driver.findElement(By.xpath("//span[@id='emailError']")) != null) {
			System.out.println("Incorrect Email : " + incorrectEmail + " Please Enter Correct Email Address : ");
			ReportsClass.logStat(Status.WARNING,
					"Incorrect Email : " + incorrectEmail + " Please Enter Correct Email Address : ");
			emailAddress_field.clear();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			emailAddress_field.sendKeys(correctEmail);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			ReportsClass.logStat(Status.PASS, "You have entered correct email address : " + correctEmail);
			Thread.sleep(2000);
			nextLocationButton_field.click();
			Thread.sleep(2000);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		} else {
			System.out.println("You have entered correct email address : " + correctEmail);
			ReportsClass.logStat(Status.PASS, "You have entered correct email address : " + correctEmail);
		}

		nextDeviceButton_field.click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		nextLastStepButton_field.click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	// Add Your Address
	public void addYourAddress(String city, String zipCode, String country) {
		nextDeviceButton_field.click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	// Enter Password
	public void enterPassword(String password, String confirmPassword) throws Exception {
		password_field.sendKeys(password);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		confirmPassword_field.sendKeys(confirmPassword);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		stayInformedCheckbox_field.click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		readAndAcceptTermCheckbox_field.click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		privacyAndPolicyCheckbox_field.click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		completeSetupButton_field.click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Thread.sleep(5000);

		if (driver.findElement(By.xpath(
				"//body/ui-view[1]/unauthenticated-container[1]/div[1]/div[1]/div[1]/ui-view[1]/div[1]/div[1]/div[1]/div[2]/div[1]/p[1]")) != null) {
			System.out.println("SignUp Successfully !!!");
			ReportsClass.logStat(Status.PASS, "SignUp Successfully !!!");
		} else {
			System.out.println("SignUp Failed !!!");
			ReportsClass.logStat(Status.FAIL, "SignUp Failed !!!");
		}
	}
}
