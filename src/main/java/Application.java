//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;
//
//import java.util.List;
//
//
//public class Application {
//    private static final String location = "drivers\\chromedriver.exe";
//    private static final String chromeDriver = "webdriver.chrome.driver";
//    private static final String madisonUrl = "http://qa2.dev.evozon.com/";
//
//    public static WebDriver init(){
//        System.setProperty(chromeDriver, location);
//        WebDriver driver = new ChromeDriver();
//        return driver;
//    }
//
//    public static void testHomepage(){
//        WebDriver driver = init();
//        driver.navigate().to(madisonUrl);
//
//        String title = driver.getTitle();
//        System.out.println(title);
//        String url = driver.getCurrentUrl();
//        System.out.println(url);
//
//        WebElement element = driver.findElement(By.className("large"));
//        element.click();
//
//        driver.navigate().to(madisonUrl+"women/pants-denim.html");
//
//        driver.navigate().back();
//
//        driver.navigate().forward();
//
//        driver.navigate().refresh();
//
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        driver.quit();
//    }
//
//    public static void testAccount(){
//        WebDriver driver = init();
//        driver.navigate().to(madisonUrl);
//        WebElement element = driver.findElement(By.cssSelector("#header > div > div.skip-links > div"));
//        element.click();
//
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        driver.quit();
//
//    }
//
//    public static void testLanguages(){
//        WebDriver driver = init();
//        driver.navigate().to(madisonUrl);
//
//        List<WebElement> elements = driver.findElements(By.cssSelector("#select-language option"));
//        for(WebElement webElement: elements)
//            System.out.println(webElement.getText());
//
//        WebElement element = driver.findElement(By.id("select-language"));
//        Select select = new Select(element);
//        select.selectByIndex(1);
//
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        driver.quit();
//    }
//
//    public static void testSearch() {
//        WebDriver driver = init();
//        driver.navigate().to(madisonUrl);
//
//        WebElement element = driver.findElement(By.id("search"));
//        element.clear();
//
//        String enteredText="woman";
//
//
//        driver.findElement(By.cssSelector(".input-text.required-entry")).sendKeys(enteredText);
//
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        driver.quit();
//    }
//
//    public static void testNewProductList()  {
//        WebDriver driver = init();
//        driver.navigate().to(madisonUrl);
//
//        List<WebElement> elements = driver.findElements(By.cssSelector(".widget-products ul .item.last"));
//        System.out.println("The number of new products: "+elements.size());
//        for(WebElement webElement: elements)
//            System.out.println(webElement.getText());
//
////        try {
////            Thread.sleep(2000);
////        } catch (InterruptedException e) {
////            e.printStackTrace();
////        }
////
////        driver.quit();
//    }
//
//    public static void testNavigation() {
//        WebDriver driver = init();
//        driver.navigate().to(madisonUrl);
//
//        List<WebElement> elements = driver.findElements(By.cssSelector("#nav"));
//        for(WebElement webElement: elements)
//            System.out.println(webElement.getText());
//
//        WebElement element = driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-5.parent > a"));
//        element.click();
//
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        driver.quit();
//    }
//
//
//    public static void main(String[]args){
//        //testHomepage();
//        //testAccount();
//        //testLanguages();
//        //testSearch();
//        testNewProductList();
//        //testNavigation();
//    }
//}
