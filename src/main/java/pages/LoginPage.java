package pages;

import helper.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="#email")
    WebElement emailInput;

    @FindBy(css="#pass")
    WebElement passwordInput;

    @FindBy(css="#send2")
    WebElement loginBtn;


    public void getLogInPage(){
        String path  ="customer/account/login/";
        getDriver().get(Constants.BASE_URL+path);
    }

    public void login(String userEmail,String userPassword){
        emailInput.sendKeys(userEmail);
        passwordInput.sendKeys(userPassword);
        loginBtn.click();
    }

}
