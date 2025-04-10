package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
  WebDriver driver;

  public HomePage(WebDriver driver) {
    this.driver = driver;
  }

  public void searchForProduct() {
    WebElement searchInput = driver.findElement(By.id("search"));
    searchInput.clear();
    searchInput.sendKeys("hoodie");
    searchInput.sendKeys(Keys.ENTER);
  }
}
