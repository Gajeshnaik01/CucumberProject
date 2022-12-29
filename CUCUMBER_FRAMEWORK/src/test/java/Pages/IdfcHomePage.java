package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IdfcHomePage {

	
	private WebDriver driver;

	public IdfcHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(xpath = "//a[@class='link-menu float-left' and text()='Application ']")
	private WebElement application;
	
	@FindBy(xpath = "//a[@class='link-menu float-left' and text()='Master Data Maintenance ']")
	private WebElement mdm;
	
	
	@FindBy(xpath = "//a[@class='link-menu float-left' and text()='BlockList Master ']")
	private WebElement blocklistMaster;
	
	@FindBy(xpath = "//a[@class='link-menu float-left' and text()='BlockList Account ']")
	private WebElement blocklistAccount;
	
	@FindBy(xpath = "//ul[@id='1u3u3u2u1']/descendant::a[text()='List ']")
	private WebElement list;
	
	@FindBy(xpath = "//input[@name='btnOk']")
	private WebElement okBtn;
	
	private String xpath="//table[@id]/tbody/tr/td[.='%s']";
			
	
	@FindBy(xpath = "//table[@class='table reveal-table']/tbody/tr/td[contains(text(),'Account Number')]/following-sibling::td")
	private WebElement accountNum;
	
	@FindBy(xpath = "//frame[@id='menu']")
	private WebElement frame;
	
			
	private WebElement convertXpathToString(String xpath,String replace) {
		String xpath1=String.format(xpath, replace);
		return driver.findElement(By.xpath(xpath1));
	}
	
	public void openAccountList() {
		application.click();
		mdm.click();
		blocklistMaster.click();
		blocklistAccount.click();
		list.click();
	}
	
	public void clickOkBtn() {
		okBtn.click();
	}
	
	
	public void clickOnAccont(String accNo) {
		String acc=accNo+"";
		convertXpathToString(xpath, acc).click();
	}
	
	
	
	public String getAccountNumber() {
		return accountNum.getText();
	}
	
	public WebElement getFrame() {
		return frame;
	}
	
}
