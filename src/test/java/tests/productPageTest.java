package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductPage;

public class productPageTest extends BaseTest {
    @Test (priority = 2)
    public void testSelectProductAndAddToCart() {
        HomePage home = new HomePage(driver);
        ProductPage product = new ProductPage(driver);

        home.searchForProduct();
        product.selectProduct("Selene Yoga Hoodie");
        product.selectSizeAndColor();
        product.addToCart();
    }
}
