package authentication;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;


public class Login extends BaseClass{

	@Test
	public void login() {
		// TODO Auto-generated method stub

		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");

		driver.findElement(By.id("email")).sendKeys("john@abc.com");
		driver.findElement(By.id("passwd")).sendKeys("abcdef");
		driver.findElement(By.id("SubmitLogin")).click();
		 
		// Assertion to check if the user is successfully logged in
        WebElement welcomeMessage = driver.findElement(By.cssSelector(".info-account"));
        Assert.assertTrue(welcomeMessage.isDisplayed(), "Login failed. Welcome message is not displayed.");
    }

	
	

	@AfterClass
	public void closeAll() {
		driver.quit();
	}

}
