package test;

import helper.Constants;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import pages.CategoryPage;
import pages.NavigationBarPage;
import pages.ProductPage;
import pages.ShoppingCartPage;

@RunWith(JUnit4.class)
public class ShoppingCartTest extends BaseTest{
    private ShoppingCartPage shoppingCartPage;
    private NavigationBarPage navigationBarPage;
    private CategoryPage categoryPage;
    private ProductPage productPage;

    @Test
    public void addItemToCart(){
        shoppingCartPage = new ShoppingCartPage(driver);
        navigationBarPage = new NavigationBarPage(driver);
        categoryPage = new CategoryPage(driver);
        productPage = new ProductPage(driver);

        //home(opens)-women-new arrivals
        navigationBarPage.clickOnMenuItem(Constants.menuItems[0]);
        categoryPage.navigateToSubcategory(Constants.womenSubcategories[0]);

        categoryPage.clickOnProduct("Tori Tank");

        productPage.selectColor("Indigo");
        productPage.selectSize("M");
        productPage.addToCart();

        //check user is redirected to shopping cart
        Assert.assertTrue(shoppingCartPage.getShoppingCartPageURL().equals(Constants.BASE_URL+"checkout/cart/"));
        
        Assert.assertTrue(shoppingCartPage.getCartProductContainer("Tori Tank").isDisplayed());
    }

}
