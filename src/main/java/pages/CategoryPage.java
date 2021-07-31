package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CategoryPage extends BasePage{

    public CategoryPage(WebDriver driver){
        super(driver);
    }

    public void navigateToSubcategory(String subcategoryTitle) {
        List<WebElement> subcategories = getDriver().findElements(By.cssSelector(".catblocks a span"));
        for (WebElement subcategory : subcategories) {
            System.out.println(subcategory.getText());
            if (subcategory.getText().equalsIgnoreCase(subcategoryTitle)) {
                subcategory.click();
                break;
            }
        }
    }

    public void clickOnProduct(String productName){
        List<WebElement> allProducts = getDriver().findElements(By.cssSelector(".products-grid .product-name"));
        for(WebElement product:allProducts){
            if(product.getText().equalsIgnoreCase(productName)){
                System.out.println(product.getText());
                product.click();
                break;
            }
        }

    }


//    public void selectSize()
//
//    public void selectColorAndSizeAndAddToCart(){
//
//        WebElement colorBtn = driver.findElement(By.cssSelector("#swatch26"));
//        colorBtn.click();
//        WebElement sizeBtn = driver.findElement(By.cssSelector("#option79"));
//        sizeBtn.click();
//        WebElement addBtn = driver.findElement(By.cssSelector(".product-options-bottom .button.btn-cart"));
//        addBtn.click();
//    }

}
