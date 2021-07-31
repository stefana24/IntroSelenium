package test;

import helper.Constants;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty(Constants.CHROMEDRIVER,Constants.DRIVERLOCATION);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(Constants.BASE_URL);
        driver.manage().window().maximize();
    }

    @After
    public void exitMethod(){
        driver.quit();
    }
}
