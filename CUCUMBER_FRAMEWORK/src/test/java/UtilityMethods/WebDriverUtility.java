package UtilityMethods;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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
			driver = new ChromeDriver();
			break;
		case "firfox":
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

}
