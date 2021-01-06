package stepdef;

import static org.junit.Assert.assertEquals;


import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GooglePuppies {

	private static WebDriver driver;
	private static String URL = "https://www.google.com/";

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1366, 768));
		
	}

	@Given("^I can open Google$")
	public void i_can_open_Google() {
		driver.get(URL);
		assertEquals("Google", driver.getTitle());
	}

	@When("^I search for puppies$")
	public void i_search_for_puppies() {
		driver.findElement(By.name("q")).click();
		driver.findElement(By.name("q")).sendKeys("puppies");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	}

	@Then("^Google will give me Puppies$")
	public void google_will_give_me_Puppies() throws InterruptedException {
		driver.findElement(By.linkText("Images")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".isv-r:nth-child(1) .rg_i")).click();
		Thread.sleep(2000);
	    
	}

	@After
	public void tearDown() {
		driver.close();
	}
}
