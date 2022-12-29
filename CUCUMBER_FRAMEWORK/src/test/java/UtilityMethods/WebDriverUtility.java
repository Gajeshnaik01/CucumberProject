package UtilityMethods;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverUtility {
	WebDriver driver;
	

	public void openURL(String url) {
		driver.get(url);
	}

	public void switchWindowToURl(String url) {
		Set<String> win = driver.getWindowHandles();

		for (String string : win) {
			driver.switchTo().window(string);
			if (driver.getCurrentUrl().contains(url)) {
				break;
			}
		}
	}

	public WebDriver intializeDriver(String browser) {

		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;

		default:
			System.out.println("No such Browser Present");
			break;
		}

		return driver;

	}
	
	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}
	public void implicitWait(String second) {
		int sec=Integer.parseInt(second);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}

	
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
		
	}
	
	public void closeDriver() {
		 driver.close();
	}
	
	
	
	public void switchToDefault() {
		driver.switchTo().defaultContent();
	}
	
	
	public void switchToFrame(WebElement element) {
		driver.switchTo().frame(element);
	}
}
