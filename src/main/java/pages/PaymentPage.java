package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PaymentPage {
    WebDriver driver;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }

    public void paymentFinalize(){
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        //wait.until(ExpectedConditions.elementToBeClickable((By.cssSelector("input#billing-address-same-as-shipping-checkmo")));
        //wait.until(ExpectedConditions.elementToBeClickable((By.cssSelector("button.checkout[type='submit']"))
        driver.findElement(By.id("billing-address-same-as-shipping-checkmo")).click();
        driver.findElement(By.cssSelector("button[title='Place Order']")).click();
    }
}