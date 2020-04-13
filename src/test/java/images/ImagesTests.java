package images;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.BrokenImagesPage;
import pages.HomePage;
import pages.PageObjectManager;

public class ImagesTests extends BaseTests {
    private BasePage basePage;
    private BrokenImagesPage brokenImagesPage;
    private PageObjectManager pageObjectManager;


    @Test
    public void validrateImages(){
        brokenImagesPage = pages.getBrokenImagesPage();
        brokenImagesPage.open();
        brokenImagesPage.iVerifyImages();

    }
}
