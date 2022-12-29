package StepDefination;

import org.openqa.selenium.WebDriver;

import Pages.HomePage;
import Pages.IdfcHomePage;
import Pages.IdfcLoginLogoutPage;
import UtilityMethods.ConfigReader;
import UtilityMethods.WebDriverUtility;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class ScenarioHooks {
	
	WebDriver driver;
	WebDriverUtility driverUtility;
	ConfigReader config;
	IdfcLoginLogoutPage idfcLogPage;
	public ScenarioHooks(Hooks hooks) {
		this.driver = hooks.getDriver();
		this.driverUtility=hooks.getDriverUtility();
		this.config=hooks.getConfigReader();
	}
	
	
	
	
	@Before(value="@idfcscenario",order=1)
	public void login() {
		String url=config.getProperty("idfcurl");
		String un=config.getProperty("un1");
		String pwd=config.getProperty("pwd1");
		driverUtility.openURL(url);
		idfcLogPage=new IdfcLoginLogoutPage(driver);
		idfcLogPage.login(un, pwd);
		IdfcHomePage idfcHomePage=new IdfcHomePage(driver);
		
		driverUtility.switchToFrame(idfcHomePage.getFrame());
		
		
	}
	
	@After(value="@idfcscenario",order=1)
	public void logout() {
		driverUtility.closeDriver();
		//driverUtility.switchToDefault();
		String url=config.getProperty("defurl");
		driverUtility.switchWindowToURl(url);
		idfcLogPage.logout(driverUtility);
		
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
