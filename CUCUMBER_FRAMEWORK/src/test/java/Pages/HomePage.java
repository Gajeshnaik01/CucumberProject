package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	private WebDriver driver;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(xpath = "//input[@id='twotabsearchtextbox']")
	private WebElement searchTxtBox;

	@FindBy(xpath = "//input[@id='nav-search-submit-button']")
	private WebElement searchBtn;

	public void searchProduct(String productName) {
		searchTxtBox.sendKeys(productName);
	}

	public ProductListPage clickSearchBtn() {
		searchBtn.click();
		return new ProductListPage(driver);
	}
}
