package stepdefs;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginFeatureStepDef {
	WebDriver driver;
	@Given("User sedang berada di halaman register")
	public void user_sedang_berada_di_halaman_register() {
		System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/");
	}

	@When("User memasukan email {string}")
	public void user_memasukan_email(String string) {
		driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(string);
	    
	}

	@When("User menekan tombol submit")
	public void user_menekan_tombol_submit() {
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
	    
	}

	@Then("User akan melihat kredensial yang diberikan")
	public void user_akan_melihat_kredensial_yang_diberikan() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(driver.findElement(By.xpath("//h2[normalize-space()='Access details to demo site.']")).getAttribute("innerHTML"));
		driver.close();
		
	  
	}

	@Then("User akan melihat pesan validasi {string}")
	public void user_akan_melihat_pesan_validasi(String string) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String expect = driver.findElement(By.xpath("//*[@id=\"message9\"]")).getText();
		assertEquals(string, expect);
		driver.close();
	    
	}

}
