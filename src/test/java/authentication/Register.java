package authentication;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test; 
public class Register extends BaseClass {


	@SuppressWarnings("deprecation")
	@Test
	public void registerPosCase(){

		// Assert that the registration form is displayed
		Assert.assertTrue(driver.findElement(By.id("id_gender1")).isDisplayed(), "Registration form is not displayed.");

		//register page
		driver.get("http://www.google.com");
		driver.findElement(By.id("email_create")).sendKeys("john@abcd.com");
		driver.findElement(By.id("SubmitCreate")).click();	
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='id_gender1']")).click();
		driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys("John");
		driver.findElement(By.name("customer_lastname")).sendKeys("Brown");
		driver.findElement(By.id("passwd")).sendKeys("abcdef");
		driver.findElement(By.id("days")).sendKeys("9  ");
		driver.findElement(By.id("months")).sendKeys("May");
		driver.findElement(By.id("years")).sendKeys("1990");
		driver.findElement(By.id("uniform-newsletter")).click();
		driver.findElement(By.id("optin")).click();
		driver.findElement(By.id("firstname")).sendKeys("John");
		driver.findElement(By.id("lastname")).sendKeys("Brown");
		driver.findElement(By.id("company")).sendKeys("XYZ");
		driver.findElement(By.id("address1")).sendKeys("Amsterdam");
		driver.findElement(By.id("address2")).sendKeys("1 Floor");
		driver.findElement(By.id("city")).sendKeys("Amsterdam");
		driver.findElement(By.id("id_state")).sendKeys("New York");
		driver.findElement(By.id("postcode")).sendKeys("12345");
		driver.findElement(By.id("other")).sendKeys("other information");
		driver.findElement(By.id("phone")).sendKeys("0123456789");
		driver.findElement(By.id("phone_mobile")).sendKeys("1234567890");
		driver.findElement(By.id("alias")).sendKeys("NY");	
		driver.findElement(By.id("submitAccount")).click();

		// Assert that the user is registered successfully
        Assert.assertTrue(driver.getCurrentUrl().contains("my-account"), "User registration failed.");
    }

	@AfterClass
	public void closeAll() {
		driver.quit();
	}

	}
	




