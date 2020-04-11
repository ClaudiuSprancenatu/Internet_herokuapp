package images;

import base.BaseTests;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.BrokenImagesPage;
import pages.HomePage;

public class ImagesTests extends BaseTests {

    private BasePage driver;

    @Test
    public void validateImages(){
        HomePage homePage = new HomePage(driver);

        homePage.clickBrokenImage();
        BrokenImagesPage brokenImagesPage = new BrokenImagesPage(driver);
        brokenImagesPage.VerifyImages();
    }
}
