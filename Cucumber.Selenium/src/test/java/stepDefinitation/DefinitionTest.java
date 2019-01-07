package stepDefinitation;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import screenshot.UtilityTest;

public class DefinitionTest 
{
	WebDriver driver;
	Logger log = Logger.getLogger("DefinitionTest");
    
	 
	@Given("^open firefox browser$")
	public  void open_firefox_browser() throws Throwable 
	{
		//PropertyConfigurator.configure("src/main/resources/Log4j/log4j.properties");
		 System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Selenium\\Geckodriver\\geckodriver.exe\\");
	       driver= new FirefoxDriver();
	       log.info("Opens WebDriver");
	       driver.get("https://accounts.google.com/ServiceLogin/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=AddSession");
	       log.info("Opening Webpage");
	       UtilityTest.utility(driver,"HomePage");
	       driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	       log.info("Opening for the webpage to load");
	}

	@When("^user enters the valid credentials$")
	public void user_enters_the_valid_credentials() throws Throwable 
	{
		//PropertyConfigurator.configure("log4j.properties");
		WebElement element = driver.findElement(By.id("identifierId"));
	      element.sendKeys("jhansi123@gmail.com");
	      log.info("Entering data in Textbox");
	      UtilityTest.utility(driver,"email-id");
	      driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
	      log.info("Clicking on next");
	      Thread.sleep(4000);
	       driver.findElement(By.xpath("//input[@name='password']")).sendKeys("13641863");
	       log.info("Entering password in the text box");
	       UtilityTest.utility(driver,"Password");
	      Thread.sleep(4000);
	     
	}

	@Then("^user should be able to login successfully$")
	public void user_should_be_able_to_login_successfully() throws Throwable 
	{
		//PropertyConfigurator.configure("log4j.properties");
		 driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
	       driver.navigate().back();
	       UtilityTest.utility(driver,"navigating back");
	       log.info("Navigating back to the Webpage");
	       Thread.sleep(3000);
	       driver.quit();
	       log.info("Closing the webdriver");
	}
	


}
