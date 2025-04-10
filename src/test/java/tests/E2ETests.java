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

public class E2ETests extends BaseTest {

    @Test
    public void paymentSuccess() throws InterruptedException {
        HomePage home = new HomePage(driver);
        ProductPage product = new ProductPage(driver);
        CartPage cart = new CartPage(driver);
        CheckoutPage checkout = new CheckoutPage(driver);
        PaymentPage payment = new PaymentPage(driver);

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

        Thread.sleep(4000);
        Assert.assertTrue(driver.getCurrentUrl().contains("checkout") && driver.getCurrentUrl().contains("shipping"),
                "Expected URL to contain 'checkout' and 'shipping' but got: " + driver.getCurrentUrl());

        checkout.fillCheckoutProcess();
        payment.paymentFinalize();

        WebDriverWait waitForVisibility = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successMsg = waitForVisibility.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h1[@class='page-title']/span[text()='Thank you for your purchase!']")));

        Assert.assertTrue(successMsg.isDisplayed(), "Success message not displayed!");
    }
}
