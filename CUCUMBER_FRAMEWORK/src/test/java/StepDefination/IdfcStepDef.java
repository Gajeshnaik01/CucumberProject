package StepDefination;

import static org.junit.Assert.fail;

import org.openqa.selenium.WebDriver;

import Pages.IdfcHomePage;
import UtilityMethods.ConfigReader;
import UtilityMethods.WebDriverUtility;
import io.cucumber.java.en.*;

public class IdfcStepDef {
	WebDriver driver;
	WebDriverUtility driverUtility;
	ConfigReader config;
	IdfcHomePage idfcHomePage;
	public IdfcStepDef(Hooks hooks) {
		this.driver = hooks.getDriver();
		this.driverUtility=hooks.getDriverUtility();
		this.config=hooks.getConfigReader();
	}
	@Given("User must be in IDFC Home Page")
	public void user_must_be_in_idfc_home_page() {
		String curUrl=config.getProperty("currenturlidfc");
		String actUrl=driverUtility.getCurrentUrl();
		if(curUrl.equals(actUrl)) {
		}
		else {
			fail("User is not in IDFC Home Page");
		}
	}
	@When("User open the Account list and click ok")
	public void user_open_the_account_list_and_click_ok() {

		idfcHomePage=new IdfcHomePage(driver);
		idfcHomePage.openAccountList();
		String switchUrl=config.getProperty("switchcururlidfc");
		driverUtility.switchWindowToURl(switchUrl);
		idfcHomePage.clickOkBtn();

	}
	@And("click on Account Number")
	public void click_on_account_number() {
		String acc = config.getProperty("accNo");
		idfcHomePage.clickOnAccont(acc);

	}
	@Then("validate the Account Number")
	public void validate_the_account_number() {

		String actualAccNo=idfcHomePage.getAccountNumber().trim();
		String expAccNo=config.getProperty("accNo").trim();
		System.out.println(actualAccNo);
		
		System.out.println(expAccNo);
		if(actualAccNo.equals(expAccNo)) {
			System.out.println("Account Number Matching");
		}
		else {
			fail("Account Number Not Matching");
		}
		
		
	}



}
