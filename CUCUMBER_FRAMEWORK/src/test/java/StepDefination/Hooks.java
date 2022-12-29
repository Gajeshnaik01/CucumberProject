package StepDefination;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import UtilityMethods.ConfigReader;
import UtilityMethods.WebDriverUtility;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	private WebDriver driver;
	private WebDriverUtility driverUtility;
	private ConfigReader configReader;

	@Before (order=0)
	public void setup() throws IOException {
		driverUtility=new WebDriverUtility();
		configReader=new ConfigReader();
		configReader.intializeConfigReader();
		String browser=configReader.getProperty("browser");
		String to=configReader.getProperty("timeouts");
		driver = driverUtility.intializeDriver(browser);
		driverUtility.maximizeBrowser();
		driverUtility.implicitWait(to);
		
		System.out.println("Browser Launched");
	}

	@After(order=0)
	public void tearDown(Scenario scenario) {
		
		
		if(scenario.isFailed()) {
			//Take Screenshot
			final byte[] shot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			//Embed into Report
			scenario.attach(shot, "image/png", scenario.getName());
		}
		//driver.quit();
		System.out.println("Browser Closed");

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
