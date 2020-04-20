package images;

import base.BaseTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BrokenImagesPage;

public class ImagesTests extends BaseTests {
    private BrokenImagesPage brokenImagesPage;

    @BeforeMethod
    public void setPages() {
        brokenImagesPage = pages.getBrokenImagesPage();
    }


    @Test
    public void validrateImages(){
        brokenImagesPage
                .open()
                .iVerifyImages();

        System.out.println("end test");
    }

    @Test
    public void testCheckboxes() {
       // brokenImagesPage
        //        .open()
       //         .iCheckUncheckedBoxes()
        //        .thenAllCheckboxesAreChecked();
    }
}
