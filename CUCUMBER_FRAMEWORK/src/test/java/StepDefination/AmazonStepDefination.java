package StepDefination;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.*;

public class AmazonStepDefination {
	WebDriver driver;
	public AmazonStepDefination(Hooks hooks) {
		this.driver=hooks.getDriver();
	}
	
	
	@Given("User must be in Amazon Page")
	public void user_must_be_in_amazon_page() {
	
		driver.get("https://www.amazon.in/");
	}

	@When("Enter the product name in search textbox")
	public void enter_the_product_name_in_search_textbox() throws InterruptedException {
		
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("IPhone");
		Thread.sleep(2000);
		
	}

	@And("click on Search Btn and click on first Product")
	public void click_on_search_btn_and_click_on_first_product() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		driver.findElement(By.xpath("//span[.='Apple iPhone 14 Plus 256GB Purple']")).click();
		Thread.sleep(2000);
		Set<String> win = driver.getWindowHandles();
		
		for (String string : win) {
			driver.switchTo().window(string);
			if(driver.getCurrentUrl().contains("https://www.amazon.in/Apple-iPhone-Plus-256GB-Purple")) {
				break;
			}
		}
	}
	

	@Then("validate the product page is displayed")
	public void validate_the_product_page_is_displayed() {
		String expResult="https://www.amazon.in/Apple-iPhone-Plus-256GB-Purple";
		String actResult=driver.getCurrentUrl();
		
		if(actResult.contains(expResult)) {
			System.out.println("Test case passed");
		}
		else {
			System.out.println("Test case Failed");
		}
		
	}

}
