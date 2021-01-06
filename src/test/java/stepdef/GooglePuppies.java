package stepdef;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GooglePuppies {

	private WebDriver driver;
	
	@Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1366, 768));
        driver.get("https://www.google.com");
        assertEquals("Google", driver.getTitle());

    }

	@Given("^I can open Google$")
	public void i_can_open_Google() {
		setup();

	}
	
	@Test
	public void searchForPuppies(){
	driver.findElement(By.name("q")).click();
	driver.findElement(By.name("q")).sendKeys("puppies");
    driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	}

	@When("^I search for puppies$")
	public void i_search_for_puppies() {
		searchForPuppies();
	}

	@Then("^Google will give me Puppies$")
	public void google_will_give_me_Puppies() {
		System.out.println("Test");
	}
	
	@After
    public void tearDown() {
        driver.close();
    }
}

