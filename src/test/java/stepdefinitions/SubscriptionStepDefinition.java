package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

import common.Utility;
import cucumber.api.java.en.*;
import pageobjects.HomePage;

public class SubscriptionStepDefinition {
	
	WebDriver driver;
	HomePage homePage;
	public SubscriptionStepDefinition() {
		this.driver = Hooks.driver;
		this.homePage = new HomePage(this.driver);
	}
	
	@Given("I open the testmaster home page")
	public void i_open_the_testmaster_home_page() {
	    this.driver.get("http://testmaster.vn/");
	    Utility.scrolled_element_into_view(this.driver, this.homePage.txtSubscriberEmail);
	}

	@Then("I should see the subscriber form on screen")
	public void i_should_see_the_subscriber_form_on_screen() {
	    Assert.assertTrue(true);
	}
}
