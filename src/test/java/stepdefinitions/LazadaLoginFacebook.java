package stepdefinitions;

import java.util.concurrent.TimeUnit;

import javax.swing.text.Utilities;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.Utility;
import cucumber.api.java.en.*;

public class LazadaLoginFacebook {
	WebDriver driver;
	
	public LazadaLoginFacebook()
	{
		this.driver = Hooks.driver;
	}
	
	@Given("I am staying at Lazada login page")
	public void i_am_staying_at_Lazada_login_page() {
	    this.driver.get("https://member.lazada.vn/user/login");
	    
	    this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@When("I click on facebook login button")
	public void i_click_on_facebook_login_button() {
	    WebElement btnLoginFace = this.driver.findElement(By.cssSelector("button.mod-third-party-login-btn"));
	    btnLoginFace.click();
	    
	}

	@Then("I should see the facebook login windows")
	public void i_should_see_the_facebook_login_windows() {
	    Utility.switch_window(this.driver, "");
	    String title = this.driver.getTitle();
	    Assert.assertEquals("Facebook", title);
	}

	@Given("I am taying at facebook login page")
	public void i_am_taying_at_facebook_login_page() {
		this.driver.get("https://member.lazada.vn/user/login");
		this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement btnLoginFace = this.driver.findElement(By.cssSelector("button.mod-third-party-login-btn"));
	    btnLoginFace.click();
	    
	    Utility.switch_window(this.driver, "");
	}

	@When("I provide my credential")
	public void i_provide_my_credential() {
	    WebElement txtUserName = this.driver.findElement(By.name("email"));
	    WebElement txtPassWord = this.driver.findElement(By.name("pass"));
	    
	    txtUserName.sendKeys("khanh.tx@euroland.com");
	    txtPassWord.sendKeys("abc123456");
	    
	    this.driver.findElement(By.name("login")).click();
	}

	@Then("I should see My profile on lazada page")
	public void i_should_see_My_profile_on_lazada_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}
}
