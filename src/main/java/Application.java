import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Application {
    private static final String location = "drivers\\chromedriver.exe";

    public static WebDriver init(){
        System.setProperty("webdriver.chrome.driver", location);
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    public static void testHomepage(){
        WebDriver driver = init();
        driver.navigate().to("http://qa2.dev.evozon.com/");

        String title = driver.getTitle();
        System.out.println(title);
        String url = driver.getCurrentUrl();
        System.out.println(url);

        WebElement element = driver.findElement(By.className("large"));
        element.click();

        driver.navigate().to("http://qa2.dev.evozon.com/women/pants-denim.html");

        driver.navigate().back();

        driver.navigate().forward();

        driver.navigate().refresh();

        driver.quit();
    }

    public static void testAccount(){
        WebDriver driver = init();
        driver.navigate().to("http://qa2.dev.evozon.com/");
        WebElement element = driver.findElement(By.cssSelector(".account-cart-wrapper a.skip-link.skip-account"));
        element.click();
        driver.quit();

    }

    public static void testLanguages(){
        WebDriver driver = init();
        driver.navigate().to("http://qa2.dev.evozon.com/");

        List<WebElement> elements = driver.findElements(By.cssSelector("#select-language option"));
        for(WebElement webElement: elements)
            System.out.println(webElement.getText());

        WebElement element = driver.findElement(By.cssSelector("#select-language"));
        Select select = new Select(element);
        select.selectByIndex(1);

        driver.quit();
    }

    public static void testSearch(){
        WebDriver driver = init();
        driver.navigate().to("http://qa2.dev.evozon.com/");

        WebElement element = driver.findElement(By.id("search"));
        element.clear();

        String enteredText="woman";

        WebElement element_enter = driver.findElement(By.xpath("//*[@id=\"search\"]"));

        element_enter.findElement(By.xpath("/html/body/div/div[2]/header/div/div[4]/form/div[1]/input")).sendKeys(enteredText);

        driver.quit();
    }

    public static void testNewProductList(){
        WebDriver driver = init();
        driver.navigate().to("http://qa2.dev.evozon.com/");

        List<WebElement> elements = driver.findElements(By.cssSelector(".widget-products ul .item.last"));
        System.out.println("The number of new products: "+elements.size());
        for(WebElement webElement: elements)
            System.out.println(webElement.getText());

        driver.quit();
    }

    public static void testNavigation() throws InterruptedException {
        WebDriver driver = init();
        driver.navigate().to("http://qa2.dev.evozon.com/");

        List<WebElement> elements = driver.findElements(By.cssSelector("#nav"));
        for(WebElement webElement: elements)
            System.out.println(webElement.getText());

        WebElement element = driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-5.parent > a"));
        element.click();

        Thread.sleep(2000);
        driver.quit();
    }


    public static void main(String[]args) throws InterruptedException {
        //testHomepage();
        //testAccount();
        //testLanguages();
        //testSearch();
        //testNewProductList();

        testNavigation();
    }
}
