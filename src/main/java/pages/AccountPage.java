package pages;

import org.openqa.selenium.WebDriver;

public class AccountPage extends BasePage{
    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public String getAccountPageURL(){
        String path  ="customer/account";
        return getDriver().getCurrentUrl();
    }
}
