package test;

import helper.Constants;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import pages.NavigationBarPage;


@RunWith(JUnit4.class)
public class NavigationBarTest extends BaseTest{
   NavigationBarPage navigationBarPage;

    @Test
    public void testNavigationBar() {
        navigationBarPage=new NavigationBarPage(driver);
        //navigationBarPage.clickOnEveryMenuItemsAndVerifyTitles();
        for(String menuItem: Constants.menuItems){
            navigationBarPage.clickOnMenuItem(menuItem);
            navigationBarPage.verifyPageCategoryTitle(menuItem);
        }

    }

}
