package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void selectColor(String color){
        getDriver().findElement(By.cssSelector("#configurable_swatch_color a[title='"+color+"']")).click();
    }

    public void selectSize(String size){
        getDriver().findElement(By.cssSelector("#configurable_swatch_size a[title='"+size+"'")).click();
    }

    @FindBy(css="#product_addtocart_form > div.product-shop > div.product-options-bottom > div.add-to-cart > div.add-to-cart-buttons > button")
    WebElement addCartBtn;


    public void addToCart(){
        addCartBtn.click();
    }
}
