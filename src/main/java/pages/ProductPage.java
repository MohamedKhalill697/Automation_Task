package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
  WebDriver driver;

  public ProductPage(WebDriver driver) {
    this.driver = driver;
  }

  public void selectProduct(String productName) {
    driver.findElement(By.linkText("Selene Yoga Hoodie")).click();
  }

  public void selectSizeAndColor() {
    driver.findElement(By.xpath("//div[@option-label='M']")).click();
    driver.findElement(By.xpath("//div[@option-label='Orange']")).click();
  }

  public void addToCart() {
    driver.findElement(By.id("product-addtocart-button")).click();
  }
}