package test;

import helper.Constants;
import org.junit.Assert;
import org.junit.Test;
import pages.AccountPage;
import pages.HeaderPage;
import pages.LoginPage;

public class LoginTest extends BaseTest{
    private LoginPage loginPage;
    private HeaderPage headerPage;
    private AccountPage accountPage;

    @Test
    public void loginTest(){
        loginPage = new LoginPage(driver);
        accountPage = new AccountPage(driver);
        headerPage = new HeaderPage(driver);


        //homepage - account-login -loginpage
        headerPage.clickOnAccount();
        headerPage.clickOnLoginLink();

        //validate current url
        Assert.assertTrue(driver.getCurrentUrl().equals(Constants.BASE_URL+"customer/account/login/"));

        //perform login
        loginPage.login(Constants.USEREMAIL,Constants.USERPASSWORD);

        //check if user is redirected to account page
        Assert.assertTrue(driver.getCurrentUrl().equals(accountPage.getAccountPageURL()));

    }
}
