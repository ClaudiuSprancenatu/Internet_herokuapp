package images;

import base.BaseTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BrokenImagesPage;
import pages.LoginPage;
import pages.SecureAreaPage;

import static org.testng.Assert.assertTrue;

public class ImagesTests extends BaseTests {
    private BrokenImagesPage brokenImagesPage;
    private LoginPage loginPage;
    private SecureAreaPage secureAreaPage;

    @BeforeMethod
    public void setPages() {
        brokenImagesPage = pages.getBrokenImagesPage();
        loginPage = pages.getLoginPage();
        secureAreaPage = pages.getSecureAreaPage();
    }


    @Test
    public void validrateImages(){
        brokenImagesPage
                .open()
                .iVerifyImages();

        System.out.println("end test");
    }

    @Test
    public void testLogin() {
        loginPage
                .open()
                .iLogin();
        assertTrue(secureAreaPage.getsuccesfulLogin().contains("You logged into a secure area!"), "Alert text is incorrect");
        System.out.println("end test");
    }
}
