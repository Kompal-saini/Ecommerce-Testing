package productPurchase;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;


public class SearchNegative extends authentication.BaseClass{

	public void negSearch(){
		// TODO Auto-generated method stub

		
		driver.get("http://automationpractice.com/index.php");
		
	
		//search
		driver.findElement(By.id("search_query_top")).sendKeys("");
		driver.findElement(By.xpath("//header/div[3]/div[1]/div[1]/div[2]/form[1]/button[1]")).click();
		
		// Assert that the search result message is displayed
        Assert.assertTrue(driver.findElement(By.className("alert-warning")).isDisplayed(),
                "Search result message is not displayed.");
    }
	
	@AfterClass
	public void closeAll() {
		driver.quit();
	}
}