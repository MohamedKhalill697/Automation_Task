package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.time.Duration;

public class cartPageTest extends BaseTest {
    @Test (priority = 3)
    public void testCartFunctionality () throws InterruptedException {
        HomePage home = new HomePage(driver);
        ProductPage product = new ProductPage(driver);
        CartPage cart = new CartPage(driver);

        home.searchForProduct();
        product.selectProduct("Hero Hoodie");
        product.selectSizeAndColor();
        product.addToCart();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        boolean isUpdated = wait.until(ExpectedConditions.textToBe(
                By.cssSelector("span.counter-number"), "1"
        ));

        Assert.assertTrue(isUpdated, "Expected cart count to be 1");
        cart.goToCart();
    }
}
