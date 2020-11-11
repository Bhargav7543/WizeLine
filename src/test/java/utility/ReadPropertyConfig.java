package utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadPropertyConfig {
	Properties configProperty;
	Properties dataProperty;

	public ReadPropertyConfig() {
		File src = new File("./Configuration/config.properties");
		File src1 = new File("./Configuration/testdata.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			configProperty = new Properties();
			configProperty.load(fis);

			FileInputStream fis1 = new FileInputStream(src1);
			dataProperty = new Properties();
			dataProperty.load(fis1);
		} catch (Exception e) {
			System.out.println("Exception is" + e.getMessage());
		}
	}

	// Extent Report get Property
	public String getExtentReportPath() {
		String extentReport = configProperty.getProperty("EXTENT_REPORT_PATH");
		return extentReport;
	}

	// Get URL
	public String getTestURL() {
		String url = dataProperty.getProperty("TEST_URL");
		return url;
	}

	// Get First Name
	public String getFirstName() {
		String firstName = dataProperty.getProperty("FIRST_NAME");
		return firstName;
	}

	// Get Last Name
	public String getLastName() {
		String lastName = dataProperty.getProperty("LAST_NAME");
		return lastName;
	}

	// Get Incorrect Email
	public String getIncorrectEmail() {
		String incorrectEmail = dataProperty.getProperty("INCORRECT_EMAIL_ADDRESS");
		return incorrectEmail;
	}

	// Get Correct Email
	public String getCorrectEmail() {
		String correctEmail = dataProperty.getProperty("CORRECT_EMAIL");
		return correctEmail;
	}

	// Get City
	public String getCity() {
		String city = dataProperty.getProperty("CITY");
		return city;
	}

	// Get Zip Code
	public String getZipCode() {
		String zipCode = dataProperty.getProperty("ZIP_CODE");
		return zipCode;
	}

	// Get Country
	public String getCountry() {
		String country = dataProperty.getProperty("COUNTRY");
		return country;
	}

	// Get Your Computer
	public String getYourComputer() {
		String yourComputer = dataProperty.getProperty("YOUR_COMPUTER");
		return yourComputer;
	}

	// Get Version
	public String getVersion() {
		String version = dataProperty.getProperty("VERSION");
		return version;
	}

	// Get Language
	public String getLanguage() {
		String language = dataProperty.getProperty("LANGUAGE");
		return language;
	}

	// Get Password
	public String getPassword() {
		String password = dataProperty.getProperty("TEST_PASSWORD");
		return password;
	}

	// Get Incorrect Password
	public String getConfirmPassword() {
		String confirmPassword = dataProperty.getProperty("TEST_CONFIRM_PASSWORD");
		return confirmPassword;
	}
}
