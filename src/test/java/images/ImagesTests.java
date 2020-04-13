package images;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.BrokenImagesPage;
import pages.HomePage;

public class ImagesTests extends BaseTests {
    //private HomePage homePage;
    private BasePage basePage;
    private BrokenImagesPage brokenImagesPage;


    @Test
    public void validrateImages(){
        brokenImagesPage = pages.getBrokenImagesPage();
        brokenImagesPage.open();
        brokenImagesPage.iVerifyImages();

    }
}
