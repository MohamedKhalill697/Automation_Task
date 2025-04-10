package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CartPage {
  WebDriver driver;

  public CartPage(WebDriver driver) {
    this.driver = driver;
  }

  public void goToCart() throws InterruptedException {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    wait.until(ExpectedConditions.elementToBeClickable(By.className("showcart"))).click();
    Thread.sleep(3000);
    wait.until(ExpectedConditions.elementToBeClickable(By.id("top-cart-btn-checkout"))).click();
  }
}