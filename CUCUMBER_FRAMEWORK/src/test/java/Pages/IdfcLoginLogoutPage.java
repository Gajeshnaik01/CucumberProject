package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilityMethods.WebDriverUtility;

public class IdfcLoginLogoutPage {
	private WebDriver driver;

	public IdfcLoginLogoutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(xpath = "//input[@placeholder='Enter your username']")
	private WebElement unTxtBox;
	
	@FindBy(xpath = "//input[@placeholder='Enter your password']")
	private WebElement pwdTxtBox;
	
	
	@FindBy(xpath = "//button[@id='login']")
	private WebElement loginBtn;
	
	
	@FindBy(xpath = "//frame[@name='app']")
	private WebElement logoutFrame;
	
	@FindBy(xpath = "//div[@class='logout-text']/following-sibling::span")
	private WebElement logout;
	
	@FindBy(xpath = "//frame[@id='content']")
	private WebElement popup;
	
	@FindBy(xpath = "//button[.='OK' and @type]")
	private WebElement okBtn;
	
	
	public void login(String un, String pwd) {
		unTxtBox.sendKeys(un);
		pwdTxtBox.sendKeys(pwd);
		loginBtn.click();
	}
	
	
	public void logout(WebDriverUtility driverUtility) {
		
		driverUtility.switchToFrame(logoutFrame);
		logout.click();
		driverUtility.switchToDefault();
		driverUtility.switchToFrame(popup);
		okBtn.click();
	}
	

}
