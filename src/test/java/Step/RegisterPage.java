package Step;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterPage {
	WebDriver driver;

	@Given("user is on register page")
	public void user_is_on_register_page() {
		// 1. connect to actual browser
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\AllDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)).pageLoadTimeout(Duration.ofSeconds(30));
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	@When("user enter valid {string}, {string}, {string} and {string}")
	public void user_enter_valid_and(String fname, String lname, String phone,String email) {
		driver.findElement(By.name("firstName")).sendKeys(fname);
		driver.findElement(By.name("lastName")).sendKeys(lname);
		driver.findElement(By.name("phone")).sendKeys(phone);
		driver.findElement(By.name("userName")).sendKeys(email);
	}

	@When("user enter valid {string}, {string}, {string}, {string} and {string}")
	public void user_enter_valid_and(String address, String city, String state, String postalcode, String country) {
		driver.findElement(By.name("address1")).sendKeys(address);

		driver.findElement(By.name("city")).sendKeys(city);

		driver.findElement(By.name("state")).sendKeys(state);
		driver.findElement(By.name("postalCode")).sendKeys(postalcode);

		WebElement selwb= driver.findElement(By.name("country"));
		Select sel = new Select(selwb);
		sel.selectByVisibleText(country);

	}

	@When("user enter valid {string}, {string}, {string} and click on submit button")
	public void user_enter_valid_and_click_on_submit_button(String username, String password, String confirmpassword) {
		driver.findElement(By.name("email")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("confirmPassword")).sendKeys(confirmpassword);
		
		driver.findElement(By.name("submit")).click();
	}

	@Then("validate user is on register success page by using url")
	public void validate_user_is_on_register_success_page_by_using_url() {
		String url = driver.getCurrentUrl();
		boolean a = url.contains("success");
		Assert.assertTrue(a);
	}

}
