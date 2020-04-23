package tests;

import base.BaseTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BrokenImagesPage;
import pages.LoginPage;
import pages.SecureAreaPage;

import static org.testng.Assert.assertTrue;

public class Tests extends BaseTests {
    private BrokenImagesPage brokenImagesPage;
    private LoginPage loginPage;
    private SecureAreaPage secureAreaPage;


    @BeforeMethod
    public void setPages() {
        brokenImagesPage = pages.getBrokenImagesPage();
        loginPage = pages.getLoginPage();
        secureAreaPage = pages.getSecureAreaPage();
    }


    @Test(priority = 3)
    public void validrateImages() {
        brokenImagesPage
                .open()
                .iVerifyImages();

        System.out.println("end test");
    }


    @Test(priority = 1)
    public void testSuccessfullyLogin() {
        loginPage
                .open()
                .LoginFrom("tomsmith", "SuperSecretPassword!");
        assertTrue(secureAreaPage.getLoginStatus().contains("You logged into a secure area!"), "Alert text is incorrect!");
        System.out.println("Successfully Login test is done!");
        loginPage.iLogout();
        assertTrue(secureAreaPage.getLoginStatus().contains("You logged out of the secure area!"), "Alert text is incorrect!");
        System.out.println("Logout test is done!");
    }

    @Test(priority = 2)
    public void testUnssucessfullyLogin() {
        loginPage
                .open()
                .LoginFrom("sprancenatuc@yahoo.com", "12345");
        assertTrue(secureAreaPage.getLoginStatus().contains("Your username is invalid!"), "Alert text is incorrect!");
        System.out.println("Unsuccessfully Login test is done!");
    }
}
