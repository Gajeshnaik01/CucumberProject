package StepDefination;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.WebDriver;

import Pages.HomePage;
import UtilityMethods.ConfigReader;
import UtilityMethods.WebDriverUtility;
import io.cucumber.java.en.*;

public class AmazonStepDefination {
	WebDriver driver;
	HomePage homePage;
	public AmazonStepDefination(Hooks hooks) {
		this.driver = hooks.getDriver();
	}
	WebDriverUtility driverUtility;
	ConfigReader config;

	@Given("User must be in Amazon Page")
	public void user_must_be_in_amazon_page() throws IOException {
		driverUtility=new WebDriverUtility(driver);
		config=new ConfigReader();
		config.intializeConfigReader();
		String url=config.getProperty("url");
		driverUtility.openURL(url);
	}

	@When("Enter the product name in search textbox")
	public void enter_the_product_name_in_search_textbox() throws InterruptedException {
		homePage = new HomePage(driver);
		homePage.searchProduct("Iphone");
		Thread.sleep(2000);

	}

	@And("click on Search Btn and click on first Product")
	public void click_on_search_btn_and_click_on_first_product() throws InterruptedException {
		homePage.clickSearchBtn().clickOnProduct();

		Thread.sleep(2000);
		String url=config.getProperty("currentUrl");
		driverUtility.switchWindowToURl(url);
		
		
	}

	@Then("validate the product page is displayed")
	public void validate_the_product_page_is_displayed() {
		String expResult = config.getProperty("currentUrl");
		String actResult = driver.getCurrentUrl();

		if (actResult.contains(expResult)) {
			System.out.println("Test case passed");
		} else {
			System.out.println("Test case Failed");
		}

	}

	/*
	 * 
	 * 
	 */
	@When("search for {string}")
	public void search_for(String string) throws InterruptedException {
		homePage = new HomePage(driver);
		homePage.searchProduct(string).clickSearchBtn();

		Thread.sleep(2000);

	}

	@Then("click on any mobile")
	public void click_on_any_mobile() {
		System.out.println("validated");
	}

}
