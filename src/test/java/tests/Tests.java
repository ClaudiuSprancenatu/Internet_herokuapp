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


    @Test
    public void validrateImages() {
        brokenImagesPage
                .open()
                .iVerifyImages();

        System.out.println("end test");
    }


    @Test
    public void testSuccessfullyLogin() {
        loginPage
                .open()
                .iSuccessfullyLogin();
        assertTrue(secureAreaPage.getLoginStatus().contains("You logged into a secure area!"), "Alert text is incorrect!");
        System.out.println("Successfully Login test is done!");
    }

    @Test
    public void testUnssucessfullyLogin() {
        loginPage
                .open()
                .iUnssucessfllyLogin();
        assertTrue(secureAreaPage.getLoginStatus().contains("Your username is invalid!"), "Alert text is incorrect!");
        System.out.println("Unsuccessfully Login test is done!");
    }

    @Test
    public void testLogOut(){
        loginPage
                .open()
                .iSuccessfullyLogin();
        loginPage.iLogout();
        assertTrue(secureAreaPage.getLoginStatus().contains("You logged out of the secure area!"), "Alert text is incorrect!");
        System.out.println("Logout test is done!");
    }
}
