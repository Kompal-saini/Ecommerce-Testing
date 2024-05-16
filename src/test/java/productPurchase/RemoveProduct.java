package productPurchase;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RemoveProduct extends authentication.BaseClass{

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
    }

    @Test(priority = 1)
    public void login() {
        driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
        driver.findElement(By.id("email")).sendKeys("john@abc.com");
        driver.findElement(By.id("passwd")).sendKeys("abcdef");
        driver.findElement(By.id("SubmitLogin")).click();
    }

    @Test(priority = 2)
    public void selectDress() {
        driver.findElement(By.id("jumpsuit_03")).click();
    }

    @SuppressWarnings("deprecation")
	@Test(priority = 3)
    public void addToCart() {
        driver.findElement(By.id("img_1")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Add to cart')]")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        assertTrue(driver.findElement(By.xpath("//h2[contains(text(),'Product successfully added to your shopping cart')]")).isDisplayed());
        driver.findElement(By.id("close")).click();
    }

    @Test(priority = 4)
    public void hoverCartAndAddProduct() {
        Actions cart = new Actions(driver);
        WebElement cartElement = driver.findElement(By.xpath("//header/div[3]/div[1]/div[1]/div[3]/div[1]/a[1]"));
        cart.moveToElement(cartElement).build().perform();
        driver.findElement(By.linkText("Add to cart")).click();
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}

