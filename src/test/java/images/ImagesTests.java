package images;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.BrokenImagesPage;
import pages.HomePage;

public class ImagesTests extends BaseTests {
    private HomePage homePage;
    private BrokenImagesPage brokenImagesPage;

    @Test
    public void validateImages(){
        homePage = pages.getHomePage();
        homePage.clickBrokenImage();

        brokenImagesPage = pages.getBrokenImagesPage();
        brokenImagesPage.VerifyImages();

    }
}
