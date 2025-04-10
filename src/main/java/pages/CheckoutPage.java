package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {
  WebDriver driver;

  public CheckoutPage(WebDriver driver) {
    this.driver = driver;
  }
  public void fillCheckoutProcess() throws InterruptedException{
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.urlContains("checkout/#shipping"));
    driver.findElement(By.cssSelector("input#customer-email")).sendKeys("test@email.com"); // if input field for email uses 'username'
    driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys("Mohamed");
    driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys("Ahmed");
    driver.findElement(By.cssSelector("input[name='street[0]']")).sendKeys("123 Test Street");
    driver.findElement(By.cssSelector("input[name='city']")).sendKeys("Cairo");
    WebElement regionDropdown = driver.findElement(By.xpath("//select[@name='region_id']"));
    Select select = new Select(regionDropdown);
    select.selectByVisibleText("Armed Forces Middle East");
    driver.findElement(By.cssSelector("input[name='postcode']")).sendKeys("12345");
    driver.findElement(By.cssSelector("input[name='telephone']")).sendKeys("0123456789");
    driver.findElement(By.cssSelector("input[type='radio'][name^='ko_unique_']:first-of-type")).click();
    driver.findElement(By.cssSelector("button[data-role='opc-continue']")).click();
    Thread.sleep(3000);
  }
}