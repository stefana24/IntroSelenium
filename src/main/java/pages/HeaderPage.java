package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HeaderPage extends BasePage{
    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="a[class*='skip-account']")
    WebElement account;

    public void clickOnAccount(){
        account.click();
    }

    @FindBy(css="#header-account > div > ul > li.last > a")
    WebElement loginLink;

    public void clickOnLoginLink(){
        loginLink.click();
    }

    @FindAll({
            @FindBy(css="#select-language > option:nth-child(1)"),
            @FindBy(css="#select-language > option:nth-child(2)"),
            @FindBy(css="#select-language > option:nth-child(3)")

    })
    private List<WebElement> languageOptions;

    public int getNumberOfLanguageOptions(){
        return languageOptions.size();
    }

    public void verifyLanguagesExist(String[] languages){
        if(languageOptions.size()==languages.length){
            for(int i=0;i<languageOptions.size();i++){
                Assert.assertEquals(languageOptions.get(i).getText(),languages[i]);
            }
        }
    }

    @FindBy(css="#select-language")
    private WebElement languageDropdown;

    public void clickOnLanguageDropdown(){
        languageDropdown.click();
    }

}
