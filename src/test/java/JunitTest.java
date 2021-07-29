import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RunWith(JUnit4.class)
public class JunitTest {

    WebDriver driver;

    @Before
    public void init(){
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://qa2.dev.evozon.com/");
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
    }

    @After
    public void existMethod() throws InterruptedException {
        Thread.sleep(15000);
        driver.quit();
    }


    @Test
    public void testHomepage(){

        String title = driver.getTitle();
        System.out.println(title);
        String url = driver.getCurrentUrl();
        System.out.println(url);

        Assert.assertTrue(title.equals("Madison Island"));

        WebElement element = driver.findElement(By.className("large"));
        element.click();

        driver.navigate().to("http://qa2.dev.evozon.com/women/pants-denim.html");

        driver.navigate().back();

        driver.navigate().forward();

        driver.navigate().refresh();

    }


    @Test
    public void testAccount(){
        WebElement element = driver.findElement(By.cssSelector("#header > div > div.skip-links > div"));
        element.click();
    }

    @Test
    public void testLanguages(){

        List<WebElement> elements = driver.findElements(By.cssSelector("#select-language option"));
        Assert.assertTrue(elements.size()==3);
        for(WebElement webElement: elements)
            System.out.println(webElement.getText());

        WebElement element = driver.findElement(By.id("select-language"));
        Select select = new Select(element);
        select.selectByIndex(1);

    }

    @Test
    public void testSearch() {

        WebElement element = driver.findElement(By.id("search"));
        element.clear();

        String enteredText="woman";


        driver.findElement(By.cssSelector(".input-text.required-entry")).sendKeys(enteredText);

    }

    @Test
    public void testNewProductList()  {
        List<WebElement> elements = driver.findElements(By.cssSelector(".widget-products ul .item.last"));
        System.out.println("The number of new products: "+elements.size()); // 5

        Assert.assertEquals(5,elements.size());
        for(WebElement webElement: elements)
            System.out.println(webElement.getText());
    }

    @Test
    public void testNavigation() {

        List<WebElement> elements = driver.findElements(By.cssSelector("#nav"));
        for(WebElement webElement: elements)
            System.out.println(webElement.getText());

        WebElement element = driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-5.parent > a"));
        element.click();

    }
    public void clickOnMenuItem(String name){
        List<WebElement> navigationBarElements = driver.findElements(By.cssSelector("#nav .nav-primary > li"));
        for(WebElement nav:navigationBarElements){
            if(nav.getText().equalsIgnoreCase(name)){
                nav.click();
                break;
            }
        }
    }

    private List<String> menuItems = Arrays.asList(new String[]{"WOMEN","MEN","ACCESSORIES","HOME & DECOR","SALE","VIP"});
    @Test
    public void testNavigationBar() throws InterruptedException {
        for(String menuItem:menuItems){
            clickOnMenuItem(menuItem);
            Assert.assertTrue(menuItem.equalsIgnoreCase(driver.findElement(By.cssSelector(".page-title.category-title h1")).getText()));
        }
    }
    public WebElement getCartProductContainer(String name){
        List<WebElement> elementsFromCart = driver.findElements(By.cssSelector(".cart-table tbody tr"));
        for(WebElement elem: elementsFromCart){
            System.out.println(elem.findElement(By.cssSelector("h2 a")).getText());
            if(elem.findElement(By.cssSelector("h2 a")).getText().equalsIgnoreCase(name)){
                return elem;
            }
        }
        return null;
    }

    @Test
    public void addItemToCart(){
        driver.navigate().to("http://qa2.dev.evozon.com/women.html");
        WebElement newArrivals = driver.findElement(By.cssSelector(".catblocks li:first-child"));
        newArrivals.click();
        WebElement toriTank = driver.findElement(By.cssSelector("#product-collection-image-418"));
        toriTank.click();

        WebElement colorBtn = driver.findElement(By.cssSelector("#swatch26"));
        colorBtn.click();

        WebElement sizeBtn = driver.findElement(By.cssSelector("#option79"));
        sizeBtn.click();

        WebElement addBtn = driver.findElement(By.cssSelector(".product-options-bottom .button.btn-cart"));
        addBtn.click();

        Assert.assertTrue(getCartProductContainer("Tori Tank").isDisplayed());
    }

}
