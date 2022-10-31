package steps;

import java.io.IOException;

import org.openqa.selenium.WebDriver; 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import common.ConfigProp;
import drivers.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import pages.LoginPage;
import pages.LogoutPage;
import pages.CategoriesPage;


public class GeneralSteps {
	final Logger LOGGER = LoggerFactory.getLogger(GeneralSteps.class);
	WebDriver driver;
	DriverFactory driverFactory;
	LoginPage login;
	CategoriesPage categories;
	LogoutPage logout;
	
	
	
	public void setup() throws IOException{
		driverFactory= new DriverFactory();
		driverFactory.getDriver(ConfigProp.getBrowser());
		driver= driverFactory.driver();	
		login = new LoginPage(driver);
		categories = new CategoriesPage(driver);
		logout = new LogoutPage(driver);
		LOGGER.info("@BeforeTest- Setup");
	}
	
	public void tearDown(){
		driverFactory.tearDown();
		LOGGER.info("@AfterTest- tearDown");
	}
	
	@Before
	public void beforeScenario() throws IOException {
		setup();
	}
	
	@After
	public void afterScenario() {
		tearDown();
	}
	
	@Step("I open the Product Store")
	@Given("^I open the Product Store$")
	   public void GoToOpenUrl() throws InterruptedException, IOException{
		login.goToOpenUrl();
	   }
	
	@Step("Login to the Product Store with the Username and Password")
	@When("^Login to the Product Store with the Username and Password$")
	public void loginToProductStore() throws InterruptedException, IOException{
		login.LoginToProducStore();
	   } 

	@Step("I add a laptop to the cart")
	@When("^I add a laptop to the cart$")
	public void IaddLaptop() throws InterruptedException, IOException{
		categories.iaddLaptop();
	   }
	@Step("I validate that the product is in the shopping cart")
	@When("^I validate that the product is in the shopping cart$")
	public void IvalidateProduct() throws InterruptedException, IOException{
		categories.ivalidateProduct();
	   }
	@Step("Close session")
	@When("^Close session$")
	public void IgoCloseSession() throws InterruptedException, IOException{
		logout.igoCloseSession();
	   }
	

	
	
	
	
}
