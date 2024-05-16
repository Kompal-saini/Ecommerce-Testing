package authentication;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;


public class ContactUs extends BaseClass{

	@Test
	public void contactPage() {
		// TODO Auto-generated method stub
		//click on contact us
		driver.findElement(By.xpath("//header/div[2]/div[1]/div[1]/nav[1]/div[3]/a[1]")).click();
		
		//contact us form
		driver.findElement(By.id("id_contact")).sendKeys("Webmaster");
		driver.findElement(By.xpath("//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/form[1]/fieldset[1]/div[1]/div[1]/div[2]/div[1]/select[1]")).sendKeys("LBWJGDJXR - 09/06/2021");
		driver.findElement(By.id("fileUpload")).sendKeys("C:\\Users\\kompa\\Downloads\\picture.jpg");
		driver.findElement(By.id("message")).sendKeys("abcde");
		driver.findElement(By.id("submitMessage")).click();
	}

	@AfterClass
	public void closeAll() {
		driver.quit();
	}
	
	}


