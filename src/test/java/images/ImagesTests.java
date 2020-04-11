package images;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.BrokenImagesPage;
import pages.HomePage;

public class ImagesTests extends BaseTests {
    private HomePage homePage;
    private BasePage basePage;
    private BrokenImagesPage brokenImagesPage;

    @Test
    public void validateImages(){
        //homePage = pages.getHomePage();
        basePage.visit("http://the-internet.herokuapp.com/broken_images");
        homePage.clickBrokenImage();

        //brokenImagesPage = pages.getBrokenImagesPage();
        brokenImagesPage.VerifyImages();

    }
}
