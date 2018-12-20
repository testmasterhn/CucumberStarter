package pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	WebDriver driver;
	@FindBy(css="div.login-form input[type=email]")
	public WebElement txtUsername;
	
	@FindBy(css="div.login-form input[type=password]")
	public WebElement txtPassword;
	
	@FindBy(css="div.login-form button.btn-login")
	public WebElement btnLogin;
	
	@FindBy(css="div.body-message>b")
	public WebElement lbMessageInBold;
	
	@FindBy(css="div.body-message>i")
	public WebElement lbMessageInItalic;
	
	//The contructor to initialize the page factory
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement WaitPopupToDisplay()
	{
		
		WebElement element = (new WebDriverWait(this.driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.popover-dialog")));
		this.driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		
		this.lbMessageInBold = element.findElement(By.cssSelector("b"));
		this.lbMessageInItalic = element.findElement(By.cssSelector("i"));
		
		return element;
	}
}
