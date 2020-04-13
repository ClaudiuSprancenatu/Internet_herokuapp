package checkbox;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.CheckboxPages;

public class CheckBoxTests extends BaseTests {

    private BasePage basePage;
    private CheckboxPages checkboxPages;

    @Test
    public void testCheckBoxes(){
        checkboxPages = pages.getCheckBoxPages();
        checkboxPages.open();
        checkboxPages.iVerifyCheckboxes();
    }
}
