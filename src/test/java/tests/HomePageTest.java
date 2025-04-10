package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

import java.time.Duration;

public class HomePageTest extends BaseTest {
  @Test
  public void testSearchProduct() {
    HomePage home = new HomePage(driver);
    home.searchForProduct();

    // Wait until the search result title is visible
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    WebElement titleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.className("page-title")
    ));

    // Assert it contains "hoodie"
    Assert.assertTrue(titleElement.getText().contains("hoodie"),
            "Expected page title to contain 'hoodie' but got: " + titleElement.getText());
  }
}
