package stepdefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pageobjects.LoginPage;
import cucumber.api.java.en.Then;
import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import common.DataHelper;

public class LoginStepDefinition {

	WebDriver driver;
	LoginPage loginPage;
	public List<HashMap<String,String>> datamap;
	
	public LoginStepDefinition() {
		this.driver = Hooks.driver;
		this.loginPage = new LoginPage(Hooks.driver);
		datamap = DataHelper.data(System.getProperty("user.dir")+"//src//test//resources//testData/default.xlsx","Sheet1");
	}

	@Given("I am staying testmaster login page")
	public void i_am_staying_testmaster_login_page() {
		this.driver.get("http://www.testmaster.vn/admin");
		
		this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@When("I provide invalid value for username and password")
	public void i_provide_invalid_value_for_username_and_password() {
		this.loginPage.txtUsername.clear();
		this.loginPage.txtUsername.sendKeys("khanh.tx @");
		this.loginPage.txtPassword.clear();
		this.loginPage.txtPassword.sendKeys("a bc");

		this.loginPage.btnLogin.click();
	}

	@Then("I should see the corresponding message on tooltip")
	public void i_should_see_the_corresponding_message_on_tooltip() {
		String userNameTooltip = this.loginPage.txtUsername.getAttribute("data-original-title");
		String passwordTooltip = this.loginPage.txtPassword.getAttribute("data-original-title");

		assertEquals("Hãy nhập E-mail ở định dạng: user@email.com", userNameTooltip);
		assertEquals("Mật khẩu chỉ nhận giá trị chữ và số", passwordTooltip);
	}

	@When("I provide valid value for username and wrong password")
	public void i_provide_valid_value_for_username_and_wrong_password() {
		this.loginPage.txtUsername.clear();
		this.loginPage.txtUsername.sendKeys("khanh.tx@live.com");
		this.loginPage.txtPassword.clear();
		this.loginPage.txtPassword.sendKeys("abc123456");

		this.loginPage.btnLogin.click();
	}

	@Then("I should see the popup message {string} in bold format and {string} in Italic format")
	public void i_should_see_the_popup_message_in_bold_format_and_in_Italic_format(String msg1, String msg2) {
			this.loginPage.WaitPopupToDisplay();
			
			assertEquals(this.loginPage.lbMessageInBold.getText(), msg1);
			assertEquals(this.loginPage.lbMessageInItalic.getText(), msg2);
	}

}