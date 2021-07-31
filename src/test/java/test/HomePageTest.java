package test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.HomePage;

import java.util.List;

@RunWith(JUnit4.class)
public class HomePageTest extends BaseTest{

    private HomePage homePage;

    @Test
    public void testNewProductList()  {
        homePage = new HomePage(driver);
        List<WebElement> elements = driver.findElements(By.cssSelector(".widget-products ul .item.last"));
        System.out.println("The number of new products: "+elements.size()); // 5
        Assert.assertEquals(5,elements.size());
        for(WebElement webElement: elements)
            System.out.println(webElement.getText());
    }

    @Test
    public void testTitle() {
        String title = driver.getTitle();
        Assert.assertTrue(title.equals("Madison Island"));
    }
}
