package UtilityMethods;

import java.util.Set;

import org.openqa.selenium.WebDriver;

public class WebDriverUtility {
	WebDriver driver;
	
	public WebDriverUtility(WebDriver driver) {
		this.driver=driver;
	}
	
	
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

}
