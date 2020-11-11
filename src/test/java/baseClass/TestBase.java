package baseClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ReportsClass;

public class TestBase {
	public static WebDriver driver;

	@BeforeClass
	public static void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	}

	@AfterClass
	public static void tearDown() {
		driver.quit();
	}

	@BeforeSuite
	public void beforeSuite() {
		ReportsClass.startUp();
	}

	@AfterSuite
	public void afterSuite() {
		ReportsClass.endTest();
	}

	public void openURL(String url) {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public void openNewTab() {
		((JavascriptExecutor) driver).executeScript("window.open();");
	}

	// User defined method to check the alert is present or not
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}
}
