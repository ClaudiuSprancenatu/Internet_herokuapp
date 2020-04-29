package tests;

import base.BaseTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BrokenImagesPage;
import pages.CheckboxPages;
import pages.LoginPage;
import pages.SecureAreaPage;

import static org.testng.Assert.assertTrue;

public class Tests extends BaseTests {
    private BrokenImagesPage brokenImagesPage;
    private LoginPage loginPage;
    private SecureAreaPage secureAreaPage;
    private CheckboxPages checkboxPages;


    @BeforeMethod
    public void setPages() {
        brokenImagesPage = pages.getBrokenImagesPage();
        loginPage = pages.getLoginPage();
        secureAreaPage = pages.getSecureAreaPage();
        checkboxPages = pages.getCheckboxPages();
    }


    @Test(priority = 3)
    public void validrateImages() {
        brokenImagesPage
                .open()
                .iVerifyImages();

        System.out.println("end test");
    }

    @Test(priority = 4)
    public void testCheckCheckboxes(){
        checkboxPages.open();
        checkboxPages.iCheckCheckboxes();
        System.out.println("The checkboxes are selected!");
    }

    @Test(priority = 5)
    public void testUncheckCheckboxes(){
        checkboxPages.open();
        checkboxPages.iUnheckCheckboxes();
        System.out.println("The checkboxes are deselect!");
    }
/*

    @Test(priority = 8)
    public void testSuccessfullyLogin() {
        loginPage
                .open()
                .LoginFrom("tomsmith", "SuperSecretPassword!");
        assertTrue(secureAreaPage.getLoginStatus().contains("You logged into a secure area!"), "Alert text is incorrect!");
        System.out.println("Successfully Login test is done!");
        loginPage.iLogout();
        assertTrue(secureAreaPage.getLoginStatus().contains("You logged out of the secure area!"), "Alert text is incorrect!");
        System.out.println("Logout test is done!");
    }*/

    @Test(dataProvider = "SuccessfulLogin", dataProviderClass = CustomerDataProvider.class, priority = 1)
    public void SuccessfulLogin(String email, String pass){
        loginPage.open().LoginFrom(email,pass);
        System.out.println("Email:" + email + "Password" + pass);

        //Verify successful Login
        assertTrue(secureAreaPage.getLoginStatus().contains("You logged into a secure area!"), "Alert text is incorrect!");
        System.out.println("Successfully Login test is done!");

        //Logout
        loginPage.iLogout();
        assertTrue(secureAreaPage.getLoginStatus().contains("You logged out of the secure area!"), "Alert text is incorrect!");
        System.out.println("Logout test is done!");


    }

    @Test(dataProvider = "UnsuccessfulLogin", dataProviderClass = CustomerDataProvider.class, priority = 2)
    public void UnsuccessfulLogin(String email, String pass, String invalid){
        loginPage.open().LoginFrom(email,pass);
        System.out.println("Email:" + email + "Password" + pass);

        //Verify Unsuccessful Login
        assertTrue(secureAreaPage.getLoginStatus().contains(invalid), "Alert text is incorrect!");
        System.out.println("Unsuccessfully Login test is done!");

    }


/*
    @Test(priority = 2)
    public void testInvalidUsername() {
        loginPage
                .open()
                .LoginFrom("sprancenatuc@yahoo.com", "SuperSecretPassword!");
        assertTrue(secureAreaPage.getLoginStatus().contains("Your username is invalid!"), "Alert text is incorrect!");
        System.out.println("Unsuccessfully Login test is done!");
    }

    @Test(priority = 3)
    public void testInvalidPassword() {
        loginPage
                .open()
                .LoginFrom("tomsmith", "12345");
        assertTrue(secureAreaPage.getLoginStatus().contains("Your password is invalid!"), "Alert text is incorrect!");
        System.out.println("Unsuccessfully Login test is done!");
    }

    @Test(priority = 4)
    public void testEmptyForm() {
        loginPage
                .open()
                .LoginFrom("", "");
        assertTrue(secureAreaPage.getLoginStatus().contains("Your username is invalid!"), "Alert text is incorrect!");
        System.out.println("Unsuccessfully Login test is done!");
    }*/
}
