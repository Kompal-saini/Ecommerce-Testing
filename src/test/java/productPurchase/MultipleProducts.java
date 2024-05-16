package productPurchase;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;


public class MultipleProducts extends authentication.BaseClass{

	@Test(priority = 1)
	public void signIn() {
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.id("email")).sendKeys("john@abc.com");
		driver.findElement(By.id("passwd")).sendKeys("abcdef");
		driver.findElement(By.id("SubmitLogin")).click();
	}

	@Test(priority = 2)
	public void addDressToCart() {
		addProductToCart("Dresses", 1);
	}

	@Test(priority = 3)
	public void addTShirtToCart() {
		addProductToCart("T-shirts", 1);
	}

	@Test(priority = 4)
	public void proceedToCheckout() {
		driver.findElement(By.linkText("Proceed to checkout")).click();
		driver.findElement(By.linkText("Proceed to checkout")).click();
		driver.findElement(By.name("processAddress")).click();
		driver.findElement(By.id("cgv")).click();
		driver.findElement(By.name("processCarrier")).click();
		driver.findElement(By.className("bankwire")).click();
		driver.findElement(By.cssSelector("button[class='button btn btn-default button-medium']")).click();
	}

	public void addProductToCart(String category, int productIndex) {
		WebElement categoryElement = driver.findElement(By.xpath("//a[@title='" + category + "']"));
		Actions hover = new Actions(driver);
		hover.moveToElement(categoryElement).perform();

		driver.findElement(By.linkText(category)).click();

		WebElement product = driver.findElement(By.xpath("//div[@id='center_column']//ul[@class='product_list grid row']/li[" + productIndex + "]"));
		hover.moveToElement(product).perform();
		driver.findElement(By.xpath("//span[text()='Add to cart']")).click();
		assertTrue(driver.findElement(By.xpath("//h2[text()='Product successfully added to your shopping cart']")).isDisplayed());
		driver.findElement(By.cssSelector("span[title='Close window']")).click(); // Close the pop-up
	}

	@AfterClass
	public void closeAll() {
		driver.quit();
	}
	
}

