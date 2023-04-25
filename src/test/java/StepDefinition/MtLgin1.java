package StepDefinition;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import dev.failsafe.internal.util.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MtLgin1 {
	public static  WebDriver driver;

	@Given("launching the browser")
	public void Initializebrowser() {
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(co);
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/newtours/");

	}

	@When("user opens url")
	public void useropensurl() throws InterruptedException {
		driver.findElement(By.name("userName")).sendKeys("mercury");
		driver.findElement(By.name("password")).sendKeys("mercury");
		Thread.sleep(3000);
		driver.findElement(By.name("submit")).click();
	}
	
	@Then("Login sucessfull")
	public void Loginsucessfull() {
		String Expval=new String();
		String Actval = new String();
		Expval="Login Successfully";
		Actval=driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/h3")).getText();
		assertEquals(Expval, Actval);
	}

}
