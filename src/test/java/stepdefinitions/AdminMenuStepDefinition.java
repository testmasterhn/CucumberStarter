package stepdefinitions;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.*;
import pageobjects.LoginPage;

public class AdminMenuStepDefinition {
	WebDriver driver;
	LoginPage loginPage;
	
	public AdminMenuStepDefinition() {
		this.driver = Hooks.driver;
		Set<Cookie> allCookies = driver.manage().getCookies();
		for(Cookie cookie : allCookies)
		{
		    driver.manage().addCookie(cookie);
		}
		
		this.loginPage = new LoginPage(Hooks.driver);
	}
	
	@Given("I navigate to the login page")
	public void i_navigate_to_the_login_page() {
		this.driver.get("http://www.testmaster.vn/admin");
	}

	@When("I submit username and password")
	public void i_submit_username_and_password() {
		/*
		this.loginPage.txtUsername.clear();
		this.loginPage.txtUsername.sendKeys("khanh.tx@live.com");
		this.loginPage.txtPassword.clear();
		this.loginPage.txtPassword.sendKeys("abc123");

		this.loginPage.btnLogin.click();
		*/
	}

	@Then("I should be logged in")
	public void i_should_be_logged_in() {
	    
	}

	@When("I click on subscription Center link")
	public void i_click_on_subscription_Center_link() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Then("I should see the Subscription Module")
	public void i_should_see_the_Subscription_Module() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@When("I click on Elearning link")
	public void i_click_on_Elearning_link() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Then("I should see the Elearning Module")
	public void i_should_see_the_Elearning_Module() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

}
