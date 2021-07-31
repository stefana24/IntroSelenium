package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ShoppingCartPage extends BasePage{

    public ShoppingCartPage(WebDriver driver){
        super(driver);
    }

    public WebElement getCartProductContainer(String name){
        List<WebElement> elementsFromCart = getDriver().findElements(By.cssSelector(".cart-table tbody tr"));
        for(WebElement elem: elementsFromCart){
            System.out.println(elem.findElement(By.cssSelector("h2 a")).getText());
            if(elem.findElement(By.cssSelector("h2 a")).getText().equalsIgnoreCase(name)){
                return elem;
            }
        }
        return null;
    }

    public String getShoppingCartPageURL(){
        return getDriver().getCurrentUrl();
    }
}
