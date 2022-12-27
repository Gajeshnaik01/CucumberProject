package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductListPage {

	public ProductListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[.='Apple iPhone 14 128GB Midnight']")
	private WebElement clickOnProd;

	public void clickOnProduct() {
		clickOnProd.click();
	}

}
