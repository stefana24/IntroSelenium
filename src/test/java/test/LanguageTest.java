package test;

import helper.Constants;
import org.junit.Assert;
import org.junit.Test;
import pages.HeaderPage;

public class LanguageTest extends BaseTest{
    private HeaderPage headerPage;

    @Test
    public void testLanguages(){
        headerPage = new HeaderPage(driver);

        headerPage.clickOnLanguageDropdown();

        headerPage.verifyLanguagesExist(Constants.languages);
        Assert.assertEquals(headerPage.getNumberOfLanguageOptions(),3);


    }

}
