package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class NavigationBarPage extends BasePage{

    public NavigationBarPage(WebDriver driver){
        super(driver);
    }

    public void clickOnMenuItem(String name){
        List<WebElement> navigationBarElements = getDriver().findElements(By.cssSelector("#nav .nav-primary > li"));
        for(WebElement nav:navigationBarElements){
            if(nav.getText().equalsIgnoreCase(name)){
                nav.click();
                break;
            }
        }
    }
//    public void clickOnEveryMenuItemsAndVerifyTitles(){
//        for(String menuItem: Constants.menuItems){
//            clickOnMenuItem(menuItem);
//            verifyPageCategoryTitle(menuItem);
//
//        }
//    }
    public void verifyPageCategoryTitle(String title){
        Assert.assertTrue(title.equalsIgnoreCase(getDriver().findElement(By.cssSelector(".page-title.category-title h1")).getText()));
    }

}
