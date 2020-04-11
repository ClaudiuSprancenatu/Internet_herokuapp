package images;

import base.BaseTests;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.BrokenImagesPage;
import pages.HomePage;

public class ImagesTests extends BaseTests {

    private HomePage homePage;
    private BrokenImagesPage brokenImagesPage;

    @Test
    public void validateImages(){
        homePage.clickBrokenImage();
        brokenImagesPage.VerifyImages();
    }
}
