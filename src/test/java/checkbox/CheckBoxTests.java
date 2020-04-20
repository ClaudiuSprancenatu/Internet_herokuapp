package checkbox;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.CheckboxPages;
import pages.HomePage;

public class CheckBoxTests extends BaseTests {

    private BasePage basePage;
    private CheckboxPages checkboxPages;
    private HomePage homePage;

    @Test
    public void testCheckBoxes(){
        //checkboxPages = pages.getCheckBoxPages();
        checkboxPages.open();
        homePage.clickCheckBoxs();
       // checkboxPages.iVerifyCheckboxes();
    }
}
