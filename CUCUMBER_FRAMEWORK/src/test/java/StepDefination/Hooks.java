package StepDefination;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import UtilityMethods.ConfigReader;
import UtilityMethods.WebDriverUtility;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	private WebDriver driver;
	private WebDriverUtility driverUtility;
	private ConfigReader configReader;

	@Before
	public void setup() throws IOException {
		driverUtility=new WebDriverUtility();
		configReader=new ConfigReader();
		configReader.intializeConfigReader();
		String browser=configReader.getProperty("browser");
		String to=configReader.getProperty("timeouts");
		driver = driverUtility.intializeDriver(browser);
		driverUtility.maximizeBrowser();
		driverUtility.implicitWait(to);
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebDriverUtility getDriverUtility() {
		return driverUtility;
	}

	public ConfigReader getConfigReader() {
		return configReader;
	}
}
