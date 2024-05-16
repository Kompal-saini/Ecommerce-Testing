package productPurchase;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class PurchaseProduct extends authentication.BaseClass{

	
		@BeforeMethod
	    public void setUp() {
	       driver.get("http://automationpractice.com/index.php");
	        driver.manage().window().maximize();
	    }

	    @Test(priority = 1)
	    public void signIn() {
	        driver.findElement(By.linkText("Sign in")).click();
	        driver.findElement(By.id("email")).sendKeys("john@abc.com");
	        driver.findElement(By.id("passwd")).sendKeys("abcdef");
	        driver.findElement(By.id("SubmitLogin")).click();
	    }

	    @Test(priority = 2)
	    public void searchAndAddProductToCart() {
	        driver.findElement(By.id("search_query_top")).sendKeys("printed dress");
	        driver.findElement(By.name("submit_search")).click();

	        WebElement product = driver.findElement(By.xpath("//ul[contains(@class,'product_list')]/li[5]"));
	        Actions hover = new Actions(driver);
	        hover.moveToElement(product).perform();
	        driver.findElement(By.xpath("//span[contains(text(),'Add to cart')]")).click();

	        assertTrue(driver.findElement(By.xpath("//h2[contains(text(),'Product successfully added to your shopping cart')]")).isDisplayed());
	    }

	    @Test(priority = 3)
	    public void proceedToCheckout() {
	        driver.findElement(By.xpath("//span[contains(text(),'Continue shopping')]")).click();
	        driver.findElement(By.linkText("Proceed to checkout")).click();
	        driver.findElement(By.xpath("//span[text()='Proceed to checkout']")).click();
	        driver.findElement(By.name("processAddress")).click();
	        driver.findElement(By.id("cgv")).click();
	        driver.findElement(By.name("processCarrier")).click();
	        driver.findElement(By.className("bankwire")).click();
	        driver.findElement(By.xpath("//span[contains(text(),'I confirm my order')]")).click();
	    }

	    @AfterMethod
	    public void tearDown() {
	        driver.quit();
	    }
	}
	



