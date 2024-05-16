package authentication;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;


public class ForgetPass extends BaseClass{

	@Test
	public void forget() {
		// TODO Auto-generated method stub


		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		driver.findElement(By.xpath("//a[contains(text(),'Forgot your password?')]")).click();
		driver.findElement(By.id("email")).sendKeys("john@abc.com");
		driver.findElement(By.xpath("//id[@contains(text(), 'submit')]")).click();


	}
	@AfterClass
	public void closeAll() {
		driver.quit();
	}

}
